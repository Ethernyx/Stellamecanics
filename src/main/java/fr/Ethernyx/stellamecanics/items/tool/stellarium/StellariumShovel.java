package fr.ethernyx.stellamecanics.items.tool.stellarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class StellariumShovel extends Item implements IMyItem {
    public static String ID = "stellarium_shovel";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pelle en stellarium");
            put("en_us", "Stellarium shovel");
        }};
        return langs.get(lang);
    }


    public StellariumShovel(Settings settings) { super(settings.shovel(CustomItemTiers.STELLARIUM, 1.5f, -3f)); }


}
