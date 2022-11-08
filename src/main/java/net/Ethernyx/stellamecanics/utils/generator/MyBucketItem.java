package net.Ethernyx.stellamecanics.utils.generator;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;

import java.util.HashMap;
import java.util.Map;

public class MyBucketItem extends BucketItem implements ICommun {
    private final String id;
    private final String modelType;
    private final Map<String, String> translate;
    private AidInfoGenerator data;

    public MyBucketItem(Fluid fluid, Settings settings, AidInfoGenerator info) {
        super(fluid, settings);
        this.modelType = info.modelType;
        this.id = info.getId();
        this.translate = info.translate;
        this.data = info;
    }

    @Override
    public AidInfoGenerator getData() {
        return data;
    }

    public String getId() {
        return id;
    }
}
