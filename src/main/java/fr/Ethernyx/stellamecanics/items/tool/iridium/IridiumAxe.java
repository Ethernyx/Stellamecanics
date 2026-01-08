package fr.ethernyx.stellamecanics.items.tool.iridium;

import fr.ethernyx.stellamecanics.init.ModTags;
import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IridiumAxe extends Item implements IMyItem {
    public static String ID = "iridium_axe";

    public String getId() {
        return ID;
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Hache en iridium");
            put("en_us", "Iridium axe");
        }};
        return langs.get(lang);
    }


    public IridiumAxe(Settings settings) { super(settings.axe(CustomItemTiers.IRIDIUM, 6, -3.2f)); }

    @Override
    public List<TagKey<Item>> getTags() {
        List<TagKey<Item>> TagsList = new ArrayList<>();

        TagsList.add(ModTags.Items.IRIDIUM_TOOL);
        return IMyItem.super.getTags();
    }
}
