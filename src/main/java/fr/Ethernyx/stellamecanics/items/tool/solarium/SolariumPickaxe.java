package fr.ethernyx.stellamecanics.items.tool.solarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class SolariumPickaxe extends Item implements IMyItem {
    public static String ID = "solarium_pickaxe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pioche en solarium");
            put("en_us", "Solarium pickaxe");
        }};
        return langs.get(lang);
    }


    public SolariumPickaxe(Settings settings) { super(settings.pickaxe(CustomItemTiers.SOLARIUM, 1f, -2.8f)); }


}
