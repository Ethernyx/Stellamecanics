package fr.ethernyx.stellamecanics.interfaces;

import fr.ethernyx.stellamecanics.utils.FluidListType;
import fr.ethernyx.stellamecanics.utils.FluidListTypeEnum;
import net.minecraft.block.Block;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;

public interface IMyFlowingFluid {

    /** Identifiant du fluide stationnaire, ex: "sun_fluid" */
    String stillId();

    /** Identifiant du fluide en écoulement, ex: "flowing_sun_fluid" */
    String flowingId();

    /** Identifiant du Block */
    String blockId();

    /** Identifiant du bucket */
    String bucketId();
    void setStill(Fluid still);
    void setFlowing(Fluid flowing);
    void setBlock(Block block);
    void setBucket(Item bucket);

    String getTranslate(String lang, FluidListTypeEnum type);

    Block Block(FlowableFluid still);
    BucketItem Bucket(FlowableFluid still);
    int color();
    Block getBlock();
    Item getBucketItem();
    Fluid getStill();
    Fluid getFlowing();
    List<TagKey<Item>> getBucketTag();
    List<TagKey<Block>> getBlockTag();
    List<TagKey<Fluid>> getStillTag();
    List<TagKey<Fluid>> getFlowingTag();



}
