package fr.ethernyx.stellamecanics.items.tool.iridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class IridiumShovel extends ShovelItem  implements IMyItem {
    public static String getId() {
        return "iridium_shovel";
    };
    @Override
    public Model getModelType() {
        return Models.HANDHELD;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<String, String>() {{
           put("fr_fr", "Pelle en iridium"); put("en_us", "Iridium shovel");
        }};
        return langs.get(lang);
    }

    

    public IridiumShovel() {
        super(CustomItemTiers.IRIDIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/

    }
    
    
}
