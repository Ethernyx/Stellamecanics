package net.Ethernyx.stellamecanics.items.ore;

import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SolariumRaw extends Item {
    private static final String id = "solarium_raw";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Solarium brut"); put("en_us", "Solarium raw");
    }};

   // private AidInfoGenerator data;

    public SolariumRaw() {
        super(new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
       /* this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);

        // furnace
        this.data.recipe.put("raw_to_solarium_ingot", new RecipeBuilder(RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("solarium_raw", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("solarium_ingot", InstanceType.ITEM, 1)))));*/
    }
    public static String getId() { return id;}
    //public AidInfoGenerator getData() { return data; }
}