package fr.ethernyx.stellamecanics.items.tool.stellarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.AxeItem;

import java.util.HashMap;
import java.util.Map;

public class StellariumAxe extends AxeItem  implements IMyItem {
    public static String getId() {
        return "stellarium_axe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Hache en stellarium");
            put("en_us", "Stellarium axe");
        }};
        return langs.get(lang);
    }

    

    public StellariumAxe() {
        super(CustomItemTiers.STELLARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
