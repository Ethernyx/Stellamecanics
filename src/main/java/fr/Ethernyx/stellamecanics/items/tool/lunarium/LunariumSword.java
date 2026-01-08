package fr.ethernyx.stellamecanics.items.tool.lunarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class LunariumSword extends Item implements IMyItem {
    public static String ID = "lunarium_sword";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Epée en lunarium");
            put("en_us", "Lunarium sword");
        }};
        return langs.get(lang);
    }


    public LunariumSword(Settings settings) { super(settings.sword(CustomItemTiers.LUNARIUM, 3f, -2.4f)); }


}
