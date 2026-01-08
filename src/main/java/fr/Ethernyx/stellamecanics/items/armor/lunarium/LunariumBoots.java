package fr.ethernyx.stellamecanics.items.armor.lunarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;

import java.util.HashMap;
import java.util.Map;

public class LunariumBoots extends Item implements IMyItem {
    public static String ID = "lunarium_boots";

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
            put("fr_fr", "Bottes en lunarium");
            put("en_us", "Lunarium boots");
        }};
        return langs.get(lang);
    }


    public LunariumBoots(Settings settings) { super(settings.armor(CustomArmorMaterials.LUNARIUM_ARMOR, EquipmentType.BOOTS)); }


}
