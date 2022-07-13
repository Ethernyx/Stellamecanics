package net.Ethernyx.stellamecanics.items.ore;

import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.item.Item;
import net.Ethernyx.stellamecanics.utils.generator.ICommun;

import java.util.*;

public class ZirconiumIngot extends Item  implements ICommun {
    private static final String id = "zirconium_ingot";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Lingot de zirconium"); put("en_us", "Zirconium ingot");
    }};

    private AidInfoGenerator data;

    public ZirconiumIngot() {
        super(new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        // block
       /* this.data.recipe.put("zirconium_block",
                new RecipeBuilder(RecipeType.SHAPE,
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("zirconium_ingot", InstanceType.ITEM, 1))),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("zirconium_block", InstanceType.BLOCK, 1))),
                        new ArrayList<>(Arrays.asList("000", "000", "000")),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("zirconium_ingot", InstanceType.ITEM, 1)))));*/
        // tools
        this.data.recipe.put("zirconium_tool", new RecipeBuilder(RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("zirconium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("zirconium_axe", InstanceType.ITEM, 1),
                        new RecipeIngredient("zirconium_hoe", InstanceType.ITEM, 1),
                        new RecipeIngredient("zirconium_pickaxe", InstanceType.ITEM, 1),
                        new RecipeIngredient("zirconium_shovel", InstanceType.ITEM, 1),
                        new RecipeIngredient("zirconium_sword", InstanceType.ITEM, 1)))));
        // armures
        this.data.recipe.put("zirconium_armor", new RecipeBuilder(RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("zirconium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("zirconium_boots", InstanceType.ITEM, 1),
                        new RecipeIngredient("zirconium_chestplate", InstanceType.ITEM, 1),
                        new RecipeIngredient("zirconium_helmet", InstanceType.ITEM, 1),
                        new RecipeIngredient("zirconium_leggings", InstanceType.ITEM, 1)))));
    }
    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
