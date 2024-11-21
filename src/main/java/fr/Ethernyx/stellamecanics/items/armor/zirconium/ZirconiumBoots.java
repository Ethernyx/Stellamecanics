package fr.ethernyx.stellamecanics.items.armor.zirconium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumBoots extends ArmorItem  implements IMyItem {
    public static String getId() {
        return "zirconium_boots";
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Bottes en zirconium");
            put("en_us", "Zirconium boots");
        }};
        return langs.get(lang);
    }


    

    public ZirconiumBoots() {
        super(CustomArmorMaterials.ZIRCONIUM_ARMOR, Type.BOOTS, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
