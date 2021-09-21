package fr.Ethernyx.stellamecanics.data.model;


import fr.Ethernyx.stellamecanics.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStatesGenerator extends BlockStateProvider {
    public BlockStatesGenerator(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.LUNARIUM_BLOCK.get());
        simpleBlock(ModBlocks.SOLARIUM_BLOCK.get());
        simpleBlock(ModBlocks.STELLARIUM_BLOCK.get());
        simpleBlock(ModBlocks.ZIRCONIUM_BLOCK.get());
        simpleBlock(ModBlocks.IRIDIUM_BLOCK.get());
        simpleBlock(ModBlocks.ZIRCALOY_BLOCK.get());
        simpleBlock(ModBlocks.OSMIRIDIUM_BLOCK.get());
        simpleBlock(ModBlocks.MAGNETITE_ORE.get());
        simpleBlock(ModBlocks.ZIRCONIUM_ORE.get());
        simpleBlock(ModBlocks.IRIDIUM_ORE.get());
        simpleBlock(ModBlocks.SOLARIUM_ORE.get());
        simpleBlock(ModBlocks.LUNARIUM_ORE.get());
    }
}
