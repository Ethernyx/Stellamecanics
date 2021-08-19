package fr.Ethernyx.stellamecanics.init;



import com.google.common.eventbus.Subscribe;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;

public class ModGenerationWorld {

    public ConfiguredFeature<?, ?> MAGNETITE_ORE_FEATURE;
    public ConfiguredFeature<?, ?> ZIRCONIUM_ORE_FEATURE;
    public ConfiguredFeature<?, ?> IRIDIUM_ORE_FEATURE;
    public void init() {
        MAGNETITE_ORE_FEATURE = register("copper_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.MAGNETITE_ORE.get().defaultBlockState(), 10))
                .squared()
                .range(60)
                .count(20));
        ZIRCONIUM_ORE_FEATURE = register("copper_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.MAGNETITE_ORE.get().defaultBlockState(), 10))
                .squared()
                .range(60)
                .count(20));
        IRIDIUM_ORE_FEATURE = register("copper_ore", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.MAGNETITE_ORE.get().defaultBlockState(), 10))
                .squared()
                .range(60)
                .count(20));
    }

    public <FC extends IFeatureConfig> ConfiguredFeature<FC, ?>register(String name, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, name, feature);
    }

    @SubscribeEvent
    public void biomeLoading(BiomeLoadingEvent e) {
        BiomeGenerationSettingsBuilder generation = e.getGeneration();
        if (e.getCategory() != Biome.Category.NETHER) {
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, MAGNETITE_ORE_FEATURE);
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ZIRCONIUM_ORE_FEATURE);
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, IRIDIUM_ORE_FEATURE);
        }

    }
}
