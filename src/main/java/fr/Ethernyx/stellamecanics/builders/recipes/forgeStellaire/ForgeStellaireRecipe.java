package fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.ethernyx.stellamecanics.init.ModRecipeSerealizers;
import fr.ethernyx.stellamecanics.init.ModRecipeTypes;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public record ForgeStellaireRecipe(Ingredient inputItem, Fluid fluid, long fluidAmount, int processTime, ItemStack result) implements Recipe<ForgeStellaireRecipeInput> {

    @Override
    public boolean matches(ForgeStellaireRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(ForgeStellaireRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return result.copy();
    }

    @Override
    public RecipeSerializer<ForgeStellaireRecipe> getSerializer() { return ModRecipeSerealizers.FORGE_STELLAIRE; }

    @Override
    public RecipeType<ForgeStellaireRecipe> getType() { return ModRecipeTypes.FORGE_STELLAIRE; }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forSingleSlot(inputItem);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class ForgeStellaireRecipeSerializer implements RecipeSerializer<ForgeStellaireRecipe> {

        public static final MapCodec<ForgeStellaireRecipe> CODEC =
                RecordCodecBuilder.mapCodec(instance -> instance.group(
                        Ingredient.CODEC.fieldOf("ingredient").forGetter(ForgeStellaireRecipe::inputItem),
                        Registries.FLUID.getCodec().fieldOf("fluid").forGetter(ForgeStellaireRecipe::fluid),
                        Codec.LONG.fieldOf("fluid_amount").forGetter(ForgeStellaireRecipe::fluidAmount),
                        Codec.INT.fieldOf("process_time").forGetter(ForgeStellaireRecipe::processTime),
                        ItemStack.CODEC.fieldOf("result").forGetter(ForgeStellaireRecipe::result)
                ).apply(instance, ForgeStellaireRecipe::new));

        @Override
        public MapCodec<ForgeStellaireRecipe> codec() { return CODEC; }

        @Override
        public PacketCodec<RegistryByteBuf, ForgeStellaireRecipe> packetCodec() {
            return PacketCodec.tuple(
                    Ingredient.PACKET_CODEC, ForgeStellaireRecipe::inputItem,
                    PacketCodecs.registryValue(RegistryKeys.FLUID), ForgeStellaireRecipe::fluid,
                    PacketCodecs.LONG, ForgeStellaireRecipe::fluidAmount,
                    PacketCodecs.INTEGER, ForgeStellaireRecipe::processTime,
                    ItemStack.PACKET_CODEC, ForgeStellaireRecipe::result,
                    ForgeStellaireRecipe::new
            );
        }
    }
}
