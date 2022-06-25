package net.Ethernyx.stellamecanics.items.armor.zircaloy;

import net.Ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyLeggings extends ArmorItem {
    private static final String id = "zircaloy_leggings";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Pantalon en zircaloy"); put("en_us", "Zircaloy leggings");
    }};

    //private AidInfoGenerator data;

    public ZircaloyLeggings() {
        super(CustomArmorMaterials.ZIRCALOY_ARMOR, EquipmentSlot.LEGS, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
      //  this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
   //public AidInfoGenerator getData() { return data; }
}
