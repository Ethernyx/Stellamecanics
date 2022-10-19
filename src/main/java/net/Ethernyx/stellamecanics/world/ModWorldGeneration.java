package net.Ethernyx.stellamecanics.world;

import net.Ethernyx.stellamecanics.utils.generator.GenerationOreMap;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.GenerationStep;

import java.util.function.Predicate;

public class ModWorldGeneration {
    public static void generateOres() {

       for (GenerationOreMap ore : ModWorldFeatures.GEN_ORE.values()) {
           Predicate<BiomeSelectionContext> biomeSelector = null;
           if (ore.getDimension() == DimensionOptions.OVERWORLD) biomeSelector = BiomeSelectors.foundInOverworld();
           else if (ore.getDimension() == DimensionOptions.NETHER)  biomeSelector = BiomeSelectors.foundInTheNether();
           else if (ore.getDimension() == DimensionOptions.END) biomeSelector = BiomeSelectors.foundInTheEnd();
           BiomeModifications.addFeature(biomeSelector, GenerationStep.Feature.UNDERGROUND_ORES, ore.getFeature().getKey().get());
       }
    }
}
