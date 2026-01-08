package fr.ethernyx.stellamecanics.items.armor.solarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;

import java.util.HashMap;
import java.util.Map;

public class SolariumChestplate extends Item implements IMyItem {
    public static String ID = "solarium_chestplate";

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
            put("fr_fr", "Plastron en solarium");
            put("en_us", "Solarium chestplate");
        }};
        return langs.get(lang);
    }


    public SolariumChestplate(Settings settings) { super(settings.armor(CustomArmorMaterials.SOLARIUM_ARMOR, EquipmentType.CHESTPLATE)); }


}
