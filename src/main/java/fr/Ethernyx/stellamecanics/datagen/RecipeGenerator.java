package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModItems;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends FabricRecipeProvider {

    public RecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public ItemConvertible getBlockOrItem(MyIngredient ingredient) {
        if (ingredient.getType() == InstanceType.BLOCK) return (ItemConvertible) ModBlocks.BLOCKS.get(ingredient.getItem());
        else if (ingredient.getType() == InstanceType.ITEM) return ModItems.ITEMS.get(ingredient.getItem());
        return null;
    }

    public List<ItemConvertible> getListBlocksOrItems(List<MyIngredient> list) {
        List<ItemConvertible> tmp = new ArrayList<>();
        for (MyIngredient ingredient : list) {
            tmp.add(getBlockOrItem(ingredient));
        }
        return tmp;
    }

    private void cookRecipe(List<RecipeBuilder> listRecipes, RecipeExporter exporter) {
        listRecipes.forEach((recipe) -> {
            switch (recipe.getType()) {
                case TOOLS:
                    if (!recipe.getInput().isEmpty() && recipe.getOutput().size() > 4) {
                        axeTool(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().getFirst()), recipe.getRecipeName() + "_axe");
                        hoeTool(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(1)), recipe.getRecipeName() + "_hoe");
                        pickaxeTool(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(2)), recipe.getRecipeName() + "_pickaxe");
                        shovelTool(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(3)), recipe.getRecipeName() + "_shovel");
                        swordTool(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(4)), recipe.getRecipeName() + "_sword");
                    }
                    break;
                case SHAPELLESS:
                    ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,getBlockOrItem(recipe.getOutput().getFirst()), recipe.getOutput().getFirst().getNb())
                            .input(getBlockOrItem(recipe.getInput().getFirst()))
                            .criterion("unlock", InventoryChangedCriterion.Conditions.items(getBlockOrItem(recipe.getInput().getFirst())))
                            .offerTo(exporter, recipe.getRecipeName());
                    break;
                case SHAPE:
                    ShapedRecipeJsonBuilder tmp = ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, getBlockOrItem(recipe.getOutput().getFirst()), recipe.getOutput().getFirst().getNb());

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
                    CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(getBlockOrItem(recipe.getInput().getFirst())), RecipeCategory.MISC, getBlockOrItem(recipe.getOutput().getFirst()), 0.2f, 100)
                            .criterion("unlock", InventoryChangedCriterion.Conditions.items(getBlockOrItem(recipe.getInput().getFirst())))
                            .offerTo(exporter, recipe.getRecipeName() + "_blasting");
                    break;
                case SMELT:
                    CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(getBlockOrItem(recipe.getInput().getFirst())), RecipeCategory.MISC, getBlockOrItem(recipe.getOutput().getFirst()), 0.2f, 200)
                            .criterion("unlock", InventoryChangedCriterion.Conditions.items(getBlockOrItem(recipe.getInput().getFirst())))
                            .offerTo(exporter, recipe.getRecipeName() + "_smelting");
                    break;
                case ARMOR:
                    if (!recipe.getInput().isEmpty() && recipe.getOutput().size() > 3) {
                        bootsArmor(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().getFirst()), recipe.getRecipeName() + "_boots");
                        chesplateArmor(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(1)), recipe.getRecipeName() + "_chesplate");
                        helmetArmor(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(2)), recipe.getRecipeName() + "_helmet");
                        leggingsArmor(exporter, getBlockOrItem(recipe.getInput().getFirst()), getBlockOrItem(recipe.getOutput().get(3)), recipe.getRecipeName() + "_leggings");
                    }
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ModItems.ITEMS.forEach((name, item) -> {
            cookRecipe(item.getRecipe(), exporter);
        });

        ModBlocks.BLOCKS.forEach((name, block) -> {
           // cookRecipe(block.getRecipe(), exporter);
        });
    }

    private void furnaceIngot(RecipeExporter exporter, ItemConvertible input, ItemConvertible output, String name) {
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(input), RecipeCategory.MISC, output, 0.2f, 200)
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(input))
                .offerTo(exporter, name + "_smelting");
        CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItems(input), RecipeCategory.MISC, output, 0.2f, 100)
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(input))
                .offerTo(exporter, name + "_blasting");
    }
    private void ingotToBlock(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible block, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, block)
                .input('I', ingot)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(exporter, name);
        
    }

    private void blockToIngot(RecipeExporter exporter, ItemConvertible block, ItemConvertible ingot, String name) {

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ingot, 9)
                .input(block)
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(block))
                .offerTo(exporter, name);
    }

    private void chesplateArmor(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .input('I', ingot)
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(exporter, name);
    }

    private void bootsArmor(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .input('I', ingot)
                .pattern("I I")
                .pattern("I I")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(exporter, name);
    }

    private void leggingsArmor(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,result)
                .input('I', ingot)
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(exporter, name);
    }

    private void helmetArmor(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .input('I', ingot)
                .pattern("III")
                .pattern("I I")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(exporter, name);
    }
    private void swordTool(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, result)
                .input('I', ingot)
                .input('S', Items.STICK)
                .pattern("I")
                .pattern("I")
                .pattern("S")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(exporter, name);
    }

    private void pickaxeTool(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .input('I', ingot)
                .input('S', Items.STICK)
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(exporter, name);
    }

    private void axeTool(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .input('I', ingot)
                .input('S', Items.STICK)
                .pattern("II")
                .pattern("SI")
                .pattern("S ")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(exporter, name);
    }

    private void shovelTool(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .input('I', ingot)
                .input('S', Items.STICK)
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(exporter, name);
    }

    private void hoeTool(RecipeExporter exporter, ItemConvertible ingot, ItemConvertible result, String name) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, result)
                .input('I', ingot)
                .input('S', Items.STICK)
                .pattern("II")
                .pattern("S ")
                .pattern("S ")
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(ingot))
                .offerTo(exporter, name);
    }

    private void alloyIngot(RecipeExporter exporter, ItemConvertible input1, ItemConvertible input2, ItemConvertible output, String name) {
        /*SmithingRecipeJsonBuilder.create(Ingredient.ofItems(input1), Ingredient.ofItems(input2), (Item) output)
                .criterion("unlock", InventoryChangedCriterion.Conditions.items(input1, input2))
                .offerTo(exporter, name);*/
    }
}
