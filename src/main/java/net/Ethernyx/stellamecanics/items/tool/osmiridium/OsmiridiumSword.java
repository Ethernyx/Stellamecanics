package net.Ethernyx.stellamecanics.items.tool.osmiridium;

import net.Ethernyx.stellamecanics.utils.CustomItemTiers;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumSword extends SwordItem {
    private static final String id = "osmiridium_sword";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Epée en osmiridium"); put("en_us", "Osmiridium sword");
    }};
    //private AidInfoGenerator data;

    public OsmiridiumSword() {
        super(CustomItemTiers.OSMIRIDIUM, 0, -2.4f, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
       // this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
    //public AidInfoGenerator getData() { return data; }
}
