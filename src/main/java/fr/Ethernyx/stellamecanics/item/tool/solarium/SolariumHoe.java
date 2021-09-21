package fr.Ethernyx.stellamecanics.item.tool.solarium;

import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class SolariumHoe extends HoeItem {
    private final String id = "solarium_hoe";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Houe en solarium"); put("en_us", "Solarium hoe");
    }};
    private AidInfoGenerator data;

    public SolariumHoe() {
        super(CustomItemTiers.SOLARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB));
    }

    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        return this.data;
    }

    public String getId() {
        return this.id;
    }
}
