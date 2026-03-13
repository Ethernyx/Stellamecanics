package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModAdvancements;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.criterion.*;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

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
                            advancement.isHidden());

            // ── Gestion des conditions du criterion ──────────────────────────────────────────────────────────────────
            advancement.getCondition().apply(builder, lookup);

                        //case CRAFTING, NONE, DURABILITY -> { builder.criterion("tick", TickCriterion.Conditions.createTick()); }
            if (advancement.getParent() != null) {
                builder.parent(Identifier.of(Stellamecanics.MOD_ID, advancement.getParent().getId()));
            }

            builder.build(exporter, Identifier.of(Stellamecanics.MOD_ID, id).toString());
        });
    }
}
