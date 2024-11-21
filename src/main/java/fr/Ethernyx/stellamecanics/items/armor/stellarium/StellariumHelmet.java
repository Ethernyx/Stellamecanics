package fr.ethernyx.stellamecanics.items.armor.stellarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class StellariumHelmet extends ArmorItem  implements IMyItem {
    public static String getId() {
        return "stellarium_helmet";
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Casque en stellarium");
            put("en_us", "Stellarium helmet");
        }};
        return langs.get(lang);
    }


    

    public StellariumHelmet() {
        super(CustomArmorMaterials.STELLARIUM_ARMOR, Type.HELMET, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
