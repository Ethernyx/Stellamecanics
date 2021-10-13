package fr.Ethernyx.stellamecanics.item.tool.lunarium;

import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.SwordItem;

import java.util.HashMap;
import java.util.Map;

public class LunariumSword extends SwordItem implements ICommun {
    private final String id = "lunarium_sword";
    private final String modelType = "item/handheld";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Epée en lunarium"); put("en_us", "Lunarium sword");
    }};
    private AidInfoGenerator data;

    public LunariumSword() {
        super(CustomItemTiers.LUNARIUM, 0, -2.4f, new Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
