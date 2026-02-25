package fr.ethernyx.stellamecanics.compatibility.rei;

import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui.ForgeStellaireScreen;
import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipe;
import fr.ethernyx.stellamecanics.compatibility.rei.forgeStellaire.ForgeStellaireCategory;
import fr.ethernyx.stellamecanics.compatibility.rei.forgeStellaire.ForgeStellaireDisplay;
import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModRecipeTypes;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class StellamecanicsREIClient implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new ForgeStellaireCategory());

        registry.addWorkstations(ForgeStellaireCategory.FORGE_STELLAIRE, EntryStacks.of(ModBlocks.FORGE_STELLAIRE));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.beginRecipeFiller(ForgeStellaireRecipe.class, ModRecipeTypes.FORGE_STELLAIRE,
                ForgeStellaireDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 166) / 2) + 30, 20, 25), ForgeStellaireScreen.class,
                ForgeStellaireCategory.FORGE_STELLAIRE);
    }
}
