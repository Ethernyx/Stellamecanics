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
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModBlocks {
    public static Map<String, IMyBlock> BLOCKS = new LinkedHashMap<>();

    public static final Block MAGNETITE_ORE = addNewBlock(GenericBlocks.builder("magnetite_ore")
            .lootTable(new MyLootTable(LootType.LUCKY_ORE, new MyIngredient("magnetite_raw", InstanceType.ITEM, 1, 3)))
            .addTranslate("fr_fr", "Minerai de magnétite")
            .addTranslate("en_us", "Magnetite ore")
            .addTag(BlockTags.PICKAXE_MINEABLE)
            .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
            .build());

    public static final Block ZIRCONIUM_ORE = addNewBlock(GenericBlocks.builder("zirconium_ore")
            .lootTable(new MyLootTable(LootType.ORE, new MyIngredient("zirconium_raw", InstanceType.ITEM, 1)))
            .addTranslate("fr_fr", "Minerai de zirconium")
            .addTranslate("en_us", "Zirconium ore")
            .addTag(BlockTags.PICKAXE_MINEABLE)
            .addTag(ModTags.Blocks.NEED_LVL_4)
            .addRecipe(RecipeBuilder.builder("ore_to_zirconium_ingot", RecipeType.ORE)
                    .input(new MyIngredient("zirconium_ore", InstanceType.BLOCK, 1))
                    .output(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))
                    .build())
            .build());

    public static final Block IRIDIUM_ORE = addNewBlock(GenericBlocks.builder("iridium_ore")
            .lootTable(new MyLootTable(LootType.ORE, new MyIngredient("iridium_raw", InstanceType.ITEM, 1)))
            .addTranslate("fr_fr", "Minerai d'iridium")
            .addTranslate("en_us", "Iridium ore")
            .addTag(BlockTags.PICKAXE_MINEABLE)
            .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
            .addRecipe(RecipeBuilder.builder("ore_to_iridium_ingot", RecipeType.ORE)
                    .input(new MyIngredient("iridium_ore", InstanceType.BLOCK, 1))
                    .output(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))
                    .build())
            .build());

    public static final Block SOLARIUM_ORE = addNewBlock(GenericBlocks.builder("solarium_ore")
            .lootTable(new MyLootTable(LootType.ORE, new MyIngredient("solarium_raw", InstanceType.ITEM, 1)))
            .addTranslate("fr_fr", "Minerai de solarium")
            .addTranslate("en_us", "Solarium ore")
            .addTag(BlockTags.PICKAXE_MINEABLE)
            .addTag(ModTags.Blocks.NEED_LVL_5)
            .addRecipe(RecipeBuilder.builder("ore_to_solarium_ingot", RecipeType.ORE)
                    .input(new MyIngredient("solarium_ore", InstanceType.BLOCK, 1))
                    .output(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))
                    .build())
            .build());

    public static final Block LUNARIUM_ORE = addNewBlock(GenericBlocks.builder("lunarium_ore")
            .lootTable(new MyLootTable(LootType.ORE, new MyIngredient("lunarium_raw", InstanceType.ITEM, 1)))
            .addTranslate("fr_fr", "Minerai de lunarium")
            .addTranslate("en_us", "Lunarium ore")
            .addTag(BlockTags.PICKAXE_MINEABLE)
            .addTag(ModTags.Blocks.NEED_LVL_5)
            .addRecipe(RecipeBuilder.builder("ore_to_lunarium_ingot", RecipeType.ORE)
                    .input(new MyIngredient("lunarium_ore", InstanceType.BLOCK, 1))
                    .output(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))
                    .build())
            .build());

    public static final Block ZIRCONIUM_BLOCK = addNewBlock(GenericBlocks.builder("zirconium_block")
            .lootTable(new MyLootTable(LootType.NORMAL, new MyIngredient("zirconium_block", InstanceType.BLOCK, 1)))
            .addTranslate("fr_fr", "Bloc de zirconium")
            .addTranslate("en_us", "Zirconium block")
            .addTag(BlockTags.PICKAXE_MINEABLE)
            .addTag(ModTags.Blocks.NEED_LVL_4)
            .addRecipe(RecipeBuilder.builder("zirconium_ingot", RecipeType.SHAPELLESS)
                    .input(new MyIngredient("zirconium_block", InstanceType.BLOCK, 1))
                    .output(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 9))
                    .build())
            .build());

    public static final Block IRIDIUM_BLOCK = addNewBlock(GenericBlocks.builder("iridium_block")
            .lootTable(new MyLootTable(LootType.NORMAL, new MyIngredient("iridium_block", InstanceType.BLOCK, 1)))
            .addTranslate("fr_fr", "Bloc d'iridium")
            .addTranslate("en_us", "Iridium block")
            .addTag(BlockTags.PICKAXE_MINEABLE)
            .addTag(BlockTags.NEEDS_DIAMOND_TOOL)
            .addRecipe(RecipeBuilder.builder("iridium_ingot", RecipeType.SHAPELLESS)
                    .input(new MyIngredient("iridium_block", InstanceType.BLOCK, 1))
                    .output(new MyIngredient("iridium_ingot", InstanceType.ITEM, 9))
                    .build())
            .build());

    public static final Block ZIRCALOY_BLOCK = addNewBlock(GenericBlocks.builder("zircaloy_block")
            .lootTable(new MyLootTable(LootType.NORMAL, new MyIngredient("zircaloy_block", InstanceType.BLOCK, 1)))
            .addTranslate("fr_fr", "Bloc de zircaloy")
            .addTranslate("en_us", "Zircaloy block")
            .addTag(BlockTags.PICKAXE_MINEABLE)
            .addTag(ModTags.Blocks.NEED_LVL_6)
            .addRecipe(RecipeBuilder.builder("zircaloy_ingot", RecipeType.SHAPELLESS)
                    .input(new MyIngredient("zircaloy_block", InstanceType.BLOCK, 1))
                    .output(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 9))
                    .build())
            .build());

    public static final Block OSMIRIDIUM_BLOCK = addNewBlock(GenericBlocks.builder("osmiridium_block")
            .lootTable(new MyLootTable(LootType.NORMAL, new MyIngredient("osmiridium_block", InstanceType.BLOCK, 1)))
            .addTranslate("fr_fr", "Bloc d'osmiridium")
            .addTranslate("en_us", "Osmiridium block")
            .addTag(BlockTags.PICKAXE_MINEABLE)
            .addTag(ModTags.Blocks.NEED_LVL_6)
            .addRecipe(RecipeBuilder.builder("osmiridium_ingot", RecipeType.SHAPELLESS)
                    .input(new MyIngredient("osmiridium_block", InstanceType.BLOCK, 1))
                    .output(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 9))
                    .build())
            .build());

    public static final Block SOLARIUM_BLOCK = addNewBlock(GenericBlocks.builder("solarium_block")
            .lootTable(new MyLootTable(LootType.NORMAL, new MyIngredient("solarium_block", InstanceType.BLOCK, 1)))
            .addTranslate("fr_fr", "Bloc de solarium")
            .addTranslate("en_us", "Solarium block")
            .addTag(BlockTags.PICKAXE_MINEABLE)
            .addTag(ModTags.Blocks.NEED_LVL_5)
            .addRecipe(RecipeBuilder.builder("solarium_ingot", RecipeType.SHAPELLESS)
                    .input(new MyIngredient("solarium_block", InstanceType.BLOCK, 1))
                    .output(new MyIngredient("solarium_ingot", InstanceType.ITEM, 9))
                    .build())
            .build());

    public static final Block LUNARIUM_BLOCK = addNewBlock(GenericBlocks.builder("lunarium_block")
            .lootTable(new MyLootTable(LootType.NORMAL, new MyIngredient("lunarium_block", InstanceType.BLOCK, 1)))
            .addTranslate("fr_fr", "Bloc de lunarium")
            .addTranslate("en_us", "Lunarium block")
            .addTag(BlockTags.PICKAXE_MINEABLE)
            .addTag(ModTags.Blocks.NEED_LVL_5)
            .addRecipe(RecipeBuilder.builder("lunarium_ingot", RecipeType.SHAPELLESS)
                    .input(new MyIngredient("lunarium_block", InstanceType.BLOCK, 1))
                    .output(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 9))
                    .build())
            .build());

    public static final Block STELLARIUM_BLOCK = addNewBlock(GenericBlocks.builder("stellarium_block")
            .lootTable(new MyLootTable(LootType.NORMAL, new MyIngredient("stellarium_block", InstanceType.BLOCK, 1)))
            .addTranslate("fr_fr", "Bloc de stellarium")
            .addTranslate("en_us", "Stellarium block")
            .addTag(BlockTags.PICKAXE_MINEABLE)
            .addTag(ModTags.Blocks.NEED_LVL_6)
            .addRecipe(RecipeBuilder.builder("stellarium_ingot", RecipeType.SHAPELLESS)
                    .input(new MyIngredient("stellarium_block", InstanceType.BLOCK, 1))
                    .output(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 9))
                    .build())
            .build());

    public static final Block FORGE_STELLAIRE = addNewBlock(
            new ForgeStellaire("forge_stellaire",
                    new MyLootTable(LootType.NORMAL, new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1)),
                    Map.of("fr_fr", "Forge Stellaire", "en_us", "Stellar forge"),
                    List.of(BlockTags.PICKAXE_MINEABLE),
                    List.of(RecipeBuilder.builder("forge_stellaire", RecipeType.SHAPE)
                            .input(new MyIngredient("iridium_block", InstanceType.BLOCK, 1))
                            .input(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))
                            .input(new MyIngredient("furnace", InstanceType.VANILLABLOCK, 1))
                            .output(new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1))
                            .pattern(List.of("0 0", "121", "111"))
                            .unlock(new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1))
                            .build())));

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