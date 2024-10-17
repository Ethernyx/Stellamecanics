package fr.ethernyx.stellamecanics.items.tool.lunarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.HoeItem;

import java.util.HashMap;
import java.util.Map;

public class LunariumHoe extends HoeItem  implements IMyItem {
    public static String getId() {
        return "lunarium_hoe";
    };
    @Override
    public Model getModelType() {
        return Models.HANDHELD;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<String, String>() {{
           put("fr_fr", "Houe en lunarium"); put("en_us", "Lunarium hoe");
        }};
        return langs.get(lang);
    }

    

    public LunariumHoe() {
        super(CustomItemTiers.LUNARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
