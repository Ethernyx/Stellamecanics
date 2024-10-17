package fr.ethernyx.stellamecanics.items.tool.stellarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.SwordItem;

import java.util.HashMap;
import java.util.Map;

public class StellariumSword extends SwordItem  implements IMyItem {
    public static String getId() {
        return "stellarium_sword";
    };
    @Override
    public Model getModelType() {
        return Models.HANDHELD;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<String, String>() {{
           put("fr_fr", "Epée en stellarium"); put("en_us", "Stellarium sword");
        }};
        return langs.get(lang);
    }

    

    public StellariumSword() {
        super(CustomItemTiers.STELLARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
