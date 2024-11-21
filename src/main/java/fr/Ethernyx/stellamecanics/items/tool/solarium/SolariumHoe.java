package fr.ethernyx.stellamecanics.items.tool.solarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.HoeItem;

import java.util.HashMap;
import java.util.Map;

public class SolariumHoe extends HoeItem  implements IMyItem {
    public static String getId() {
        return "solarium_hoe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Houe en solarium");
            put("en_us", "Solarium hoe");
        }};
        return langs.get(lang);
    }

    

    public SolariumHoe() {
        super(CustomItemTiers.SOLARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
