package fr.Ethernyx.stellamecanics.item.tool.osmiridium;

import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.SwordItem;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumSword extends SwordItem {
    private final String id = "osmiridium_sword";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Epée en osmiridium"); put("en_us", "Osmiridium sword");
    }};
    private AidInfoGenerator data;

    public OsmiridiumSword() {
        super(CustomItemTiers.OSMIRIDIUM, 0, -2.4f, new Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB));
    }

    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        return this.data;
    }

    public String getId() {
        return this.id;
    }
}
