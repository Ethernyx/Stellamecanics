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
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

public class ForgeStellaireCategory implements DisplayCategory<BasicDisplay> {
    private static final Identifier ARROW_TEXTURE =
            Identifier.of(Stellamecanics.MOD_ID, "textures/gui/arrow_progress.png");

    private static final Identifier TEXTURE =
            Identifier.of(Stellamecanics.MOD_ID, "textures/gui/forge_stellaire_deux_jauge.png");

    public static final CategoryIdentifier<ForgeStellaireDisplay> FORGE_STELLAIRE = CategoryIdentifier.of(Stellamecanics.MOD_ID, "forge_stellaire");
    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return FORGE_STELLAIRE;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.stellamecanics.forge_stellaire");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.FORGE_STELLAIRE.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 55);
        List<Widget> widgets = new LinkedList<>();

        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 175, 102)));

        // Slot item input
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 72, startPoint.y + 47))
                .entries(display.getInputEntries().get(0)).markInput());

        // Slot fluide (index 1 dans les inputs)
        if (display.getInputEntries().size() > 1) {
            ForgeStellaireDisplay forgeStellaireDisplay = (ForgeStellaireDisplay) display;
            IMyFlowingFluid fluid = (IMyFlowingFluid) forgeStellaireDisplay.getFluid();

            final int x = fluid.getStillTag().contains(ModTags.Fluids.FLUIDTAGS.get("forge_stellaire_fluid_input_right").getTag()) ? 27 : 13;
            final int color = 0xAA000000 | (fluid.color() & 0xFFFFFF);

            Widget fluidWidget = Widgets.createDrawableWidget((helper, mouseX, mouseY, delta) -> {
                helper.fillGradient(
                        startPoint.x + x, startPoint.y + 24,
                        startPoint.x + x + 7, startPoint.y + 82,
                        color, color
                );
            });

            // Ajoute le widget avec un tooltip
            widgets.add(Widgets.withTooltip(
                    Widgets.withBounds(
                            fluidWidget,
                            new Rectangle(startPoint.x + x, startPoint.y + 24, 7, 58)
                    ),
                    List.of(
                            Text.translatable(fluid.getBlock().getTranslationKey()),
                            Text.literal(forgeStellaireDisplay.getFluidAmount() + " mB")
                    )
            ));
        }

        // Slot output
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 122, startPoint.y + 47))
                .entries(display.getOutputEntries().getFirst()).markOutput().disableBackground());

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}
