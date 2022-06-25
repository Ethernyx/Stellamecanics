package net.Ethernyx.stellamecanics.items.tool.zirconium;

import net.Ethernyx.stellamecanics.utils.CustomItemTiers;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumSword extends SwordItem {
    private static final String id = "zirconium_sword";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Epée en zirconium"); put("en_us", "Zirconium sword");
    }};
    //private AidInfoGenerator data;

    public ZirconiumSword() {
        super(CustomItemTiers.ZIRCONIUM, 0, -2.4f, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        //this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
   // public AidInfoGenerator getData() { return data; }
}
