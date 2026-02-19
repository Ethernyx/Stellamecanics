package fr.ethernyx.stellamecanics;

import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui.ForgeStellaireScreen;
import fr.ethernyx.stellamecanics.init.*;
import fr.ethernyx.stellamecanics.world.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stellamecanics implements ModInitializer {
	public static final String MOD_ID = "stellamecanics";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemsGroups.registerItemsGroups();
		ModTags.registerModTags();
		ModFluids.registerModFluids();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerModBlockEntities();

		ModWorldGeneration.generateOres();
		ModScreenHandlers.registerScreenHandlers();

		ModRecipeSerealizers.registerRecipeSerealizers();
		ModRecipeTypes.registerRecipeTypes();

	}
}