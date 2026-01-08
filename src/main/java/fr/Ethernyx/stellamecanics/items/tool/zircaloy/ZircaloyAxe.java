package fr.ethernyx.stellamecanics.items.tool.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyAxe extends Item implements IMyItem {
    public static String ID = "zircaloy_axe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Hache en zircaloy");
            put("en_us", "Zircaloy axe");
        }};
        return langs.get(lang);
    }


    public ZircaloyAxe(Settings settings) { super(settings.axe(CustomItemTiers.ZIRCALOY, 6f, -3.2f)); }


}
