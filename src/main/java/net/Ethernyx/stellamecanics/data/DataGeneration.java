package net.Ethernyx.stellamecanics.data;

import net.Ethernyx.stellamecanics.data.lang.LangGenerator;
import net.Ethernyx.stellamecanics.data.lootTable.LootTableGenerator;
import net.Ethernyx.stellamecanics.data.model.ItemModelGenerator;
import net.Ethernyx.stellamecanics.data.recipe.RecipeGenerator;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.SerealizerGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import java.util.List;

public class DataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        List<AidInfoGenerator> aids = new SerealizerGenerator().getDatas();
        fabricDataGenerator.addProvider(new RecipeGenerator(fabricDataGenerator, aids));
        fabricDataGenerator.addProvider(new ItemModelGenerator(fabricDataGenerator, aids));
        fabricDataGenerator.addProvider(new LangGenerator(fabricDataGenerator, aids, "en_us"));
        fabricDataGenerator.addProvider(new LangGenerator(fabricDataGenerator, aids, "fr_fr"));
        fabricDataGenerator.addProvider(new LootTableGenerator(fabricDataGenerator, aids));
    }
}
