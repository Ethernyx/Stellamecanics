package fr.ethernyx.stellamecanics.items.tool.lunarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class LunariumAxe extends Item implements IMyItem {
    public static String ID = "lunarium_axe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Hache en lunarium");
            put("en_us", "Lunarium axe");
        }};
        return langs.get(lang);
    }


    public LunariumAxe(Settings settings) { super(settings.axe(CustomItemTiers.LUNARIUM, 6f, -3.2f)); }


}
