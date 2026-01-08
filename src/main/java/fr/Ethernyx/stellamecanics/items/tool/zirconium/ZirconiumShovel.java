package fr.ethernyx.stellamecanics.items.tool.zirconium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumShovel extends Item implements IMyItem {
    public static String ID = "zirconium_shovel";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pelle en zirconium");
            put("en_us", "Zirconium shovel");
        }};
        return langs.get(lang);
    }


    public ZirconiumShovel(Settings settings) { super(settings.shovel(CustomItemTiers.ZIRCONIUM, 1.5f, -3f)); }


}
