package fr.ethernyx.stellamecanics.items.tool.iridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.SwordItem;

import java.util.HashMap;
import java.util.Map;

public class IridiumSword extends SwordItem  implements IMyItem {
    public static String getId() {
        return "iridium_sword";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Epée en iridium");
            put("en_us", "Iridium sword");
        }};
        return langs.get(lang);
    }

    

    public IridiumSword() {
        super(CustomItemTiers.IRIDIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/

    }
    
    
}
