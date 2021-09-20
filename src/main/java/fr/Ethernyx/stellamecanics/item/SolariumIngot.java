package fr.Ethernyx.stellamecanics.item;

import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.item.Item;

import java.util.*;

public class SolariumIngot extends Item {
    private final String id = "solarium_ingot";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Lingot de solarium"); put("en_us", "Solarium ingot");
    }};

    private AidInfoGenerator data;

    public SolariumIngot() {
        super(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
    }

    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        // block
        this.data.recipe.put("solarium_block",
                new RecipeBuilder(RecipeType.SHAPE,
                        new ArrayList<>(Collections.singletonList(ModItems.SOLARIUM_INGOT.get())),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient(ModBlocks.SOLARIUM_BLOCK.get(), 1))),
                        new ArrayList<>(Arrays.asList("000", "000", "000")),
                        new ArrayList<>(Collections.singletonList(ModItems.SOLARIUM_INGOT.get()))));
        // tools
        this.data.recipe.put("solarium_tool", new RecipeBuilder(RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(ModItems.SOLARIUM_INGOT.get())),
                new ArrayList<>(Arrays.asList(new RecipeIngredient(ModItems.SOLARIUM_AXE.get(), 1),
                        new RecipeIngredient(ModItems.SOLARIUM_HOE.get(), 1),
                        new RecipeIngredient(ModItems.SOLARIUM_PICKAXE.get(), 1),
                        new RecipeIngredient(ModItems.SOLARIUM_SHOVEL.get(), 1),
                        new RecipeIngredient(ModItems.SOLARIUM_SWORD.get(), 1)))));
        // armures
        this.data.recipe.put("solarium_armor", new RecipeBuilder(RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(ModItems.SOLARIUM_INGOT.get())),
                new ArrayList<>(Arrays.asList(new RecipeIngredient(ModItems.SOLARIUM_BOOTS.get(), 1),
                        new RecipeIngredient(ModItems.SOLARIUM_CHESTPLATE.get(), 1),
                        new RecipeIngredient(ModItems.SOLARIUM_HELMET.get(), 1),
                        new RecipeIngredient(ModItems.SOLARIUM_LEGGINGS.get(), 1)))));
        return this.data;
    }

    public String getId() {
        return this.id;
    }
}
