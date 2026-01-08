package fr.ethernyx.stellamecanics.items.tool.solarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class SolariumSword extends Item implements IMyItem {
    public static String ID = "solarium_sword";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Epée en solarium");
            put("en_us", "Solarium sword");
        }};
        return langs.get(lang);
    }


    public SolariumSword(Settings settings) { super(settings.sword(CustomItemTiers.SOLARIUM, 3f, -2.4f)); }


}
