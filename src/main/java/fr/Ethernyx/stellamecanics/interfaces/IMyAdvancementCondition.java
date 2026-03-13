package fr.ethernyx.stellamecanics.interfaces;

import net.minecraft.advancement.Advancement;
import net.minecraft.registry.RegistryWrapper;

public interface IMyAdvancementCondition {
    void apply(Advancement.Builder builder, RegistryWrapper.WrapperLookup lookup);
}
