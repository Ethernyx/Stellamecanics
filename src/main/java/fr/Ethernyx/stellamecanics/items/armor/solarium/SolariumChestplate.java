package fr.ethernyx.stellamecanics.items.armor.solarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class SolariumChestplate extends ArmorItem  implements IMyItem {
    public static String getId() {
        return "solarium_chestplate";
    };
    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<String, String>() {{
           put("fr_fr", "Plastron en solarium"); put("en_us", "Solarium chestplate");
        }};
        return langs.get(lang);
    }


    

    public SolariumChestplate() {
        super(CustomArmorMaterials.SOLARIUM_ARMOR, Type.CHESTPLATE, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
