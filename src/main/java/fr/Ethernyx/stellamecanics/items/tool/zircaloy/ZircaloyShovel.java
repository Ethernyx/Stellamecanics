package fr.ethernyx.stellamecanics.items.tool.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyShovel extends Item implements IMyItem {
    public static String ID = "zircaloy_shovel";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pelle en zircaloy");
            put("en_us", "Zircaloy shovel");
        }};
        return langs.get(lang);
    }


    public ZircaloyShovel(Settings settings) { super(settings.shovel(CustomItemTiers.ZIRCALOY, 1.5f, -3f)); }


}
