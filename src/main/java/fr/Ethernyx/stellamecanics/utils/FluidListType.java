package fr.ethernyx.stellamecanics.utils;

import net.minecraft.block.Block;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;

public class FluidListType {
    private final FlowableFluid still;
    private final FlowableFluid flowing;
    private final Block block;
    private final BucketItem bucket;

    public FluidListType(FlowableFluid still, FlowableFluid flowing, Block block, BucketItem bucket) {
        this.still = still;
        this.flowing = flowing;
        this.block = block;
        this.bucket = bucket;
    }
    public FlowableFluid getStill() { return still; }
    public FlowableFluid getFlowing() { return flowing; }
    public Block getBlock() { return block; }
    public BucketItem getBucket() { return bucket; }
}
