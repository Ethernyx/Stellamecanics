package fr.ethernyx.stellamecanics.items.ore;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;

import java.util.*;

public class ZircaloyIngot extends Item implements IMyItem {
    public static String ID = "zircaloy_ingot";

    public String getId() {
        return ID;
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Lingot de zircaloy");
            put("en_us", "Zircaloy ingot");
        }};
        return langs.get(lang);
    }


    public ZircaloyIngot(Settings settings) { super(settings); }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();

        recipes.add(new RecipeBuilder("zircaloy_block", RecipeType.SHAPE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("zircaloy_block", InstanceType.BLOCK, 1))),
                new ArrayList<>(Arrays.asList("000", "000", "000")),
                new ArrayList<>(Collections.singletonList(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1)))));

        recipes.add(new RecipeBuilder("zircaloy_tool", RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("zircaloy_axe", InstanceType.ITEM, 1),
                        new MyIngredient("zircaloy_hoe", InstanceType.ITEM, 1),
                        new MyIngredient("zircaloy_pickaxe", InstanceType.ITEM, 1),
                        new MyIngredient("zircaloy_shovel", InstanceType.ITEM, 1),
                        new MyIngredient("zircaloy_sword", InstanceType.ITEM, 1)))));

        recipes.add(new RecipeBuilder("zircaloy_armor", RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("zircaloy_boots", InstanceType.ITEM, 1),
                        new MyIngredient("zircaloy_chestplate", InstanceType.ITEM, 1),
                        new MyIngredient("zircaloy_helmet", InstanceType.ITEM, 1),
                        new MyIngredient("zircaloy_leggings", InstanceType.ITEM, 1)))));

        return recipes;
    }

}
