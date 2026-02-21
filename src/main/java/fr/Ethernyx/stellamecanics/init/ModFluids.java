package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyFlowingFluid;
import fr.ethernyx.stellamecanics.utils.FluidListType;
import fr.ethernyx.stellamecanics.utils.FluidListTypeEnum;
import fr.ethernyx.stellamecanics.utils.generic.GenericFluids;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;

import java.util.*;

public class ModFluids {
    public static Map<String, FluidListType> FLUIDS = new HashMap<>();

    public static final FluidListType SOLARIUM_FLUID = addNewFluid(
            GenericFluids.create(
                    Map.of(FluidListTypeEnum.STILL, "solarium_fluid_still", FluidListTypeEnum.FLOWING, "solarium_fluid_flowing", FluidListTypeEnum.BLOCK, "solarium_fluid_block", FluidListTypeEnum.BUCKET, "solarium_fluid_bucket"),
                    Map.of(FluidListTypeEnum.BLOCK, Map.of("fr_fr", "Solarium", "en_us", "Solarium"), FluidListTypeEnum.BUCKET, Map.of("fr_fr", "Bucket de solarium", "en_us", "Solarium bucket")),
                    List.of(ConventionalItemTags.BUCKETS),
                    List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE),
                    Map.of(FluidListTypeEnum.STILL, List.of(FluidTags.WATER), FluidListTypeEnum.FLOWING, List.of(FluidTags.WATER)),
                    0xFFAA00
            ));
    public static final FluidListType LUNARIUM_FLUID = addNewFluid(
            GenericFluids.create(
                    Map.of(FluidListTypeEnum.STILL, "lunarium_fluid_still", FluidListTypeEnum.FLOWING, "lunarium_fluid_flowing", FluidListTypeEnum.BLOCK, "lunarium_fluid_block", FluidListTypeEnum.BUCKET, "lunarium_fluid_bucket"),
                    Map.of(FluidListTypeEnum.BLOCK, Map.of("fr_fr", "Lunarium", "en_us", "Lunarium"), FluidListTypeEnum.BUCKET, Map.of("fr_fr", "Bucket de lunarium", "en_us", "Lunarium bucket")),
                    List.of(ConventionalItemTags.BUCKETS),
                    List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE),
                    Map.of(FluidListTypeEnum.STILL, List.of(FluidTags.WATER), FluidListTypeEnum.FLOWING, List.of(FluidTags.WATER)),
                    0xC8D8E8
            ));

    private static FluidListType addNewFluid(FluidListType fluidListType) {
        IMyFlowingFluid still = (IMyFlowingFluid) fluidListType.getStill();
        FLUIDS.put(still.stillId(), fluidListType);
        return fluidListType;
    }

    public static void registerModFluids() {
        Stellamecanics.LOGGER.debug("Registering Mod Fluids for " + Stellamecanics.MOD_ID);
    }
}