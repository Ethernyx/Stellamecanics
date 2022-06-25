package net.Ethernyx.stellamecanics.items.tool.zircaloy;

import net.Ethernyx.stellamecanics.utils.CustomItemTiers;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyShovel extends ShovelItem {
    private static final String id = "zircaloy_shovel";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Pelle en zircaloy"); put("en_us", "Zircaloy shovel");
    }};
    //private AidInfoGenerator data;

    public ZircaloyShovel() {
        super(CustomItemTiers.ZIRCALOY, 0, -2.4f, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
      //  this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
  //  public AidInfoGenerator getData() { return data; }
}
