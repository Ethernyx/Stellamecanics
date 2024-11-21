package fr.ethernyx.stellamecanics.items.ore;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;


public class MagnetiteRaw extends Item implements IMyItem {

    public static String getId() {
        return "magnetite_raw";
    }
    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Magnétite brut");
            put("en_us", "Magnetite raw");
        }};
        return langs.get(lang);
    }


    

    public MagnetiteRaw() {
        super(new Settings());
       /* this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }

    
    
}
