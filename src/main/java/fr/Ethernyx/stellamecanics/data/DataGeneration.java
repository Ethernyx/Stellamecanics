package fr.Ethernyx.stellamecanics.data;

import fr.Ethernyx.stellamecanics.data.lang.LangGenerator;
import fr.Ethernyx.stellamecanics.data.lootTable.LootTableGenerator;
import fr.Ethernyx.stellamecanics.data.model.BlockStatesGenerator;
import fr.Ethernyx.stellamecanics.data.model.ItemModelGenerator;
import fr.Ethernyx.stellamecanics.data.recipe.RecipeGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.SerealizerGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import fr.Ethernyx.stellamecanics.Main;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {
    public DataGeneration() {}

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        List<AidInfoGenerator> aids = new SerealizerGenerator().getDatas();

        if (e.includeClient())
        {
            ExistingFileHelper existingFileHelper = e.getExistingFileHelper();
            generator.addProvider(new BlockStatesGenerator(generator, Main.MOD_ID, existingFileHelper));
            generator.addProvider(new ItemModelGenerator(generator, existingFileHelper, aids));
            generator.addProvider(new LangGenerator(generator, Main.MOD_ID, "en_us", aids));
            generator.addProvider(new LangGenerator(generator, Main.MOD_ID, "fr_fr", aids));
        }
        if (e.includeServer()) {
            generator.addProvider(new LootTableGenerator(generator, aids));
            generator.addProvider(new RecipeGenerator(generator, aids));
        }
    }
}
