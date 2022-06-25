package net.Ethernyx.stellamecanics.items.tool.lunarium;

import net.Ethernyx.stellamecanics.utils.CustomItemTiers;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class LunariumHoe extends HoeItem {
    private static final String id = "lunarium_hoe";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Houe en lunarium"); put("en_us", "Lunarium hoe");
    }};
    //private AidInfoGenerator data;

    public LunariumHoe() {
        super(CustomItemTiers.LUNARIUM, 0, -2.4f, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        //this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
    //public AidInfoGenerator getData() { return data; }
}
