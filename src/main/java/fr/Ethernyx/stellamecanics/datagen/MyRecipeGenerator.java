package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipeBuilder;
import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModFluids;
import fr.ethernyx.stellamecanics.init.ModItems;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MyRecipeGenerator extends FabricRecipeProvider {

    public MyRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected net.minecraft.data.recipe.RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                ModItems.ITEMS.forEach((name, item) -> {
                    cookRecipe(item.getRecipe(), exporter);
                });

                ModBlocks.BLOCKS.forEach((name, block) -> {
                    cookRecipe(block.getRecipe(), exporter);
                });
            }

            private void cookRecipe(List<RecipeBuilder> listRecipes, RecipeExporter exporter) {
                listRecipes.forEach((recipe) -> {
                    switch (recipe.getType()) {
                        case TOOLS:
                            if (!recipe.getInput().isEmpty() && recipe.getOutput().size() > 4) {
                                axeTool(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().getFirst()), recipe.getRecipeName() + "_axe");
                                hoeTool(exporter, getBlockOrItem (recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(1)), recipe.getRecipeName() + "_hoe");
                                pickaxeTool(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(2)), recipe.getRecipeName() + "_pickaxe");
                                shovelTool(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(3)), recipe.getRecipeName() + "_shovel");
                                swordTool(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(4)), recipe.getRecipeName() + "_sword");
                            }
                            break;
                        case SHAPELLESS:
                            createShapeless(RecipeCategory.MISC,getBlockOrItem(recipe.getOutput().getFirst()), recipe.getOutput().getFirst().getNb())
                                    .input(getBlockOrItem(recipe.getInput().getFirst()))
                                    .criterion("unlock", InventoryChangedCriterion.Conditions.items(getBlockOrItem(recipe.getInput().getFirst())))
                                    .offerTo(exporter, recipe.getRecipeName());
                            break;
                        case SHAPE:
                            ShapedRecipeJsonBuilder tmp = createShaped(RecipeCategory.MISC, getBlockOrItem(recipe.getOutput().getFirst()), recipe.getOutput().getFirst().getNb());
                            for (int i = 0; i < recipe.getInput().size(); i++) {
                                tmp.input((char)(i + '0'), getBlockOrItem(recipe.getInput().get(i)));
                            }
                            for (String pattern : recipe.getPattern()) {
                                tmp.pattern(pattern);
                            }

                            tmp.criterion("unlock", InventoryChangedCriterion.Conditions.items(getListBlocksOrItems(recipe.getUnlock()).toArray(new ItemConvertible[0])));
                            tmp.offerTo(exporter, recipe.getRecipeName());
                            break;
                        case ORE:
                            furnaceIngot(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().getFirst()), recipe.getRecipeName());
                            break;
                        case SMITH:
                            if (recipe.getInput().size() > 1) alloyIngot(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getInput().get(1)), getBlockOrItem(recipe.getOutput().getFirst()), recipe.getRecipeName());
                            break;
                        case BLAST:
                        case SMELT:
                            List<ItemConvertible> COOKIES = List.of(getBlockOrItem(recipe.getInput().getFirst()));
                            if (recipe.getType() == RecipeType.BLAST) offerBlasting(COOKIES, RecipeCategory.MISC, getBlockOrItem(recipe.getOutput().getFirst()), 0.2f, 100, recipe.getRecipeName() + "_blasting");
                            else offerSmelting(COOKIES, RecipeCategory.MISC, getBlockOrItem(recipe.getOutput().getFirst()), 0.2f, 200, recipe.getRecipeName() + "_smelting");
                            break;
                        case ARMOR:
                            if (!recipe.getInput().isEmpty() && recipe.getOutput().size() > 3) {
                                bootsArmor(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().getFirst()), recipe.getRecipeName() + "_boots");
                                chesplateArmor(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(1)), recipe.getRecipeName() + "_chesplate");
                                helmetArmor(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(2)), recipe.getRecipeName() + "_helmet");
                                leggingsArmor(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(3)), recipe.getRecipeName() + "_leggings");
                            }
                            break;
                        case FORGE:
                            ForgeStellaireRecipeBuilder.offer(exporter, recipe.getRecipeName(), Ingredient.ofItems(getBlockOrItem(recipe.getInput().getFirst())), getFluid(recipe.getFluid().getFirst()), recipe.getFluid().getFirst().getNb(), 50, new ItemStack(getBlockOrItem(recipe.getOutput().getFirst()), recipe.getOutput().getFirst().getNb()));
                        default:
                            break;
                    }
                });
            }

            private void furnaceIngot(RecipeExporter exporter, ItemConvertible input, ItemConvertible output, String name) {
                List<ItemConvertible> COOKIES = List.of(input);
                offerSmelting(COOKIES, RecipeCategory.MISC, output, 0.2f, 200,  name + "_smelting");
                offerBlasting(COOKIES, RecipeCategory.MISC, output, 0.2f, 100,  name + "_blasting");
            }

            private void ingotToBlock(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible block, String name) {
                createShaped(RecipeCategory.MISC, block)
                        .input('I', ingot)
                        .pattern("III")
                        .pattern("III")
                        .pattern("III")
                        .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                        .offerTo(exporter, name);

            }

            private void blockToIngot(RecipeExporter exporter, ItemConvertible block, ItemConvertible ingot, String name) {

                createShapeless(RecipeCategory.MISC, ingot, 9)
                        .input(block)
                        .criterion("unlock", InventoryChangedCriterion.Conditions.items(block))
                        .offerTo(exporter, name);
            }

            private void chesplateArmor(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
                createShaped(RecipeCategory.COMBAT, result)
                        .input('I', ingot)
                        .pattern("I I")
                        .pattern("III")
                        .pattern("III")
                        .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                        .offerTo(exporter, name);
            }

            private void bootsArmor(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
                createShaped(RecipeCategory.COMBAT, result)
                        .input('I', ingot)
                        .pattern("I I")
                        .pattern("I I")
                        .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                        .offerTo(exporter, name);
            }

            private void leggingsArmor(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
                createShaped(RecipeCategory.COMBAT,result)
                        .input('I', ingot)
                        .pattern("III")
                        .pattern("I I")
                        .pattern("I I")
                        .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                        .offerTo(exporter, name);
            }

            private void helmetArmor(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
                createShaped(RecipeCategory.COMBAT, result)
                        .input('I', ingot)
                        .pattern("III")
                        .pattern("I I")
                        .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                        .offerTo(exporter, name);
            }
            private void swordTool(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
                createShaped(RecipeCategory.COMBAT, result)
                        .input('I', ingot)
                        .input('S', Items.STICK)
                        .pattern("I")
                        .pattern("I")
                        .pattern("S")
                        .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                        .offerTo(exporter, name);
            }

            private void pickaxeTool(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
                createShaped(RecipeCategory.TOOLS, result)
                        .input('I', ingot)
                        .input('S', Items.STICK)
                        .pattern("III")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                        .offerTo(exporter, name);
            }

            private void axeTool(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
                createShaped(RecipeCategory.TOOLS, result)
                        .input('I', ingot)
                        .input('S', Items.STICK)
                        .pattern("II")
                        .pattern("SI")
                        .pattern("S ")
                        .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                        .offerTo(exporter, name);
            }

            private void shovelTool(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
                createShaped(RecipeCategory.TOOLS, result)
                        .input('I', ingot)
                        .input('S', Items.STICK)
                        .pattern("I")
                        .pattern("S")
                        .pattern("S")
                        .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                        .offerTo(exporter, name);
            }

            private void hoeTool(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
                createShaped(RecipeCategory.TOOLS, result)
                        .input('I', ingot)
                        .input('S', Items.STICK)
                        .pattern("II")
                        .pattern("S ")
                        .pattern("S ")
                        .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                        .offerTo(exporter, name);
            }

            private void alloyIngot(RecipeExporter exporter, ItemConvertible input1, ItemConvertible input2, ItemConvertible output, String name) {
            }
        };
    }

    public ItemConvertible getBlockOrItem(MyIngredient ingredient) {
        switch (ingredient.getType()) {
            case BLOCK -> { return (ItemConvertible) ModBlocks.BLOCKS.get(ingredient.getItem()); }
            case ITEM -> { return (ItemConvertible) ModItems.ITEMS.get(ingredient.getItem()); }
            case VANILLABLOCK -> { return Registries.BLOCK.get(Identifier.of("minecraft", ingredient.getItem())); }
            case VANILLAITEM -> { return Registries.ITEM.get(Identifier.of("minecraft", ingredient.getItem())); }
            default -> { return null; }
        }
    }

    public Fluid getFluid(MyIngredient ingredient) {
        switch (ingredient.getType()) {
            case VANILLAFLUID ->  { return Registries.FLUID.get(Identifier.of("minecraft", ingredient.getItem())); }
            case FLUID ->  { return ModFluids.FLUIDS.get(ingredient.getItem()).getStill().getStill(); }
            default -> { return null; }
        }
    }

    public List<ItemConvertible> getListBlocksOrItems(List<MyIngredient> list) {
        List<ItemConvertible> tmp = new ArrayList<>();
        for (MyIngredient ingredient : list) {
            tmp.add(getBlockOrItem(ingredient));
        }
        return tmp;
    }

    @Override
    public String getName() {
        return "";
    }
}
