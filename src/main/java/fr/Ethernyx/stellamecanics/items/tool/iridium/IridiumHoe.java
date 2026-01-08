package fr.ethernyx.stellamecanics.items.tool.iridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class IridiumHoe extends Item implements IMyItem {
    public static String ID = "iridium_hoe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Houe en iridium");
            put("en_us", "Iridium hoe");
        }};
        return langs.get(lang);
    }


    public IridiumHoe(Settings settings) { super(settings.hoe(CustomItemTiers.IRIDIUM, 0f, -3f)); }


}
