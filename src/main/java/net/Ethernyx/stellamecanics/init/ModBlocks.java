package net.Ethernyx.stellamecanics.init;

import net.Ethernyx.stellamecanics.Main;
import net.Ethernyx.stellamecanics.block.*;
import net.Ethernyx.stellamecanics.block.ore.*;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.ICommun;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.Ethernyx.stellamecanics.utils.generator.LinkIItemProvidderAndAidInfoGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {
    public static Map<String, LinkIItemProvidderAndAidInfoGenerator> BLOCKS = new HashMap<>();

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
    //public static final Block FORGE_STELLAIRE = addNewBlock(ForgeStellaireBlock.getId(), new ForgeStellaireBlock());
    
    public static Block addNewBlock(String name, Block block) {
        BLOCKS.put(name, new LinkIItemProvidderAndAidInfoGenerator(block, ((ICommun) block).getData(), InstanceType.BLOCK));
        importToItem(name, block, ((ICommun) block).getData());
        return Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, name), (Block) block);
    }

    public static void importToItem(String name, Block blockItem, AidInfoGenerator data) {
        ModItems.addNewItem(name, new BlockItem(blockItem, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)), data);
    }

    public static void registerModBlocks() { Main.LOGGER.debug("Registering Mod Blocks for " + Main.MOD_ID); }
}
