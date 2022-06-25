package net.Ethernyx.stellamecanics.items.tool.osmiridium;

import net.Ethernyx.stellamecanics.utils.CustomItemTiers;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumHoe extends HoeItem {
    private static final String id = "osmiridium_hoe";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Houe en osmiridium"); put("en_us", "Osmiridium hoe");
    }};
    //private AidInfoGenerator data;

    public OsmiridiumHoe() {
        super(CustomItemTiers.OSMIRIDIUM, 0, -2.4f, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        //this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
    //public AidInfoGenerator getData() { return data; }
}