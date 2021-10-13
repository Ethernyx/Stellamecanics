package fr.Ethernyx.stellamecanics.item.tool.solarium;

import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class SolariumShovel extends ShovelItem implements ICommun {
    private final String id = "solarium_shovel";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Pelle en solarium"); put("en_us", "Solarium shovel");
    }};
    private AidInfoGenerator data;

    public SolariumShovel() {
        super(CustomItemTiers.SOLARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
