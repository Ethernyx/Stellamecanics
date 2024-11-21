package fr.ethernyx.stellamecanics.items.tool.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyShovel extends ShovelItem  implements IMyItem {
    public static String getId() {
        return "zircaloy_shovel";
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pelle en zircaloy");
            put("en_us", "Zircaloy shovel");
        }};
        return langs.get(lang);
    }

    

    public ZircaloyShovel() {
        super(CustomItemTiers.ZIRCALOY, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
