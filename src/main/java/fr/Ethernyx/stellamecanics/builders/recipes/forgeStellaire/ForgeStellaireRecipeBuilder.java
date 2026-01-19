package fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire;

import fr.ethernyx.stellamecanics.Stellamecanics;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ForgeStellaireRecipeBuilder {

    public static void offer(
            RecipeExporter exporter,
            String id,
            Ingredient ingredient,
            Fluid fluid,
            long fluidAmount,
            int processTime,
            ItemStack result
    ) {
        ForgeStellaireRecipe recipe =
                new ForgeStellaireRecipe(
                        ingredient,
                        fluid,
                        fluidAmount,
                        processTime,
                        result
                );

        RegistryKey<Recipe<?>> key =
                RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(Stellamecanics.MOD_ID, "forge_stellaire_" + id));

        exporter.accept(key, recipe, null);
    }
}
