package fr.ethernyx.stellamecanics.items.armor.iridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class IridiumBoots extends ArmorItem  implements IMyItem {
    public static String getId() {
        return "iridium_boots";
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Bottes en iridium");
            put("en_us", "Iridium boots");
        }};
        return langs.get(lang);
    }


    

    public IridiumBoots() {
        super(CustomArmorMaterials.IRIDIUM_ARMOR, Type.BOOTS, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
