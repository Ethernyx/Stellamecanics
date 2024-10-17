package fr.ethernyx.stellamecanics.items.tool.lunarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.PickaxeItem;

import java.util.HashMap;
import java.util.Map;

public class LunariumPickaxe extends PickaxeItem  implements IMyItem {
    public static String getId() {
        return "lunarium_pickaxe";
    };
    @Override
    public Model getModelType() {
        return Models.HANDHELD;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<String, String>() {{
           put("fr_fr", "Pioche en lunarium"); put("en_us", "Lunarium pickaxe");
        }};
        return langs.get(lang);
    }

    

    public LunariumPickaxe() {
        super(CustomItemTiers.LUNARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
