package fr.ethernyx.stellamecanics.items.tool.solarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.PickaxeItem;

import java.util.HashMap;
import java.util.Map;

public class SolariumPickaxe extends PickaxeItem  implements IMyItem {
    public static String getId() {
        return "solarium_pickaxe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pioche en solarium");
            put("en_us", "Solarium pickaxe");
        }};
        return langs.get(lang);
    }

    

    public SolariumPickaxe() {
        super(CustomItemTiers.SOLARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
