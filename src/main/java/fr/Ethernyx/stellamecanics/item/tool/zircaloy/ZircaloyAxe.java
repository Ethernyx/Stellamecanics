package fr.Ethernyx.stellamecanics.item.tool.zircaloy;

import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.AxeItem;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyAxe extends AxeItem {
    private final String id = "zircaloy_axe";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Hache en zircaloy"); put("en_us", "Zircaloy axe");
    }};

    public ZircaloyAxe() {
        super(CustomItemTiers.ZIRCALOY, 0, -2.4f, new Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB));
    }

    private AidInfoGenerator data;

    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        return this.data;
    }

    public String getId() {
        return this.id;
    }
}
