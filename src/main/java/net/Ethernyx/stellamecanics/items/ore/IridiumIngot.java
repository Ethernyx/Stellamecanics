package net.Ethernyx.stellamecanics.items.ore;

import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.Item;

import java.util.*;

public class IridiumIngot extends Item {
    protected static final String id = "iridium_ingot";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Lingot de iridium"); put("en_us", "Iridium ingot");
    }};
  //  private AidInfoGenerator data;



    public IridiumIngot() {
        super(new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        /*this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        // block
        this.data.recipe.put("iridium_block",
                new RecipeBuilder(RecipeType.SHAPE,
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("iridium_ingot", InstanceType.ITEM, 1))),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("iridium_block", InstanceType.BLOCK, 1))),
                        new ArrayList<>(Arrays.asList("000", "000", "000")),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("iridium_ingot", InstanceType.ITEM, 1)))));
        // tools
        this.data.recipe.put("iridium_tool", new RecipeBuilder(RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("iridium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("iridium_axe", InstanceType.ITEM, 1),
                        new RecipeIngredient("iridium_hoe", InstanceType.ITEM, 1),
                        new RecipeIngredient("iridium_pickaxe", InstanceType.ITEM, 1),
                        new RecipeIngredient("iridium_shovel", InstanceType.ITEM, 1),
                        new RecipeIngredient("iridium_sword", InstanceType.ITEM, 1)))));
        // armures
        this.data.recipe.put("iridium_armor", new RecipeBuilder(RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("iridium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("iridium_boots", InstanceType.ITEM, 1),
                        new RecipeIngredient("iridium_chestplate", InstanceType.ITEM, 1),
                        new RecipeIngredient("iridium_helmet", InstanceType.ITEM, 1),
                        new RecipeIngredient("iridium_leggings", InstanceType.ITEM, 1)))));*/
    }
    public static String getId() { return id;}
    //public AidInfoGenerator getData() { return data; }
}
