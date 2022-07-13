package net.Ethernyx.stellamecanics.data.model;

import net.Ethernyx.stellamecanics.init.ModBlocks;
import net.Ethernyx.stellamecanics.init.ModItems;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.Models;

import java.util.List;

public class ItemModelGenerator extends FabricModelProvider {
    private final List<AidInfoGenerator> aids;

    public ItemModelGenerator(FabricDataGenerator dataGenerator, List<AidInfoGenerator> aids) {
        super(dataGenerator);
        this.aids = aids;
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (AidInfoGenerator item : this.aids) {
            switch (item.getType()) {
                case BLOCK:
                    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCKS.get(item.getId()).block);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void generateItemModels(net.minecraft.data.client.ItemModelGenerator itemModelGenerator) {
        for (AidInfoGenerator item : this.aids) {
            switch (item.getType()) {
                case ITEM:
                case ENCHANTMENT:
                    itemModelGenerator.register(ModItems.ITEMS.get(item.getId()).item, item.getModelType() == "item/generated" ? Models.GENERATED : Models.HANDHELD);
                    break;
                default:
                    break;
            }
        }
    }
}
