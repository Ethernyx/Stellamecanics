package net.Ethernyx.stellamecanics.block.fluid;

import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;

import java.util.HashMap;
import java.util.Map;

public class IridiumFluid extends FluidBlock {
    private static final String id = "lunarium_block";
    private final String modelType = "simpleblock";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Bloc de lunarium"); put("en_us", "Lunarium block");
    }};

    public IridiumFluid(FlowableFluid fluid, Settings settings) {
        super(fluid, settings);
    }
}
