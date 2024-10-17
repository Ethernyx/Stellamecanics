package fr.ethernyx.stellamecanics.items.tool.osmiridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.HoeItem;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumHoe extends HoeItem  implements IMyItem {
    public static String getId() {
        return "osmiridium_hoe";
    };
    @Override
    public Model getModelType() {
        return Models.HANDHELD;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<String, String>() {{
           put("fr_fr", "Houe en osmiridium"); put("en_us", "Osmiridium hoe");
        }};
        return langs.get(lang);
    }

    

    public OsmiridiumHoe() {
        super(CustomItemTiers.OSMIRIDIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
