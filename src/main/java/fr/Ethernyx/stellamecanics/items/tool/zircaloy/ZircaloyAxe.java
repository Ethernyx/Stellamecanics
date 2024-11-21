package fr.ethernyx.stellamecanics.items.tool.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.AxeItem;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyAxe extends AxeItem  implements IMyItem {
    public static String getId() {
        return "zircaloy_axe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Hache en zircaloy");
            put("en_us", "Zircaloy axe");
        }};
        return langs.get(lang);
    }

    

    public ZircaloyAxe() {
        super(CustomItemTiers.ZIRCALOY, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
