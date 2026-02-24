package fr.ethernyx.stellamecanics.interfaces;

import net.minecraft.fluid.Fluid;
import net.minecraft.registry.tag.TagKey;

import java.util.List;

public interface IMyFluidTag {
    default List<TagKey<Fluid>> legacy() { return List.of(); }
    TagKey<Fluid> getTag();
    default boolean isreplace() { return false ;}
    String getName();
}
