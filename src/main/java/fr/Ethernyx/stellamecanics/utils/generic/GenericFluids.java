package fr.ethernyx.stellamecanics.utils.generic;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyFlowingFluid;
import fr.ethernyx.stellamecanics.utils.FluidListType;
import fr.ethernyx.stellamecanics.utils.FluidListTypeEnum;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
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

import java.util.List;
import java.util.Map;

public abstract class GenericFluids extends FlowableFluid implements IMyFlowingFluid {

    private Block BLOCK;
    private Item  BUCKET;
    private Fluid STILL;
    private Fluid FLOWING;

    // IDs des ressources (still, flowing, block, bucket)
    private final Map<FluidListTypeEnum, String> ids;

    // Traductions : FluidListTypeEnum (BLOCK, BUCKET) → (lang → texte)
    private final Map<FluidListTypeEnum, Map<String, String>> translate;

    // Tags
    private final List<TagKey<Item>>  bucketTags;
    private final List<TagKey<Block>> blockTags;
    private final Map<FluidListTypeEnum, List<TagKey<Fluid>>> fluidTags; // STILL / FLOWING

    // Couleur de rendu
    private final int color;

    protected GenericFluids(
            Map<FluidListTypeEnum, String> ids,
            Map<FluidListTypeEnum, Map<String, String>> translate,
            List<TagKey<Item>>  bucketTags,
            List<TagKey<Block>> blockTags,
            Map<FluidListTypeEnum, List<TagKey<Fluid>>> fluidTags,
            int color
    ) {
        this.ids = ids;
        this.translate  = translate;
        this.bucketTags = bucketTags  != null ? bucketTags  : List.of();
        this.blockTags  = blockTags   != null ? blockTags   : List.of();
        this.fluidTags  = fluidTags   != null ? fluidTags   : Map.of();
        this.color      = color;
    }

    public static FluidListType create(
            Map<FluidListTypeEnum, String> ids,
            Map<FluidListTypeEnum, Map<String, String>> translate,
            List<TagKey<Item>>  bucketTags,
            List<TagKey<Block>> blockTags,
            Map<FluidListTypeEnum, List<TagKey<Fluid>>> fluidTags,
            int color
    ) {
        GenericFluids still   = new Still(ids, translate, bucketTags, blockTags, fluidTags, color);
        GenericFluids flowing = new Flowing(ids, translate, bucketTags, blockTags, fluidTags, color);

        FlowableFluid registerStill = Registry.register(
                Registries.FLUID,
                Identifier.of(Stellamecanics.MOD_ID, still.stillId()),
                still
        );

        FlowableFluid registerFlowing = Registry.register(
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
        return new FluidListType(registerStill, registerFlowing, still.getBlock(), (BucketItem) still.getBucketItem());
    }

    // ── IMyFlowingFluid ────────────────────────────────────────────────────────

    @Override public String stillId()   { return ids.get(FluidListTypeEnum.STILL); }
    @Override public String flowingId() { return ids.get(FluidListTypeEnum.FLOWING); }
    @Override public String blockId()   { return ids.get(FluidListTypeEnum.BLOCK); }
    @Override public String bucketId()  { return ids.get(FluidListTypeEnum.BUCKET); }
    @Override public void setStill(Fluid still)     { STILL   = still; }
    @Override public void setFlowing(Fluid flowing) { FLOWING = flowing; }
    @Override public void setBlock(Block block)     { BLOCK   = block; }
    @Override public void setBucket(Item bucket)    { BUCKET  = bucket; }
    @Override public Fluid getStill()     { return STILL; }
    @Override public Fluid getFlowing()   { return FLOWING; }
    @Override public Block getBlock()     { return BLOCK; }
    @Override public Item  getBucketItem(){ return BUCKET; }
    @Override public int color() { return color; }
    @Override public String getTranslate(String lang, FluidListTypeEnum type) { return translate.getOrDefault(type, Map.of()).getOrDefault(lang, ""); }
    @Override public List<TagKey<Item>>  getBucketTag()  { return bucketTags; }
    @Override public List<TagKey<Block>> getBlockTag()   { return blockTags; }
    @Override public List<TagKey<Fluid>> getStillTag() { return fluidTags.getOrDefault(FluidListTypeEnum.STILL, List.of()); }
    @Override public List<TagKey<Fluid>> getFlowingTag() { return fluidTags.getOrDefault(FluidListTypeEnum.FLOWING, List.of());}

    // ── Factory méthodes pour le block et le bucket ────────────────────────────

    @Override
    public Block Block(FlowableFluid still) {
        return new FluidBlock(
                still,
                AbstractBlock.Settings.create()
                        .registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                                Identifier.of(Stellamecanics.MOD_ID, blockId())))
                        .noCollision()
                        .strength(100.0f)
                        .luminance(state -> 0)
                        .replaceable()
                        .liquid()
                        .pistonBehavior(PistonBehavior.DESTROY)
        );
    }

    @Override
    public BucketItem Bucket(FlowableFluid still) {
        return new BucketItem(
                still,
                new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                                Identifier.of(Stellamecanics.MOD_ID, bucketId())))
                        .maxCount(1)
                        .recipeRemainder(Items.BUCKET)
        );
    }

    // ── FlowableFluid ──────────────────────────────────────────────────────────

    @Override public boolean matchesType(Fluid f)                   { return f == getStill() || f == getFlowing(); }
    @Override protected boolean isInfinite(ServerWorld w)           { return false; }
    @Override protected int     getMaxFlowDistance(WorldView w)     { return 4; }
    @Override protected int     getLevelDecreasePerBlock(WorldView w){ return 1; }
    @Override public    int     getTickRate(WorldView w)            { return 5; }
    @Override protected float   getBlastResistance()                { return 100f; }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return getBlock().getDefaultState()
                .with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final var be = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, be);
    }

    // ── Sous-classes Still / Flowing ───────────────────────────────────────────

    public static class Still extends GenericFluids {
        public Still(Map<FluidListTypeEnum, String> ids,
                     Map<FluidListTypeEnum, Map<String, String>> translate,
                     List<TagKey<Item>> bucketTags,
                     List<TagKey<Block>> blockTags,
                     Map<FluidListTypeEnum, List<TagKey<Fluid>>> fluidTags,
                     int color) {
            super(ids, translate, bucketTags, blockTags, fluidTags, color);
        }

        @Override public int     getLevel(FluidState s) { return 8; }
        @Override public boolean isStill(FluidState s)  { return true; }
    }

    public static class Flowing extends GenericFluids {
        public Flowing(Map<FluidListTypeEnum, String> ids,
                       Map<FluidListTypeEnum, Map<String, String>> translate,
                       List<TagKey<Item>> bucketTags,
                       List<TagKey<Block>> blockTags,
                       Map<FluidListTypeEnum, List<TagKey<Fluid>>> fluidTags,
                       int color) {
            super(ids, translate, bucketTags, blockTags, fluidTags, color);
        }

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> b) {
            super.appendProperties(b);
            b.add(LEVEL);
        }

        @Override public int     getLevel(FluidState s) { return s.get(LEVEL); }
        @Override public boolean isStill(FluidState s)  { return false; }
    }
}