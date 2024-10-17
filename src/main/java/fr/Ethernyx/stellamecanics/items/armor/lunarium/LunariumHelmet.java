package fr.ethernyx.stellamecanics.items.armor.lunarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class LunariumHelmet extends ArmorItem  implements IMyItem {
    public static String getId() {
        return "lunarium_helmet";
    };
    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<String, String>() {{
           put("fr_fr", "Casque en lunarium"); put("en_us", "Lunarium helmet");
        }};
        return langs.get(lang);
    }


    

    public LunariumHelmet() {
        super(CustomArmorMaterials.LUNARIUM_ARMOR, Type.HELMET, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
