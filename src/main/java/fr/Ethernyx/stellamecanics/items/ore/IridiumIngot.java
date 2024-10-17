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

public class IridiumIngot extends Item  implements IMyItem {
    public static String getId() {
        return "iridium_ingot";
    }
    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<String, String>() {{
            put("fr_fr", "Lingot de iridium"); put("en_us", "Iridium ingot");
        }};
        return langs.get(lang);
    }
    



    public IridiumIngot() {
        super(new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);
        // block
        this.data.recipe.put("iridium_block",
                new RecipeBuilder(RecipeType.SHAPE,
                        new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))),
                        new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_block", InstanceType.BLOCK, 1))),
                        new ArrayList<>(Arrays.asList("000", "000", "000")),
                        new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1)))));
        // tools
        this.data.recipe.put("iridium_tool", new RecipeBuilder(RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("iridium_axe", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_hoe", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_pickaxe", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_shovel", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_sword", InstanceType.ITEM, 1)))));
        // armures
        this.data.recipe.put("iridium_armor", new RecipeBuilder(RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("iridium_boots", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_chestplate", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_helmet", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_leggings", InstanceType.ITEM, 1)))));*/
    }
    

    @Override
    public List<RecipeBuilder> getRecipe() {
        List<RecipeBuilder> recipes = new ArrayList<>();
        recipes.add(new RecipeBuilder("iridium_block", RecipeType.SHAPE,
                new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_block", InstanceType.BLOCK, 1))),
                new ArrayList<>(Arrays.asList("000", "000", "000")),
                new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1)))));

        recipes.add(new RecipeBuilder("iridium_tool", RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("iridium_axe", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_hoe", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_pickaxe", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_shovel", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_sword", InstanceType.ITEM, 1)))));

        recipes.add(new RecipeBuilder("iridium_armor", RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new MyIngredient("iridium_boots", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_chestplate", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_helmet", InstanceType.ITEM, 1),
                        new MyIngredient("iridium_leggings", InstanceType.ITEM, 1)))));

        return recipes;
    }
}
