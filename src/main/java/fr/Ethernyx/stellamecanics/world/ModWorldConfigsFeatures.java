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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModWorldConfigsFeatures extends OreConfiguredFeatures {
    public static Map<String, MyFeatureConfig> CONFIG_FEATURE = new HashMap<>();

    private static final RuleTest STONE_REPLACEABLES = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
    private static final RuleTest NETHER_REPLACEABLES = new BlockMatchRuleTest(Blocks.NETHERRACK);
    private static final RuleTest END_REPLACEABLES = new BlockMatchRuleTest(Blocks.END_STONE);


    public static final RegistryKey<ConfiguredFeature<?, ?>> OVERWORLD_IRIDIUM_ORES = registerFeatureConfig("iridium_ore", Map.of(STONE_REPLACEABLES, ModBlocks.IRIDIUM_ORE.getDefaultState()),6);
    public static final RegistryKey<ConfiguredFeature<?, ?>> OVERWORLD_ZIRCONIUM_ORES = registerFeatureConfig("zirconium_ore", Map.of(STONE_REPLACEABLES, ModBlocks.ZIRCONIUM_ORE.getDefaultState()), 6);
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_LUNARIUM_ORES = registerFeatureConfig("lunarium_ore", Map.of(END_REPLACEABLES, ModBlocks.LUNARIUM_ORE.getDefaultState()), 6);
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_SOLARIUM_ORES = registerFeatureConfig("solarium_ore", Map.of(NETHER_REPLACEABLES, ModBlocks.SOLARIUM_ORE.getDefaultState()), 6);

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        CONFIG_FEATURE.forEach((key, item) -> {
            register(context, item.getRegistryKey(), Feature.ORE, new OreFeatureConfig(item.getFeatureConfig(), item.getSize()));
        });
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> registerFeatureConfig(String name, Map<RuleTest, BlockState> ruleConfigs, int size) {
        List<OreFeatureConfig.Target> list = new ArrayList<>();

        ruleConfigs.forEach((rule, config) -> {
            list.add(OreFeatureConfig.createTarget(rule, config));
        });

        CONFIG_FEATURE.put(name, new MyFeatureConfig(list, name, size));
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