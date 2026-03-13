package fr.ethernyx.stellamecanics.builders.advancements.criterionTypes;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModCriteria;
import fr.ethernyx.stellamecanics.interfaces.IMyAdvancementCondition;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public record ForgedItemCondition(List<String> recipeIds) implements IMyAdvancementCondition {
    @Override
    public void apply(Advancement.Builder builder, RegistryWrapper.WrapperLookup lookup) {
        List<String> criterion = new ArrayList<>();
        recipeIds.forEach((recipeId) -> {
                builder.criterion("criterion_recipe_" + recipeId,
                        new AdvancementCriterion<>(ModCriteria.FORGE_STELLAIRE_USED,
                                ModCriteria.FORGE_STELLAIRE_USED.create(Identifier.of(Stellamecanics.MOD_ID, recipeId)))
                );
                criterion.add("criterion_recipe_" + recipeId);
        });
        if (!criterion.isEmpty()) builder.requirements(AdvancementRequirements.anyOf(criterion));
    }
}
