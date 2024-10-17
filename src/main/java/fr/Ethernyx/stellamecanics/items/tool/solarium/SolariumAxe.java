package fr.ethernyx.stellamecanics.items.tool.solarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.AxeItem;

import java.util.HashMap;
import java.util.Map;

public class SolariumAxe extends AxeItem  implements IMyItem {
    public static String getId() {
        return "solarium_axe";
    };
    @Override
    public Model getModelType() {
        return Models.HANDHELD;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<String, String>() {{
           put("fr_fr", "Hache en solarium"); put("en_us", "Solarium axe");
        }};
        return langs.get(lang);
    }

    

    public SolariumAxe() {
        super(CustomItemTiers.SOLARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
