package fr.ethernyx.stellamecanics.datagen;

import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


public class LangGenerator implements DataProvider {
    private static final Logger LOGGER = LogUtils.getLogger();
    public Map<String, JsonObject> jsonLang = new HashMap<>();
    final DataOutput.PathResolver langsPathResolver;
    CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup;
    private final List<String> languages = new ArrayList<>();
    FabricDataOutput dataOutput;

    public LangGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        this.langsPathResolver = dataOutput.getResolver( DataOutput.OutputType.RESOURCE_PACK, "lang");
        this.registryLookup = registryLookup;
        this.dataOutput = dataOutput;
        languages.add("fr_fr");
        languages.add("en_us");
    }

    protected void addTranslations() {

        languages.forEach((lang) -> {
            jsonLang.put(lang, new JsonObject());
            if (!ModBlocks.BLOCKS.isEmpty()) {
                ModBlocks.BLOCKS.forEach((key, block) -> {
                    jsonLang.get(lang).addProperty("block." + Stellamecanics.MOD_ID + "." + key, block.getTranslate(lang));
                });
            }

            if (!ModItems.ITEMS.isEmpty()) {
                ModItems.ITEMS.forEach((key, item) -> {
                    jsonLang.get(lang).addProperty("item." + Stellamecanics.MOD_ID + "." + key, item.getTranslate(lang));
                });
            }

            jsonLang.get(lang).addProperty("itemgroup." + Stellamecanics.MOD_ID  +".stellamecanics_tab", "Stellamecanics");
        });
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        addTranslations();
        languages.forEach((lang) -> {
            System.out.print(langsPathResolver.resolveJson(Identifier.tryParse(Stellamecanics.MOD_ID + ":" + lang)));
            DataProvider.writeToPath(writer, jsonLang.get(lang), langsPathResolver.resolveJson(Identifier.tryParse(Stellamecanics.MOD_ID + ":" + lang)));
        });
        return null;
    }



    @Override
    public String getName() {
        return "Language ";
    }
}
