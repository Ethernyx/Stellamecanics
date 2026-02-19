package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.init.ModFluids;
import fr.ethernyx.stellamecanics.interfaces.IMyFlowingFluid;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;

import java.util.concurrent.CompletableFuture;

public class FluidTagGenerator extends FabricTagProvider.FluidTagProvider {

    public FluidTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        if (!ModFluids.FLUIDS.isEmpty()) {
            ModFluids.FLUIDS.forEach((key, fluid) -> {
                if (!((IMyFlowingFluid) fluid.getStill()).getFlowingTag().isEmpty()) {
                    ((IMyFlowingFluid) fluid.getStill()).getFlowingTag().forEach((tag) -> {
                        valueLookupBuilder(tag).add(fluid.getFlowing());
                    });
                }
                if (!((IMyFlowingFluid) fluid.getStill()).getStillTag().isEmpty()) {
                    ((IMyFlowingFluid) fluid.getStill()).getStillTag().forEach((tag) -> {
                        valueLookupBuilder(tag).add(fluid.getStill());
                    });
                }
            });
        }
    }
}
