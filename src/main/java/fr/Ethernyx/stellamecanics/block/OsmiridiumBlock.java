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

public class OsmiridiumBlock extends Block implements IMyBlock {
    public static String getId() {
        return "osmiridium_block";
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Bloc de osmiridium");
            put("en_us", "Osmiridium block");
        }};
        return langs.get(lang);
    }

    public OsmiridiumBlock() {
        super(Settings.create().strength(3f, 15f).requiresTool());
    }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();

        recipes.add(new RecipeBuilder("osmiridium_ingot", RecipeType.SHAPELLESS,
                new ArrayList<>(Collections.singletonList(new MyIngredient("osmiridium_block", InstanceType.BLOCK, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 9)))));

        return recipes;
    }

    @Override
    public MyLootTable getLootTable() {
        return new MyLootTable(LootType.NORMAL, new MyIngredient("osmiridium_block", InstanceType.BLOCK, 1));
    }

    @Override
    public List<TagKey<Block>> getTags() {
        List<TagKey<Block>> tags = new ArrayList<>();
        tags.add(BlockTags.PICKAXE_MINEABLE);

        // LVL 6
        tags.add(ModTags.Blocks.NEED_OSMIRIDIUM_TOOL);
        tags.add(ModTags.Blocks.NEED_STELLARIUM_TOOL);
        tags.add(ModTags.Blocks.NEED_ZIRCALOY_TOOL);
        return tags;
    }
}
