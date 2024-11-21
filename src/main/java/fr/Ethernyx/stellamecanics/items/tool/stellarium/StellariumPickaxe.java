package fr.ethernyx.stellamecanics.items.tool.stellarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.PickaxeItem;

import java.util.HashMap;
import java.util.Map;

public class StellariumPickaxe extends PickaxeItem  implements IMyItem {
    public static String getId() {
        return "stellarium_pickaxe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pioche en stellarium");
            put("en_us", "Stellarium pickaxe");
        }};
        return langs.get(lang);
    }

    

    public StellariumPickaxe() {
        super(CustomItemTiers.STELLARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
