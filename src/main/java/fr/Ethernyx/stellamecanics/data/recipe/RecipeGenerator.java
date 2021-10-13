package fr.Ethernyx.stellamecanics.data.recipe;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.Ethernyx.stellamecanics.utils.generator.SerealizerGenerator;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {
    private final List<AidInfoGenerator> aids;

    public RecipeGenerator(DataGenerator p_i48262_1_, List<AidInfoGenerator> aids) {
        super(p_i48262_1_);
        this.aids = aids;
    }

    public IItemProvider getBlockOrItem(RecipeIngredient ingredient) {
        if (ingredient.getType() == InstanceType.BLOCK) return ModBlocks.MAP_BLOCKS.get(ingredient.getItem()).block.get();
        else if (ingredient.getType() == InstanceType.ITEM) return ModItems.MAP_ITEMS.get(ingredient.getItem()).item.get();
        return null;
    }

    public List<IItemProvider> getListBlocksOrItems(List<RecipeIngredient> list) {
        List<IItemProvider> tmp = new ArrayList<>();
        for (RecipeIngredient ingredient : list) {
            tmp.add(getBlockOrItem(ingredient));
        }
        return tmp;
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
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
                           ShapelessRecipeBuilder.shapeless(getBlockOrItem(entry.getValue().getOutput().get(0)), entry.getValue().getOutput().get(0).getNb())
                                   .requires(getBlockOrItem(entry.getValue().getInput().get(0)))
                                   .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(getBlockOrItem(entry.getValue().getInput().get(0))))
                                   .save(consumer, new ResourceLocation(Main.MOD_ID, entry.getKey()));
                           break;
                       case SHAPE:
                           ShapedRecipeBuilder tmp = ShapedRecipeBuilder.shaped(getBlockOrItem(entry.getValue().getOutput().get(0)), entry.getValue().getOutput().get(0).getNb());

                           for (int i = 0; i < entry.getValue().getInput().size(); i++) {
                               tmp.define((char)(i + '0'), getBlockOrItem(entry.getValue().getInput().get(i)));
                           }
                           for (String pattern : entry.getValue().getPattern()) {
                               tmp.pattern(pattern);
                           }

                           tmp.unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(getListBlocksOrItems(entry.getValue().getUnlock()).toArray(new IItemProvider[0])));
                           tmp.save(consumer, new ResourceLocation(Main.MOD_ID, entry.getKey()));
                           break;
                       case ORE:
                           furnaceIngot(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getOutput().get(0)), entry.getKey());
                           break;
                       case SMITH:
                           if (entry.getValue().getInput().size() > 1) alloyIngot(consumer, getBlockOrItem(entry.getValue().getInput().get(0)), getBlockOrItem(entry.getValue().getInput().get(1)), getBlockOrItem(entry.getValue().getOutput().get(0)), entry.getKey());
                           break;
                       case BLAST:
                           CookingRecipeBuilder.blasting(Ingredient.of(getBlockOrItem(entry.getValue().getInput().get(0))), getBlockOrItem(entry.getValue().getOutput().get(0)), 0.2f, 100)
                                   .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(getBlockOrItem(entry.getValue().getInput().get(0))))
                                   .save(consumer, new ResourceLocation(Main.MOD_ID, entry.getKey() + "_blasting"));
                           break;
                       case SMELT:
                           CookingRecipeBuilder.smelting(Ingredient.of(getBlockOrItem(entry.getValue().getInput().get(0))), getBlockOrItem(entry.getValue().getOutput().get(0)), 0.2f, 200)
                                   .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(getBlockOrItem(entry.getValue().getInput().get(0))))
                                   .save(consumer, new ResourceLocation(Main.MOD_ID, entry.getKey() + "_smelting"));
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
    private void furnaceIngot(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider output, String name) {
        CookingRecipeBuilder.smelting(Ingredient.of(input), output, 0.2f, 200)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(input))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name + "_smelting"));
        CookingRecipeBuilder.blasting(Ingredient.of(input), output, 0.2f, 100)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(input))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name + "_blasting"));
    }
    private void ingotToBlock(Consumer<IFinishedRecipe> consumer, IItemProvider ingot, IItemProvider block, String name) {
        ShapedRecipeBuilder.shaped(block)
                .define('I', ingot)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ingot))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name));
    }

    private void blockToIngot(Consumer<IFinishedRecipe> consumer, IItemProvider block, IItemProvider ingot, String name) {
        ShapelessRecipeBuilder.shapeless(ingot, 9)
                .requires(block)
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(block))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name));
    }

    private void chesplateArmor(Consumer<IFinishedRecipe> consumer, IItemProvider ingot, IItemProvider result, String name) {
        ShapedRecipeBuilder.shaped(result)
                .define('I', ingot)
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ingot))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name));
    }

    private void bootsArmor(Consumer<IFinishedRecipe> consumer, IItemProvider ingot, IItemProvider result, String name) {
        ShapedRecipeBuilder.shaped(result)
                .define('I', ingot)
                .pattern("I I")
                .pattern("I I")
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ingot))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name));
    }

    private void leggingsArmor(Consumer<IFinishedRecipe> consumer, IItemProvider ingot, IItemProvider result, String name) {
        ShapedRecipeBuilder.shaped(result)
                .define('I', ingot)
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ingot))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name));
    }

    private void helmetArmor(Consumer<IFinishedRecipe> consumer, IItemProvider ingot, IItemProvider result, String name) {
        ShapedRecipeBuilder.shaped(result)
                .define('I', ingot)
                .pattern("III")
                .pattern("I I")
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ingot))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name));
    }
    private void swordTool(Consumer<IFinishedRecipe> consumer, IItemProvider ingot, IItemProvider result, String name) {
        ShapedRecipeBuilder.shaped(result)
                .define('I', ingot)
                .define('S', Items.STICK)
                .pattern("I")
                .pattern("I")
                .pattern("S")
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ingot))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name));
    }

    private void pickaxeTool(Consumer<IFinishedRecipe> consumer, IItemProvider ingot, IItemProvider result, String name) {
        ShapedRecipeBuilder.shaped(result)
                .define('I', ingot)
                .define('S', Items.STICK)
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ingot))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name));
    }

    private void axeTool(Consumer<IFinishedRecipe> consumer, IItemProvider ingot, IItemProvider result, String name) {
        ShapedRecipeBuilder.shaped(result)
                .define('I', ingot)
                .define('S', Items.STICK)
                .pattern("II")
                .pattern("SI")
                .pattern("S ")
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ingot))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name));
    }

    private void shovelTool(Consumer<IFinishedRecipe> consumer, IItemProvider ingot, IItemProvider result, String name) {
        ShapedRecipeBuilder.shaped(result)
                .define('I', ingot)
                .define('S', Items.STICK)
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ingot))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name));
    }

    private void hoeTool(Consumer<IFinishedRecipe> consumer, IItemProvider ingot, IItemProvider result, String name) {
        ShapedRecipeBuilder.shaped(result)
                .define('I', ingot)
                .define('S', Items.STICK)
                .pattern("II")
                .pattern("S ")
                .pattern("S ")
                .unlockedBy("unlock", InventoryChangeTrigger.Instance.hasItems(ingot))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name));
    }

    private void alloyIngot(Consumer<IFinishedRecipe> consumer, IItemProvider input1, IItemProvider input2, IItemProvider output, String name) {
        SmithingRecipeBuilder.smithing(Ingredient.of(input1), Ingredient.of(input2), (Item) output)
                .unlocks("unlock", InventoryChangeTrigger.Instance.hasItems(input1, input2))
                .save(consumer, new ResourceLocation(Main.MOD_ID, name));
    }
}
