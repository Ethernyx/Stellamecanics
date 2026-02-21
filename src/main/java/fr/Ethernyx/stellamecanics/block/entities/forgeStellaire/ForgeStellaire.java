package fr.ethernyx.stellamecanics.block.entities.forgeStellaire;

import com.mojang.serialization.MapCodec;
import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModBlockEntities;
import fr.ethernyx.stellamecanics.interfaces.IMyBlock;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.ethernyx.stellamecanics.utils.generator.LootType;
import fr.ethernyx.stellamecanics.utils.generator.MyLootTable;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

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


        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }


        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof ForgeStellaireEntity forge)) {
            return ActionResult.PASS;
        }

        // 🪣 1️⃣ PRIORITÉ AU FLUIDE
        if (handleFluidInteraction(player, hand, forge, world, pos)) {
            return ActionResult.CONSUME;
        }

        // 🖱️ 2️⃣ SINON → GUI
        player.openHandledScreen(forge);
        return ActionResult.CONSUME;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ForgeStellaireEntity(pos, state);
    }

    private boolean handleFluidInteraction(PlayerEntity player, Hand hand,
                                           ForgeStellaireEntity forge, World world, BlockPos pos) {

        ItemStack stack = player.getStackInHand(hand);

        if (stack.isOf(Items.LAVA_BUCKET)) {

            if (forge.addFluid(forge.tankSolarium, Fluids.LAVA, 1000)) {
                // 🔊 SON
                world.playSound(
                        null,                    // tous les joueurs
                        pos,
                        SoundEvents.ITEM_BUCKET_EMPTY_LAVA,
                        SoundCategory.BLOCKS,
                        1.0F,
                        1.0F
                );
                if (!player.getAbilities().creativeMode) {
                    player.setStackInHand(hand, new ItemStack(Items.BUCKET));
                }

                return true;
            }
        } else if (stack.isOf(Items.BUCKET)) {
            if (forge.addFluid(forge.tankSolarium,Fluids.LAVA, - 1000)) {
                // 🔊 SON
                world.playSound(
                        null,                    // tous les joueurs
                        pos,
                        SoundEvents.ITEM_BUCKET_FILL_LAVA,
                        SoundCategory.BLOCKS,
                        1.0F,
                        1.0F
                );
                if (!player.getAbilities().creativeMode) {
                    player.setStackInHand(hand, new ItemStack(Items.LAVA_BUCKET));
                }

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
}
