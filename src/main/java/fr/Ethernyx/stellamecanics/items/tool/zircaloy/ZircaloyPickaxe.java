package fr.ethernyx.stellamecanics.items.tool.zircaloy;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyPickaxe extends Item implements IMyItem {
    public static String ID = "zircaloy_pickaxe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pioche en zircaloy");
            put("en_us", "Zircaloy pickaxe");
        }};
        return langs.get(lang);
    }


    public ZircaloyPickaxe(Settings settings) { super(settings.pickaxe(CustomItemTiers.ZIRCALOY, 1f, -2.8f)); }


}
