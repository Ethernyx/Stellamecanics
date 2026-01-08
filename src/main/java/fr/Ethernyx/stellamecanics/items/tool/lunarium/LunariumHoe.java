package fr.ethernyx.stellamecanics.items.tool.lunarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class LunariumHoe extends Item implements IMyItem {
    public static String ID = "lunarium_hoe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Houe en lunarium");
            put("en_us", "Lunarium hoe");
        }};
        return langs.get(lang);
    }


    public LunariumHoe(Settings settings) { super(settings.hoe(CustomItemTiers.LUNARIUM, 0f, -3f)); }


}
