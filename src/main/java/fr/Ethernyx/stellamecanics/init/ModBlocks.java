package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.block.*;
import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.ForgeStellaire;
import fr.ethernyx.stellamecanics.block.ore.*;
import fr.ethernyx.stellamecanics.interfaces.IMyBlock;
import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ModBlocks {
    public static Map<String, IMyBlock> BLOCKS = new HashMap<>();

    public static final Block MAGNETITE_ORE = addNewBlock(MagnetiteOre.ID, MagnetiteOre::new);
    public static final Block ZIRCONIUM_ORE = addNewBlock(ZirconiumOre.ID, ZirconiumOre::new);
    public static final Block IRIDIUM_ORE = addNewBlock(IridiumOre.ID, IridiumOre::new);
    public static final Block SOLARIUM_ORE = addNewBlock(SolariumOre.ID, SolariumOre::new);
    public static final Block LUNARIUM_ORE = addNewBlock(LunariumOre.ID, LunariumOre::new);
    public static final Block ZIRCONIUM_BLOCK = addNewBlock(ZirconiumBlock.ID, ZirconiumBlock::new);
    public static final Block IRIDIUM_BLOCK = addNewBlock(IridiumBlock.ID, IridiumBlock::new);
    public static final Block ZIRCALOY_BLOCK = addNewBlock(ZircaloyBlock.ID, ZircaloyBlock::new);
    public static final Block OSMIRIDIUM_BLOCK = addNewBlock(OsmiridiumBlock.ID, OsmiridiumBlock::new);
    public static final Block SOLARIUM_BLOCK = addNewBlock(SolariumBlock.ID, SolariumBlock::new);
    public static final Block LUNARIUM_BLOCK = addNewBlock(LunariumBlock.ID, LunariumBlock::new);
    public static final Block STELLARIUM_BLOCK = addNewBlock(StellariumBlock.ID, StellariumBlock::new);

    public static final Block FORGE_STELLAIRE = addNewBlock(ForgeStellaire.ID, ForgeStellaire::new);


    private static Block addNewBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        BLOCKS.put(name, (IMyBlock) function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Stellamecanics.MOD_ID, name)))));
        registerBlockItem(name, (Block) BLOCKS.get(name));
        return Registry.register(Registries.BLOCK, Identifier.of(Stellamecanics.MOD_ID, name), (Block) BLOCKS.get(name));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Stellamecanics.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Stellamecanics.MOD_ID, name)))));
    }

    /*public static <T extends Block & IMyBlock> T addNewItem(
            String name,
            Function<Block.Settings, T> factory
    ) {
        Identifier id = Identifier.of(Stellamecanics.MOD_ID, name);

        AbstractBlock.Settings settings = new AbstractBlock.Settings().create()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, id));

        T block = factory.apply(settings);

        Registry.register(Registries.BLOCK, id, block);
        BLOCKS.put(name, block);
        return block;
    }*/

    public static void registerModBlocks() { Stellamecanics.LOGGER.debug("Registering Mod Blocks for " + Stellamecanics.MOD_ID); }
}
