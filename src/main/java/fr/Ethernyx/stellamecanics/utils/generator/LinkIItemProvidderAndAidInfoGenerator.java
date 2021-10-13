package fr.Ethernyx.stellamecanics.utils.generator;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;

public class LinkIItemProvidderAndAidInfoGenerator {
    public final RegistryObject<Item> item;
    public final RegistryObject<Block> block;
    public final AidInfoGenerator data;

    public LinkIItemProvidderAndAidInfoGenerator(RegistryObject<? extends IItemProvider> block, AidInfoGenerator data, InstanceType type) {
        if (type == InstanceType.BLOCK) this.block = (RegistryObject<Block>) block; else this.block = null;
        if (type == InstanceType.ITEM) this.item = (RegistryObject<Item>) block; else this.item = null;
        this.data = data;

    }
}
