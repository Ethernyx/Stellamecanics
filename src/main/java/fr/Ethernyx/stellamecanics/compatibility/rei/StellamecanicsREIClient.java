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
import me.shedaniel.rei.api.client.registry.display.DynamicDisplayGenerator;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.ServerRecipeManager;

import java.util.List;
import java.util.Optional;

public class StellamecanicsREIClient implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new ForgeStellaireCategory());

        registry.addWorkstations(ForgeStellaireCategory.FORGE_STELLAIRE, EntryStacks.of(ModBlocks.FORGE_STELLAIRE));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.beginFiller(RecipeEntry.class)
                .filter(entry -> {
                    boolean match = entry.value() instanceof ForgeStellaireRecipe;
                    if (match) System.out.println("[REI] Found ForgeStellaireRecipe: " + entry.id());
                    return match;
                })
                .fill(entry -> new ForgeStellaireDisplay((RecipeEntry<ForgeStellaireRecipe>) entry));
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 166) / 2) + 30, 20, 25), ForgeStellaireScreen.class,
                ForgeStellaireCategory.FORGE_STELLAIRE);
    }
}
