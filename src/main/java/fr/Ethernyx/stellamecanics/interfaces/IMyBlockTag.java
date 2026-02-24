package fr.ethernyx.stellamecanics.interfaces;

import net.minecraft.block.Block;
import net.minecraft.registry.tag.TagKey;

import java.util.List;

public interface IMyBlockTag {
    default List<TagKey<Block>> legacy() { return List.of(); }
    TagKey<Block> getTag();
    default boolean isreplace() { return false ;}
    String getName();
}
