package fr.ethernyx.stellamecanics.block;

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

public class IridiumBlock extends Block implements IMyBlock {
    public static String getId() {
        return "iridium_block";
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<String, String>() {{
            put("fr_fr", "Bloc d'iridium");
            put("en_us", "Iridium block");
        }};
        return langs.get(lang);
    }

    public IridiumBlock() {
        super(Settings.create().strength(3f, 15f).requiresTool());
        /*this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.BLOCK);

        this.data.recipe.put("iridium_ingot", new RecipeBuilder(RecipeType.SHAPELLESS,
                new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_block", InstanceType.BLOCK, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_ingot", InstanceType.ITEM, 9)))));
        this.data.setLootType(LootType.NORMAL);
        this.data.addTag(BlockTags.PICKAXE_MINEABLE);
        this.data.addTag(ModTags.NEEDS_TOOL_LEVEL_4);*/
    }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();

        recipes.add(new RecipeBuilder("iridium_ingot", RecipeType.SHAPELLESS,
                new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_block", InstanceType.BLOCK, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_ingot", InstanceType.ITEM, 9)))));

        return recipes;
    }

    @Override
    public MyLootTable getLootTable() {
        return new MyLootTable(LootType.NORMAL, new MyIngredient("iridium_block", InstanceType.BLOCK, 1));
    }

    @Override
    public List<TagKey<Block>> getTags() {
        List<TagKey<Block>> tags = new ArrayList<>();
        tags.add(BlockTags.PICKAXE_MINEABLE);

        // LVL 4
        tags.add(ModTags.Blocks.NEED_IRIDIUM_TOOL);

        // LVL 5
        tags.add(ModTags.Blocks.NEED_LUNARIUM_TOOL);
        tags.add(ModTags.Blocks.NEED_SOLARIUM_TOOL);
        tags.add(ModTags.Blocks.NEED_ZIRCONIUM_TOOL);

        // LVL 6
        tags.add(ModTags.Blocks.NEED_OSMIRIDIUM_TOOL);
        tags.add(ModTags.Blocks.NEED_STELLARIUM_TOOL);
        tags.add(ModTags.Blocks.NEED_ZIRCALOY_TOOL);
        return tags;
    }
}
