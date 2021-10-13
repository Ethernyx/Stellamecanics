package fr.Ethernyx.stellamecanics.item.ore;

import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
import fr.Ethernyx.stellamecanics.utils.*;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;

import java.util.*;

public class LunariumIngot extends Item implements ICommun {
    private final String id = "lunarium_ingot";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Lingot de lunarium"); put("en_us", "Lunarium ingot");
    }};

    private AidInfoGenerator data;

    public LunariumIngot() {
        super(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        // block
        this.data.recipe.put("lunarium_block",
                new RecipeBuilder(RecipeType.SHAPE,
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("lunarium_ingot", InstanceType.ITEM, 1))),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("lunarium_block", InstanceType.BLOCK, 1))),
                        new ArrayList<>(Arrays.asList("000", "000", "000")),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("lunarium_block", InstanceType.BLOCK, 1)))));
        // tools
        this.data.recipe.put("lunarium_tool", new RecipeBuilder(RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("lunarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("lunarium_axe", InstanceType.ITEM, 1),
                        new RecipeIngredient("lunarium_hoe", InstanceType.ITEM, 1),
                        new RecipeIngredient("lunarium_pickaxe", InstanceType.ITEM, 1),
                        new RecipeIngredient("lunarium_shovel", InstanceType.ITEM, 1),
                        new RecipeIngredient("lunarium_sword", InstanceType.ITEM, 1)))));
        // armures
        this.data.recipe.put("lunarium_armor", new RecipeBuilder(RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("lunarium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("lunarium_boots", InstanceType.ITEM, 1),
                        new RecipeIngredient("lunarium_chestplate", InstanceType.ITEM, 1),
                        new RecipeIngredient("lunarium_helmet", InstanceType.ITEM, 1),
                        new RecipeIngredient("lunarium_leggings", InstanceType.ITEM, 1)))));
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
