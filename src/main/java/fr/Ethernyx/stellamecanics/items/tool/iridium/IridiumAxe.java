package fr.ethernyx.stellamecanics.items.tool.iridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.AxeItem;

import java.util.HashMap;
import java.util.Map;

public class IridiumAxe extends AxeItem  implements IMyItem {
    public static String getId() {
        return "iridium_axe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Hache en iridium");
            put("en_us", "Iridium axe");
        }};
        return langs.get(lang);
    }

    

    public IridiumAxe() {
        super(CustomItemTiers.IRIDIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    

}
