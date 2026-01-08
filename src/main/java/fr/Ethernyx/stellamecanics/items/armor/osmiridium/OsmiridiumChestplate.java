package fr.ethernyx.stellamecanics.items.armor.osmiridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumChestplate extends Item implements IMyItem {
    public static String ID = "osmiridium_chestplate";

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
            put("fr_fr", "Plastron en osmiridium");
            put("en_us", "Osmiridium chestplate");
        }};
        return langs.get(lang);
    }


    public OsmiridiumChestplate(Settings settings) { super(settings.armor(CustomArmorMaterials.OSMIRIDIUM_ARMOR, EquipmentType.CHESTPLATE)); }


}
