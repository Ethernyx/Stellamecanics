package fr.Ethernyx.stellamecanics.item.tool.solarium;

import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

import java.util.HashMap;
import java.util.Map;

public class SolariumSword extends SwordItem {
    private final String id = "solarium_sword";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Epée en solarium"); put("en_us", "Solarium sword");
    }};
    private AidInfoGenerator data;

    public SolariumSword() {
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
