package fr.ethernyx.stellamecanics.items.tool.osmiridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.PickaxeItem;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumPickaxe extends PickaxeItem  implements IMyItem {
    public static String getId() {
        return "osmiridium_pickaxe";
    };
    @Override
    public Model getModelType() {
        return Models.HANDHELD;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<String, String>() {{
           put("fr_fr", "Pioche en osmiridium"); put("en_us", "Osmiridium pickaxe");
        }};
        return langs.get(lang);
    }

    

    public OsmiridiumPickaxe() {
        super(CustomItemTiers.OSMIRIDIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
