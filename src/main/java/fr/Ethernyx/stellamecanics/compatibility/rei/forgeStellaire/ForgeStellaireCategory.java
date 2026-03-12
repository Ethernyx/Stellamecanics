package fr.ethernyx.stellamecanics.compatibility.rei.forgeStellaire;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModTags;
import fr.ethernyx.stellamecanics.interfaces.IMyFlowingFluid;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

public class ForgeStellaireCategory implements DisplayCategory<BasicDisplay> {
    private static final Identifier ARROW_TEXTURE =
            Identifier.of(Stellamecanics.MOD_ID, "textures/gui/arrow_progress.png");

    private static final Identifier TEXTURE =
            Identifier.of(Stellamecanics.MOD_ID, "textures/gui/forge_stellaire_deux_jauge.png");

    private static final int ARROW_WIDTH  = 24;
    private static final int ARROW_HEIGHT = 16;
    private static final int GAUGE_WIDTH  = 6;
    private static final int GAUGE_HEIGHT = 59;
    // Capacité max identique à ForgeStellaireEntity.CAPACITY
    private static final long TANK_CAPACITY = 10_000L;

    public static final CategoryIdentifier<ForgeStellaireDisplay> FORGE_STELLAIRE = CategoryIdentifier.of(Stellamecanics.MOD_ID, "forge_stellaire");

    @Override public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return FORGE_STELLAIRE;
    }
    @Override public Text getTitle() {
        return Text.translatable("block.stellamecanics.forge_stellaire");
    }
    @Override public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.FORGE_STELLAIRE.asItem().getDefaultStack());
    }
    @Override public int getDisplayHeight() { return 90; }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point o = new Point(bounds.getCenterX() - 88, bounds.getCenterY() - 55);
        List<Widget> widgets = new LinkedList<>();

        // ── Fond GUI ──────────────────────────────────────────────────────────
        widgets.add(Widgets.createTexturedWidget(TEXTURE,
                new Rectangle(o.x, o.y, 176, 102)));

        // ── Slot input ────────────────────────────────────────────────────────
        widgets.add(Widgets.createSlot(new Point(o.x + 72, o.y + 47))
                .entries(display.getInputEntries().get(0))
                .markInput());

        // ── Slot output ───────────────────────────────────────────────────────
        widgets.add(Widgets.createSlot(new Point(o.x + 122, o.y + 47))
                .entries(display.getOutputEntries().getFirst())
                .markOutput()
                .disableBackground());

        if (!(display instanceof ForgeStellaireDisplay fd)) return widgets;

        // ── Flèche animée ─────────────────────────────────────────────────────
        // Cycle basé sur le temps réel, durée = processTime ticks × 50 ms/tick
        final long cycleDurationMs = Math.max(1L, (long) fd.getProcessTime() * 50L);
        final int arrowX = o.x + 79 + 12;
        final int arrowY = o.y + 48;

        widgets.add(Widgets.createDrawableWidget((DrawContext ctx, int mx, int my, float delta) -> {
            int progress = (int) ((System.currentTimeMillis() % cycleDurationMs)
                    * ARROW_WIDTH / cycleDurationMs);
            if (progress > 0) {
                ctx.drawTexture(RenderPipelines.GUI_TEXTURED,
                        ARROW_TEXTURE,
                        arrowX, arrowY,
                        0, 0,
                        progress, ARROW_HEIGHT,
                        ARROW_WIDTH, ARROW_HEIGHT);
            }
        }));

        // ── Temps de craft ────────────────────────────────────────────────────
        double seconds = fd.getProcessTime() / 20.0;
        widgets.add(Widgets.createLabel(
                new Point(bounds.getCenterX(), o.y + 106),
                Text.literal("⏱ " + fd.getProcessTime() + " ticks ("
                        + String.format("%.1f", seconds) + "s)")
        ).color(0xFF666666).noShadow().centered());

        // ── Jauge fluide ──────────────────────────────────────────────────────
        if (display.getInputEntries().size() > 1) {
            Fluid fluid = fd.getFluid();

            // Détermine quel côté (gauche = solarium / droite = lunarium)
            boolean isRight = false;
            if (fluid instanceof IMyFlowingFluid myFluid) {
                isRight = myFluid.getStillTag().contains(
                        ModTags.Fluids.FLUIDTAGS.get("forge_stellaire_fluid_input_right").getTag());
            }

            final int gaugeX = o.x + (isRight ? 27 : 13);
            final int gaugeY = o.y + 23;

            // Hauteur remplie proportionnelle à fluidAmount / TANK_CAPACITY
            int filledH = (int) Math.round(
                    (double) fd.getFluidAmount() / TANK_CAPACITY * GAUGE_HEIGHT);
            filledH = Math.max(1, Math.min(filledH, GAUGE_HEIGHT));
            final int finalFilledH = filledH;
            final int drawY = gaugeY + GAUGE_HEIGHT - filledH;

            // Widget avec rendu du sprite fluide réel via DrawContext
            Widget fluidWidget = Widgets.createDrawableWidget(
                    (DrawContext ctx, int mx, int my, float delta) -> {
                        renderFluidInGauge(ctx, fluid, gaugeX, drawY,
                                GAUGE_WIDTH, finalFilledH);
                    });

            // Tooltip sur la jauge
            widgets.add(Widgets.withTooltip(
                    Widgets.withBounds(fluidWidget,
                            new Rectangle(gaugeX, gaugeY, GAUGE_WIDTH, GAUGE_HEIGHT)),
                    buildFluidTooltip(fluid, fd.getFluidAmount())
            ));
        }

        return widgets;
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    /**
     * Dessine le fluide dans la jauge en utilisant le vrai sprite via DrawContext.
     * Guard complet : si le FluidRenderHandler est absent (fluide custom sans
     * rendu enregistré), repli sur rectangle coloré via IMyFlowingFluid.color().
     */
    private void renderFluidInGauge(DrawContext ctx, Fluid fluid,
                                    int x, int y, int w, int h) {
        if (h <= 0) return;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.world == null) return;

        FluidRenderHandler handler = FluidRenderHandlerRegistry.INSTANCE.get(fluid);

        if (handler != null) {
            FluidState state = fluid.getDefaultState();
            Sprite sprite = handler.getFluidSprites(client.world, null, state)[0];
            int tint  = handler.getFluidColor(client.world, null, state);
            int color = 0xFF000000 | (tint & 0xFFFFFF);
            ctx.drawSpriteStretched(RenderPipelines.GUI_TEXTURED, sprite, x, y, w, h, color);
        } else {
            int color = 0xFF3F76E4;
            if (fluid instanceof IMyFlowingFluid f) {
                color = 0xFF000000 | (f.color() & 0xFFFFFF);
            }
            ctx.fill(x, y, x + w, y + h, color);
        }
    }

    private List<Text> buildFluidTooltip(Fluid fluid, long fluidAmount) {
        String blockKey = fluid.getDefaultState()
                .getBlockState().getBlock().getTranslationKey();
        return List.of(
                Text.translatable(blockKey),
                Text.literal(fluidAmount + " mB requis")
        );
    }
}
