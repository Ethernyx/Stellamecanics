package net.Ethernyx.stellamecanics.items.tool.solarium;

import net.Ethernyx.stellamecanics.utils.CustomItemTiers;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;

import java.util.HashMap;
import java.util.Map;

public class SolariumPickaxe extends PickaxeItem {
    private static final String id = "solarium_pickaxe";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Pioche en solarium"); put("en_us", "Solarium pickaxe");
    }};
    //private AidInfoGenerator data;

    public SolariumPickaxe() {
        super(CustomItemTiers.SOLARIUM, 0, -2.4f, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        //this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
    //public AidInfoGenerator getData() { return data; }
}
