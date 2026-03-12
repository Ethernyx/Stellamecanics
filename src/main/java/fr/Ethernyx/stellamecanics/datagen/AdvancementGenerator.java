package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModAdvancements;
import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModCriteria;
import fr.ethernyx.stellamecanics.init.ModItems;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AdvancementGenerator extends FabricAdvancementProvider {
    public AdvancementGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> future) {
        super(output, future);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup lookup, Consumer<AdvancementEntry> exporter) {

        RegistryEntryLookup<Item> itemLookup = lookup.getOrThrow(RegistryKeys.ITEM);
        ModAdvancements.ADVANCEMENTS.forEach((id, advancement) -> {
            Advancement.Builder builder = Advancement.Builder.create()
                    .display(
                            advancement.getIcon(),
                            Text.translatable("advancement." + Stellamecanics.MOD_ID + "." + id + ".title"),
                            Text.translatable("advancement." + Stellamecanics.MOD_ID + "." + id + ".description"),
                            advancement.getBackground(),
                            advancement.getFrame(),
                            advancement.isShowToast(),
                            advancement.isAnnounceToChat(),
                            advancement.isHidden()
                    );
                    switch (advancement.getType()) {
                        case INVENTORY ->  {
                            List<ItemPredicate> items = new ArrayList<>();
                            advancement.getItems().forEach((item) -> {
                                switch (item.getType()) {
                                    case ITEM -> {
                                        items.add(ItemPredicate.Builder.create()
                                                .items(itemLookup, ModItems.ITEMS.get(item.getItem()).asItem())
                                                .count(NumberRange.IntRange.exactly(item.getNb()))
                                                .build());
                                    }
                                    case BLOCK -> {
                                        items.add(ItemPredicate.Builder.create()
                                                .items(itemLookup, ModBlocks.BLOCKS.get(item.getItem()))
                                                .count(NumberRange.IntRange.exactly(item.getNb()))
                                                .build());
                                    }
                                }
                            });
                            builder.criterion("criterion", InventoryChangedCriterion.Conditions.items(items.toArray(new ItemPredicate[0])));
                        }
                        case FORGE_CRAFTING -> {
                            List<String> criterion = new ArrayList<>();
                            advancement.getItems().forEach((item) -> {
                                if (item.getType() == InstanceType.RECIPE) {
                                    builder.criterion("criterion_recipe_" + item.getItem(),
                                            new AdvancementCriterion<>(ModCriteria.FORGE_STELLAIRE_USED,
                                                    ModCriteria.FORGE_STELLAIRE_USED.create(Identifier.of(Stellamecanics.MOD_ID, item.getItem())))
                                    );
                                    criterion.add("criterion_recipe_" + item.getItem());
                                }
                            });
                            if (!criterion.isEmpty()) builder.requirements(AdvancementRequirements.anyOf(criterion));
                        }
                        case CRAFTING, NONE, DURABILITY -> { builder.criterion("tick", TickCriterion.Conditions.createTick()); }
                    }

            if (advancement.getParent() != null) {
                builder.parent(Identifier.of(Stellamecanics.MOD_ID, advancement.getParent().getId()));
            }

            builder.build(exporter, Identifier.of(Stellamecanics.MOD_ID, id).toString());
        });
    }
}
