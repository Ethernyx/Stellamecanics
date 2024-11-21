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

public class ZirconiumIngot extends Item  implements IMyItem {
    public static String getId() {
        return "zirconium_ingot";
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Lingot de zirconium");
            put("en_us", "Zirconium ingot");
        }};
        return langs.get(lang);
    }


    

    public ZirconiumIngot() {
        super(new Settings());
    }

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();

        recipes.add(new RecipeBuilder("zirconium_block", RecipeType.SHAPE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("zirconium_block", InstanceType.BLOCK, 1))),
                new ArrayList<>(Arrays.asList("000", "000", "000")),
                new ArrayList<>(Collections.singletonList(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1)))));

        recipes.add(new RecipeBuilder("zirconium_tool", RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("zirconium_axe", InstanceType.ITEM, 1),
                        new MyIngredient("zirconium_hoe", InstanceType.ITEM, 1),
                        new MyIngredient("zirconium_pickaxe", InstanceType.ITEM, 1),
                        new MyIngredient("zirconium_shovel", InstanceType.ITEM, 1),
                        new MyIngredient("zirconium_sword", InstanceType.ITEM, 1)))));

        recipes.add(new RecipeBuilder("zirconium_armor", RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("zirconium_boots", InstanceType.ITEM, 1),
                        new MyIngredient("zirconium_chestplate", InstanceType.ITEM, 1),
                        new MyIngredient("zirconium_helmet", InstanceType.ITEM, 1),
                        new MyIngredient("zirconium_leggings", InstanceType.ITEM, 1)))));

        return recipes;
    }
    
}
