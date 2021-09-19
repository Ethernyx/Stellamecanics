package fr.Ethernyx.stellamecanics.init;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.block.ForgeStellaireBlock;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);

    public static final RegistryObject<Block> MAGNETITE_ORE = createBlock("magnetite_ore", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ZIRCONIUM_ORE = createBlock("zirconium_ore", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> IRIDIUM_ORE = createBlock("iridium_ore", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SOLARIUM_ORE = createBlock("solarium_ore", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LUNARIUM_ORE = createBlock("lunarium_ore", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ZIRCONIUM_BLOCK = createBlock("zirconium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> IRIDIUM_BLOCK = createBlock("iridium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> ZIRCALOY_BLOCK = createBlock("zircaloy_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> OSMIRIDIUM_BLOCK = createBlock("osmiridium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> SOLARIUM_BLOCK = createBlock("solarium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> LUNARIUM_BLOCK = createBlock("lunarium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> STELLARIUM_BLOCK = createBlock("stellarium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> FORGE_STELLAIRE = createBlock("forge_stellaire", ForgeStellaireBlock::new);

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier) {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
        return block;
    }
}
