package fr.Ethernyx.stellamecanics.item.tool.stellarium;

import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.PickaxeItem;

import java.util.HashMap;
import java.util.Map;

public class StellariumPickaxe extends PickaxeItem {
    private final String id = "stellarium_pickaxe";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Pioche en stellarium"); put("en_us", "Stellarium pickaxe");
    }};
    private AidInfoGenerator data;

    public StellariumPickaxe() {
        super(CustomItemTiers.STELLARIUM, 0, -2.4f, new Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB));
    }

    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        return this.data;
    }

    public String getId() {
        return this.id;
    }
}
