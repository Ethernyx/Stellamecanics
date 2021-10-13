package fr.Ethernyx.stellamecanics.item.ore;

import fr.Ethernyx.stellamecanics.utils.ICommun;
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

public class ZirconiumRaw extends Item implements ICommun {
    private final String id = "zirconium_raw";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Zirconium brut"); put("en_us", "Zirconium raw");
    }};

    private AidInfoGenerator data;

    public ZirconiumRaw() {
        super(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);

        // furnace
        this.data.recipe.put("raw_to_zirconium_ingot", new RecipeBuilder(RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("zirconium_raw", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("zirconium_ingot", InstanceType.ITEM, 1)))));
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
