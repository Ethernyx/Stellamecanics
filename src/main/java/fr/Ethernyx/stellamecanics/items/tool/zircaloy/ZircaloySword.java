package fr.ethernyx.stellamecanics.items.tool.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ZircaloySword extends Item implements IMyItem {
    public static String ID = "zircaloy_sword";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Epée en zircaloy");
            put("en_us", "Zircaloy sword");
        }};
        return langs.get(lang);
    }


    public ZircaloySword(Settings settings) { super(settings.sword(CustomItemTiers.ZIRCALOY, 3f, -2.4f)); }


}
