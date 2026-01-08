package fr.ethernyx.stellamecanics.items.tool.iridium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class IridiumShovel extends Item implements IMyItem {
    public static String ID = "iridium_shovel";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pelle en iridium");
            put("en_us", "Iridium shovel");
        }};
        return langs.get(lang);
    }


    public IridiumShovel(Settings settings) {
        super(settings.shovel(CustomItemTiers.IRIDIUM, 1.5f, -3f));
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/

    }


}
