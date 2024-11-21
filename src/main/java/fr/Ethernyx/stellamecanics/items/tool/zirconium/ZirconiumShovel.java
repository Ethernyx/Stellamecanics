package fr.ethernyx.stellamecanics.items.tool.zirconium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumShovel extends ShovelItem  implements IMyItem {
    public static String getId() {
        return "zirconium_shovel";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pelle en zirconium");
            put("en_us", "Zirconium shovel");
        }};
        return langs.get(lang);
    }

    

    public ZirconiumShovel() {
        super(CustomItemTiers.ZIRCONIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
