package fr.ethernyx.stellamecanics.interfaces;

import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;

public interface IMyItem extends ItemConvertible {
    String getId();

    default Model getModelType() { return Models.HANDHELD; }
    default String getTranslate(String lang) { return ""; }
    default List<RecipeBuilder> getRecipe() { return new ArrayList<>(); }
    default List<TagKey<Item>> getTags() { return new ArrayList<>(); }
}
