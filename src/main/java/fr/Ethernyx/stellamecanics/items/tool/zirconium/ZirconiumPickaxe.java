package fr.ethernyx.stellamecanics.items.tool.zirconium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumPickaxe extends Item implements IMyItem {
    public static String ID = "zirconium_pickaxe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pioche en zirconium");
            put("en_us", "Zirconium pickaxe");
        }};
        return langs.get(lang);
    }


    public ZirconiumPickaxe(Settings settings) { super(settings.pickaxe(CustomItemTiers.ZIRCONIUM, 1f, -2.8f)); }


}
