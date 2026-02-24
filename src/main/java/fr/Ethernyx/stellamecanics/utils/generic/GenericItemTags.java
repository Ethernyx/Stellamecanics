package fr.ethernyx.stellamecanics.utils.generic;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyItemTag;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;

public class GenericItemTags implements IMyItemTag {
    private final String name;
    private final TagKey<Item> tag;
    private final List<TagKey<Item>> legacy;

    public GenericItemTags(String name, List<TagKey<Item>> legacy) {
        this.name = name;
        this.tag = TagKey.of(RegistryKeys.ITEM, Identifier.of(Stellamecanics.MOD_ID, name));
        this.legacy = legacy;
    }

    @Override public List<TagKey<Item>> legacy() { return legacy; }
    @Override public TagKey<Item> getTag() { return tag; }
    @Override public  String getName() { return name; }

}
