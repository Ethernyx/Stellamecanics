package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui.ForgeStellaireScreenHandler;
import fr.ethernyx.stellamecanics.network.BlockPosPayload;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<ForgeStellaireScreenHandler> FORGE_STELLAIRE = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of(Stellamecanics.MOD_ID, "forge_stellaire"),
            new ExtendedScreenHandlerType<>(ForgeStellaireScreenHandler::new, BlockPosPayload.PACKET_CODEC)
    );

    public static void registerScreenHandlers() {
        Stellamecanics.LOGGER.info("Registering Screen Handlers for " + Stellamecanics.MOD_ID);
    }
}
