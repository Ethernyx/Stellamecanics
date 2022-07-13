package net.Ethernyx.stellamecanics.data.recipe;

import net.Ethernyx.stellamecanics.Main;
import net.Ethernyx.stellamecanics.init.ModBlocks;
import net.Ethernyx.stellamecanics.init.ModItems;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.resource.ResourcePackSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    private final List<AidInfoGenerator> aids;

    public RecipeGenerator(FabricDataGenerator dataGenerator, List<AidInfoGenerator> aids) {
        super(dataGenerator);
        this.aids = aids;
    }

    public ItemConvertible getBlockOrItem(RecipeIngredient ingredient) {
        if (ingredient.getType() == InstanceType.BLOCK) return ModBlocks.BLOCKS.get(ingredient.getItem()).block;
        else if (ingredient.getType() == InstanceType.ITEM) return ModItems.ITEMS.get(ingredient.getItem()).item;
        return null;
    }

    public List<ItemConvertible> getListBlocksOrItems(List<RecipeIngredient> list) {
        List<ItemConvertible> tmp = new ArrayList<>();
        for (RecipeIngredient ingredient : list) {
            tmp.add(getBlockOrItem(ingredient));
        }
        return tmp;
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> consumer) {
        for (AidInfoGenerator item : this.aids) {
            if (item.getRecipe().size() > 0) {
                for (Map.Entry<String, RecipeBuilder> entry : item.getRecipe().entrySet()) {
                    switch (entry.getValue().getType()) {
                        case TOOLS:
                            if (entry.getValue().getInput().size() > 0 && entry.getValue().getOutput().size() > 4) {
                                axeTool(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getOutput().get(0)), entry.getKey() + "_axe");
                                hoeTool(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getOutput().get(1)), entry.getKey() + "_hoe");
                                pickaxeTool(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getOutput().get(2)), entry.getKey() + "_pickaxe");
                                shovelTool(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getOutput().get(3)), entry.getKey() + "_shovel");
                                swordTool(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getOutput().get(4)), entry.getKey() + "_sword");
                            }
                            break;
                        case SHAPELLESS:
                            ShapelessRecipeJsonBuilder.create(getBlockOrItem(entry.getValue().getOutput().get(0)), entry.getValue().getOutput().get(0).getNb())
                                    .input(getBlockOrItem(entry.getValue().getInput().get(0)))
                                    .criterion("unlock", InventoryChangedCriterion.Conditions.items(getBlockOrItem(entry.getValue().getInput().get(0))))
                                    .offerTo(consumer, entry.getKey());
                            break;
                        case SHAPE:
                            ShapedRecipeJsonBuilder tmp = ShapedRecipeJsonBuilder.create(getBlockOrItem(entry.getValue().getOutput().get(0)), entry.getValue().getOutput().get(0).getNb());

                            for (int i = 0; i < entry.getValue().getInput().size(); i++) {
                                tmp.input((char)(i + '0'), getBlockOrItem(entry.getValue().getInput().get(i)));
                            }
                            for (String pattern : entry.getValue().getPattern()) {
                                tmp.pattern(pattern);
                            }

                            tmp.criterion("unlock", InventoryChangedCriterion.Conditions.items(getListBlocksOrItems(entry.getValue().getUnlock()).toArray(new ItemConvertible[0])));
                            tmp.offerTo(consumer, entry.getKey());
                            break;
                        case ORE:
                            furnaceIngot(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getOutput().get(0)), entry.getKey());
                            break;
                        case SMITH:
                            if (entry.getValue().getInput().size() > 1) alloyIngot(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getInput().get(1)), getBlockOrItem(entry.getValue().getOutput().get(0)), entry.getKey());
                            break;
                        case BLAST:
                            CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(getBlockOrItem(entry.getValue().getInput().get(0))), getBlockOrItem(entry.getValue().getOutput().get(0)), 0.2f, 100)
                                    .criterion("unlock", InventoryChangedCriterion.Conditions.items(getBlockOrItem(entry.getValue().getInput().get(0))))
                                    .offerTo(consumer, entry.getKey() + "_blasting");
                            break;
                        case SMELT:
                            CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(getBlockOrItem(entry.getValue().getInput().get(0))), getBlockOrItem(entry.getValue().getOutput().get(0)), 0.2f, 200)
                                    .criterion("unlock", InventoryChangedCriterion.Conditions.items(getBlockOrItem(entry.getValue().getInput().get(0))))
                                    .offerTo(consumer, entry.getKey() + "_smelting");
                            break;
                        case ARMOR:
                            if (entry.getValue().getInput().size() > 0 && entry.getValue().getOutput().size() > 3) {
                                bootsArmor(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getOutput().get(0)), entry.getKey() + "_boots");
                                chesplateArmor(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getOutput().get(1)), entry.getKey() + "_chesplate");
                                helmetArmor(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getOutput().get(2)), entry.getKey() + "_helmet");
                                leggingsArmor(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getOutput().get(3)), entry.getKey() + "_leggings");
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
    private void furnaceIngot(Consumer<RecipeJsonProvider> consumer, ItemConvertible input, ItemConvertible output, String name) {
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(input), output, 0.2f, 200)
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(input))
                .offerTo(consumer, name + "_smelting");
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(input), output, 0.2f, 100)
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(input))
                .offerTo(consumer, name + "_blasting");
    }
    private void ingotToBlock(Consumer<RecipeJsonProvider> consumer, ItemConvertible ingot, ItemConvertible block, String name) {
        ShapedRecipeJsonBuilder.create(block)
                .input('I', ingot)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(consumer, name);
        
    }

    private void blockToIngot(Consumer<RecipeJsonProvider> consumer, ItemConvertible block, ItemConvertible ingot, String name) {

        ShapelessRecipeJsonBuilder.create(ingot, 9)
                .input(block)
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(block))
                .offerTo(consumer, name);
    }

    private void chesplateArmor(Consumer<RecipeJsonProvider> consumer, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(result)
                .input('I', ingot)
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(consumer, name);
    }

    private void bootsArmor(Consumer<RecipeJsonProvider> consumer, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(result)
                .input('I', ingot)
                .pattern("I I")
                .pattern("I I")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(consumer, name);
    }

    private void leggingsArmor(Consumer<RecipeJsonProvider> consumer, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(result)
                .input('I', ingot)
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(consumer, name);
    }

    private void helmetArmor(Consumer<RecipeJsonProvider> consumer, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(result)
                .input('I', ingot)
                .pattern("III")
                .pattern("I I")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(consumer, name);
    }
    private void swordTool(Consumer<RecipeJsonProvider> consumer, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(result)
                .input('I', ingot)
                .input('S', Items.STICK)
                .pattern("I")
                .pattern("I")
                .pattern("S")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(consumer, name);
    }

    private void pickaxeTool(Consumer<RecipeJsonProvider> consumer, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(result)
                .input('I', ingot)
                .input('S', Items.STICK)
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(consumer, name);
    }

    private void axeTool(Consumer<RecipeJsonProvider> consumer, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(result)
                .input('I', ingot)
                .input('S', Items.STICK)
                .pattern("II")
                .pattern("SI")
                .pattern("S ")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(consumer, name);
    }

    private void shovelTool(Consumer<RecipeJsonProvider> consumer, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(result)
                .input('I', ingot)
                .input('S', Items.STICK)
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(consumer, name);
    }

    private void hoeTool(Consumer<RecipeJsonProvider> consumer, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(result)
                .input('I', ingot)
                .input('S', Items.STICK)
                .pattern("II")
                .pattern("S ")
                .pattern("S ")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(consumer, name);
    }

    private void alloyIngot(Consumer<RecipeJsonProvider> consumer, ItemConvertible input1, ItemConvertible input2, ItemConvertible output, String name) {
        SmithingRecipeJsonBuilder.create(Ingredient.ofItems(input1), Ingredient.ofItems(input2), (Item) output)
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(input1, input2))
                .offerTo(consumer, name);
    }

}
