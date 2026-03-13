package fr.ethernyx.stellamecanics.builders.advancements.criterionTypes;

import fr.ethernyx.stellamecanics.interfaces.IMyAdvancementCondition;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.criterion.TickCriterion;
import net.minecraft.registry.RegistryWrapper;

public record NoneCondition() implements IMyAdvancementCondition {
    @Override
    public void apply(Advancement.Builder builder, RegistryWrapper.WrapperLookup lookup) {
        builder.criterion("tick", TickCriterion.Conditions.createTick());
    }
}
