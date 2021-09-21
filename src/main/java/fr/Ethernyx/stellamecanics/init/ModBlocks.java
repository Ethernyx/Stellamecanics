package fr.Ethernyx.stellamecanics.init;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.block.*;
import fr.Ethernyx.stellamecanics.block.ore.*;
import fr.Ethernyx.stellamecanics.block.tileentity.ForgeStellaireBlock;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static final RegistryObject<Block> MAGNETITE_ORE = createBlock(new MagnetiteOre().getId(), MagnetiteOre::new);
    public static final RegistryObject<Block> ZIRCONIUM_ORE = createBlock(new ZirconiumOre().getId(), ZirconiumOre::new);
    public static final RegistryObject<Block> IRIDIUM_ORE = createBlock(new IridiumOre().getId(), IridiumOre::new);
    public static final RegistryObject<Block> SOLARIUM_ORE = createBlock(new SolariumOre().getId(), SolariumOre::new);
    public static final RegistryObject<Block> LUNARIUM_ORE = createBlock(new LunariumOre().getId(), LunariumBlock::new);
    public static final RegistryObject<Block> ZIRCONIUM_BLOCK = createBlock(new ZirconiumBlock().getId(), ZirconiumBlock::new);
    public static final RegistryObject<Block> IRIDIUM_BLOCK = createBlock(new IridiumBlock().getId(), IridiumBlock::new);
    public static final RegistryObject<Block> ZIRCALOY_BLOCK = createBlock(new ZircaloyBlock().getId(),  ZircaloyBlock::new);
    public static final RegistryObject<Block> OSMIRIDIUM_BLOCK = createBlock(new OsmiridiumBlock().getId(), OsmiridiumBlock::new);
    public static final RegistryObject<Block> SOLARIUM_BLOCK = createBlock(new SolariumBlock().getId(), SolariumBlock::new);
    public static final RegistryObject<Block> LUNARIUM_BLOCK = createBlock(new LunariumBlock().getId(), LunariumBlock::new);
    public static final RegistryObject<Block> STELLARIUM_BLOCK = createBlock(new StellariumBlock().getId(), StellariumBlock::new);
    public static final RegistryObject<Block> FORGE_STELLAIRE = createBlock("forge_stellaire", ForgeStellaireBlock::new);

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier) {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
        return block;
    }
}
