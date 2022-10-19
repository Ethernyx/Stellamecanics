package net.Ethernyx.stellamecanics.world;

import net.Ethernyx.stellamecanics.Main;
import net.Ethernyx.stellamecanics.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModWorldConfigsFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_IRIDIUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.IRIDIUM_ORE.getDefaultState()));
    public static final List<OreFeatureConfig.Target> OVERWORLD_ZIRCONIUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ZIRCONIUM_ORE.getDefaultState()));
    public static final List<OreFeatureConfig.Target> END_LUNARIUM_ORES = List.of(
            OreFeatureConfig.createTarget(new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.LUNARIUM_ORE.getDefaultState()));
    public static final List<OreFeatureConfig.Target> NETHER_SOLARIUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER, ModBlocks.SOLARIUM_ORE.getDefaultState()));


    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> IRIDIUM_ORE =
            ConfiguredFeatures.register("iridium_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_IRIDIUM_ORES, 6));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ZIRCONIUM_ORE =
            ConfiguredFeatures.register("zirconium_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_ZIRCONIUM_ORES, 6));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LUNARIUM_ORE =
            ConfiguredFeatures.register("lunarium_ore", Feature.ORE, new OreFeatureConfig(END_LUNARIUM_ORES, 6));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> SOLARIUM_ORE =
            ConfiguredFeatures.register("solarium_ore", Feature.ORE, new OreFeatureConfig(NETHER_SOLARIUM_ORES, 6));

    public static void registerConfiguredFeatures() {
        Main.LOGGER.debug("Registering the ModConfiguredFeatures for " + Main.MOD_ID);
    }
}
