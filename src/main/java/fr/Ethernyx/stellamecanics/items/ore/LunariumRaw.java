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

public class LunariumRaw extends Item  implements IMyItem {
    public static String getId() {
        return "lunarium_raw";
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Lunarium brut");
            put("en_us", "Lunarium raw");
        }};
        return langs.get(lang);
    }


    

    public LunariumRaw() {
        super(new Settings());
    }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();

        recipes.add(new RecipeBuilder("raw_to_lunarium_ingot", RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("lunarium_raw", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1)))));
        return recipes;
    }

    
}
