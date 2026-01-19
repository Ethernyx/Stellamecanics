package fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import fr.ethernyx.stellamecanics.Stellamecanics;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.joml.Matrix4f;

import java.util.ArrayList;
import java.util.List;

public class ForgeStellaireScreen extends HandledScreen<ForgeStellaireScreenHandler> {
    private static final Identifier ARROW_TEXTURE =
            Identifier.of(Stellamecanics.MOD_ID, "textures/gui/arrow_progress.png");

    private static final Identifier TEXTURE =
            Identifier.of(Stellamecanics.MOD_ID, "textures/gui/forge_stellaire_une_jauge.png");

    public ForgeStellaireScreen(ForgeStellaireScreenHandler handler, PlayerInventory inv, Text title) {
        super(handler, inv, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 166;
    }

    @Environment(EnvType.CLIENT)
    public static Sprite getFluidSprite(Fluid fluid) {
        FluidRenderHandler handler =
                FluidRenderHandlerRegistry.INSTANCE.get(fluid);

        if (handler == null) return null;

        Sprite[] sprites = handler.getFluidSprites(
                MinecraftClient.getInstance().world,
                BlockPos.ORIGIN,
                fluid.getDefaultState()
        );

        return sprites != null && sprites.length > 0 ? sprites[0] : null;
    }

    private void drawFluidSprite(
            DrawContext context,
            Sprite sprite,
            int x,
            int y,
            int width,
            int height
    ) {
        if (sprite == null || width <= 0 || height <= 0) return;

        Identifier atlas = sprite.getAtlasId();

        int u = sprite.getX();
        int v = sprite.getY();

        context.drawTexture(
                RenderPipelines.GUI_TEXTURED,
                atlas,
                x,
                y,
                u,
                v,
                width,
                height,
                256,
                256
        );
    }

    @Override
    protected void drawBackground(DrawContext ctx, float delta, int mouseX, int mouseY) {
        ctx.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, 256, 256);

        // barre de cuisson
        renderProgressArrow(ctx, x, y);
        int tankX = x + 12;
        int tankY = y + 71;
        int tankW = 6;
        int tankH = 58;

        if (isMouseOverFluid(mouseX, mouseY, tankX, tankY, tankW, tankH)) {
            List<Text> tooltip = getFluidTooltip(
                    handler.getFluid(),
                    handler.getFluidAmount(),
                    handler.getCapacity()
            );

            ctx.drawTooltip(
                    textRenderer,
                    tooltip,
                    mouseX,
                    mouseY
            );
        }

        // 🔥 jauge de fluide
        Sprite sprite = getFluidSprite(Fluids.LAVA);
        if (sprite == null) return;
        int maxHeight = 58;
        drawFluidSprite(ctx, sprite, x + 14, y + 72, 6, maxHeight);//handler.getFluidScaled(maxHeight));
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(RenderPipelines.GUI_TEXTURED, ARROW_TEXTURE, x + 73, y + 35, 0, 0,
                    handler.getScaledArrowProgress(), 16, 24, 16);
        }
    }

    private boolean isMouseOverFluid(
            double mouseX,
            double mouseY,
            int x,
            int y,
            int width,
            int height
    ) {
        return mouseX >= x && mouseX < x + width
                && mouseY >= y && mouseY < y + height;
    }

    private List<Text> getFluidTooltip(Fluid fluid, int amount, int capacity) {
        List<Text> tooltip = new ArrayList<>();

        if (fluid == Fluids.EMPTY) {
            tooltip.add(Text.translatable("tooltip.forge_stellaire.empty"));
            return tooltip;
        }

        tooltip.add(Text.translatable(fluid.getDefaultState().getBlockState().getBlock().getTranslationKey()));

        tooltip.add(
                Text.literal(amount + " / " + capacity + " mB")
                        .formatted(Formatting.GRAY)
        );

        return tooltip;
    }
}
