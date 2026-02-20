package fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui;

import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.ForgeStellaireEntity;
import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModScreenHandlers;
import fr.ethernyx.stellamecanics.network.BlockPosPayload;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;

public class ForgeStellaireScreenHandler extends ScreenHandler {
    private final PropertyDelegate properties;
    private final ForgeStellaireEntity blockEntity;
    private final ScreenHandlerContext context;
    private final int AMOUNT = 0;
    private final int CAPACITY = 1;

    public ForgeStellaireScreenHandler(int syncId, PlayerInventory playerInventory, BlockPosPayload payload) {
        this(syncId, playerInventory, (ForgeStellaireEntity) playerInventory.player.getEntityWorld().getBlockEntity(payload.pos()), new ArrayPropertyDelegate(7));
    }

    public ForgeStellaireScreenHandler(int syncId, PlayerInventory playerInventory, ForgeStellaireEntity blockEntity, PropertyDelegate propertyDelegate) {
        super(ModScreenHandlers.FORGE_STELLAIRE, syncId);
        this.blockEntity = blockEntity;
        this.context = ScreenHandlerContext.create(this.blockEntity.getWorld(), this.blockEntity.getPos());
        SimpleInventory inputInventory = this.blockEntity.getInputInventory();
        checkSize(inputInventory, 1);
        inputInventory.onOpen(playerInventory.player);

        SimpleInventory outputInventory = this.blockEntity.getOutputInventory();
        checkSize(outputInventory, 1);
        outputInventory.onOpen(playerInventory.player);

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
        addBlockInventory(inputInventory, outputInventory);

        checkDataCount(propertyDelegate, 7);
        addProperties(propertyDelegate);
        this.properties = propertyDelegate;
    }


    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = getSlot(slotIndex);
        if (slot != null && slot.hasStack()) {
            ItemStack inSlot = slot.getStack();
            newStack = inSlot.copy();

            if (slotIndex < 2) {
                if (!insertItem(inSlot, 2, this.slots.size(), true))
                    return ItemStack.EMPTY;
            } else if (!insertItem(inSlot, 0, 2, false))
                return ItemStack.EMPTY;

            if (inSlot.isEmpty())
                slot.setStack(ItemStack.EMPTY);
            else slot.markDirty();
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, ModBlocks.FORGE_STELLAIRE);
    }

    private void addBlockInventory(SimpleInventory inputInventory, SimpleInventory outputInventory) {
        addSlot(new Slot(inputInventory, 0, 72, 47));
        addSlot(new Slot(outputInventory, 0, 122, 47) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });
    }

    private void addPlayerInventory(PlayerInventory playerInv) {
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 9; ++j)
                this.addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 104 + i * 18));
    }

    private void addPlayerHotbar(PlayerInventory playerInv) {
        for (int i = 0; i < 9; ++i)
            this.addSlot(new Slot(playerInv, i, 8 + i * 18, 162));
    }

    public boolean isCrafting() { return properties.get(0) > 0; }

    public int getScaledArrowProgress() {
        int progress = this.properties.get(0);
        int maxProgress = this.properties.get(1); // Max Progress
        int arrowPixelSize = 24; // This is the width in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }

    public int getInfosLunarium(int type) { return type == AMOUNT ? properties.get(5) : properties.get(6); }
    public int getInfosSolarium(int type) { return type == AMOUNT ? properties.get(3) : properties.get(4); }
    public Fluid getFluid() { return Fluids.LAVA;}
    public ForgeStellaireEntity getBlockEntity() { return blockEntity; }
}
