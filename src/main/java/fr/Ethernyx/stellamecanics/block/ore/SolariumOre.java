package fr.ethernyx.stellamecanics.block.ore;

import fr.ethernyx.stellamecanics.init.ModTags;
import fr.ethernyx.stellamecanics.interfaces.IMyBlock;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.ethernyx.stellamecanics.utils.generator.LootType;
import fr.ethernyx.stellamecanics.utils.generator.MyLootTable;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.block.Block;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.*;

public class SolariumOre extends Block implements IMyBlock {
    public static String getId() {
        return "solarium_ore";
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<String, String>() {{
            put("fr_fr", "Minerai de solarium");
            put("en_us", "Solarium ore");
        }};
        return langs.get(lang);
    }

    

    public SolariumOre() {
        super(Settings.create().strength(3f, 15f).requiresTool());
        /*this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.BLOCK);
        this.data.recipe.put("ore_to_solarium_ingot", new RecipeBuilder(RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("solarium_ore", InstanceType.BLOCK, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1)))));
        this.data.setLootType(LootType.ORE, new MyIngredient("solarium_raw", InstanceType.ITEM, 1));
        this.data.addTag(BlockTags.PICKAXE_MINEABLE);
        this.data.addTag(ModTags.NEEDS_TOOL_LEVEL_4);*/
    }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();

        recipes.add(new RecipeBuilder("ore_to_solarium_ingot", RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("solarium_ore", InstanceType.BLOCK, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1)))));

        return recipes;
    }

    @Override
    public MyLootTable getLootTable() {
        return new MyLootTable(LootType.ORE, new MyIngredient("solarium_raw", InstanceType.ITEM, 1));
    }

    @Override
    public List<TagKey<Block>> getTags() {
        List<TagKey<Block>> tags = new ArrayList<>();
        tags.add(BlockTags.PICKAXE_MINEABLE);
        tags.add(ModTags.Blocks.NEED_IRIDIUM_TOOL);
        return tags;
    }
}
