package fr.ethernyx.stellamecanics.items.tool.lunarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class LunariumShovel extends Item implements IMyItem {
    public static String ID = "lunarium_shovel";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pelle en lunarium");
            put("en_us", "Lunarium shovel");
        }};
        return langs.get(lang);
    }


    public LunariumShovel(Settings settings) { super(settings.shovel(CustomItemTiers.LUNARIUM, 1.5f, -3f)); }


}
