package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.init.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }


    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        if (!ModBlocks.BLOCKS.isEmpty()) {
            ModBlocks.BLOCKS.forEach((key, block) -> {
                if (!block.getTags().isEmpty()) {
                    block.getTags().forEach((tag) -> {
                        valueLookupBuilder(tag).add((Block) block);
                    });
                }
            });
        }
    }
}
