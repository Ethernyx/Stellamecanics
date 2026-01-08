package fr.ethernyx.stellamecanics.items.tool.lunarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class LunariumPickaxe extends Item implements IMyItem {
    public static String ID = "lunarium_pickaxe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pioche en lunarium");
            put("en_us", "Lunarium pickaxe");
        }};
        return langs.get(lang);
    }


    public LunariumPickaxe(Settings settings) { super(settings.pickaxe(CustomItemTiers.LUNARIUM, 1f, -2.8f)); }


}
