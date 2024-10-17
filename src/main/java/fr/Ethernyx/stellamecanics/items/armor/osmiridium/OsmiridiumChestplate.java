package fr.ethernyx.stellamecanics.items.armor.osmiridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumChestplate extends ArmorItem  implements IMyItem {
    public static String getId() {
        return "osmiridium_chestplate";
    };
    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<String, String>() {{
           put("fr_fr", "Plastron en osmiridium"); put("en_us", "Osmiridium chestplate");
        }};
        return langs.get(lang);
    }


    

    public OsmiridiumChestplate() {
        super(CustomArmorMaterials.OSMIRIDIUM_ARMOR, Type.CHESTPLATE, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
