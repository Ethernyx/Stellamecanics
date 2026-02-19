package fr.ethernyx.stellamecanics.utils.screen.widgets;

import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FluidWidget implements Drawable, Widget {
    private final SingleFluidStorage fluidStorage;
    private final Supplier<BlockPos> posSupplier;
    private final Supplier<Long> amountSupplier;
    private final Supplier<Long> capacitySupplier;

    private final int width, height;
    private int x, y;

    public FluidWidget(SingleFluidStorage fluidStorage, int x, int y, int width, int height,
                       Supplier<BlockPos> posSupplier,
                       Supplier<Long> amountSupplier,
                       Supplier<Long> capacitySupplier) {
        this.fluidStorage = fluidStorage;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.posSupplier = posSupplier;
        this.amountSupplier = amountSupplier;
        this.capacitySupplier = capacitySupplier;
    }

    public static Builder builder(SingleFluidStorage fluidStorage) {
        return new Builder(fluidStorage);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        final long fluidAmount;
        final long fluidCapacity;
        final Fluid fluid;
        // ✅ On lit depuis les suppliers (PropertyDelegate synchro), pas depuis le storage direct
        try {
            fluidAmount  = this.amountSupplier.get();
            fluidCapacity = this.capacitySupplier.get();
            fluid = this.fluidStorage.variant.getFluid();
        } catch (Exception e) {
            return; // Storage en cours de modification, on skip ce frame
        }

        if (fluidAmount <= 0 || fluidCapacity <= 0) return;
        if (fluid == null || fluid == Fluids.EMPTY) return;

        FluidRenderHandler fluidRenderHandler = FluidRenderHandlerRegistry.INSTANCE.get(fluid);
        if (fluidRenderHandler == null) return;

        BlockPos pos = this.posSupplier.get();
        if (pos == null) return;

        World world = MinecraftClient.getInstance().world;
        if (world == null) return;

        FluidState fluidState = fluid.getDefaultState();
        Sprite sprite = fluidRenderHandler.getFluidSprites(world, pos, fluidState)[0];

        int tintColor = fluidRenderHandler.getFluidColor(world, pos, fluidState);
        int color = 0xFF000000 | (tintColor & 0xFFFFFF);

        // ✅ Calcul précis avec double + clamp pour éviter tout dépassement
        int fluidHeight = (int) Math.round((double) fluidAmount / (double) fluidCapacity * this.height);
        fluidHeight = Math.max(0, Math.min(fluidHeight, this.height));

        int drawY = this.y + this.height - fluidHeight;
        context.drawSpriteStretched(RenderPipelines.GUI_TEXTURED, sprite, this.x, drawY, this.width, fluidHeight, color);

        if (isPointWithinBounds(this.x, this.y, this.width, this.height, mouseX, mouseY)) {
            drawTooltip(context, mouseX, mouseY, fluid, fluidAmount, fluidCapacity);
        }
    }

    protected void drawTooltip(DrawContext context, int mouseX, int mouseY,
                               Fluid fluid, long fluidAmount, long fluidCapacity) {
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;

        List<Text> texts = List.of(
                Text.translatable(fluid.getDefaultState().getBlockState().getBlock().getTranslationKey()),
                Text.literal("%d / %d mB".formatted(fluidAmount, fluidCapacity))
        );
        context.drawTooltip(textRenderer, texts, mouseX, mouseY);
    }

    private static boolean isPointWithinBounds(int x, int y, int width, int height, int pointX, int pointY) {
        return pointX >= x && pointX <= x + width &&
                pointY >= y && pointY <= y + height;
    }

    @Override public void setX(int x)                       { this.x = x; }
    @Override public void setY(int y)                       { this.y = y; }
    @Override public int getX()                             { return this.x; }
    @Override public int getY()                             { return this.y; }
    @Override public int getWidth()                         { return this.width; }
    @Override public int getHeight()                        { return this.height; }
    @Override public void forEachChild(Consumer<ClickableWidget> consumer) {}

    // ─── Builder ────────────────────────────────────────────────────────────────

    public static class Builder {
        private final SingleFluidStorage    fluidStorage;
        private Supplier<BlockPos>          posSupplier   = () -> null;
        private Supplier<Long>              amountSupplier   = () -> 0L;
        private Supplier<Long>              capacitySupplier = () -> 0L;
        private int                         x, y, width, height;

        public Builder(SingleFluidStorage fluidStorage)     { this.fluidStorage = fluidStorage; }

        public Builder position(int x, int y)               { this.x = x; this.y = y; return this; }
        public Builder x(int x)                             { this.x = x; return this; }
        public Builder y(int y)                             { this.y = y; return this; }
        public Builder size(int w, int h)                   { this.width = w; this.height = h; return this; }
        public Builder width(int w)                         { this.width = w; return this; }
        public Builder height(int h)                        { this.height = h; return this; }

        public Builder bounds(int x, int y, int width, int height) {
            this.x = x; this.y = y; this.width = width; this.height = height;
            return this;
        }

        public Builder posSupplier(Supplier<BlockPos> s)    { this.posSupplier = s; return this; }
        public Builder amountSupplier(Supplier<Long> s)     { this.amountSupplier = s; return this; }
        public Builder capacitySupplier(Supplier<Long> s)   { this.capacitySupplier = s; return this; }

        public FluidWidget build()                          { return new FluidWidget(fluidStorage, x, y, width, height, posSupplier, amountSupplier, capacitySupplier); }
    }
}