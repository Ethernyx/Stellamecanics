package fr.Ethernyx.stellamecanics.data.recipe;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider {

    public RecipeGenerator(DataGenerator p_i48262_1_) {
        super(p_i48262_1_);
    }


    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

        /* *** craft solarium ingot *** */
        blockToIngot(consumer, ModBlocks.SOLARIUM_BLOCK.get(), ModItems.SOLARIUM_INGOT.get(), "solarium_ingot");
        /* *** craft solarium block *** */
        ingotToBlock(consumer, ModItems.SOLARIUM_INGOT.get(), ModBlocks.SOLARIUM_BLOCK.get(), "solarium_block");
        /* *** craft lunarium ingot *** */
        blockToIngot(consumer, ModBlocks.LUNARIUM_BLOCK.get(), ModItems.LUNARIUM_INGOT.get(), "lunarium_ingot");
        /* *** craft lunarium block *** */
        ingotToBlock(consumer, ModItems.LUNARIUM_INGOT.get(), ModBlocks.LUNARIUM_BLOCK.get(), "lunarium_block");
        /* *** craft stellarium ingot *** */
        blockToIngot(consumer, ModBlocks.STELLARIUM_BLOCK.get(), ModItems.STELLARIUM_INGOT.get(), "stellarium_ingot");
        /* *** craft stellarium block *** */
        ingotToBlock(consumer, ModItems.STELLARIUM_INGOT.get(), ModBlocks.STELLARIUM_BLOCK.get(), "stellarium_block");
        /* *** craft solarium armor *** */
        helmetArmor(consumer, ModItems.SOLARIUM_INGOT.get(), ModItems.SOLARIUM_HELMET.get(), "solarium_helmet");
        chesplateArmor(consumer, ModItems.SOLARIUM_INGOT.get(), ModItems.SOLARIUM_CHESTPLATE.get(), "solarium_chesplate");
        leggingsArmor(consumer, ModItems.SOLARIUM_INGOT.get(), ModItems.SOLARIUM_LEGGINGS.get(), "solarium_leggings");
        bootsArmor(consumer, ModItems.SOLARIUM_INGOT.get(), ModItems.SOLARIUM_BOOTS.get(), "solarium_boots");
        /* *** craft lunarium armor *** */
        helmetArmor(consumer, ModItems.LUNARIUM_INGOT.get(), ModItems.LUNARIUM_HELMET.get(), "lunarium_helmet");
        chesplateArmor(consumer, ModItems.LUNARIUM_INGOT.get(), ModItems.LUNARIUM_CHESTPLATE.get(), "lunarium_chesplate");
        leggingsArmor(consumer, ModItems.LUNARIUM_INGOT.get(), ModItems.LUNARIUM_LEGGINGS.get(), "lunarium_leggings");
        bootsArmor(consumer, ModItems.LUNARIUM_INGOT.get(), ModItems.LUNARIUM_BOOTS.get(), "lunarium_boots");
        /* *** craft solarium tools *** */
        pickaxeTool(consumer, ModItems.SOLARIUM_INGOT.get(), ModItems.SOLARIUM_PICKAXE.get(), "solarium_pickaxe");
        shovelTool(consumer, ModItems.SOLARIUM_INGOT.get(), ModItems.SOLARIUM_SHOVEL.get(), "solarium_shovel");
        axeTool(consumer, ModItems.SOLARIUM_INGOT.get(), ModItems.SOLARIUM_AXE.get(), "solarium_axe");
        hoeTool(consumer, ModItems.SOLARIUM_INGOT.get(), ModItems.SOLARIUM_HOE.get(), "solarium_hoe");
        swordTool(consumer, ModItems.SOLARIUM_INGOT.get(), ModItems.SOLARIUM_SWORD.get(), "solarium_sword");
        /* *** craft lunarium tools *** */
        pickaxeTool(consumer, ModItems.LUNARIUM_INGOT.get(), ModItems.LUNARIUM_PICKAXE.get(), "lunarium_pickaxe");
        shovelTool(consumer, ModItems.LUNARIUM_INGOT.get(), ModItems.LUNARIUM_SHOVEL.get(), "lunarium_shovel");
        axeTool(consumer, ModItems.LUNARIUM_INGOT.get(), ModItems.LUNARIUM_AXE.get(), "lunarium_axe");
        hoeTool(consumer, ModItems.LUNARIUM_INGOT.get(), ModItems.LUNARIUM_HOE.get(), "lunarium_hoe");
        swordTool(consumer, ModItems.LUNARIUM_INGOT.get(), ModItems.LUNARIUM_SWORD.get(), "lunarium_sword");
        /* *** craft iridium ingot *** */
        blockToIngot(consumer, ModBlocks.IRIDIUM_BLOCK.get(), ModItems.IRIDIUM_INGOT.get(), "iridium_ingot");
        furnaceIngot(consumer, ModBlocks.IRIDIUM_ORE.get(), ModItems.IRIDIUM_INGOT.get(), "ore_to_iridium_ingot");
        furnaceIngot(consumer, ModItems.IRIDIUM_RAW.get(), ModItems.IRIDIUM_INGOT.get(), "raw_to_iridium_ingot");
        /* *** craft iridium block *** */
        ingotToBlock(consumer, ModItems.IRIDIUM_INGOT.get(), ModBlocks.IRIDIUM_BLOCK.get(), "iridium_block");
        /* *** craft zirconium ingot *** */
        blockToIngot(consumer, ModBlocks.ZIRCONIUM_BLOCK.get(), ModItems.ZIRCONIUM_INGOT.get(), "zirconium_ingot");
        furnaceIngot(consumer, ModBlocks.ZIRCONIUM_ORE.get(), ModItems.ZIRCONIUM_INGOT.get(), "ore_to_zirconium_ingot");
        furnaceIngot(consumer, ModItems.ZIRCONIUM_RAW.get(), ModItems.ZIRCONIUM_INGOT.get(), "raw_to_zirconium_ingot");
        /* *** craft zirconium block *** */
        ingotToBlock(consumer, ModItems.ZIRCONIUM_INGOT.get(), ModBlocks.ZIRCONIUM_BLOCK.get(), "zirconium_block");
        /* *** craft zircaloy ingot *** */
        blockToIngot(consumer, ModBlocks.ZIRCALOY_BLOCK.get(), ModItems.ZIRCALOY_INGOT.get(), "zircaloy_ingot");
        /* *** craft zircaloy block *** */
        ingotToBlock(consumer, ModItems.ZIRCALOY_INGOT.get(), ModBlocks.ZIRCALOY_BLOCK.get(), "zircaloy_block");
        /* *** craft osmiridium ingot *** */
        blockToIngot(consumer, ModBlocks.OSMIRIDIUM_BLOCK.get(), ModItems.OSMIRIDIUM_INGOT.get(), "osmiridium_ingot");
        /* *** craft osmiridium block *** */
        ingotToBlock(consumer, ModItems.OSMIRIDIUM_INGOT.get(), ModBlocks.OSMIRIDIUM_BLOCK.get(), "osmiridium_block");
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

}
