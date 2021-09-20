package fr.Ethernyx.stellamecanics.item;

import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.item.Item;

import java.util.*;

public class ZircaloyIngot extends Item {
    private final String id = "zircaloy_ingot";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Lingot de zircaloy"); put("en_us", "Zircaloy ingot");
    }};

    private AidInfoGenerator data;

    public ZircaloyIngot() {
        super(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
    }

    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        // block
        this.data.recipe.put("zircaloy_block",
                new RecipeBuilder(RecipeType.SHAPE,
                        new ArrayList<>(Collections.singletonList(ModItems.ZIRCALOY_INGOT.get())),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient(ModBlocks.ZIRCALOY_BLOCK.get(), 1))),
                        new ArrayList<>(Arrays.asList("000", "000", "000")),
                        new ArrayList<>(Collections.singletonList(ModItems.ZIRCALOY_INGOT.get()))));
        // tools
        this.data.recipe.put("zircaloy_tool", new RecipeBuilder(RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(ModItems.ZIRCALOY_INGOT.get())),
                new ArrayList<>(Arrays.asList(new RecipeIngredient(ModItems.ZIRCALOY_AXE.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCALOY_HOE.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCALOY_PICKAXE.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCALOY_SHOVEL.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCALOY_SWORD.get(), 1)))));
        // armures
        this.data.recipe.put("zircaloy_armor", new RecipeBuilder(RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(ModItems.ZIRCALOY_INGOT.get())),
                new ArrayList<>(Arrays.asList(new RecipeIngredient(ModItems.ZIRCALOY_BOOTS.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCALOY_CHESTPLATE.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCALOY_HELMET.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCALOY_LEGGINGS.get(), 1)))));
        return this.data;
    }

    public String getId() {
        return this.id;
    }
}
