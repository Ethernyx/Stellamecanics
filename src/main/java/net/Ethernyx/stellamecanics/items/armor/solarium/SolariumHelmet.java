package net.Ethernyx.stellamecanics.items.armor.solarium;

import net.Ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class SolariumHelmet extends ArmorItem {
    private static final String id = "solarium_helmet";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Casque en solarium"); put("en_us", "Solarium helmet");
    }};

    //private AidInfoGenerator data;

    public SolariumHelmet() {
        super(CustomArmorMaterials.SOLARIUM_ARMOR, EquipmentSlot.HEAD, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        //this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
   // public AidInfoGenerator getData() { return data; }
}
