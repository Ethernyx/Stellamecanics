package fr.ethernyx.stellamecanics.interfaces;

import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

import java.util.List;

public interface IMyItemTag {
    default List<TagKey<Item>> legacy() { return List.of(); }
    TagKey<Item> getTag();
    default boolean isreplace() { return false ;}
    String getName();
}
