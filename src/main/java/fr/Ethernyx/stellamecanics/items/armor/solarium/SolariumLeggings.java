package fr.ethernyx.stellamecanics.items.armor.solarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class SolariumLeggings extends ArmorItem  implements IMyItem {
    public static String getId() {
        return "solarium_leggings";
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pantalon en solarium");
            put("en_us", "Solarium leggings");
        }};
        return langs.get(lang);
    }


    

    public SolariumLeggings() {
        super(CustomArmorMaterials.SOLARIUM_ARMOR, Type.LEGGINGS, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
