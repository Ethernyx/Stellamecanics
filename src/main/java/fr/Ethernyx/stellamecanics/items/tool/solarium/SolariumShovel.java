package fr.ethernyx.stellamecanics.items.tool.solarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class SolariumShovel extends ShovelItem  implements IMyItem {
    public static String getId() {
        return "solarium_shovel";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pelle en solarium");
            put("en_us", "Solarium shovel");
        }};
        return langs.get(lang);
    }

    

    public SolariumShovel() {
        super(CustomItemTiers.SOLARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
