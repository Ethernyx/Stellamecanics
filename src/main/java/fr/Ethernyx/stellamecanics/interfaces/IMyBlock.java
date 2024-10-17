package fr.ethernyx.stellamecanics.interfaces;

import fr.ethernyx.stellamecanics.utils.generator.LootType;
import fr.ethernyx.stellamecanics.utils.generator.MyLootTable;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.minecraft.block.Block;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;

public interface IMyBlock {
    static String getId() { return ""; };
    default Model getModelType() { return Models.CUBE_ALL; }
    default String getTranslate(String lang) { return ""; }
    default List<RecipeBuilder> getRecipe() { return new ArrayList<RecipeBuilder>(); }
    default MyLootTable getLootTable() { return new MyLootTable(LootType.NONE); }
    default List<TagKey<Block>> getTags() { return new ArrayList<>(); }
}
