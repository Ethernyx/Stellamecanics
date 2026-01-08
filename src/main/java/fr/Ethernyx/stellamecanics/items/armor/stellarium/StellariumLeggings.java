package fr.ethernyx.stellamecanics.items.armor.stellarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;

import java.util.HashMap;
import java.util.Map;

public class StellariumLeggings extends Item implements IMyItem {
    public static String ID = "stellarium_leggings";

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
            put("fr_fr", "Pantalon en stellarium");
            put("en_us", "Stellarium leggings");
        }};
        return langs.get(lang);
    }


    public StellariumLeggings(Settings settings) { super(settings.armor(CustomArmorMaterials.STELLARIUM_ARMOR, EquipmentType.LEGGINGS)); }


}
