package net.Ethernyx.stellamecanics.items.tool.lunarium;

import net.Ethernyx.stellamecanics.utils.CustomItemTiers;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.Item;
import net.Ethernyx.stellamecanics.utils.generator.ICommun;
import net.minecraft.item.PickaxeItem;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;

import java.util.HashMap;
import java.util.Map;

public class LunariumPickaxe extends PickaxeItem  implements ICommun {
    private static final String id = "lunarium_pickaxe";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Pioche en lunarium"); put("en_us", "Lunarium pickaxe");
    }};
    private AidInfoGenerator data;

    public LunariumPickaxe() {
        super(CustomItemTiers.LUNARIUM, 0, -2.4f, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
