package fr.ethernyx.stellamecanics.items.tool.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.HoeItem;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyHoe extends HoeItem  implements IMyItem {
    public static String getId() {
        return "zircaloy_hoe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Houe en zircaloy");
            put("en_us", "Zircaloy hoe");
        }};
        return langs.get(lang);
    }

    

    public ZircaloyHoe() {
        super(CustomItemTiers.ZIRCALOY, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
