package fr.ethernyx.stellamecanics.items.armor.zirconium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumHelmet extends Item implements IMyItem {
    public static String ID = "zirconium_helmet";

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
            put("fr_fr", "Casque en zirconium");
            put("en_us", "Zirconium helmet");
        }};
        return langs.get(lang);
    }


    public ZirconiumHelmet(Settings settings) { super(settings.armor(CustomArmorMaterials.ZIRCONIUM_ARMOR, EquipmentType.HELMET)); }


}
