package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.ForgeStellaire;
import fr.ethernyx.stellamecanics.interfaces.IMyBlock;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.ethernyx.stellamecanics.utils.generator.LootType;
import fr.ethernyx.stellamecanics.utils.generator.MyLootTable;
import fr.ethernyx.stellamecanics.utils.generic.GenericBlocks;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModBlocks {
    public static Map<String, IMyBlock> BLOCKS = new HashMap<>();

    public static final Block MAGNETITE_ORE = addNewBlock(
            new GenericBlocks("magnetite_ore",
                    new MyLootTable(LootType.LUCKY_ORE,
                            new MyIngredient("magnetite_raw", InstanceType.ITEM, 1, 3)),
                    Map.of("fr_fr", "Minerai de magnétite", "en_us", "Magnetite ore"),
                    List.of(BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_DIAMOND_TOOL),
                    null
            ));
    public static final Block ZIRCONIUM_ORE = addNewBlock(
            new GenericBlocks("zirconium_ore",
                    new MyLootTable(LootType.ORE,
                            new MyIngredient("zirconium_raw", InstanceType.ITEM, 1)),
                    Map.of("fr_fr", "Minerai de zirconium", "en_us", "Zirconium ore"),
                    List.of(BlockTags.PICKAXE_MINEABLE, ModTags.Blocks.BLOCKTAGS.get("need_lvl_4").getTag()),
                    List.of(new RecipeBuilder("ore_to_zirconium_ingot", RecipeType.ORE,
                            List.of(new MyIngredient("zirconium_ore", InstanceType.BLOCK, 1)),
                            List.of(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))))
            ));
    public static final Block IRIDIUM_ORE = addNewBlock(
            new GenericBlocks("iridium_ore",
                    new MyLootTable(LootType.ORE, new MyIngredient("iridium_raw", InstanceType.ITEM, 1)),
                    Map.of("fr_fr", "Minerai d'iridium", "en_us", "Iridium ore"),
                    List.of(BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_DIAMOND_TOOL),
                    List.of(new RecipeBuilder("ore_to_iridium_ingot", RecipeType.ORE,
                            List.of(new MyIngredient("iridium_ore", InstanceType.BLOCK, 1)),
                            List.of(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))))
            ));
    public static final Block SOLARIUM_ORE = addNewBlock(
            new GenericBlocks("solarium_ore",
                    new MyLootTable(LootType.ORE, new MyIngredient("solarium_raw", InstanceType.ITEM, 1)),
                    Map.of("fr_fr", "Minerai de solarium", "en_us", "Solarium ore"),
                    List.of(BlockTags.PICKAXE_MINEABLE, ModTags.Blocks.BLOCKTAGS.get("need_lvl_5").getTag()),
                    List.of(new RecipeBuilder("ore_to_solarium_ingot", RecipeType.ORE,
                            List.of(new MyIngredient("solarium_ore", InstanceType.BLOCK, 1)),
                            List.of(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))))
            ));
    public static final Block LUNARIUM_ORE = addNewBlock(
            new GenericBlocks("lunarium_ore",
                    new MyLootTable(LootType.ORE, new MyIngredient("lunarium_raw", InstanceType.ITEM, 1)),
                    Map.of("fr_fr", "Minerai de lunarium", "en_us", "Lunarium ore"),
                    List.of(BlockTags.PICKAXE_MINEABLE, ModTags.Blocks.BLOCKTAGS.get("need_lvl_5").getTag()),
                    List.of(new RecipeBuilder("ore_to_lunarium_ingot", RecipeType.ORE,
                            List.of(new MyIngredient("lunarium_ore", InstanceType.BLOCK, 1)),
                            List.of(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))))
            ));
    public static final Block ZIRCONIUM_BLOCK = addNewBlock(
            new GenericBlocks("zirconium_block",
                    new MyLootTable(LootType.NORMAL, new MyIngredient("zirconium_block", InstanceType.BLOCK, 1)),
                    Map.of("fr_fr", "Bloc de zirconium", "en_us", "Zirconium block"),
                    List.of(BlockTags.PICKAXE_MINEABLE, ModTags.Blocks.BLOCKTAGS.get("need_lvl_4").getTag()),
                    List.of(new RecipeBuilder("zirconium_ingot", RecipeType.SHAPELLESS,
                            List.of(new MyIngredient("zirconium_block", InstanceType.BLOCK, 1)),
                            List.of(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 9))))
            ));
    public static final Block IRIDIUM_BLOCK = addNewBlock(
            new GenericBlocks("iridium_block",
                    new MyLootTable(LootType.NORMAL, new MyIngredient("iridium_block", InstanceType.BLOCK, 1)),
                    Map.of("fr_fr", "Bloc d'iridium", "en_us", "Iridium block"),
                    List.of(BlockTags.PICKAXE_MINEABLE, BlockTags.NEEDS_DIAMOND_TOOL),
                    List.of(new RecipeBuilder("iridium_ingot", RecipeType.SHAPELLESS,
                            List.of(new MyIngredient("iridium_block", InstanceType.BLOCK, 1)),
                            List.of(new MyIngredient("iridium_ingot", InstanceType.ITEM, 9))))
            ));
    public static final Block ZIRCALOY_BLOCK = addNewBlock(
            new GenericBlocks("zircaloy_block",
                    new MyLootTable(LootType.NORMAL, new MyIngredient("zircaloy_block", InstanceType.BLOCK, 1)),
                    Map.of("fr_fr", "Bloc de zircaloy", "en_us", "Zircaloy block"),
                    List.of(BlockTags.PICKAXE_MINEABLE, ModTags.Blocks.BLOCKTAGS.get("need_lvl_6").getTag()),
                    List.of(new RecipeBuilder("zircaloy_ingot", RecipeType.SHAPELLESS,
                            List.of(new MyIngredient("zircaloy_block", InstanceType.BLOCK, 1)),
                            List.of(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 9))))
            ));
    public static final Block OSMIRIDIUM_BLOCK = addNewBlock(
            new GenericBlocks("osmiridium_block",
                    new MyLootTable(LootType.NORMAL, new MyIngredient("osmiridium_block", InstanceType.BLOCK, 1)),
                    Map.of("fr_fr", "Bloc d'osmiridium", "en_us", "Osmiridium block"),
                    List.of(BlockTags.PICKAXE_MINEABLE, ModTags.Blocks.BLOCKTAGS.get("need_lvl_6").getTag()),
                    List.of(new RecipeBuilder("osmiridium_ingot", RecipeType.SHAPELLESS,
                            List.of(new MyIngredient("osmiridium_block", InstanceType.BLOCK, 1)),
                            List.of(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 9))))
            ));
    public static final Block SOLARIUM_BLOCK = addNewBlock(
            new GenericBlocks("solarium_block",
                    new MyLootTable(LootType.NORMAL, new MyIngredient("solarium_block", InstanceType.BLOCK, 1)),
                    Map.of("fr_fr", "Bloc de solarium", "en_us", "Solarium block"),
                    List.of(BlockTags.PICKAXE_MINEABLE, ModTags.Blocks.BLOCKTAGS.get("need_lvl_5").getTag()),
                    List.of(new RecipeBuilder("solarium_ingot", RecipeType.SHAPELLESS,
                            List.of(new MyIngredient("solarium_block", InstanceType.BLOCK, 1)),
                            List.of(new MyIngredient("solarium_ingot", InstanceType.ITEM, 9))))
            ));
    public static final Block LUNARIUM_BLOCK = addNewBlock(
            new GenericBlocks("lunarium_block",
                    new MyLootTable(LootType.NORMAL, new MyIngredient("lunarium_block", InstanceType.BLOCK, 1)),
                    Map.of("fr_fr", "Bloc de lunarium", "en_us", "Lunarium block"),
                    List.of(BlockTags.PICKAXE_MINEABLE, ModTags.Blocks.BLOCKTAGS.get("need_lvl_5").getTag()),
                    List.of(new RecipeBuilder("lunarium_ingot", RecipeType.SHAPELLESS,
                            List.of(new MyIngredient("lunarium_block", InstanceType.BLOCK, 1)),
                            List.of(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 9))))
            ));
    public static final Block STELLARIUM_BLOCK = addNewBlock(
            new GenericBlocks("stellarium_block",
                    new MyLootTable(LootType.NORMAL, new MyIngredient("stellarium_block", InstanceType.BLOCK, 1)),
                    Map.of("fr_fr", "Bloc de stellarium", "en_us", "Stellarium block"),
                    List.of(BlockTags.PICKAXE_MINEABLE, ModTags.Blocks.BLOCKTAGS.get("need_lvl_6").getTag()),
                    List.of(new RecipeBuilder("stellarium_ingot", RecipeType.SHAPELLESS,
                            List.of(new MyIngredient("stellarium_block", InstanceType.BLOCK, 1)),
                            List.of(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 9))))
            ));
    public static final Block FORGE_STELLAIRE = addNewBlock(
            new ForgeStellaire("forge_stellaire",
                    new MyLootTable(LootType.NORMAL, new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1)),
                    Map.of("fr_fr", "Forge Stellaire", "en_us", "Stellar forge"),
                    List.of(BlockTags.PICKAXE_MINEABLE),
                    List.of(new RecipeBuilder("forge_stellaire", RecipeType.SHAPE,
                            List.of(new MyIngredient("iridium_block", InstanceType.BLOCK, 1),
                                    new MyIngredient("iridium_ingot", InstanceType.ITEM, 1),
                                    new MyIngredient("furnace", InstanceType.VANILLABLOCK, 1)),
                            List.of(new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1)),
                            List.of("0 0", "121", "111"),
                            List.of(new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1))))
            ));
    public static <T extends Block & IMyBlock> T addNewBlock(T block) {
        Registry.register(Registries.BLOCK, Identifier.of(Stellamecanics.MOD_ID, block.getId()), block);
        BLOCKS.put(block.getId(), block);
        registerBlockItem(block);
        return block;
    }

    private static <T extends Block & IMyBlock> void registerBlockItem(T block) {
        Registry.register(Registries.ITEM, Identifier.of(Stellamecanics.MOD_ID, block.getId()),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Stellamecanics.MOD_ID, block.getId())))));
    }

    public static void registerModBlocks() { Stellamecanics.LOGGER.debug("Registering Mod Blocks for " + Stellamecanics.MOD_ID); }
}
