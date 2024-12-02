package fr.ethernyx.stellamecanics.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.GenerationStep;

import java.util.function.Predicate;

public class ModWorldGeneration  {
    public static void generateOres() {
        ModWorldPlacedFeatures.PLACED_FEATURE.forEach((key, item) -> {
            Predicate<BiomeSelectionContext> biomeSelector = null;
            if (item.getDimension() == DimensionOptions.OVERWORLD) biomeSelector = BiomeSelectors.foundInOverworld();
            else if (item.getDimension() == DimensionOptions.NETHER)  biomeSelector = BiomeSelectors.foundInTheNether();
            else if (item.getDimension() == DimensionOptions.END) biomeSelector = BiomeSelectors.foundInTheEnd();
            else return;
            BiomeModifications.addFeature(biomeSelector, GenerationStep.Feature.UNDERGROUND_ORES, item.getRegistryKey());
        });
    }
}
