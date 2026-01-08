package fr.ethernyx.stellamecanics.items.tool.iridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class IridiumPickaxe extends Item implements IMyItem {
    public static String ID = "iridium_pickaxe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pioche en iridium");
            put("en_us", "Iridium pickaxe");
        }};
        return langs.get(lang);
    }


    public IridiumPickaxe(Settings settings) { super(settings.pickaxe(CustomItemTiers.IRIDIUM, 1f, -2.8f)); }


}
