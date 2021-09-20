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

public class ZirconiumIngot extends Item {
    private final String id = "zirconium_ingot";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Lingot de zirconium"); put("en_us", "Zirconium ingot");
    }};

    private AidInfoGenerator data;

    public ZirconiumIngot() {
        super(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
    }

    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        // block
        this.data.recipe.put("zirconium_block",
                new RecipeBuilder(RecipeType.SHAPE,
                        new ArrayList<>(Collections.singletonList(ModItems.ZIRCONIUM_INGOT.get())),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient(ModBlocks.ZIRCONIUM_BLOCK.get(), 1))),
                        new ArrayList<>(Arrays.asList("000", "000", "000")),
                        new ArrayList<>(Collections.singletonList(ModItems.ZIRCONIUM_INGOT.get()))));
        // tools
        this.data.recipe.put("zirconium_tool", new RecipeBuilder(RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(ModItems.ZIRCONIUM_INGOT.get())),
                new ArrayList<>(Arrays.asList(new RecipeIngredient(ModItems.ZIRCONIUM_AXE.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCONIUM_HOE.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCONIUM_PICKAXE.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCONIUM_SHOVEL.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCONIUM_SWORD.get(), 1)))));
        // armures
        this.data.recipe.put("zirconium_armor", new RecipeBuilder(RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(ModItems.ZIRCONIUM_INGOT.get())),
                new ArrayList<>(Arrays.asList(new RecipeIngredient(ModItems.ZIRCONIUM_BOOTS.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCONIUM_CHESTPLATE.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCONIUM_HELMET.get(), 1),
                        new RecipeIngredient(ModItems.ZIRCONIUM_LEGGINGS.get(), 1)))));
        return this.data;
    }

    public String getId() {
        return this.id;
    }
}
