package fr.ethernyx.stellamecanics.items.armor.solarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;

import java.util.HashMap;
import java.util.Map;

public class SolariumBoots extends Item implements IMyItem {
    public static String ID = "solarium_boots";

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
            put("fr_fr", "Bottes en solarium");
            put("en_us", "Solarium boots");
        }};
        return langs.get(lang);
    }


    public SolariumBoots(Settings settings) { super(settings.armor(CustomArmorMaterials.SOLARIUM_ARMOR, EquipmentType.BOOTS)); }


}
