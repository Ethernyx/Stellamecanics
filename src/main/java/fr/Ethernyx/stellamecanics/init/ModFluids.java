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
                    Map.of(FluidListTypeEnum.STILL, List.of(FluidTags.WATER, ModTags.Fluids.FLUIDTAGS.get("forge_stellaire_fluid_input_left").getTag()), FluidListTypeEnum.FLOWING, List.of(FluidTags.WATER, ModTags.Fluids.FLUIDTAGS.get("forge_stellaire_fluid_input_left").getTag())),
                    0xFFAA00
            ));
    public static final FluidListType LUNARIUM_FLUID = addNewFluid(
            GenericFluids.create(
                    Map.of(FluidListTypeEnum.STILL, "lunarium_fluid_still", FluidListTypeEnum.FLOWING, "lunarium_fluid_flowing", FluidListTypeEnum.BLOCK, "lunarium_fluid_block", FluidListTypeEnum.BUCKET, "lunarium_fluid_bucket"),
                    Map.of(FluidListTypeEnum.BLOCK, Map.of("fr_fr", "Lunarium", "en_us", "Lunarium"), FluidListTypeEnum.BUCKET, Map.of("fr_fr", "Bucket de lunarium", "en_us", "Lunarium bucket")),
                    List.of(ConventionalItemTags.BUCKETS),
                    List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE),
                    Map.of(FluidListTypeEnum.STILL, List.of(FluidTags.WATER, ModTags.Fluids.FLUIDTAGS.get("forge_stellaire_fluid_input_right").getTag()), FluidListTypeEnum.FLOWING, List.of(FluidTags.WATER, ModTags.Fluids.FLUIDTAGS.get("forge_stellaire_fluid_input_right").getTag())),
                    0xC8D8E8
            ));
    public static final FluidListType STELLARIUM_FLUID = addNewFluid(
            GenericFluids.create(
                    Map.of(FluidListTypeEnum.STILL, "stellarium_fluid_still", FluidListTypeEnum.FLOWING, "stellarium_fluid_flowing", FluidListTypeEnum.BLOCK, "stellarium_fluid_block", FluidListTypeEnum.BUCKET, "stellarium_fluid_bucket"),
                    Map.of(FluidListTypeEnum.BLOCK, Map.of("fr_fr", "Stellarium", "en_us", "Stellarium"), FluidListTypeEnum.BUCKET, Map.of("fr_fr", "Bucket de stellarium", "en_us", "Stellarium bucket")),
                    List.of(ConventionalItemTags.BUCKETS),
                    List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE),
                    Map.of(FluidListTypeEnum.STILL, List.of(FluidTags.WATER), FluidListTypeEnum.FLOWING, List.of(FluidTags.WATER)),
                    0xC8D8E8 /* <-- pas bon */
            ));
    public static final FluidListType ZIRCONIUM_FLUID = addNewFluid(
            GenericFluids.create(
                    Map.of(FluidListTypeEnum.STILL, "zirconium_fluid_still", FluidListTypeEnum.FLOWING, "zirconium_fluid_flowing", FluidListTypeEnum.BLOCK, "zirconium_fluid_block", FluidListTypeEnum.BUCKET, "zirconium_fluid_bucket"),
                    Map.of(FluidListTypeEnum.BLOCK, Map.of("fr_fr", "Zirconium", "en_us", "Zirconium"), FluidListTypeEnum.BUCKET, Map.of("fr_fr", "Bucket de zirconium", "en_us", "Zirconium bucket")),
                    List.of(ConventionalItemTags.BUCKETS),
                    List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE),
                    Map.of(FluidListTypeEnum.STILL, List.of(FluidTags.LAVA), FluidListTypeEnum.FLOWING, List.of(FluidTags.LAVA)),
                    0xC8D8E8 /* <-- pas bon */
            ));
    public static final FluidListType IRIDIUM_FLUID = addNewFluid(
            GenericFluids.create(
                    Map.of(FluidListTypeEnum.STILL, "iridium_fluid_still", FluidListTypeEnum.FLOWING, "iridium_fluid_flowing", FluidListTypeEnum.BLOCK, "iridium_fluid_block", FluidListTypeEnum.BUCKET, "iridium_fluid_bucket"),
                    Map.of(FluidListTypeEnum.BLOCK, Map.of("fr_fr", "Iridium", "en_us", "Iridium"), FluidListTypeEnum.BUCKET, Map.of("fr_fr", "Bucket d'iridium", "en_us", "Iridium bucket")),
                    List.of(ConventionalItemTags.BUCKETS),
                    List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE),
                    Map.of(FluidListTypeEnum.STILL, List.of(FluidTags.LAVA), FluidListTypeEnum.FLOWING, List.of(FluidTags.LAVA)),
                    0xC8D8E8 /* <-- pas bon */
            ));
    public static final FluidListType ZIRCALOY_FLUID = addNewFluid(
            GenericFluids.create(
                    Map.of(FluidListTypeEnum.STILL, "zircaloy_fluid_still", FluidListTypeEnum.FLOWING, "zircaloy_fluid_flowing", FluidListTypeEnum.BLOCK, "zircaloy_fluid_block", FluidListTypeEnum.BUCKET, "zircaloy_fluid_bucket"),
                    Map.of(FluidListTypeEnum.BLOCK, Map.of("fr_fr", "Zircaloy", "en_us", "Zircaloy"), FluidListTypeEnum.BUCKET, Map.of("fr_fr", "Bucket de zircaloy", "en_us", "Zircaloy bucket")),
                    List.of(ConventionalItemTags.BUCKETS),
                    List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE),
                    Map.of(FluidListTypeEnum.STILL, List.of(FluidTags.LAVA), FluidListTypeEnum.FLOWING, List.of(FluidTags.LAVA)),
                    0xC8D8E8 /* <-- pas bon */
            ));
    public static final FluidListType OSMIRIDIUM_FLUID = addNewFluid(
            GenericFluids.create(
                    Map.of(FluidListTypeEnum.STILL, "osmiridium_fluid_still", FluidListTypeEnum.FLOWING, "osmiridium_fluid_flowing", FluidListTypeEnum.BLOCK, "osmiridium_fluid_block", FluidListTypeEnum.BUCKET, "osmiridium_fluid_bucket"),
                    Map.of(FluidListTypeEnum.BLOCK, Map.of("fr_fr", "Osmiridium", "en_us", "Osmiridium"), FluidListTypeEnum.BUCKET, Map.of("fr_fr", "Bucket d'osmiridium", "en_us", "Osmiridium bucket")),
                    List.of(ConventionalItemTags.BUCKETS),
                    List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE),
                    Map.of(FluidListTypeEnum.STILL, List.of(FluidTags.LAVA), FluidListTypeEnum.FLOWING, List.of(FluidTags.LAVA)),
                    0xC8D8E8 /* <-- pas bon */
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