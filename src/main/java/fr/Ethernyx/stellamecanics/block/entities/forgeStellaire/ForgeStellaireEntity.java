package fr.ethernyx.stellamecanics.block.entities.forgeStellaire;

import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui.ForgeStellaireScreenHandler;
import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipe;
import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipeInput;
import fr.ethernyx.stellamecanics.init.ModBlockEntities;
import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModRecipeTypes;
import fr.ethernyx.stellamecanics.interfaces.IMyBlockEntity;
import fr.ethernyx.stellamecanics.interfaces.ImplementedInventory;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ForgeStellaireEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory, IMyBlockEntity {
    public static String ID = "forge_stellaire_entity";
    public static String IDBLOCK = "forge_stellaire";
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    public static final long CAPACITY = 10 * FluidConstants.BUCKET;
    private int progress = 0;
    private int progressTime = 0;
    private final int maxProgress = 200;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(2, ItemStack.EMPTY);

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
                case 3 -> (int) (tankSolarium.getAmount() / FluidConstants.BUCKET);
                case 4 -> (int) (tankSolarium.getCapacity() / FluidConstants.BUCKET);
                case 5 -> (int) (tankLunarium.getAmount() / FluidConstants.BUCKET);
                case 6 -> (int) (tankLunarium.getCapacity() / FluidConstants.BUCKET);
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
        Inventories.writeData(view, items);
        view.putInt("forge_stellaire.progress", progress);
        view.putInt("forge_stellaire.progress_time", progressTime);
    }

    @Override
    protected void readData(ReadView view) {
        Inventories.readData(view, items);
        progress = view.getInt("forge_stellaire.progress", 0);
        progressTime = view.getInt("forge_stellaire.progress_time", 0);
        super.readData(view);
    }

    @Override
    public void onBlockReplaced(BlockPos pos, BlockState oldState) {
        ItemScatterer.spawn(world, pos, (this));
        super.onBlockReplaced(pos, oldState);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) return;

        if(hasRecipe()) {
            increaseCraftingProgress();
            markDirty(world, pos, state);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }

        if (world.isDay()) addSolariumFluid(10);
        else addLunariumFluid(10);
        /*if (be.burnTime <= 0 && !be.tank.isResourceBlank()) {
            int burn = getBurnTime(be.tank.getResource());
            if (burn > 0) {
                try (Transaction tx = Transaction.openOuter()) {
                    be.tank.extract(be.tank.getResource(), FluidConstants.BUCKET / 10, tx);
                    tx.commit();
                }
                be.burnTime = burn;
            }
        }

        if (be.burnTime > 0) {
            be.burnTime--;
            be.cookTime++;

            if (be.cookTime >= be.maxCookTime) {
                // 🔥 ici tu feras le smelting réel
                be.cookTime = 0;
            }
        } else {
            be.cookTime = 0;
        }*/
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

        ItemStack output = recipe.get().value().result();
        this.removeStack(INPUT_SLOT, 1);
        this.addFluid(recipe.get().value().fluid(),- recipe.get().value().fluidAmount());
        this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress || this.progressTime <= this.progress;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<ForgeStellaireRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }

        this.progressTime = recipe.get().value().processTime();
        ItemStack output = recipe.get().value().result();
        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private Optional<RecipeEntry<ForgeStellaireRecipe>> getCurrentRecipe() {
        return ((ServerWorld) this.getWorld()).getRecipeManager()
                .getFirstMatch(ModRecipeTypes.FORGE_STELLAIRE, new ForgeStellaireRecipeInput(items.get(INPUT_SLOT)), this.getWorld());
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = this.getStack(OUTPUT_SLOT).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT).getMaxCount();
        int currentCount = this.getStack(OUTPUT_SLOT).getCount();

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

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    public boolean addFluid(Fluid fluid, long amount) {
        if (fluid == Fluids.LAVA) return addSolariumFluid(amount);
        else if (fluid == Fluids.WATER) return addLunariumFluid(amount);
        else return false;

    }

    private boolean addSolariumFluid(long amount) {
        try (Transaction transaction = Transaction.openOuter()) {
            long inserted = 0;
            if (amount > 0) {
                inserted = tankSolarium.insert(
                        FluidVariant.of(Fluids.LAVA),
                        amount,
                        transaction
                );
            } else {
                inserted = tankSolarium.extract(
                        FluidVariant.of(Fluids.LAVA),
                        - amount,
                        transaction
                );
            }


            if (inserted > 0) {
                transaction.commit();
                markDirty();
                world.updateListeners(pos, getCachedState(), getCachedState(), 3);
                return true;
            }
        }

        return false;
    }

    private boolean addLunariumFluid(long amount) {
        try (Transaction transaction = Transaction.openOuter()) {
            long inserted = 0;
            if (amount > 0) {
                inserted = tankLunarium.insert(
                        FluidVariant.of(Fluids.LAVA),
                        amount,
                        transaction
                );
            } else {
                inserted = tankLunarium.extract(
                        FluidVariant.of(Fluids.LAVA),
                        - amount,
                        transaction
                );
            }


            if (inserted > 0) {
                transaction.commit();
                markDirty();
                world.updateListeners(pos, getCachedState(), getCachedState(), 3);
                return true;
            }
        }

        return false;
    }
}
