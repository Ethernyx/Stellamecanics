package fr.ethernyx.stellamecanics.items.armor.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyBoots extends Item implements IMyItem {
    public static String ID = "zircaloy_boots";

    public String getId() {
        return ID;
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Bottes en zircaloy");
            put("en_us", "Zircaloy boots");
        }};
        return langs.get(lang);
    }


    public ZircaloyBoots(Settings settings) { super(settings.armor(CustomArmorMaterials.ZIRCALOY_ARMOR, EquipmentType.BOOTS)); }


}
