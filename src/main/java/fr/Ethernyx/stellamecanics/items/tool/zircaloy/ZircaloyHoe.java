package fr.ethernyx.stellamecanics.items.tool.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyHoe extends Item implements IMyItem {
    public static String ID = "zircaloy_hoe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Houe en zircaloy");
            put("en_us", "Zircaloy hoe");
        }};
        return langs.get(lang);
    }


    public ZircaloyHoe(Settings settings) { super(settings.hoe(CustomItemTiers.ZIRCALOY, 0f, -3f)); }


}
