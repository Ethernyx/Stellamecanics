package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;


public class LootTableGenerator extends FabricBlockLootTableProvider {

    public LootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        ModBlocks.BLOCKS.forEach((key, block) -> {
                    switch (block.getLootTable().getType()) {
                        case NONE:
                            addDrop((Block) block, dropsNothing());
                            break;
                        case NORMAL:
                            addDrop((Block) block);
                            break;
                        case ORE:
                            addDrop((Block) block, ModItems.ITEMS.get(block.getLootTable().getOutput().getItem()));
                            break;
                        case MULTIPLE:
                            drops((Block) block, ModItems.ITEMS.get(block.getLootTable().getOutput().getItem()), ConstantLootNumberProvider.create(block.getLootTable().getOutput().getNb()));
                            break;
                        case SILKTOUCH:
                            dropsWithSilkTouch((Block) block);
                            break;
                        case LUCKY_ORE:
                            RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
                            dropsWithSilkTouch(
                                    (Block) block,
                                    applyExplosionDecay(
                                            (Block) block,
                                            ItemEntry.builder(ModItems.ITEMS.get(block.getLootTable().getOutput().getItem()))
                                                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1F, block.getLootTable().getOutput().getNb())))
                                                    .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                                    )
                            );
                            break;
                        default:
                            break;
                    }
            });
    }
}
