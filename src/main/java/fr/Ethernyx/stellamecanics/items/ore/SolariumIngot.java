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

public class SolariumIngot extends Item implements IMyItem {
    public static String ID = "solarium_ingot";

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
            put("fr_fr", "Lingot de solarium");
            put("en_us", "Solarium ingot");
        }};
        return langs.get(lang);
    }


    public SolariumIngot(Settings settings) {
        super(settings);
    }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();

        recipes.add(new RecipeBuilder("solarium_block", RecipeType.SHAPE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("solarium_block", InstanceType.BLOCK, 1))),
                new ArrayList<>(Arrays.asList("000", "000", "000")),
                new ArrayList<>(Collections.singletonList(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1)))));

        recipes.add(new RecipeBuilder("solarium_tool", RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("solarium_axe", InstanceType.ITEM, 1),
                        new MyIngredient("solarium_hoe", InstanceType.ITEM, 1),
                        new MyIngredient("solarium_pickaxe", InstanceType.ITEM, 1),
                        new MyIngredient("solarium_shovel", InstanceType.ITEM, 1),
                        new MyIngredient("solarium_sword", InstanceType.ITEM, 1)))));

        recipes.add(new RecipeBuilder("solarium_armor", RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("solarium_boots", InstanceType.ITEM, 1),
                        new MyIngredient("solarium_chestplate", InstanceType.ITEM, 1),
                        new MyIngredient("solarium_helmet", InstanceType.ITEM, 1),
                        new MyIngredient("solarium_leggings", InstanceType.ITEM, 1)))));

        return recipes;
    }


}
