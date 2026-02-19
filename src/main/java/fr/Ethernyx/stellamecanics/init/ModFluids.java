package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.fluids.LunariumFluid;
import fr.ethernyx.stellamecanics.fluids.SolariumFluid;
import fr.ethernyx.stellamecanics.interfaces.IMyFlowingFluid;
import fr.ethernyx.stellamecanics.utils.FluidListType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.*;

public class ModFluids {
    public static Map<String, FluidListType> FLUIDS = new HashMap<>();

    public static final FluidListType SOLARIUM_FLUID = addNewFluid(new SolariumFluid.Still(), new SolariumFluid.Flowing());
    public static final FluidListType LUNARIUM_FLUID = addNewFluid(new LunariumFluid.Still(), new LunariumFluid.Flowing());

    private static <T extends FlowableFluid & IMyFlowingFluid> FluidListType addNewFluid(T still, T flowing) {

        FlowableFluid registerStill = (T) Registry.register(
                Registries.FLUID,
                Identifier.of(Stellamecanics.MOD_ID, still.stillId()),
                still
        );

        FlowableFluid registerFlowing = (T) Registry.register(
                Registries.FLUID,
                Identifier.of(Stellamecanics.MOD_ID, flowing.flowingId()),
                flowing
        );

        still.setStill(registerStill);
        still.setFlowing(registerFlowing);
        flowing.setStill(registerStill);
        flowing.setFlowing(registerFlowing);

        still.setBlock(Registry.register(
                Registries.BLOCK,
                Identifier.of(Stellamecanics.MOD_ID, still.blockId()),
                still.Block(still)
        ));
        still.setBucket(Registry.register(
                Registries.ITEM,
                Identifier.of(Stellamecanics.MOD_ID, still.bucketId()),
                still.Bucket(still)
        ));
        flowing.setBlock(still.getBlock());
        flowing.setBucket(still.getBucketItem());

        FluidListType fluids = new FluidListType(registerStill, registerFlowing, still.getBlock(), (BucketItem) still.getBucketItem());
        FLUIDS.put(still.stillId(), fluids);
        return fluids;
    }

    public static void registerModFluids() {
        Stellamecanics.LOGGER.debug("Registering Mod Fluids for " + Stellamecanics.MOD_ID);
    }
}