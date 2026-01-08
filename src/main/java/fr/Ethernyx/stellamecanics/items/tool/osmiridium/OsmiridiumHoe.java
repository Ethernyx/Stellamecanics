package fr.ethernyx.stellamecanics.items.tool.osmiridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumHoe extends Item implements IMyItem {
    public static String ID = "osmiridium_hoe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Houe en osmiridium");
            put("en_us", "Osmiridium hoe");
        }};
        return langs.get(lang);
    }


    public OsmiridiumHoe(Settings settings) { super(settings.hoe(CustomItemTiers.OSMIRIDIUM, 0f, -3f)); }


}
