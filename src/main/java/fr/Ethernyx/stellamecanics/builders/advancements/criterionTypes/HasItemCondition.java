package fr.ethernyx.stellamecanics.builders.advancements.criterionTypes;

import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModItems;
import fr.ethernyx.stellamecanics.interfaces.IMyAdvancementCondition;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Item;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public record HasItemCondition(List<MyIngredient> items) implements IMyAdvancementCondition {
    @Override
    public void apply(Advancement.Builder builder, RegistryWrapper.WrapperLookup lookup) {
        RegistryEntryLookup<Item> itemLookup = lookup.getOrThrow(RegistryKeys.ITEM);
        List<ItemPredicate> array = new ArrayList<>();
        items.forEach((item) -> {
            switch (item.getType()) {
                case ITEM -> {
                    array.add(ItemPredicate.Builder.create()
                            .items(itemLookup, ModItems.ITEMS.get(item.getItem()).asItem())
                            .count(NumberRange.IntRange.atLeast(item.getNb()))
                            .build());
                }
                case BLOCK -> {
                    array.add(ItemPredicate.Builder.create()
                            .items(itemLookup, ModBlocks.BLOCKS.get(item.getItem()))
                            .count(NumberRange.IntRange.atLeast(item.getNb()))
                            .build());
                }
                case VANILLAITEM -> {
                    array.add(ItemPredicate.Builder.create()
                            .items(itemLookup, Registries.ITEM.get(Identifier.of("minecraft", item.getItem())))
                            .count(NumberRange.IntRange.atLeast(item.getNb()))
                            .build());
                }
                case VANILLABLOCK -> {
                    array.add(ItemPredicate.Builder.create()
                            .items(itemLookup, Registries.BLOCK.get(Identifier.of("minecraft", item.getItem())))
                            .count(NumberRange.IntRange.atLeast(item.getNb()))
                            .build());
                }
            }
        });
        builder.criterion("criterion", InventoryChangedCriterion.Conditions.items(array.toArray(new ItemPredicate[0])));
    }
}
