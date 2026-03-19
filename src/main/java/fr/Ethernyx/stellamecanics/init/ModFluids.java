package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyFlowingFluid;
import fr.ethernyx.stellamecanics.utils.FluidListType;
import fr.ethernyx.stellamecanics.utils.generic.GenericFluids;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModFluids {
    public static Map<String, FluidListType> FLUIDS = new LinkedHashMap<>();

    public static final FluidListType SOLARIUM_FLUID = addNewFluid(GenericFluids.builder()
            .still("solarium_fluid_still")
            .flowing("solarium_fluid_flowing")
            .block("solarium_fluid_block", Map.of("fr_fr", "Solarium", "en_us", "Solarium"))
            .bucket("solarium_fluid_bucket", Map.of("fr_fr", "Bucket de solarium", "en_us", "Solarium bucket"))
            .addBucketTag(ConventionalItemTags.BUCKETS)
            .blockTags(List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE))
            .fluidTags(List.of(FluidTags.WATER, ModTags.Fluids.FORGE_STELLAIRE_FLUID_INPUT_LEFT))
            .color(0xFFAA00)
            .build());

    public static final FluidListType LUNARIUM_FLUID = addNewFluid(GenericFluids.builder()
            .still("lunarium_fluid_still")
            .flowing("lunarium_fluid_flowing")
            .block("lunarium_fluid_block", Map.of("fr_fr", "Lunarium", "en_us", "Lunarium"))
            .bucket("lunarium_fluid_bucket", Map.of("fr_fr", "Bucket de lunarium", "en_us", "Lunarium bucket"))
            .addBucketTag(ConventionalItemTags.BUCKETS)
            .blockTags(List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE))
            .fluidTags(List.of(FluidTags.WATER, ModTags.Fluids.FORGE_STELLAIRE_FLUID_INPUT_RIGHT))
            .color(0xC8D8E8) // TODO : choisir la vraie couleur du lunarium
            .build());

    public static final FluidListType STELLARIUM_FLUID = addNewFluid(GenericFluids.builder()
            .still("stellarium_fluid_still")
            .flowing("stellarium_fluid_flowing")
            .block("stellarium_fluid_block", Map.of("fr_fr", "Stellarium", "en_us", "Stellarium"))
            .bucket("stellarium_fluid_bucket", Map.of("fr_fr", "Bucket de stellarium", "en_us", "Stellarium bucket"))
            .addBucketTag(ConventionalItemTags.BUCKETS)
            .blockTags(List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE))
            .addFluidTag(FluidTags.WATER)
            .color(0xC8D8E8) // TODO : choisir la vraie couleur du stellarium
            .build());

    public static final FluidListType ZIRCONIUM_FLUID = addNewFluid(GenericFluids.builder()
            .still("zirconium_fluid_still")
            .flowing("zirconium_fluid_flowing")
            .block("zirconium_fluid_block", Map.of("fr_fr", "Zirconium", "en_us", "Zirconium"))
            .bucket("zirconium_fluid_bucket", Map.of("fr_fr", "Bucket de zirconium", "en_us", "Zirconium bucket"))
            .addBucketTag(ConventionalItemTags.BUCKETS)
            .blockTags(List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE))
            .addFluidTag(FluidTags.LAVA)
            .color(0xC8D8E8) // TODO : choisir la vraie couleur du zirconium
            .build());

    public static final FluidListType IRIDIUM_FLUID = addNewFluid(GenericFluids.builder()
            .still("iridium_fluid_still")
            .flowing("iridium_fluid_flowing")
            .block("iridium_fluid_block", Map.of("fr_fr", "Iridium", "en_us", "Iridium"))
            .bucket("iridium_fluid_bucket", Map.of("fr_fr", "Bucket d'iridium", "en_us", "Iridium bucket"))
            .addBucketTag(ConventionalItemTags.BUCKETS)
            .blockTags(List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE))
            .addFluidTag(FluidTags.LAVA)
            .color(0xC8D8E8) // TODO : choisir la vraie couleur de l'iridium
            .build());

    public static final FluidListType ZIRCALOY_FLUID = addNewFluid(GenericFluids.builder()
            .still("zircaloy_fluid_still")
            .flowing("zircaloy_fluid_flowing")
            .block("zircaloy_fluid_block", Map.of("fr_fr", "Zircaloy", "en_us", "Zircaloy"))
            .bucket("zircaloy_fluid_bucket", Map.of("fr_fr", "Bucket de zircaloy", "en_us", "Zircaloy bucket"))
            .addBucketTag(ConventionalItemTags.BUCKETS)
            .blockTags(List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE))
            .addFluidTag(FluidTags.LAVA)
            .color(0xC8D8E8) // TODO : choisir la vraie couleur du zircaloy
            .build());

    public static final FluidListType OSMIRIDIUM_FLUID = addNewFluid(GenericFluids.builder()
            .still("osmiridium_fluid_still")
            .flowing("osmiridium_fluid_flowing")
            .block("osmiridium_fluid_block", Map.of("fr_fr", "Osmiridium", "en_us", "Osmiridium"))
            .bucket("osmiridium_fluid_bucket", Map.of("fr_fr", "Bucket d'osmiridium", "en_us", "Osmiridium bucket"))
            .addBucketTag(ConventionalItemTags.BUCKETS)
            .blockTags(List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE))
            .addFluidTag(FluidTags.LAVA)
            .color(0xC8D8E8) // TODO : choisir la vraie couleur de l'osmiridium
            .build());


    private static FluidListType addNewFluid(FluidListType fluidListType) {
        IMyFlowingFluid still = (IMyFlowingFluid) fluidListType.getStill();
        FLUIDS.put(still.stillId(), fluidListType);
        return fluidListType;
    }

    public static void registerModFluids() {
        Stellamecanics.LOGGER.debug("Registering Mod Fluids for " + Stellamecanics.MOD_ID);
    }
}