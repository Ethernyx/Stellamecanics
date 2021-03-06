package fr.Ethernyx.stellamecanics.item.ore;

import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.item.Item;

import java.util.*;

public class ZircaloyIngot extends Item implements ICommun {
    private final String id = "zircaloy_ingot";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Lingot de zircaloy"); put("en_us", "Zircaloy ingot");
    }};

    private AidInfoGenerator data;

    public ZircaloyIngot() {
        super(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        // block
        this.data.recipe.put("zircaloy_block",
                new RecipeBuilder(RecipeType.SHAPE,
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("zircaloy_ingot", InstanceType.ITEM, 1))),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("zircaloy_block", InstanceType.BLOCK, 1))),
                        new ArrayList<>(Arrays.asList("000", "000", "000")),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("zircaloy_ingot", InstanceType.ITEM, 1)))));
        // tools
        this.data.recipe.put("zircaloy_tool", new RecipeBuilder(RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("zircaloy_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("zircaloy_axe", InstanceType.ITEM, 1),
                        new RecipeIngredient("zircaloy_hoe", InstanceType.ITEM, 1),
                        new RecipeIngredient("zircaloy_pickaxe", InstanceType.ITEM, 1),
                        new RecipeIngredient("zircaloy_shovel", InstanceType.ITEM, 1),
                        new RecipeIngredient("zircaloy_sword", InstanceType.ITEM, 1)))));
        // armures
        this.data.recipe.put("zircaloy_armor", new RecipeBuilder(RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("zircaloy_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("zircaloy_boots", InstanceType.ITEM, 1),
                        new RecipeIngredient("zircaloy_chestplate", InstanceType.ITEM, 1),
                        new RecipeIngredient("zircaloy_helmet", InstanceType.ITEM, 1),
                        new RecipeIngredient("zircaloy_leggings", InstanceType.ITEM, 1)))));
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
