package fr.Ethernyx.stellamecanics.data.recipe;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

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

}
