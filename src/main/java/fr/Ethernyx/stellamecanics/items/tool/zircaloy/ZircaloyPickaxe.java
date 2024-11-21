package fr.ethernyx.stellamecanics.items.tool.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.PickaxeItem;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyPickaxe extends PickaxeItem  implements IMyItem {
    public static String getId() {
        return "zircaloy_pickaxe";
    }

    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pioche en zircaloy");
            put("en_us", "Zircaloy pickaxe");
        }};
        return langs.get(lang);
    }

    

    public ZircaloyPickaxe() {
        super(CustomItemTiers.ZIRCALOY, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
