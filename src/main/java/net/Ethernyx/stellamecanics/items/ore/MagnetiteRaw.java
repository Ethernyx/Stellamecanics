package net.Ethernyx.stellamecanics.items.ore;

import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.item.Item;
import net.Ethernyx.stellamecanics.utils.generator.ICommun;

import java.util.HashMap;
import java.util.Map;

public class MagnetiteRaw extends Item  implements ICommun {
    private static final String id = "magnetite_raw";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Magnetite brut"); put("en_us", "Magnetite raw");
    }};

    private AidInfoGenerator data;

    public MagnetiteRaw() {
        super(new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }

    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
