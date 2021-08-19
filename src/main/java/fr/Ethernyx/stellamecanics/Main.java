package fr.Ethernyx.stellamecanics;

import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModFluids;
import fr.Ethernyx.stellamecanics.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "stellamecanics";

    public  Main() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        //ModTileEntities.TILE_ENTITIES.register(bus);
        //ModEnchantments.ENCHANTMENTS.register(bus);
        ModFluids.FLUIDS.register(bus);
    }
    private void setup(FMLCommonSetupEvent e) {
        /*ModFeatures features = new ModFeatures();
        features.init();
        MinecraftForge.EVENT_BUS.register(features);*/
    }

    private void clientSetup(FMLClientSetupEvent e) {

    }
}
