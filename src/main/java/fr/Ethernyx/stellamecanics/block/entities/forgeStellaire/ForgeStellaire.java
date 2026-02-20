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

    public static String ID = "forge_stellaire";
    public static final MapCodec<ForgeStellaire> CODEC = ForgeStellaire.createCodec(ForgeStellaire::new);

    public ForgeStellaire(Settings settings) {
        super(settings.registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                Identifier.of(Stellamecanics.MOD_ID, ID))).strength(3f, 15f));
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Forge Stellaire");
            put("en_us", "Star Forge");
        }};
        return langs.get(lang);
    }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();
        recipes.add(new RecipeBuilder(
                "forge_stellaire",
                        RecipeType.SHAPE,
                        new ArrayList<>(List.of(
                                new MyIngredient("iridium_block", InstanceType.BLOCK, 1),
                                new MyIngredient("iridium_ingot", InstanceType.ITEM, 1),
                                new MyIngredient("furnace", InstanceType.VANILLABLOCK, 1)
                        )),
                        new ArrayList<>(Collections.singletonList(new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1))),
                        new ArrayList<>(Arrays.asList("0 0", "121", "111")),
                new ArrayList<>(Collections.singletonList(new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1)))
        ));
        return recipes;
    }

    @Override
    public MyLootTable getLootTable() {
        return new MyLootTable(LootType.NORMAL, new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1));
    }

    @Override
    public List<TagKey<Block>> getTags() {
        List<TagKey<Block>> tags = new ArrayList<>();
        tags.add(BlockTags.PICKAXE_MINEABLE);
        return tags;
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

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
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
