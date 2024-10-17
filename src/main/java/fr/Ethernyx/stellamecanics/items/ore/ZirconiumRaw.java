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

public class ZirconiumRaw extends Item  implements IMyItem {
    public static String getId() {
        return "zirconium_raw";
    };
    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<String, String>() {{
           put("fr_fr", "Zirconium brut"); put("en_us", "Zirconium raw");
        }};
        return langs.get(lang);
    }


    

    public ZirconiumRaw() {
        super(new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);

        // furnace
        this.data.recipe.put("raw_to_zirconium_ingot", new RecipeBuilder(RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("zirconium_raw", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1)))));*/
    }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();

        recipes.add(new RecipeBuilder("raw_to_zirconium_ingot", RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("zirconium_raw", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1)))));

        return recipes;
    }
    
}
