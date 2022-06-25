package net.Ethernyx.stellamecanics.items.armor.solarium;

import net.Ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class SolariumChestplate extends ArmorItem {
    private static final String id = "solarium_chestplate";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Plastron en solarium"); put("en_us", "Solarium chestplate");
    }};

    //private AidInfoGenerator data;

    public SolariumChestplate() {
        super(CustomArmorMaterials.SOLARIUM_ARMOR, EquipmentSlot.CHEST, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        //this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
    //public AidInfoGenerator getData() { return data; }
}
