package fr.ethernyx.stellamecanics.items.armor.zirconium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumChestplate extends Item implements IMyItem {
    public static String ID = "zirconium_chestplate";

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
            put("fr_fr", "Plastron en zirconium");
            put("en_us", "Zirconium chestplate");
        }};
        return langs.get(lang);
    }


    public ZirconiumChestplate(Settings settings) { super(settings.armor(CustomArmorMaterials.ZIRCONIUM_ARMOR, EquipmentType.CHESTPLATE)); }


}
