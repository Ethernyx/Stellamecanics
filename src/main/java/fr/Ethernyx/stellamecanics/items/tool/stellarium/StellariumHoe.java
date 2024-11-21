package fr.ethernyx.stellamecanics.items.tool.stellarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.HoeItem;

import java.util.HashMap;
import java.util.Map;

public class StellariumHoe extends HoeItem  implements IMyItem {
    public static String getId() {
        return "stellarium_hoe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Houe en stellarium");
            put("en_us", "Stellarium hoe");
        }};
        return langs.get(lang);
    }

    

    public StellariumHoe() {
        super(CustomItemTiers.STELLARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
