package fr.ethernyx.stellamecanics.items.tool.osmiridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumAxe extends Item implements IMyItem {
    public static String ID = "osmiridium_axe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Hache en osmiridium");
            put("en_us", "Osmiridium axe");
        }};
        return langs.get(lang);
    }


    public OsmiridiumAxe(Settings settings) { super(settings.axe(CustomItemTiers.OSMIRIDIUM, 6f, -3.2f)); }


}
