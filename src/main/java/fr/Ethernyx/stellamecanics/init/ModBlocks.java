package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.block.*;
import fr.ethernyx.stellamecanics.block.ore.*;
import fr.ethernyx.stellamecanics.interfaces.IMyBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {
    public static Map<String, IMyBlock> BLOCKS = new HashMap<>();

    public static final Block MAGNETITE_ORE = addNewBlock(MagnetiteOre.getId(), new MagnetiteOre());
    public static final Block ZIRCONIUM_ORE = addNewBlock(ZirconiumOre.getId(), new ZirconiumOre());
    public static final Block IRIDIUM_ORE = addNewBlock(IridiumOre.getId(), new IridiumOre());
    public static final Block SOLARIUM_ORE = addNewBlock(SolariumOre.getId(), new SolariumOre());
    public static final Block LUNARIUM_ORE = addNewBlock(LunariumOre.getId(), new LunariumOre());
    public static final Block ZIRCONIUM_BLOCK = addNewBlock(ZirconiumBlock.getId(), new ZirconiumBlock());
    public static final Block IRIDIUM_BLOCK = addNewBlock(IridiumBlock.getId(), new IridiumBlock());
    public static final Block ZIRCALOY_BLOCK = addNewBlock(ZircaloyBlock.getId(), new ZircaloyBlock());
    public static final Block OSMIRIDIUM_BLOCK = addNewBlock(OsmiridiumBlock.getId(), new OsmiridiumBlock());
    public static final Block SOLARIUM_BLOCK = addNewBlock(SolariumBlock.getId(), new SolariumBlock());
    public static final Block LUNARIUM_BLOCK = addNewBlock(LunariumBlock.getId(), new LunariumBlock());
    public static final Block STELLARIUM_BLOCK = addNewBlock(StellariumBlock.getId(), new StellariumBlock());


    private static Block addNewBlock(String name, Block block) {
        BLOCKS.put(name, (IMyBlock) block);
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Stellamecanics.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Stellamecanics.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() { Stellamecanics.LOGGER.debug("Registering Mod Blocks for " + Stellamecanics.MOD_ID); }
}
