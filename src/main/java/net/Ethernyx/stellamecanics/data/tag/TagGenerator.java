package net.Ethernyx.stellamecanics.data.tag;

import net.Ethernyx.stellamecanics.Main;
import net.Ethernyx.stellamecanics.init.ModBlocks;
import net.Ethernyx.stellamecanics.init.ModItems;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

import java.util.List;

public class TagGenerator extends FabricTagProvider.BlockTagProvider {

    private final List<AidInfoGenerator> aids;

    public TagGenerator(FabricDataGenerator dataGenerator, List<AidInfoGenerator> aids) {
        super(dataGenerator);
        this.aids = aids;
    }

    @Override
    protected void generateTags() {
        for (AidInfoGenerator item : this.aids) {
            if (item.getTags().size() > 0) {
                for (TagKey<Block> tag : item.getTags()) {
                    getOrCreateTagBuilder(TagKey.of(tag.registry(), tag.id())).add(ModBlocks.BLOCKS.get(item.getId()).block);
                }
            }
        }
    }
}
