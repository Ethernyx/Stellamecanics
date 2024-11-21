package fr.ethernyx.stellamecanics.items.tool.solarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.SwordItem;

import java.util.HashMap;
import java.util.Map;

public class SolariumSword extends SwordItem  implements IMyItem {
    public static String getId() {
        return "solarium_sword";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Epée en solarium");
            put("en_us", "Solarium sword");
        }};
        return langs.get(lang);
    }

    

    public SolariumSword() {
        super(CustomItemTiers.SOLARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    

    
}
