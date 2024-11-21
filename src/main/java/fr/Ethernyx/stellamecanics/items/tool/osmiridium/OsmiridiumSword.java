package fr.ethernyx.stellamecanics.items.tool.osmiridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.SwordItem;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumSword extends SwordItem  implements IMyItem {
    public static String getId() {
        return "osmiridium_sword";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Epée en osmiridium");
            put("en_us", "Osmiridium sword");
        }};
        return langs.get(lang);
    }

    

    public OsmiridiumSword() {
        super(CustomItemTiers.OSMIRIDIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
