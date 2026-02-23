package fr.ethernyx.stellamecanics.block.entities.forgeStellaire;

import com.mojang.serialization.MapCodec;
import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModBlockEntities;
import fr.ethernyx.stellamecanics.init.ModFluids;
import fr.ethernyx.stellamecanics.interfaces.IMyBlock;
import fr.ethernyx.stellamecanics.utils.generator.LootType;
import fr.ethernyx.stellamecanics.utils.generator.MyLootTable;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.TextureKey;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.minecraft.state.property.Properties;

import java.util.*;

public class ForgeStellaire extends BlockWithEntity implements IMyBlock, BlockEntityProvider {

    private final String id;
    private final Map<String, String> translate;
    private final List<TagKey<Block>> tags;
    private final List<RecipeBuilder> recipes;
    private final MyLootTable lootTable;
    public static final MapCodec<ForgeStellaire> CODEC = MapCodec.unit(
            () -> new ForgeStellaire(
                    "forge_stellaire",
                    new MyLootTable(LootType.NONE),
                    Map.of(),
                    List.of(),
                    List.of()
            )
    );

    public ForgeStellaire(String id, MyLootTable lootTable,Map<String, String> translate, List<TagKey<Block>> tags, List<RecipeBuilder> recipes) {
        super(Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                Identifier.of(Stellamecanics.MOD_ID, id))).strength(3f, 15f));
        this.id = id;
        this.lootTable = lootTable;
        this.translate = translate;
        this.tags = tags == null ? List.of() : tags;
        this.recipes = recipes == null ? List.of() : recipes;
    }

    @Override public String getId() {
        return id;
    }
    @Override public String getTranslate(String lang) { return translate.get(lang); }
    @Override public List<RecipeBuilder> getRecipe() { return recipes; }
    @Override public MyLootTable getLootTable() { return lootTable; }
    @Override public List<TagKey<Block>> getTags() { return tags; }
    @Override protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                         PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient()) return ActionResult.SUCCESS;

        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof ForgeStellaireEntity forge)) return ActionResult.PASS;

        Direction side = hit.getSide();

        // Côté gauche (WEST) → tankSolarium, côté droit (EAST) → tankLunarium
        if (side == Direction.WEST || side == Direction.EAST) {
            boolean isSolarium = side == Direction.WEST;
            SingleFluidStorage tank  = isSolarium ? forge.tankSolarium  : forge.tankLunarium;
            Fluid fluid = isSolarium ? ModFluids.SOLARIUM_FLUID.getStill() : ModFluids.LUNARIUM_FLUID.getStill();
            Item bucketFull = isSolarium ? ModFluids.SOLARIUM_FLUID.getBucket() : ModFluids.LUNARIUM_FLUID.getBucket();

            // ✅ On vérifie que l'item en main est bien le bucket du bon fluide (ou un bucket vide)
             stack = player.getStackInHand(hand);
            if (!stack.isOf(bucketFull) && !stack.isOf(Items.BUCKET)) {
                // Bucket du mauvais fluide (ou autre item) → on ouvre le GUI à la place
                player.openHandledScreen(forge);
                return ActionResult.CONSUME;
            }
            if (handleFluidInteraction(player, hand, forge, world, pos, tank, fluid, bucketFull)) {
                return ActionResult.CONSUME;
            }
            // Clic sur un côté tank mais interaction impossible → on n'ouvre pas le GUI
            return ActionResult.PASS;
        }

        // Toute autre face → ouvre le GUI
        player.openHandledScreen(forge);
        return ActionResult.CONSUME;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ForgeStellaireEntity(pos, state);
    }

    private boolean handleFluidInteraction(PlayerEntity player, Hand hand,
                                           ForgeStellaireEntity forge, World world, BlockPos pos,
                                           SingleFluidStorage tank, Fluid fluid, Item bucketFull) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.isOf(bucketFull)) {
            if (forge.addFluid(tank, fluid, 1000)) {
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, SoundCategory.BLOCKS, 1f, 1f);
                if (!player.getAbilities().creativeMode)
                    player.setStackInHand(hand, new ItemStack(Items.BUCKET));
                return true;
            }
        } else if (stack.isOf(Items.BUCKET)) {
            if (forge.addFluid(tank, fluid, -1000)) {
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundCategory.BLOCKS, 1f, 1f);
                if (!player.getAbilities().creativeMode)
                    player.setStackInHand(hand, new ItemStack(bucketFull));
                return true;
            }
        }
        return false;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if(world.isClient()) {
            return null;
        }

        return validateTicker(type, ModBlockEntities.FORGE_STELLAIRE,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }


    @Override
    public Model getModelType() {
        return new Model(
                Optional.of(Identifier.of(Stellamecanics.MOD_ID, "block/forge_stellaire/forge_stellaire_base")),
                Optional.empty(),
                TextureKey.TOP,
                TextureKey.BOTTOM,
                TextureKey.NORTH,
                TextureKey.SOUTH,
                TextureKey.WEST,
                TextureKey.EAST
        );
    }
}
