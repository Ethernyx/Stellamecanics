package fr.ethernyx.stellamecanics.fluids;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyFlowingFluid;
import fr.ethernyx.stellamecanics.utils.FluidListTypeEnum;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SolariumFluid extends FlowableFluid implements IMyFlowingFluid {

    private Block BLOCK;
    private Item  BUCKET;
    private Fluid STILL;
    private Fluid FLOWING;

    @Override public int color() { return 0xFFAA00; }
    @Override public void setBlock(Block block)   { BLOCK  = block; }
    @Override public void setBucket(Item bucket)  { BUCKET = bucket; }
    @Override public void setStill(Fluid still)     { STILL   = still; }
    @Override public void setFlowing(Fluid flowing) { FLOWING = flowing; }

    @Override public String stillId()   { return "solarium_fluid_still"; }
    @Override public String flowingId() { return "solarium_fluid_flowing"; }
    @Override public String blockId()   { return "solarium_fluid_block"; }
    @Override public String bucketId()  { return "solarium_fluid_bucket"; }
    @Override public Fluid getStill()               { return STILL; }
    @Override public Fluid getFlowing()             { return FLOWING; }
    @Override public Item getBucketItem()           { return BUCKET; }
    @Override public Block getBlock()               { return BLOCK; }
    @Override public List<TagKey<Item>> getBucketTag() { return List.of(ConventionalItemTags.BUCKETS); }
    @Override public List<TagKey<Block>> getBlockTag() { return List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE); }
    @Override public List<TagKey<Fluid>> getStillTag() { return List.of(FluidTags.WATER); }
    @Override public List<TagKey<Fluid>> getFlowingTag() { return List.of(FluidTags.WATER); }

    @Override
    public String getTranslate(String lang, FluidListTypeEnum type) {
        Map<FluidListTypeEnum, Map<String, String>> langs = new HashMap<>();
        Map<String, String> block = new HashMap<>() {{
            put("fr_fr", "Solarium");
            put("en_us", "Solarium");
        }};
        Map<String, String> bucket = new HashMap<>() {{
            put("fr_fr", "Bucket de solarium");
            put("en_us", "Solarium bucket");
        }};
        langs.put(FluidListTypeEnum.BLOCK, block);
        langs.put(FluidListTypeEnum.BUCKET, bucket);
        return langs.get(type).get(lang);
    }

    @Override
    public Block Block(FlowableFluid still) {
        return new FluidBlock(
                still,
                AbstractBlock.Settings.create()
                        .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Stellamecanics.MOD_ID, blockId())))
                        .noCollision()
                        .strength(100.0f)
                        .luminance(state -> 15)
                        .replaceable()
                        .liquid()
                        .burnable()
                        .pistonBehavior(PistonBehavior.DESTROY)
        );
    }

    @Override
    public BucketItem Bucket(FlowableFluid still) {
        return new BucketItem(
                still,
                new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Stellamecanics.MOD_ID, bucketId())))
                        .maxCount(1)
                        .recipeRemainder(Items.BUCKET)
        );
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return getBlock().getDefaultState()
                .with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override public boolean matchesType(Fluid f) {
        return f == getStill() || f == getFlowing();
    }

    @Override protected boolean isInfinite(ServerWorld w)              { return false; }
    @Override protected int     getMaxFlowDistance(WorldView w)        { return 4; }
    @Override protected int     getLevelDecreasePerBlock(WorldView w)  { return 1; }
    @Override public    int     getTickRate(WorldView w)               { return 5; }
    @Override protected float   getBlastResistance()                   { return 100f; }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess w, BlockPos pos, BlockState state) {
        final var be = state.hasBlockEntity() ? w.getBlockEntity(pos) : null;
        Block.dropStacks(state, w, pos, be);
    }

    public static class Still extends SolariumFluid {
        @Override public int     getLevel(FluidState s) { return 8; }
        @Override public boolean isStill(FluidState s)  { return true; }
    }

    public static class Flowing extends SolariumFluid {
        @Override protected void appendProperties(StateManager.Builder<Fluid, FluidState> b) {
            super.appendProperties(b);
            b.add(LEVEL);
        }
        @Override public int     getLevel(FluidState s) { return s.get(LEVEL); }
        @Override public boolean isStill(FluidState s)  { return false; }
    }
}