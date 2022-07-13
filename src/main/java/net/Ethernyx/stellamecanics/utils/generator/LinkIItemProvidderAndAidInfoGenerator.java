package net.Ethernyx.stellamecanics.utils.generator;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;

public class LinkIItemProvidderAndAidInfoGenerator {
    public final Item item;
    public final Block block;
    public final AidInfoGenerator data;

    public LinkIItemProvidderAndAidInfoGenerator(ItemConvertible block, AidInfoGenerator data, InstanceType type) {
        if (type == InstanceType.BLOCK) this.block = (Block) block; else this.block = null;
        if (type == InstanceType.ITEM) this.item = (Item) block; else this.item = null;
        this.data = data;

    }

}
