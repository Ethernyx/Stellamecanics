package fr.ethernyx.stellamecanics.utils.generic;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyBlockTag;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;

public class GenericBlockTags implements IMyBlockTag {
    private final String name;
    private final TagKey<Block> tag;
    private final List<TagKey<Block>> legacy;

    public GenericBlockTags(String name, List<TagKey<Block>> legacy) {
        this.name = name;
        this.tag = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Stellamecanics.MOD_ID, name));
        this.legacy = legacy;
    }

    @Override public List<TagKey<Block>> legacy() { return legacy; }
    @Override public TagKey<Block> getTag() { return tag; }
    @Override public  String getName() { return name; }
}
