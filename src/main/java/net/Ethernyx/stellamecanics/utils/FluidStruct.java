package net.Ethernyx.stellamecanics.utils;

import net.Ethernyx.stellamecanics.Main;
import net.Ethernyx.stellamecanics.init.ModItems;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.MyBucketItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidStruct {
    private static FlowableFluid STILL;
    private static FlowableFluid FLOWING;
    private static Block BLOCK;
    private static Item BUCKET;
    private static String NAME;

    public FluidStruct(String name, FlowableFluid still, FlowableFluid flowing , Block copy, AidInfoGenerator bucket_infos) {
        setName(name);
        setStill(still, flowing, copy, bucket_infos);
    }

    private static void setName(String name) {
        NAME = name;
    }

    private void setStill(FlowableFluid still, FlowableFluid flowing , Block copy, AidInfoGenerator bucket_infos) {
        STILL = Registry.register(Registry.FLUID, new Identifier(Main.MOD_ID, NAME), still);
        setFlowable(flowing, copy, bucket_infos);
    }
    private void setFlowable(FlowableFluid flowing , Block copy, AidInfoGenerator bucket_infos) {
        FLOWING  = Registry.register(Registry.FLUID, new Identifier(Main.MOD_ID, "flowing_" + NAME), flowing);
        setBucket(bucket_infos, copy);
    }


    private void setBucket(AidInfoGenerator bucket_infos, Block copy) {
        BUCKET = ModItems.addNewItem(bucket_infos.getId(), new MyBucketItem(STILL, new FabricItemSettings().group(ModItemsGroup.STELLAMECANICS).recipeRemainder(Items.BUCKET).maxCount(1), bucket_infos));
    }

    public void setBlock(Block copy) {
        BLOCK = Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, NAME + "_block"), new FluidBlock(FLOWING, FabricBlockSettings.copyOf(copy)));
    }

    public Block getBlock() {
        return BLOCK;
    }

    public FlowableFluid getFlowing() {
        return FLOWING;
    }

    public FlowableFluid getStill() {
        return STILL;
    }

    public Item getBucket() {
        return BUCKET;
    }
}
