package fr.ethernyx.stellamecanics.utils.generic;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyFluidTag;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;

public class GenericFluidTags implements IMyFluidTag {
    private final String name;
    private final TagKey<Fluid> tag;
    private final List<TagKey<Fluid>> legacy;

    public GenericFluidTags(String name, List<TagKey<Fluid>> legacy) {
        this.name = name;
        this.tag = TagKey.of(RegistryKeys.FLUID, Identifier.of(Stellamecanics.MOD_ID, name));
        this.legacy = legacy;
    }

    @Override public List<TagKey<Fluid>> legacy() { return legacy; }
    @Override public TagKey<Fluid> getTag() { return tag; }
    @Override public  String getName() { return name; }
}
