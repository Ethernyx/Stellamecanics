package fr.ethernyx.stellamecanics.items.tool.osmiridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumShovel extends ShovelItem  implements IMyItem {
    public static String getId() {
        return "osmiridium_shovel";
    };
    @Override
    public Model getModelType() {
        return Models.HANDHELD;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<String, String>() {{
           put("fr_fr", "Pelle en osmiridium"); put("en_us", "Osmiridium shovel");
        }};
        return langs.get(lang);
    }

    

    public OsmiridiumShovel() {
        super(CustomItemTiers.OSMIRIDIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
