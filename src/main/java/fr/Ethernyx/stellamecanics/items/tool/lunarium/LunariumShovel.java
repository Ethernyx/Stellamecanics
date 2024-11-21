package fr.ethernyx.stellamecanics.items.tool.lunarium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class LunariumShovel extends ShovelItem  implements IMyItem {
    public static String getId() {
        return "lunarium_shovel";
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Pelle en lunarium");
            put("en_us", "Lunarium shovel");
        }};
        return langs.get(lang);
    }

    

    public LunariumShovel() {
        super(CustomItemTiers.LUNARIUM, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
