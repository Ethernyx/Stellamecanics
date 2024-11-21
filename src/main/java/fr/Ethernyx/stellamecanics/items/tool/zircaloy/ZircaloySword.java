package fr.ethernyx.stellamecanics.items.tool.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.SwordItem;

import java.util.HashMap;
import java.util.Map;

public class ZircaloySword extends SwordItem  implements IMyItem {
    public static String getId() {
        return "zircaloy_sword";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Epée en zircaloy");
            put("en_us", "Zircaloy sword");
        }};
        return langs.get(lang);
    }

    

    public ZircaloySword() {
        super(CustomItemTiers.ZIRCALOY, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
