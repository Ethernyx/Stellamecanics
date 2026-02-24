package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModFluids;
import fr.ethernyx.stellamecanics.init.ModTags;
import fr.ethernyx.stellamecanics.interfaces.IMyFlowingFluid;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        if (!ModTags.Blocks.BLOCKTAGS.isEmpty()) {
            ModTags.Blocks.BLOCKTAGS.forEach((name, tag) -> {
                tag.legacy().forEach(blockTag -> {
                    valueLookupBuilder(tag.getTag()).addTag(blockTag);
                });
                valueLookupBuilder(tag.getTag()).setReplace(tag.isreplace());
            });
        }
        if (!ModBlocks.BLOCKS.isEmpty()) {
            ModBlocks.BLOCKS.forEach((key, block) -> {
                if (!block.getTags().isEmpty()) {
                    block.getTags().forEach((tag) -> {
                        valueLookupBuilder(tag).add((Block) block);
                    });
                }
            });
        }
        if (!ModFluids.FLUIDS.isEmpty()) {
            ModFluids.FLUIDS.forEach((key, fluid) -> {
                if (!((IMyFlowingFluid) fluid.getStill()).getBlockTag().isEmpty()) {
                    ((IMyFlowingFluid) fluid.getStill()).getBlockTag().forEach((tag) -> {
                        valueLookupBuilder(tag).add(fluid.getBlock());
                    });
                }
            });
        }
    }
}
