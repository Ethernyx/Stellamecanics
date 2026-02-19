package fr.ethernyx.stellamecanics;

import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui.ForgeStellaireScreen;
import fr.ethernyx.stellamecanics.init.ModFluids;
import fr.ethernyx.stellamecanics.init.ModScreenHandlers;
import fr.ethernyx.stellamecanics.interfaces.IMyFlowingFluid;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;

public class StellamecanicsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.FORGE_STELLAIRE, ForgeStellaireScreen::new);
        ModFluids.FLUIDS.forEach((id, fluids) -> {
            FlowableFluid still   = fluids.getStill();
            FlowableFluid flowing = fluids.getFlowing();

            FluidRenderHandlerRegistry.INSTANCE.register(
                    still,
                    flowing,
                    new SimpleFluidRenderHandler(
                            Identifier.of("minecraft", "block/water_still"),
                            Identifier.of("minecraft", "block/water_flow"),
                            (still instanceof IMyFlowingFluid f) ? f.color() : 0xFFFFFF
                    )
            );
        });
    }
}
