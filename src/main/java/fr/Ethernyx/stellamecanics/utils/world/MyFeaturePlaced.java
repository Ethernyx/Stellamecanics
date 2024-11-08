package fr.ethernyx.stellamecanics.utils.world;

import fr.ethernyx.stellamecanics.Stellamecanics;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.feature.PlacedFeature;

public class MyFeaturePlaced {
    private final RegistryKey<PlacedFeature> registryKey;
    private final int count;
    private final int yMin;
    private final int yMax;
    private final String name;
    private final RegistryKey<DimensionOptions> dimension;


    public MyFeaturePlaced( RegistryKey<DimensionOptions> dimension, String name, int count, int yMin, int yMax) {
        this.name = name;
        this.registryKey = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Stellamecanics.MOD_ID, name));
        this.count = count;
        this.yMin = yMin;
        this.yMax = yMax;
        this.dimension = dimension;
    }

    public RegistryKey<PlacedFeature> getRegistryKey() {
        return registryKey;
    }

    public int getyMin() {
        return yMin;
    }

    public int getCount() {
        return count;
    }

    public int getyMax() {
        return yMax;
    }

    public RegistryKey<DimensionOptions> getDimension() {
        return dimension;
    }

    public String getName() {
        return name;
    }
}
