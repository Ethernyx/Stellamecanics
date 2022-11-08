package net.Ethernyx.stellamecanics;

import net.Ethernyx.stellamecanics.init.ModFluids;
import net.Ethernyx.stellamecanics.utils.FluidStruct;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class StellamecanicsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        for (FluidStruct fluid : ModFluids.FLUIDS.values()) {
            FluidRenderHandlerRegistry.INSTANCE.register(fluid.getStill(), fluid.getFlowing(),
                    new SimpleFluidRenderHandler(
                            new Identifier("minecraft:block/water_still"),
                            new Identifier("minecraft:block/water_flow"),
                            0xA1E038D0
                    ));
            BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                    fluid.getStill(), fluid.getFlowing());
        }
    }
}
