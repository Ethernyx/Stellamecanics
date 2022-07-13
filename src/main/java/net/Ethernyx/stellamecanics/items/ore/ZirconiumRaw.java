package net.Ethernyx.stellamecanics.items.ore;

import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.item.Item;
import net.Ethernyx.stellamecanics.utils.generator.ICommun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ZirconiumRaw extends Item  implements ICommun {
    private static final String id = "zirconium_raw";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Zirconium brut"); put("en_us", "Zirconium raw");
    }};

    private AidInfoGenerator data;

    public ZirconiumRaw() {
        super(new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);

        // furnace
        this.data.recipe.put("raw_to_zirconium_ingot", new RecipeBuilder(RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("zirconium_raw", InstanceType.ITEM, 1))),
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("zirconium_ingot", InstanceType.ITEM, 1)))));
    }
    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
