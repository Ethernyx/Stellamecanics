package fr.ethernyx.stellamecanics.world;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.utils.world.MyFeaturePlaced;
import fr.ethernyx.stellamecanics.utils.world.ModifierPlacementType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModWorldPlacedFeatures {

    public static Map<String, MyFeaturePlaced> PLACED_FEATURE = new HashMap<>();

    public static final RegistryKey<PlacedFeature> IRIDIUM_ORE_PLACED = registerPlacedFeature("iridium_ore", DimensionOptions.OVERWORLD, 10, 2, 80, ModifierPlacementType.UNIFORM);
    public static final RegistryKey<PlacedFeature> ZIRCONIUM_ORE_PLACED = registerPlacedFeature("zirconium_ore", DimensionOptions.OVERWORLD, 10, 2, 80, ModifierPlacementType.UNIFORM);
    public static final RegistryKey<PlacedFeature> LUNARIUM_ORE_PLACED = registerPlacedFeature("lunarium_ore", DimensionOptions.END, 10, 2, 80, ModifierPlacementType.UNIFORM);
    public static final RegistryKey<PlacedFeature> SOLARIUM_ORE_PLACED = registerPlacedFeature("solarium_ore", DimensionOptions.NETHER, 10, 2, 80, ModifierPlacementType.UNIFORM);

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        PLACED_FEATURE.forEach((key, item) -> {
            switch (item.getType()) {
                case UNIFORM:
                    register(context,
                            item.getRegistryKey(),
                            registryLookup.getOrThrow(ModWorldConfigsFeatures.CONFIG_FEATURE.get(key).getRegistryKey()),
                            modifiersWithCount(item.getCount(),
                                    HeightRangePlacementModifier.uniform(
                                            YOffset.fixed(item.getyMin()),
                                            YOffset.fixed(item.getyMax()))));
                    break;
                case TRAPEZOID:
                    /* ymin = le y ou proba la plus faible
                    *  ymax = le y ou la proba est la plus forte
                    * */

                    register(context,
                            item.getRegistryKey(),
                            registryLookup.getOrThrow(ModWorldConfigsFeatures.CONFIG_FEATURE.get(key).getRegistryKey()),
                            modifiersWithCount(item.getCount(),
                                    HeightRangePlacementModifier.trapezoid(
                                            YOffset.fixed(item.getyMin()),
                                            YOffset.fixed(item.getyMax()))));
                    break;
                default:
                    break;
            }
        });
    }


    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }

    /* name, dimension, nb filon / chunk, ymin, ymax, type de placement */

    private static RegistryKey<PlacedFeature> registerPlacedFeature(String name, RegistryKey<DimensionOptions> dim, int count, int yMin, int yMax, ModifierPlacementType type) {
        PLACED_FEATURE.put(name, new MyFeaturePlaced(dim, name, count, yMin, yMax, type));
        return PLACED_FEATURE.get(name).getRegistryKey();
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    public static void registerModWorldFeatures() { Stellamecanics.LOGGER.debug("Registering Mod World Placed Features for " + Stellamecanics.MOD_ID); }
}



