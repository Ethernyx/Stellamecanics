package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModItems;
import fr.ethernyx.stellamecanics.init.ModItemsGroups;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class LangUsGenerator extends FabricLanguageProvider {
    public LangUsGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us",  registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        String lang = "en_us";
        if (!ModBlocks.BLOCKS.isEmpty()) {
            ModBlocks.BLOCKS.forEach((key, block) -> {
                translationBuilder.add((Block) block, block.getTranslate(lang));
            });
        }

        if (!ModItems.ITEMS.isEmpty()) {
            ModItems.ITEMS.forEach((key, item) -> {
                translationBuilder.add((Item) item, item.getTranslate(lang));
            });
        }
        addText(translationBuilder, ModItemsGroups.STELLAMECANICS.getDisplayName(), "Stellamecanics");
    }

    private static void addText(@NotNull TranslationBuilder builder, @NotNull Text text, @NotNull String value) {
        if (text.getContent() instanceof TranslatableTextContent translatableTextContent) {
            builder.add(translatableTextContent.getKey(), value);
        } else {
            Stellamecanics.LOGGER.warn("Failed to add translation for text: {}", text.getString());
        }
    }
}
