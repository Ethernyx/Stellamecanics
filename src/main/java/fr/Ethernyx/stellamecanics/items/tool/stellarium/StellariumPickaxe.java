package fr.ethernyx.stellamecanics.items.tool.stellarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class StellariumPickaxe extends Item implements IMyItem {
    public static String ID = "stellarium_pickaxe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pioche en stellarium");
            put("en_us", "Stellarium pickaxe");
        }};
        return langs.get(lang);
    }


    public StellariumPickaxe(Settings settings) { super(settings.pickaxe(CustomItemTiers.STELLARIUM, 1f, -2.8f)); }


}
