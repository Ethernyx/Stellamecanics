package fr.Ethernyx.stellamecanics.item.tool.zircaloy;

import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.SwordItem;

import java.util.HashMap;
import java.util.Map;

public class ZircaloySword extends SwordItem {
    private final String id = "zircaloy_sword";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Epée en zircaloy"); put("en_us", "Zircaloy sword");
    }};
    private AidInfoGenerator data;

    public ZircaloySword() {
        super(CustomItemTiers.ZIRCALOY, 0, -2.4f, new Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB));
    }

    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        return this.data;
    }

    public String getId() {
        return this.id;
    }
}
