package fr.ethernyx.stellamecanics.items.tool.zirconium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.HoeItem;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumHoe extends HoeItem  implements IMyItem {
    public static String getId() {
        return "zirconium_hoe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Houe en zirconium");
            put("en_us", "Zirconium hoe");
        }};
        return langs.get(lang);
    }

    

    public ZirconiumHoe() {
        super(CustomItemTiers.ZIRCONIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
