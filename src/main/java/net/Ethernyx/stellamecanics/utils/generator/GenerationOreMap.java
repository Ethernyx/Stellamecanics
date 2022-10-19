package net.Ethernyx.stellamecanics.utils.generator;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.feature.PlacedFeature;

public class GenerationOreMap {
    private final RegistryEntry<PlacedFeature> feature;
    private final RegistryKey<DimensionOptions> dimension;


    public GenerationOreMap(RegistryEntry<PlacedFeature> feature, RegistryKey<DimensionOptions> dimension) {
        this.feature = feature;
        this.dimension = dimension;
    }

    public RegistryKey<DimensionOptions> getDimension() {
        return dimension;
    }

    public RegistryEntry<PlacedFeature> getFeature() {
        return feature;
    }
}
