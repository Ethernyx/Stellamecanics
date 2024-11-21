package fr.ethernyx.stellamecanics.items.armor.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyChestplate extends ArmorItem  implements IMyItem {
    public static String getId() {
        return "zircaloy_chestplate";
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Plastron en zircaloy");
            put("en_us", "Zircaloy chestplate");
        }};
        return langs.get(lang);
    }


    

    public ZircaloyChestplate() {
        super(CustomArmorMaterials.ZIRCALOY_ARMOR, Type.CHESTPLATE, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
