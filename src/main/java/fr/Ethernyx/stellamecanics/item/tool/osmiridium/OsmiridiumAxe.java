package fr.Ethernyx.stellamecanics.item.tool.osmiridium;

import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.AxeItem;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumAxe extends AxeItem implements ICommun {
    private final String id = "osmiridium_axe";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Hache en osmiridium"); put("en_us", "Osmiridium axe");
    }};
    private AidInfoGenerator data;

    public OsmiridiumAxe() {
        super(CustomItemTiers.OSMIRIDIUM, 0, -2.4f, new Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }

    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }

}
