package net.Ethernyx.stellamecanics.data.lootTable;

import net.Ethernyx.stellamecanics.Main;
import net.Ethernyx.stellamecanics.init.ModBlocks;
import net.Ethernyx.stellamecanics.init.ModItems;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.minecraft.block.Block;
import net.minecraft.data.DataWriter;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContextParameter;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;



public class LootTableGenerator extends SimpleFabricLootTableProvider {

    private final List<AidInfoGenerator> aids;

    public LootTableGenerator(FabricDataGenerator dataGenerator, List<AidInfoGenerator> aids) {
        super(dataGenerator, LootContextTypes.BLOCK);
        this.aids = aids;
    }
    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
        for (AidInfoGenerator block : this.aids) {
            Identifier path = new Identifier(Main.MOD_ID, "blocks/" + block.getId());
            switch (block.getType()) {
                case BLOCK:
                    switch (block.getLootType()) {
                        case NONE:
                            identifierBuilderBiConsumer.accept(path, BlockLootTableGenerator.dropsNothing());
                            break;
                        case NORMAL:
                            identifierBuilderBiConsumer.accept(path, BlockLootTableGenerator.drops(ModBlocks.BLOCKS.get(block.getId()).block));
                            break;
                        case ORE:
                            identifierBuilderBiConsumer.accept(path, BlockLootTableGenerator.oreDrops(ModBlocks.BLOCKS.get(block.getId()).block, ModItems.ITEMS.get(block.getLootOutput().getItem()).item));
                            break;
                        case MULTIPLE:
                            identifierBuilderBiConsumer.accept(path, BlockLootTableGenerator.drops(ModBlocks.BLOCKS.get(block.getId()).block, ModItems.ITEMS.get(block.getLootOutput().getItem()).item, ConstantLootNumberProvider.create(block.getLootOutput().getNb())));
                            break;
                        case SILKTOUCH:
                            identifierBuilderBiConsumer.accept(path, BlockLootTableGenerator.dropsWithSilkTouch(ModBlocks.BLOCKS.get(block.getId()).block));
                            break;
                        case LUCKY_ORE:
                            identifierBuilderBiConsumer.accept(path, BlockLootTableGenerator.dropsWithSilkTouch(ModBlocks.BLOCKS.get(block.getId()).block, (LootPoolEntry.Builder)BlockLootTableGenerator.applyExplosionDecay(ModBlocks.BLOCKS.get(block.getId()).block, ItemEntry.builder(ModItems.ITEMS.get(block.getLootOutput().getItem()).item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, block.getLootOutput().getNb()))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))));
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

   @Override
    public String getName() {
        return "LootTables";
    }
}
