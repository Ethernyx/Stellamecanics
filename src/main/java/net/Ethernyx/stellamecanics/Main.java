package net.Ethernyx.stellamecanics;

import net.Ethernyx.stellamecanics.init.ModBlocks;
import net.Ethernyx.stellamecanics.init.ModItems;
import net.Ethernyx.stellamecanics.init.ModTags;
import net.Ethernyx.stellamecanics.world.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public static final String MOD_ID = "stellamecanics";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModTags.registerModTags();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateOres();
	}
}
