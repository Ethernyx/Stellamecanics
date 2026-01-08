package fr.ethernyx.stellamecanics.items.armor.iridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;

import java.util.HashMap;
import java.util.Map;

public class IridiumChestplate extends Item implements IMyItem {
    public static String ID = "iridium_chestplate";

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
            put("fr_fr", "Plastron en iridium");
            put("en_us", "Iridium chestplate");
        }};
        return langs.get(lang);
    }


    public IridiumChestplate(Settings settings) { super(settings.armor(CustomArmorMaterials.IRIDIUM_ARMOR, EquipmentType.CHESTPLATE)); }


}
