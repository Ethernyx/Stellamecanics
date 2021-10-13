package fr.Ethernyx.stellamecanics.item.ore;

import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class MagnetiteRaw extends Item implements ICommun {
    private final String id = "magnetite_raw";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Magnetite brut"); put("en_us", "Magnetite raw");
    }};

    private AidInfoGenerator data;

    public MagnetiteRaw() {
        super(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }

    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
