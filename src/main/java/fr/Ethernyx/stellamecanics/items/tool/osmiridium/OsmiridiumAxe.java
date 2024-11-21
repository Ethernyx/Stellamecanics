package fr.ethernyx.stellamecanics.items.tool.osmiridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.AxeItem;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumAxe extends AxeItem  implements IMyItem {
    public static String getId() {
        return "osmiridium_axe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Hache en osmiridium");
            put("en_us", "Osmiridium axe");
        }};
        return langs.get(lang);
    }

    

    public OsmiridiumAxe() {
        super(CustomItemTiers.OSMIRIDIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }

    
    

}
