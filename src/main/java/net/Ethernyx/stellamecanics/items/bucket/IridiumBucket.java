package net.Ethernyx.stellamecanics.items.bucket;

import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.ICommun;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;

import java.util.HashMap;
import java.util.Map;

public class IridiumBucket extends BucketItem implements ICommun {
    private static final String id = "iridium_bucket";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Seau d'iridium fondu"); put("en_us", "Molten iridium bucket");
    }};
    private AidInfoGenerator data;

    public IridiumBucket(Fluid fluid, Settings settings) {
        super(fluid, settings);
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }

    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
