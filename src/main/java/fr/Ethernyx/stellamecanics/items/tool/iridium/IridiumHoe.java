package fr.ethernyx.stellamecanics.items.tool.iridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.HoeItem;

import java.util.HashMap;
import java.util.Map;

public class IridiumHoe extends HoeItem  implements IMyItem {
    public static String getId() {
        return "iridium_hoe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Houe en iridium");
            put("en_us", "Iridium hoe");
        }};
        return langs.get(lang);
    }

    

    public IridiumHoe() {
        super(CustomItemTiers.IRIDIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
