package fr.ethernyx.stellamecanics.items.tool.stellarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class StellariumHoe extends Item implements IMyItem {
    public static String ID = "stellarium_hoe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Houe en stellarium");
            put("en_us", "Stellarium hoe");
        }};
        return langs.get(lang);
    }


    public StellariumHoe(Settings settings) { super(settings.hoe(CustomItemTiers.STELLARIUM, 0f, -3f)); }


}
