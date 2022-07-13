package net.Ethernyx.stellamecanics.items.tool.lunarium;

import net.Ethernyx.stellamecanics.utils.CustomItemTiers;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.Ethernyx.stellamecanics.utils.generator.ICommun;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;

import java.util.HashMap;
import java.util.Map;

public class LunariumAxe extends AxeItem  implements ICommun {
    private static final String id = "lunarium_axe";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Hache en lunarium"); put("en_us", "Lunarium axe");
    }};
    private AidInfoGenerator data;

    public LunariumAxe() {
        super(CustomItemTiers.LUNARIUM, 0, -2.4f, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
