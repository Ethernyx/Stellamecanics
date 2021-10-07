package fr.Ethernyx.stellamecanics.data.model;


import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;

public class BlockStatesGenerator extends BlockStateProvider {
    private final List<AidInfoGenerator> aids;
    public BlockStatesGenerator(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper, List<AidInfoGenerator> aids) {
        super(generator, modid, existingFileHelper);
        this.aids = aids;
    }

    @Override
    protected void registerStatesAndModels() {
        for (AidInfoGenerator block : this.aids) {
            if (block.getType() != InstanceType.BLOCK) continue;
            
            if (block.getModelType().equals("simpleblock")) simpleBlock(ModBlocks.MAP_BLOCKS.get(block.getId()).get());
        }
    }
}
