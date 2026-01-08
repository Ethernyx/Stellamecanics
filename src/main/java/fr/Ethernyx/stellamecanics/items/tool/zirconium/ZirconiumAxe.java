package fr.ethernyx.stellamecanics.items.tool.zirconium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumAxe extends Item implements IMyItem {
    public static String ID = "zirconium_axe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Hache en zirconium");
            put("en_us", "Zirconium axe");
        }};
        return langs.get(lang);
    }


    public ZirconiumAxe(Settings settings) { super(settings.axe(CustomItemTiers.ZIRCONIUM, 6f, -3.2f)); }


}
