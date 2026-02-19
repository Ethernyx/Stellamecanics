package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModFluids;
import fr.ethernyx.stellamecanics.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.ModelIds;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;

public class    ModelGenerator extends FabricModelProvider {

    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        ModBlocks.BLOCKS.forEach((id, block) -> {
            blockStateModelGenerator.registerSimpleCubeAll((Block) block);
        });
        ModFluids.FLUIDS.forEach((id, fluid) -> {
            BlockStateModelGenerator.createSingletonBlockState(
                    fluid.getBlock(),
                    BlockStateModelGenerator.createWeightedVariant(
                            ModelIds.getMinecraftNamespacedBlock("water")
                    )
            );
        });
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        ModItems.ITEMS.forEach((key, item) -> {
            itemModelGenerator.register((Item) item, item.getModelType());
        });

        ModFluids.FLUIDS.forEach((id, fluid) -> {
            itemModelGenerator.register(fluid.getBucket(), Models.GENERATED);
        });
    }
}
