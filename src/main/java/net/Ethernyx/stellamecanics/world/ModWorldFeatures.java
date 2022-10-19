package net.Ethernyx.stellamecanics.world;

import net.Ethernyx.stellamecanics.utils.generator.GenerationOreMap;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModWorldFeatures {

    public static Map<String, GenerationOreMap> GEN_ORE = new HashMap<>();
    public static final RegistryEntry<PlacedFeature> IRIDIUM_ORE_PLACED = registerFeature(DimensionOptions.OVERWORLD, PlacedFeatures.register("iridium_ore_placed",
            ModWorldConfigsFeatures.IRIDIUM_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))));
    public static final RegistryEntry<PlacedFeature> ZIRCONIUM_ORE_PLACED = registerFeature(DimensionOptions.OVERWORLD, PlacedFeatures.register("zirconium_ore_placed",
            ModWorldConfigsFeatures.ZIRCONIUM_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))));
    public static final RegistryEntry<PlacedFeature> LUNARIUM_ORE_PLACED = registerFeature(DimensionOptions.END, PlacedFeatures.register("lunarium_ore_placed",
            ModWorldConfigsFeatures.LUNARIUM_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))));
    public static final RegistryEntry<PlacedFeature> SOLARIUM_ORE_PLACED = registerFeature(DimensionOptions.NETHER, PlacedFeatures.register("solarium_ore_placed",
            ModWorldConfigsFeatures.SOLARIUM_ORE, modifiersWithCount(10,
                    HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))));


    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }

    private static RegistryEntry<PlacedFeature> registerFeature(RegistryKey<DimensionOptions> dim, RegistryEntry<PlacedFeature> feature) {
        GEN_ORE.put(feature.getKey().toString(), new GenerationOreMap(feature, dim));
        return feature;
    }
}
