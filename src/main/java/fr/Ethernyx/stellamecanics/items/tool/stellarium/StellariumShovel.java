package fr.ethernyx.stellamecanics.items.tool.stellarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class StellariumShovel extends ShovelItem  implements IMyItem {
    public static String getId() {
        return "stellarium_shovel";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pelle en stellarium");
            put("en_us", "Stellarium shovel");
        }};
        return langs.get(lang);
    }

    

    public StellariumShovel() {
        super(CustomItemTiers.STELLARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
