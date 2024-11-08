package fr.ethernyx.stellamecanics.utils.world;

import fr.ethernyx.stellamecanics.Stellamecanics;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class MyFeatureConfig {
    private final List<OreFeatureConfig.Target> featureConfig;
    private final String name;
    private final int size;
    private final RegistryKey<ConfiguredFeature<?, ?>> registryKey;

    public MyFeatureConfig(List<OreFeatureConfig.Target> featureConfig, String name, int size) {
        this.featureConfig = featureConfig;
        this.name = name;
        this.size = size;
        this.registryKey = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Stellamecanics.MOD_ID,name));
    }

    public List<OreFeatureConfig.Target> getFeatureConfig() {
        return featureConfig;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public RegistryKey<ConfiguredFeature<?, ?>> getRegistryKey() {
        return registryKey;
    }
}
