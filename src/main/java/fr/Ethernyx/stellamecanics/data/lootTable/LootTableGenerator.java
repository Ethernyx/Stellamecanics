package fr.Ethernyx.stellamecanics.data.lootTable;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LootTableGenerator extends LootTableProvider {
    public LootTableGenerator(DataGenerator p_i50789_1_) {
        super(p_i50789_1_);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(BlockLootTable::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((p_218436_2_, p_218436_3_) -> LootTableManager.validate(validationtracker, p_218436_2_, p_218436_3_));
    }

    static class BlockLootTable extends BlockLootTables {
        @Override
        protected void addTables() {
            this.add(ModBlocks.MAGNETITE_ORE.get(), (p_218568_0_) -> createOreDrop(p_218568_0_, ModItems.MAGNETITE_RAW.get()));
            this.add(ModBlocks.ZIRCONIUM_ORE.get(), (p_218568_0_) -> createOreDrop(p_218568_0_, ModItems.ZIRCONIUM_RAW.get()));
            this.add(ModBlocks.IRIDIUM_ORE.get(), (p_218568_0_) -> createOreDrop(p_218568_0_, ModItems.IRIDIUM_RAW.get()));
            this.add(ModBlocks.SOLARIUM_ORE.get(), (p_218568_0_) -> createOreDrop(p_218568_0_, ModItems.SOLARIUM_RAW.get()));
            this.add(ModBlocks.LUNARIUM_ORE.get(), (p_218568_0_) -> createOreDrop(p_218568_0_, ModItems.LUNARIUM_RAW.get()));
            this.dropSelf(ModBlocks.SOLARIUM_BLOCK.get());
            this.dropSelf(ModBlocks.LUNARIUM_BLOCK.get());
            this.dropSelf(ModBlocks.STELLARIUM_BLOCK.get());
            this.dropSelf(ModBlocks.ZIRCONIUM_BLOCK.get());
            this.dropSelf(ModBlocks.IRIDIUM_BLOCK.get());
            this.dropSelf(ModBlocks.ZIRCALOY_BLOCK.get());
            this.dropSelf(ModBlocks.OSMIRIDIUM_BLOCK.get());
            this.dropSelf(ModBlocks.FORGE_STELLAIRE.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ModBlocks.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }
}
