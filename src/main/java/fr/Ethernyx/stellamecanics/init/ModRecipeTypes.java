package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeTypes {
    public static final RecipeType<ForgeStellaireRecipe> FORGE_STELLAIRE =
            Registry.register(
                    Registries.RECIPE_TYPE,
                    Identifier.of(Stellamecanics.MOD_ID, "forge_stellaire"),
                    new RecipeType<ForgeStellaireRecipe>() {
                        @Override
                        public String toString() {
                            return "forge_stellaire";
                        }
                    }
            );

    public static void registerRecipeTypes() {
        Stellamecanics.LOGGER.info("Registering Recipe Types Handlers for " + Stellamecanics.MOD_ID);
    }
}
