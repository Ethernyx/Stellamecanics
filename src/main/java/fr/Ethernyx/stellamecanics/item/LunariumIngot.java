package fr.Ethernyx.stellamecanics.item;

import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
import fr.Ethernyx.stellamecanics.utils.*;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;

import java.util.*;

public class LunariumIngot extends Item {
    private final String id = "lunarium_ingot";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Lingot de lunarium"); put("en_us", "Lunarium ingot");
    }};

    private AidInfoGenerator data;

    public LunariumIngot() {
        super(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB));

        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        // block
        this.data.recipe.put("lunarium_block",
                new RecipeBuilder(RecipeType.SHAPE,
                        new ArrayList<>(Collections.singletonList(ModItems.LUNARIUM_INGOT.get())),
                new ArrayList<>(Collections.singletonList(new RecipeIngredient(ModBlocks.LUNARIUM_BLOCK.get(), 1))),
                new ArrayList<>(Arrays.asList("000", "000", "000")),
                new ArrayList<>(Collections.singletonList(ModBlocks.LUNARIUM_BLOCK.get()))));
        // tools
        this.data.recipe.put("lunarium_tool", new RecipeBuilder(RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(ModItems.LUNARIUM_INGOT.get())),
                new ArrayList<>(Arrays.asList(new RecipeIngredient(ModItems.LUNARIUM_AXE.get(), 1),
                        new RecipeIngredient(ModItems.LUNARIUM_HOE.get(), 1),
                        new RecipeIngredient(ModItems.LUNARIUM_PICKAXE.get(), 1),
                        new RecipeIngredient(ModItems.LUNARIUM_SHOVEL.get(), 1)))));
        // armures
        this.data.recipe.put("lunarium_armor", new RecipeBuilder(RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(ModItems.LUNARIUM_INGOT.get())),
                new ArrayList<>(Arrays.asList(new RecipeIngredient(ModItems.LUNARIUM_BOOTS.get(), 1),
                        new RecipeIngredient(ModItems.LUNARIUM_CHESTPLATE.get(), 1),
                        new RecipeIngredient(ModItems.LUNARIUM_HELMET.get(), 1),
                        new RecipeIngredient(ModItems.LUNARIUM_LEGGINGS.get(), 1)))));

    }

    public AidInfoGenerator getData(){
        return this.data;
    }




}
