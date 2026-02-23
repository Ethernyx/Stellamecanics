package fr.ethernyx.stellamecanics.block.entities.forgeStellaire;

import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui.ForgeStellaireScreenHandler;
import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipe;
import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipeInput;
import fr.ethernyx.stellamecanics.init.ModBlockEntities;
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
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int TANKSOLARIUMAMOUNT_SLOT = 3;
    private static final int TANKLUNARIUMAMOUNT_SLOT = 5;
    public static final long CAPACITY = 10 * 1000;
    private int progress = 0;
    private int progressTime = 0;
    private final int maxProgress = 200;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);
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
    private final PropertyDelegate properties = new ArrayPropertyDelegate(7) {

        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> progress;
                case 1 -> progressTime;
                case 2 -> maxProgress;
                case 3 -> (int) (tankSolarium.getAmount());
                case 4 -> (int) (tankSolarium.getCapacity());
                case 5 -> (int) (tankLunarium.getAmount());
                case 6 -> (int) (tankLunarium.getCapacity());
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            // client side only → rien à faire
        }

        @Override
        public int size() {
            return 7;
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
        view.put("forge_stellaire.input",  ItemStack.CODEC, input.getStack(0));
        view.put("forge_stellaire.output", ItemStack.CODEC, output.getStack(0));
        view.putInt("forge_stellaire.progress", progress);
        view.putInt("forge_stellaire.progress_time", progressTime);
        view.putString("forge_stellaire.tank_solarium", tankSolarium.getResource().getFluid() != null
                ? Registries.FLUID.getId(tankSolarium.getResource().getFluid()).toString() : "minecraft:empty");
        view.putLong("forge_stellaire.tank_solarium_amount", tankSolarium.getAmount());
        view.putString("forge_stellaire.tank_lunarium", tankLunarium.getResource().getFluid() != null
                ? Registries.FLUID.getId(tankLunarium.getResource().getFluid()).toString() : "minecraft:empty");
        view.putLong("forge_stellaire.tank_lunarium_amount", tankLunarium.getAmount());
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        view.read("forge_stellaire.input",  ItemStack.CODEC).ifPresent(s -> input.setStack(0, s));
        view.read("forge_stellaire.output", ItemStack.CODEC).ifPresent(s -> output.setStack(0, s));
        progress     = view.getInt("forge_stellaire.progress", 0);
        progressTime = view.getInt("forge_stellaire.progress_time", 0);

        Fluid tmp = Registries.FLUID.get(Identifier.of(view.getString("forge_stellaire.tank_solarium", "")));
        if (tmp != Fluids.EMPTY) addFluid(tankSolarium, tmp, view.getLong("forge_stellaire.tank_solarium_amount", 0L));
        tmp = Registries.FLUID.get(Identifier.of(view.getString("forge_stellaire.tank_lunarium", "")));
        if (tmp != Fluids.EMPTY) addFluid(tankLunarium, tmp, view.getLong("forge_stellaire.tank_lunarium_amount", 0L));

        if (world != null && !world.isClient()) {
            world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) return;

        if(hasRecipe()) {
            if (progressTime == 0) this.progressTime = getCurrentRecipe().get().value().processTime();
            increaseCraftingProgress();
            markDirty(world, pos, state);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }

        if (world.isDay()) addFluid(tankSolarium, ModFluids.SOLARIUM_FLUID.getFlowing(), 4);
        else addFluid(tankLunarium, ModFluids.LUNARIUM_FLUID.getFlowing(), 4);
    }

    private void resetProgress() {
        this.progress = 0;
        this.progressTime = 0;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private void craftItem() {
        Optional<RecipeEntry<ForgeStellaireRecipe>> recipe = getCurrentRecipe();
        ForgeStellaireRecipe r = recipe.get().value();

        input.removeStack(0, 1);

        ItemStack output = r.result();
        this.output.setStack(0, new ItemStack(output.getItem(),
                this.output.getStack(0).getCount() + output.getCount()));

        // Extraction du fluide
        SingleFluidStorage tank = r.fluid() == ModFluids.LUNARIUM_FLUID.getStill() ? tankLunarium : tankSolarium;
        boolean extracted = addFluid(tank, r.fluid(), -r.fluidAmount());

        if (!extracted) {
            // log pour debug — à retirer en prod
            System.out.println("[ForgeStellaireEntity] Echec extraction fluide: "
                    + r.fluidAmount() + " droplets de " + r.fluid());
        }
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress || this.progressTime <= this.progress;
    }

    private Fluid getTankFluid(ForgeStellaireRecipe recipe) {
        return recipe.fluid() == ModFluids.LUNARIUM_FLUID.getStill()
                ? tankLunarium.getResource().getFluid()
                : tankSolarium.getResource().getFluid();
    }

    private int getTankAmount(ForgeStellaireRecipe recipe) {
        return recipe.fluid() == ModFluids.LUNARIUM_FLUID.getStill()
                ? properties.get(TANKLUNARIUMAMOUNT_SLOT)
                : properties.get(TANKSOLARIUMAMOUNT_SLOT);
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

        // Pipes fluides : WEST → Solarium / EAST → Lunarium
        FluidStorage.SIDED.registerForBlockEntity((be, direction) -> {
            if (direction == Direction.WEST) return be.tankSolarium;
            if (direction == Direction.EAST) return be.tankLunarium;
            return null;
        }, ModBlockEntities.FORGE_STELLAIRE);
    }
}
