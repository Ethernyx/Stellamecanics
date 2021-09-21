package fr.Ethernyx.stellamecanics.item.tool.zirconium;

import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.ShovelItem;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumShovel extends ShovelItem {
    private final String id = "zirconium_shovel";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Pelle en zirconium"); put("en_us", "Zirconium shovel");
    }};
    private AidInfoGenerator data;

    public ZirconiumShovel() {
        super(CustomItemTiers.ZIRCONIUM, 0, -2.4f, new Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB));
    }

    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        return this.data;
    }

    public String getId() {
        return this.id;
    }
}
