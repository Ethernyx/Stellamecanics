package fr.ethernyx.stellamecanics.items.tool.zirconium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumSword extends Item implements IMyItem {
    public static String ID = "zirconium_sword";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Epée en zirconium");
            put("en_us", "Zirconium sword");
        }};
        return langs.get(lang);
    }


    public ZirconiumSword(Settings settings) { super(settings.sword(CustomItemTiers.ZIRCONIUM, 3f, -2.4f)); }


}
