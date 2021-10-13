package fr.Ethernyx.stellamecanics.item.tool.osmiridium;

import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.HoeItem;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumHoe extends HoeItem implements ICommun {
    private final String id = "osmiridium_hoe";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Houe en osmiridium"); put("en_us", "Osmiridium hoe");
    }};
    private AidInfoGenerator data;

    public OsmiridiumHoe() {
        super(CustomItemTiers.OSMIRIDIUM, 0, -2.4f, new Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
