package fr.Ethernyx.stellamecanics.item.tool.osmiridium;

import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.PickaxeItem;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumPickaxe extends PickaxeItem implements ICommun {
    private final String id = "osmiridium_pickaxe";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Pioche en osmiridium"); put("en_us", "Osmiridium pickaxe");
    }};
    private AidInfoGenerator data;

    public OsmiridiumPickaxe() {
        super(CustomItemTiers.OSMIRIDIUM, 0, -2.4f, new Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
