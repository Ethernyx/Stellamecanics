package fr.ethernyx.stellamecanics.block.entities.forgeStellaire;

import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui.ForgeStellaireScreenHandler;
import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipe;
import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipeInput;
import fr.ethernyx.stellamecanics.init.ModBlockEntities;
import fr.ethernyx.stellamecanics.init.ModCriteria;
import fr.ethernyx.stellamecanics.init.ModFluids;
import fr.ethernyx.stellamecanics.init.ModRecipeTypes;
import fr.ethernyx.stellamecanics.interfaces.IMyBlockEntity;
import fr.ethernyx.stellamecanics.network.BlockPosPayload;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.*;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;



public class ForgeStellaireEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPosPayload>, IMyBlockEntity {
    public static String ID = "forge_stellaire_entity";
    public static String IDBLOCK = "forge_stellaire";
    private static final int PRODUCTION_SOLARIUM_PER_TICK = 4;
    private static final int PRODUCTION_LUNARIUM_PER_TICK = 4;
    public static final long CAPACITY = 10 * 1000;
    private int progress = 0;
    private int progressTime = 0;
    private final int maxProgress = 200;
    private final SimpleInventory input = new SimpleInventory(1) {
        @Override
        public void markDirty() {
            super.markDirty();
            update();
        }

        @Override
        public boolean isValid(int slot, ItemStack stack) {
            return ForgeStellaireEntity.this.isValid(stack, slot);
        }
    };

    private final SimpleInventory output = new SimpleInventory(1) {
        @Override
        public void markDirty() {
            super.markDirty();
            update();
        }

        @Override
        public boolean isValid(int slot, ItemStack stack) {
            return false;
        }
    };

    public final InventoryStorage inputInventoryStorage = InventoryStorage.of(input, Direction.UP);
    public final InventoryStorage outputInventoryStorage = InventoryStorage.of(output, Direction.DOWN);

    public final SingleFluidStorage tankSolarium = new SingleFluidStorage() {
        @Override
        protected long getCapacity(FluidVariant fluidVariant) {
            return CAPACITY;
        }

        @Override
        protected void onFinalCommit() {
            markDirty();
        }
    };

    public final SingleFluidStorage tankLunarium = new SingleFluidStorage() {
        @Override
        protected long getCapacity(FluidVariant fluidVariant) {
            return CAPACITY;
        }

        @Override
        protected void onFinalCommit() {
            markDirty();
        }
    };
    private final PropertyDelegate properties = new ArrayPropertyDelegate(6) {

        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> progress;
                case 1 -> progressTime;
                case 2 -> (int) (tankSolarium.getAmount());
                case 3 -> (int) (tankSolarium.getCapacity());
                case 4 -> (int) (tankLunarium.getAmount());
                case 5 -> (int) (tankLunarium.getCapacity());
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            // client side only → rien à faire
        }

        @Override
        public int size() {
            return 6;
        }
    };


    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getIdBlock() {
        return IDBLOCK;
    }

    public ForgeStellaireEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FORGE_STELLAIRE, pos, state);
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        // Sauvegarder seulement si non vide
        if (!input.getStack(0).isEmpty())
            view.put("forge_stellaire.input", ItemStack.CODEC, input.getStack(0));
        if (!output.getStack(0).isEmpty())
            view.put("forge_stellaire.output", ItemStack.CODEC, output.getStack(0));
        view.putInt("forge_stellaire.progress", progress);
        view.putInt("forge_stellaire.progress_time", progressTime);

        Fluid solariumFluid = tankSolarium.getResource().getFluid();
        view.putString("forge_stellaire.tank_solarium",
                (solariumFluid != null && solariumFluid != Fluids.EMPTY)
                        ? Registries.FLUID.getId(solariumFluid).toString()
                        : "");

        Fluid lunariumFluid = tankLunarium.getResource().getFluid();
        view.putString("forge_stellaire.tank_lunarium",
                (lunariumFluid != null && lunariumFluid != Fluids.EMPTY)
                        ? Registries.FLUID.getId(lunariumFluid).toString()
                        : "");

        view.putLong("forge_stellaire.tank_solarium_amount", tankSolarium.getAmount());
        view.putLong("forge_stellaire.tank_lunarium_amount", tankLunarium.getAmount());
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        view.read("forge_stellaire.input",  ItemStack.CODEC).ifPresent(s -> input.setStack(0, s));
        view.read("forge_stellaire.output", ItemStack.CODEC).ifPresent(s -> output.setStack(0, s));
        progress     = view.getInt("forge_stellaire.progress", 0);
        progressTime = view.getInt("forge_stellaire.progress_time", 0);

        String id = view.getString("forge_stellaire.tank_solarium", "");
        if (!id.isEmpty()) {
            Fluid tmp = Registries.FLUID.get(Identifier.of(id));
            if (tmp != null && tmp != Fluids.EMPTY)
                addFluid(tankSolarium, tmp, view.getLong("forge_stellaire.tank_solarium_amount", 0L));
        }

        id = view.getString("forge_stellaire.tank_lunarium", "");
        if (!id.isEmpty()) {
            Fluid tmp = Registries.FLUID.get(Identifier.of(id));
            if (tmp != null && tmp != Fluids.EMPTY)
                addFluid(tankLunarium, tmp, view.getLong("forge_stellaire.tank_lunarium_amount", 0L));
        }

        if (world != null && !world.isClient()) {
            world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) return;

        if(hasRecipe()) {
            if (progressTime == 0) this.progressTime = Math.min(getCurrentRecipe().get().value().processTime(), this.maxProgress);
            increaseCraftingProgress();
            markDirty(world, pos, state);

            if(hasCraftingFinished()) {
                // Récupérer le joueur qui a le GUI ouvert
                ServerPlayerEntity player = ((ServerWorld) world).getPlayers()
                        .stream()
                        .filter(p -> p.currentScreenHandler instanceof ForgeStellaireScreenHandler handler
                                && handler.getBlockEntity() == this)
                        .findFirst()
                        .orElse(null);

                craftItem(player);
                resetProgress();
            }
        } else {
            resetProgress();
        }

        if (world.isDay()) addFluid(tankSolarium, ModFluids.SOLARIUM_FLUID.getFlowing(), tankSolarium.getCapacity() - tankSolarium.getAmount() > PRODUCTION_SOLARIUM_PER_TICK ? PRODUCTION_SOLARIUM_PER_TICK : tankSolarium.getCapacity() - tankSolarium.getAmount());
        else addFluid(tankLunarium, ModFluids.LUNARIUM_FLUID.getFlowing(), tankLunarium.getCapacity() - tankLunarium.getAmount() > PRODUCTION_LUNARIUM_PER_TICK ? PRODUCTION_LUNARIUM_PER_TICK : tankLunarium.getCapacity() - tankLunarium.getAmount());
    }

    private void resetProgress() {
        this.progress = 0;
        this.progressTime = 0;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private void craftItem(ServerPlayerEntity player) {
        Optional<RecipeEntry<ForgeStellaireRecipe>> recipe = getCurrentRecipe();
        ForgeStellaireRecipe r = recipe.get().value();

        input.removeStack(0, 1);

        ItemStack output = r.result();
        this.output.setStack(0, new ItemStack(output.getItem(),
                this.output.getStack(0).getCount() + output.getCount()));

        // Extraction du fluide
        SingleFluidStorage tank = r.fluid() == ModFluids.LUNARIUM_FLUID.getStill() ? tankLunarium : tankSolarium;
        addFluid(tank, r.fluid(), -r.fluidAmount());

        // Déclencher le criterion si on a un joueur
        if (player != null) {
            RecipeEntry<ForgeStellaireRecipe> entry = recipe.get();
            ModCriteria.FORGE_STELLAIRE_USED.trigger(player, entry.id().getValue());
        }
    }

    private boolean hasCraftingFinished() {
        return this.progressTime <= this.progress;
    }

    private Fluid getTankFluid(ForgeStellaireRecipe recipe) {
        return recipe.fluid() == ModFluids.LUNARIUM_FLUID.getStill()
                ? tankLunarium.getResource().getFluid()
                : tankSolarium.getResource().getFluid();
    }

    private int getTankAmount(ForgeStellaireRecipe recipe) {
        return Math.toIntExact(recipe.fluid() == ModFluids.LUNARIUM_FLUID.getStill()
                ? tankLunarium.getAmount()
                : tankSolarium.getAmount());
    }

    private boolean hasEnoughFluid(ForgeStellaireRecipe recipe) {
        Fluid recipeFluid = recipe.fluid();
        long required = recipe.fluidAmount();
        Fluid tankFluid = getTankFluid(recipe);
        int stored = getTankAmount(recipe);

        if (tankFluid == Fluids.EMPTY) return false;
        if (stored <= 0) return false;

        return tankFluid == recipeFluid && stored >= required;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<ForgeStellaireRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().result();

        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output) && hasEnoughFluid(recipe.get().value());
    }

    private Optional<RecipeEntry<ForgeStellaireRecipe>> getCurrentRecipe() {
        assert world != null;
        if (world.isClient()) return Optional.empty();
        return ((ServerWorld) this.getWorld()).getRecipeManager()
                .getFirstMatch(ModRecipeTypes.FORGE_STELLAIRE, new ForgeStellaireRecipeInput(input.getStack(0)), this.getWorld());
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.output.getStack(0).isEmpty() || this.output.getStack(0).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = this.output.getStack(0).isEmpty() ? 64 : this.output.getStack(0).getMaxCount();
        int currentCount = this.output.getStack(0).getCount();

        return maxCount >= currentCount + count;
    }



    @Override
    public Text getDisplayName() {
        return Text.translatable("container.stellamecanics.forge_stellaire");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInv, PlayerEntity player) {
        return new ForgeStellaireScreenHandler(syncId, playerInv, this, properties);
    }

    public boolean addFluid(SingleFluidStorage tank,
                             Fluid fluid,
                             long amount) {
        FluidVariant variant = FluidVariant.of(fluid);

        try (Transaction tx = Transaction.openOuter()) {
            long changed;

            if (amount > 0) {
                changed = tank.insert(variant, amount, tx);
            } else {
                changed = tank.extract(variant, -amount, tx);
            }

            if (changed == Math.abs(amount)) {
                tx.commit();
                markDirty();
                if (world != null) world.updateListeners(pos, getCachedState(), getCachedState(), 3);
                return true;
            }
        }
        return false;
    }
    @Override
    public void setWorld(World world) {
        super.setWorld(world);

        // world vient juste d'être attaché, tu peux notifier le client
        if (world != null && !world.isClient()) {
            world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    public boolean isValid(ItemStack stack, int slot) {
        if(stack.isEmpty()) return true;
        if(slot != 0) return false;

        Storage<FluidVariant> storage = ContainerItemContext.withConstant(stack).find(FluidStorage.ITEM);
        return storage != null;
    }

    private void update() {
        markDirty();
        if(world != null)
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
    }

    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return new BlockPosPayload(this.pos);
    }

    public SimpleInventory getInputInventory() {
        return input;
    }
    public SimpleInventory getOutputInventory() {
        return output;
    }

    public SingleFluidStorage  getFluidStorageSolarium() { return tankSolarium;}
    public SingleFluidStorage  getFluidStorageLunarium() { return tankLunarium;}
    // Getters pour l'enregistrement des pipes (Transfer API)
    public InventoryStorage getInputInventoryStorage()  { return inputInventoryStorage; }
    public InventoryStorage getOutputInventoryStorage() { return outputInventoryStorage; }

    private static boolean storagesRegistered = false;

    public static void registerStorages() {
        if (storagesRegistered) return;
        storagesRegistered = true;

        // Pipes items : dessus → input / dessous → output
        ItemStorage.SIDED.registerForBlockEntity((be, direction) -> {
            if (direction == Direction.UP)   return be.inputInventoryStorage;
            if (direction == Direction.DOWN) return be.outputInventoryStorage;
            return null;
        }, ModBlockEntities.FORGE_STELLAIRE);

        // Pipes fluides : SOUTH → Solarium / NORTH → Lunarium
        FluidStorage.SIDED.registerForBlockEntity((be, direction) -> {
            if (direction == Direction.SOUTH) return be.tankSolarium;
            if (direction == Direction.NORTH) return be.tankLunarium;
            return null;
        }, ModBlockEntities.FORGE_STELLAIRE);
    }
}
