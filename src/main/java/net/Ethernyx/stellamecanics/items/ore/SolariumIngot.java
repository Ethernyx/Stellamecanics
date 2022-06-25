package net.Ethernyx.stellamecanics.items.ore;

import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.Item;

import java.util.*;

public class SolariumIngot extends Item {
    private static final String id = "solarium_ingot";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Lingot de solarium"); put("en_us", "Solarium ingot");
    }};

   // private AidInfoGenerator data;

    public SolariumIngot() {
        super(new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
      /*  this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        // block
        this.data.recipe.put("solarium_block",
                new RecipeBuilder(RecipeType.SHAPE,
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("solarium_ingot", InstanceType.ITEM, 1))),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("solarium_block", InstanceType.BLOCK, 1))),
                        new ArrayList<>(Arrays.asList("000", "000", "000")),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("solarium_ingot", InstanceType.ITEM, 1)))));
        // tools
        this.data.recipe.put("solarium_tool", new RecipeBuilder(RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("solarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("solarium_axe", InstanceType.ITEM, 1),
                        new RecipeIngredient("solarium_hoe", InstanceType.ITEM, 1),
                        new RecipeIngredient("solarium_pickaxe", InstanceType.ITEM, 1),
                        new RecipeIngredient("solarium_shovel", InstanceType.ITEM, 1),
                        new RecipeIngredient("solarium_sword", InstanceType.ITEM, 1)))));
        // armures
        this.data.recipe.put("solarium_armor", new RecipeBuilder(RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("solarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("solarium_boots", InstanceType.ITEM, 1),
                        new RecipeIngredient("solarium_chestplate", InstanceType.ITEM, 1),
                        new RecipeIngredient("solarium_helmet", InstanceType.ITEM, 1),
                        new RecipeIngredient("solarium_leggings", InstanceType.ITEM, 1)))));*/
    }
    public static String getId() { return id;}
  //  public AidInfoGenerator getData() { return data; }
}
