package fr.ethernyx.stellamecanics.items.armor.osmiridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumLeggings extends ArmorItem  implements IMyItem {
    public static String getId() {
        return "osmiridium_leggings";
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pantalon en osmiridium");
            put("en_us", "Osmiridium leggings");
        }};
        return langs.get(lang);
    }


    

    public OsmiridiumLeggings() {
        super(CustomArmorMaterials.OSMIRIDIUM_ARMOR, Type.LEGGINGS, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
