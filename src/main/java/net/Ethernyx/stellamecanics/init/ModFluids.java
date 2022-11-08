package net.Ethernyx.stellamecanics.init;

import net.Ethernyx.stellamecanics.Main;
import net.Ethernyx.stellamecanics.fluid.MoltenIridiumFluid;
import net.Ethernyx.stellamecanics.utils.FluidStruct;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FlowableFluid;

import java.util.HashMap;
import java.util.Map;

public class ModFluids {
    public static Map<String, FluidStruct> FLUIDS = new HashMap<>();

    public static void registerModTags() {
        Main.LOGGER.debug("Registering Mod Fluids for " + Main.MOD_ID);

        addNewFluid("molten_iridium", new MoltenIridiumFluid.Still(), new MoltenIridiumFluid.Flowing(),
                new AidInfoGenerator("molten_iridium_bucket", "item/generated",
                        new HashMap<String, String>() {{
            put("fr_fr", "Seau d'iridium fondu"); put("en_us", "Molten iridium bucket");
        }}, InstanceType.ITEM));
    }

    public static void addNewFluid(String name, FlowableFluid still, FlowableFluid flowing, AidInfoGenerator bucket_infos) {
        FLUIDS.put(name, new FluidStruct(name, still, flowing, Blocks.WATER, bucket_infos));
        FLUIDS.get(name).setBlock(Blocks.WATER);
    }
}
