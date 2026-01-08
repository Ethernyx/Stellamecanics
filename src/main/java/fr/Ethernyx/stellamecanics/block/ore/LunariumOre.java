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

public class LunariumOre extends Block implements IMyBlock {
    public static String ID = "lunarium_ore";
public String getId() { return ID;  }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Minerai de lunarium");
            put("en_us", "Lunarium ore");
        }};
        return langs.get(lang);
    }

   public LunariumOre(Settings settings) { super(settings.strength(3f, 15f).requiresTool()); }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();

        recipes.add(new RecipeBuilder("ore_to_lunarium_ingot", RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("lunarium_ore", InstanceType.BLOCK, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1)))));

        return recipes;
    }

    @Override
    public MyLootTable getLootTable() {
        return new MyLootTable(LootType.ORE, new MyIngredient("lunarium_raw", InstanceType.ITEM, 1));
    }

    @Override
    public List<TagKey<Block>> getTags() {
        List<TagKey<Block>> tags = new ArrayList<>();
        tags.add(BlockTags.PICKAXE_MINEABLE);
        tags.add(ModTags.Blocks.NEED_IRIDIUM_TOOL);
        return tags;
    }
}
