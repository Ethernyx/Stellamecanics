package fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.utils.screen.widgets.FluidWidget;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ForgeStellaireScreen extends HandledScreen<ForgeStellaireScreenHandler> {
    private static final Identifier ARROW_TEXTURE =
            Identifier.of(Stellamecanics.MOD_ID, "textures/gui/arrow_progress.png");

    private static final Identifier TEXTURE =
            Identifier.of(Stellamecanics.MOD_ID, "textures/gui/forge_stellaire_deux_jauge.png");

    public ForgeStellaireScreen(ForgeStellaireScreenHandler handler, PlayerInventory inv, Text title) {
        super(handler, inv, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 186;
    }

    @Override
    protected void init() {
        super.init();
        this.clearChildren();
        if (this.handler.getBlockEntity() == null) return;
        this.playerInventoryTitleY = this.handler.getSlot(2).y - 12;
        addDrawable(FluidWidget.builder(this.handler.getBlockEntity().getFluidStorageSolarium())
                .bounds(this.x + 13, this.y + 23, 6, 59)
                .posSupplier(() -> this.handler.getBlockEntity().getPos())
                .amountSupplier(() -> (long) this.handler.getInfosSolarium(0))    // ← PropertyDelegate index 3
                .capacitySupplier(() -> (long) this.handler.getInfosSolarium(1))     // ← PropertyDelegate index 4
                .build());
        addDrawable(FluidWidget.builder(this.handler.getBlockEntity().getFluidStorageLunarium())
                .bounds(this.x + 27, this.y + 23, 6, 59)
                .posSupplier(() -> this.handler.getBlockEntity().getPos())
                .amountSupplier(() -> (long) this.handler.getInfosLunarium(0))    // ← PropertyDelegate index 5
                .capacitySupplier(() -> (long) this.handler.getInfosLunarium(1))     // ← PropertyDelegate index 6
                .build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext ctx, float delta, int mouseX, int mouseY) {
        ctx.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, 256, 256);

        // barre de cuisson
        renderProgressArrow(ctx, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(RenderPipelines.GUI_TEXTURED, ARROW_TEXTURE, x + 92, y + 48, 0, 0,
                    handler.getScaledArrowProgress(), 16, 24, 16);
        }
    }
}
