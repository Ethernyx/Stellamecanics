package fr.ethernyx.stellamecanics.items.tool.osmiridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumPickaxe extends Item implements IMyItem {
    public static String ID = "osmiridium_pickaxe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pioche en osmiridium");
            put("en_us", "Osmiridium pickaxe");
        }};
        return langs.get(lang);
    }


    public OsmiridiumPickaxe(Settings settings) { super(settings.pickaxe(CustomItemTiers.OSMIRIDIUM, 1f, -2.8f)); }


}
