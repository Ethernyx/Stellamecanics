package fr.ethernyx.stellamecanics.items.armor.lunarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class LunariumChestplate extends ArmorItem  implements IMyItem {
    public static String getId() {
        return "lunarium_chestplate";
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Plastron en lunarium");
            put("en_us", "Lunarium chestplate");
        }};
        return langs.get(lang);
    }


    

    public LunariumChestplate() {
        super(CustomArmorMaterials.LUNARIUM_ARMOR, Type.CHESTPLATE, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
