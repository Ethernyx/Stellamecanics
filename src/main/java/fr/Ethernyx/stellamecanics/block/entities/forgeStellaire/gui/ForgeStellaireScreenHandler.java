package fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui;

import fr.ethernyx.stellamecanics.init.ModScreenHandlers;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class ForgeStellaireScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate properties;

    public ForgeStellaireScreenHandler(int syncId, PlayerInventory playerInv, Inventory inventory, PropertyDelegate properties) {
        super(ModScreenHandlers.FORGE_STELLAIRE, syncId);
        this.inventory = inventory;
        this.properties = properties;

        // slot input
        this.addSlot(new Slot(inventory, 0, 54, 34));
        // slot output
        this.addSlot(new Slot(inventory, 1, 104, 34));

        // propriétés sync (burnTime, cookTime, maxCookTime)
        this.addProperties(properties);

        // inventaire joueur
        addPlayerInventory(playerInv);
        addPlayerHotbar(playerInv);
    }

    public ForgeStellaireScreenHandler(int syncId, PlayerInventory playerInv) {
        this(syncId, playerInv, new SimpleInventory(2), new ArrayPropertyDelegate(7));
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int sslot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(sslot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (sslot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInv) {
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 9; ++j)
                this.addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
    }

    private void addPlayerHotbar(PlayerInventory playerInv) {
        for (int i = 0; i < 9; ++i)
            this.addSlot(new Slot(playerInv, i, 8 + i * 18, 142));
    }

    public boolean isCrafting() {
        return properties.get(0) > 0;
    }

    public int getScaledArrowProgress() {
        int progress = this.properties.get(0);
        int maxProgress = this.properties.get(1); // Max Progress
        int arrowPixelSize = 24; // This is the width in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }

    public int getFluidAmount() { return (int) (properties.get(3) * FluidConstants.BUCKET);}
    public int getCapacity() { return (int) (properties.get(4) * FluidConstants.BUCKET);}
    public Fluid getFluid() { return Fluids.LAVA;}

    public int getFluidScaled(int height) {
        long amount = properties.get(3) * FluidConstants.BUCKET;
        long capacity = properties.get(4) * FluidConstants.BUCKET;
       // System.out.println("Fluid: " + amount + "/" + capacity);
        if (capacity == 0) return 0;
        return (int) (amount * height / capacity);
    }
}
