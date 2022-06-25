package net.Ethernyx.stellamecanics.items.armor.iridium;

import net.Ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class IridiumLeggings extends ArmorItem {
    private static final String id = "iridium_leggings";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Pantalon en iridium"); put("en_us", "Iridium leggings");
    }};

  //  private AidInfoGenerator data;

    public IridiumLeggings() {
        super(CustomArmorMaterials.IRIDIUM_ARMOR, EquipmentSlot.LEGS, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
       // this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
   // public AidInfoGenerator getData() { return data; }
}