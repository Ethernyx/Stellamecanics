package net.Ethernyx.stellamecanics.items.ore;

import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.Item;

import java.util.*;

public class StellariumIngot extends Item {
    private static final String id = "stellarium_ingot";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Lingot de stellarium"); put("en_us", "Stellarium ingot");
    }};

   // private AidInfoGenerator data;

    public StellariumIngot() {
        super(new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        /*this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        // block
        this.data.recipe.put("stellarium_block",
                new RecipeBuilder(RecipeType.SHAPE,
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("stellarium_ingot", InstanceType.ITEM, 1))),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("stellarium_block", InstanceType.BLOCK, 1))),
                        new ArrayList<>(Arrays.asList("000", "000", "000")),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("stellarium_ingot", InstanceType.ITEM, 1)))));
        // tools
        this.data.recipe.put("stellarium_tool", new RecipeBuilder(RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("stellarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("stellarium_axe", InstanceType.ITEM, 1),
                        new RecipeIngredient("stellarium_hoe", InstanceType.ITEM, 1),
                        new RecipeIngredient("stellarium_pickaxe", InstanceType.ITEM, 1),
                        new RecipeIngredient("stellarium_shovel", InstanceType.ITEM, 1),
                        new RecipeIngredient("stellarium_sword", InstanceType.ITEM, 1)))));
        // armures
        this.data.recipe.put("stellarium_armor", new RecipeBuilder(RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("stellarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("stellarium_boots", InstanceType.ITEM, 1),
                        new RecipeIngredient("stellarium_chestplate", InstanceType.ITEM, 1),
                        new RecipeIngredient("stellarium_helmet", InstanceType.ITEM, 1),
                        new RecipeIngredient("stellarium_leggings", InstanceType.ITEM, 1)))));*/
    }
    public static String getId() { return id;}
    //public AidInfoGenerator getData() { return data; }
}
