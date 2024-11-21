package fr.ethernyx.stellamecanics.items.armor.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyBoots extends ArmorItem  implements IMyItem {
    public static String getId() {
        return "zircaloy_boots";
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Bottes en zircaloy");
            put("en_us", "Zircaloy boots");
        }};
        return langs.get(lang);
    }


    

    public ZircaloyBoots() {
        super(CustomArmorMaterials.ZIRCALOY_ARMOR, Type.BOOTS, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
