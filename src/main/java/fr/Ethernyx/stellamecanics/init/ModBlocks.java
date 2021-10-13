package fr.Ethernyx.stellamecanics.init;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.block.*;
import fr.Ethernyx.stellamecanics.block.ore.*;
import fr.Ethernyx.stellamecanics.block.tileentity.ForgeStellaireBlock;
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.Ethernyx.stellamecanics.utils.generator.LinkIItemProvidderAndAidInfoGenerator;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {

    public static Map<String, LinkIItemProvidderAndAidInfoGenerator> MAP_BLOCKS = new HashMap<>();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static final RegistryObject<Block> MAGNETITE_ORE = createBlock(new MagnetiteOre(), MagnetiteOre::new);
    public static final RegistryObject<Block> ZIRCONIUM_ORE = createBlock(new ZirconiumOre(), ZirconiumOre::new);
    public static final RegistryObject<Block> IRIDIUM_ORE = createBlock(new IridiumOre(), IridiumOre::new);
    public static final RegistryObject<Block> SOLARIUM_ORE = createBlock(new SolariumOre(), SolariumOre::new);
    public static final RegistryObject<Block> LUNARIUM_ORE = createBlock(new LunariumOre(), LunariumBlock::new);
    public static final RegistryObject<Block> ZIRCONIUM_BLOCK = createBlock(new ZirconiumBlock(), ZirconiumBlock::new);
    public static final RegistryObject<Block> IRIDIUM_BLOCK = createBlock(new IridiumBlock(), IridiumBlock::new);
    public static final RegistryObject<Block> ZIRCALOY_BLOCK = createBlock(new ZircaloyBlock(),  ZircaloyBlock::new);
    public static final RegistryObject<Block> OSMIRIDIUM_BLOCK = createBlock(new OsmiridiumBlock(), OsmiridiumBlock::new);
    public static final RegistryObject<Block> SOLARIUM_BLOCK = createBlock(new SolariumBlock(), SolariumBlock::new);
    public static final RegistryObject<Block> LUNARIUM_BLOCK = createBlock(new LunariumBlock(), LunariumBlock::new);
    public static final RegistryObject<Block> STELLARIUM_BLOCK = createBlock(new StellariumBlock(), StellariumBlock::new);
    public static final RegistryObject<Block> FORGE_STELLAIRE = createBlock(new ForgeStellaireBlock(), ForgeStellaireBlock::new);

    public static RegistryObject<Block> createBlock(ICommun my_class, Supplier<? extends Block> supplier) {

        RegistryObject<Block> block = BLOCKS.register(my_class.getId(), supplier);
        ModItems.createItem(my_class, () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
       // ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
        MAP_BLOCKS.put(my_class.getId(), new LinkIItemProvidderAndAidInfoGenerator(block, my_class.getData(), InstanceType.BLOCK));
        return block;
    }
}
