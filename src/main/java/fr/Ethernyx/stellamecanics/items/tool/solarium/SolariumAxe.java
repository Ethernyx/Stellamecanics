package fr.ethernyx.stellamecanics.items.tool.solarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class SolariumAxe extends Item implements IMyItem {
    public static String ID = "solarium_axe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Hache en solarium");
            put("en_us", "Solarium axe");
        }};
        return langs.get(lang);
    }


    public SolariumAxe(Settings settings) { super(settings.axe(CustomItemTiers.SOLARIUM, 6f, -3.2f)); }


}
