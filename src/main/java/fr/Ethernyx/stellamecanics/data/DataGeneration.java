package fr.Ethernyx.stellamecanics.data;

import fr.Ethernyx.stellamecanics.data.lang.LangGenerator;
import fr.Ethernyx.stellamecanics.data.recipe.RecipeGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import fr.Ethernyx.stellamecanics.Main;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {
    public DataGeneration() {}

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent e) {
        DataGenerator generator = e.getGenerator();
        if (e.includeServer()) {
            generator.addProvider(new RecipeGenerator(generator));
            generator.addProvider(new LangGenerator(generator, Main.MOD_ID, "en_us"));
            generator.addProvider(new LangGenerator(generator, Main.MOD_ID, "fr_fr"));
        }
    }
}
