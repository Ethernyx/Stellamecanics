package net.Ethernyx.stellamecanics.items.tool.iridium;

import net.Ethernyx.stellamecanics.utils.CustomItemTiers;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.Item;
import net.Ethernyx.stellamecanics.utils.generator.ICommun;
import net.minecraft.item.SwordItem;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;

import java.util.HashMap;
import java.util.Map;

public class IridiumSword extends SwordItem  implements ICommun {
    private static final String id = "iridium_sword";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Epée en iridium"); put("en_us", "Iridium sword");
    }};
    private AidInfoGenerator data;

    public IridiumSword() {
        super(CustomItemTiers.IRIDIUM, 0, -2.4f, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);

    }
    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
