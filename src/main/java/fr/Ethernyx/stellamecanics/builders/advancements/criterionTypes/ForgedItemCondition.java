package fr.ethernyx.stellamecanics.builders.advancements.criterionTypes;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModCriteria;
import fr.ethernyx.stellamecanics.interfaces.IMyAdvancementCondition;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.RecipeCraftedCriterion;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public record ForgedItemCondition(List<RecipeCondition> recipes, boolean all) implements IMyAdvancementCondition {

    public record RecipeCondition(String recipeId, RecipeType recipeType) {}

    public ForgedItemCondition(List<RecipeCondition> recipes) { this(recipes, false); }

    public static RecipeCondition addRecipe(String id, RecipeType recipeType) { return new RecipeCondition(id, recipeType); }

    @Override
    public void apply(Advancement.Builder builder, RegistryWrapper.WrapperLookup lookup) {
        List<String> criterion = new ArrayList<>();
        recipes.forEach((recipe) -> {
            switch (recipe.recipeType()) {
                case FORGE -> {
                    builder.criterion("criterion_recipe_" + recipe.recipeId(),
                            new AdvancementCriterion<>(ModCriteria.FORGE_STELLAIRE_USED,
                                    ModCriteria.FORGE_STELLAIRE_USED.create(Identifier.of(Stellamecanics.MOD_ID, recipe.recipeId())))
                    );

                }
                case SHAPELLESS, SHAPE -> {
                    builder.criterion("criterion_recipe_" + recipe.recipeId(),
                            RecipeCraftedCriterion.Conditions.create(
                                    RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(Stellamecanics.MOD_ID, recipe.recipeId()))
                            )
                    );
                }
                default -> throw new IllegalStateException("Advancement ['" + recipe.recipeType() + "'] : ce type de craft n'as pas été prototypé");
            }
            criterion.add("criterion_recipe_" + recipe.recipeId());

        });
        if (!criterion.isEmpty()) {
            if (all) builder.requirements(AdvancementRequirements.allOf(criterion));
            else builder.requirements(AdvancementRequirements.anyOf(criterion));
        }
    }
}
