package fr.ethernyx.stellamecanics.items.tool.zirconium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumHoe extends Item implements IMyItem {
    public static String ID = "zirconium_hoe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Houe en zirconium");
            put("en_us", "Zirconium hoe");
        }};
        return langs.get(lang);
    }


    public ZirconiumHoe(Settings settings) { super(settings.hoe(CustomItemTiers.ZIRCONIUM, 0f, -3f)); }


}
