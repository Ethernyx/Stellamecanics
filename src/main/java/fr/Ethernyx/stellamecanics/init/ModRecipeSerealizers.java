package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeSerealizers {
    public static final RecipeSerializer<ForgeStellaireRecipe> FORGE_STELLAIRE =
            Registry.register(
                    Registries.RECIPE_SERIALIZER,
                    Identifier.of(Stellamecanics.MOD_ID, "forge_stellaire"),
                    new ForgeStellaireRecipe.ForgeStellaireRecipeSerializer()
            );

    public static void registerRecipeSerealizers() {
        Stellamecanics.LOGGER.info("Registering Recipe Serealizers for " + Stellamecanics.MOD_ID);
    }
}
