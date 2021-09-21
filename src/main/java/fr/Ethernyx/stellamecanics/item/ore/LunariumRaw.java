package fr.Ethernyx.stellamecanics.item.ore;

import fr.Ethernyx.stellamecanics.init.ModItems;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LunariumRaw extends Item {
    private final String id = "lunarium_raw";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Lunarium brut"); put("en_us", "Lunarium raw");
    }};

    private AidInfoGenerator data;

    public LunariumRaw() {
        super(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
    }
    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);

        // furnace
        this.data.recipe.put("raw_to_lunarium_ingot", new RecipeBuilder(RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(ModItems.LUNARIUM_RAW.get())),
                new ArrayList<>(Collections.singletonList(new RecipeIngredient(ModItems.LUNARIUM_INGOT.get(), 1)))));
        return this.data;
    }
    public String getId() {
        return this.id;
    }
}
