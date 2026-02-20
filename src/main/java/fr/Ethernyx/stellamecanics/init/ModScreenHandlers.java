package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui.ForgeStellaireScreenHandler;
import fr.ethernyx.stellamecanics.network.BlockPosPayload;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ModScreenHandlers {
    public static final Map<String, Map<String, String>> GUI_TRANSLATIONS = new HashMap<>();

    public static final ScreenHandlerType<ForgeStellaireScreenHandler> FORGE_STELLAIRE = addNewHandler(
            "forge_stellaire",
            Map.of("fr_fr", "Forge Stellaire", "en_us", "Stellar Forge"),
            new ExtendedScreenHandlerType<>(ForgeStellaireScreenHandler::new, BlockPosPayload.PACKET_CODEC)
    );

    private static <T extends ScreenHandler> ScreenHandlerType<T> addNewHandler(
            String id, Map<String, String> translations, ScreenHandlerType<T> type) {
        GUI_TRANSLATIONS.put("container." + Stellamecanics.MOD_ID + "." + id, translations);
        return Registry.register(Registries.SCREEN_HANDLER,
                Identifier.of(Stellamecanics.MOD_ID, id), type);
    }

    public static void registerScreenHandlers() {
        Stellamecanics.LOGGER.info("Registering Screen Handlers for " + Stellamecanics.MOD_ID);
    }
}
