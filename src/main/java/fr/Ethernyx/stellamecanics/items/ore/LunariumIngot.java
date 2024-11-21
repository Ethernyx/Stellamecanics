package fr.ethernyx.stellamecanics.items.ore;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

import java.util.*;

public class LunariumIngot extends Item  implements IMyItem {
    public static String getId() {
        return "lunarium_ingot";
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Lingot de lunarium");
            put("en_us", "Lunarium ingot");
        }};
        return langs.get(lang);
    }


    

    public LunariumIngot() {
        super(new Settings());
    }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();
        recipes.add(new RecipeBuilder("lunarium_block", RecipeType.SHAPE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("lunarium_block", InstanceType.BLOCK, 1))),
                new ArrayList<>(Arrays.asList("000", "000", "000")),
                new ArrayList<>(Collections.singletonList(new MyIngredient("lunarium_block", InstanceType.BLOCK, 1)))));

        recipes.add(new RecipeBuilder("lunarium_tool", RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("lunarium_axe", InstanceType.ITEM, 1),
                        new MyIngredient("lunarium_hoe", InstanceType.ITEM, 1),
                        new MyIngredient("lunarium_pickaxe", InstanceType.ITEM, 1),
                        new MyIngredient("lunarium_shovel", InstanceType.ITEM, 1),
                        new MyIngredient("lunarium_sword", InstanceType.ITEM, 1)))));

        recipes.add(new RecipeBuilder("lunarium_armor", RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("lunarium_boots", InstanceType.ITEM, 1),
                        new MyIngredient("lunarium_chestplate", InstanceType.ITEM, 1),
                        new MyIngredient("lunarium_helmet", InstanceType.ITEM, 1),
                        new MyIngredient("lunarium_leggings", InstanceType.ITEM, 1)))));
        return recipes;
    }

    
}
