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

public class ZirconiumRaw extends Item implements IMyItem {
    public static String ID = "zirconium_raw";

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
            put("fr_fr", "Zirconium brut");
            put("en_us", "Zirconium raw");
        }};
        return langs.get(lang);
    }


    public ZirconiumRaw(Settings settings) { super(settings); }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();

        recipes.add(new RecipeBuilder("raw_to_zirconium_ingot", RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("zirconium_raw", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1)))));

        return recipes;
    }

}
