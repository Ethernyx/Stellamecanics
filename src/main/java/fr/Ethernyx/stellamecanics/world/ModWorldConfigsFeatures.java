package fr.ethernyx.stellamecanics.world;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.utils.world.MyFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModWorldConfigsFeatures extends OreConfiguredFeatures {
    public static Map<String, MyFeatureConfig> CONFIG_FEATURE = new HashMap<>();

    public static final RegistryKey<ConfiguredFeature<?, ?>> OVERWORLD_IRIDIUM_ORES = registerFeatureConfig("iridium_ore", new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.IRIDIUM_ORE.getDefaultState(),6);
    public static final RegistryKey<ConfiguredFeature<?, ?>> OVERWORLD_ZIRCONIUM_ORES = registerFeatureConfig("zirconium_ore", new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.ZIRCONIUM_ORE.getDefaultState(), 6);
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_LUNARIUM_ORES = registerFeatureConfig("lunarium_ore", new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.LUNARIUM_ORE.getDefaultState(), 6);
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_SOLARIUM_ORES = registerFeatureConfig("solarium_ore", new BlockMatchRuleTest(Blocks.NETHERRACK), ModBlocks.SOLARIUM_ORE.getDefaultState(), 6);

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        CONFIG_FEATURE.forEach((key, item) -> {
            register(context, item.getRegistryKey(), Feature.ORE, new OreFeatureConfig(item.getFeatureConfig(), item.getSize()));
        });
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> registerFeatureConfig(String name, RuleTest rule, BlockState state, int size) {
        CONFIG_FEATURE.put(name, new MyFeatureConfig(List.of(OreFeatureConfig.createTarget(rule, state)), name, size));
        return CONFIG_FEATURE.get(name).getRegistryKey();
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                   F feature,
                                                                                   FC featureConfig) {
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }

    public static void registerConfiguredFeatures() {
        Stellamecanics.LOGGER.debug("Registering the ModConfiguredFeatures for " + Stellamecanics.MOD_ID);
    }
}