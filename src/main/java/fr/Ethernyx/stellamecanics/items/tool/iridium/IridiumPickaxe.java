package fr.ethernyx.stellamecanics.items.tool.iridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.PickaxeItem;

import java.util.HashMap;
import java.util.Map;

public class IridiumPickaxe extends PickaxeItem  implements IMyItem {
    public static String getId() {
        return "iridium_pickaxe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pioche en iridium");
            put("en_us", "Iridium pickaxe");
        }};
        return langs.get(lang);
    }

    

    public IridiumPickaxe() {
        super(CustomItemTiers.IRIDIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
