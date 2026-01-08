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

public class StellariumIngot extends Item implements IMyItem {
    public static String ID = "stellarium_ingot";

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
            put("fr_fr", "Lingot de stellarium");
            put("en_us", "Stellarium ingot");
        }};
        return langs.get(lang);
    }


    public StellariumIngot(Settings settings) { super(settings); }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();

        recipes.add(new RecipeBuilder("stellarium_block", RecipeType.SHAPE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("stellarium_block", InstanceType.BLOCK, 1))),
                new ArrayList<>(Arrays.asList("000", "000", "000")),
                new ArrayList<>(Collections.singletonList(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1)))));

        recipes.add(new RecipeBuilder("stellarium_tool", RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("stellarium_axe", InstanceType.ITEM, 1),
                        new MyIngredient("stellarium_hoe", InstanceType.ITEM, 1),
                        new MyIngredient("stellarium_pickaxe", InstanceType.ITEM, 1),
                        new MyIngredient("stellarium_shovel", InstanceType.ITEM, 1),
                        new MyIngredient("stellarium_sword", InstanceType.ITEM, 1)))));

        recipes.add(new RecipeBuilder("stellarium_armor", RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("stellarium_boots", InstanceType.ITEM, 1),
                        new MyIngredient("stellarium_chestplate", InstanceType.ITEM, 1),
                        new MyIngredient("stellarium_helmet", InstanceType.ITEM, 1),
                        new MyIngredient("stellarium_leggings", InstanceType.ITEM, 1)))));

        return recipes;
    }


}
