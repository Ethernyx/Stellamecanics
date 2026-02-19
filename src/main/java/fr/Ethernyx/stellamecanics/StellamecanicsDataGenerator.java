package fr.ethernyx.stellamecanics;

import fr.ethernyx.stellamecanics.datagen.*;
import fr.ethernyx.stellamecanics.world.ModWorldConfigsFeatures;
import fr.ethernyx.stellamecanics.world.ModWorldPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class StellamecanicsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BlockTagGenerator::new);
		pack.addProvider(ItemTagGenerator::new);
		pack.addProvider(FluidTagGenerator::new);
		pack.addProvider(LootTableGenerator::new);
		pack.addProvider(ModelGenerator::new);
		pack.addProvider(MyRecipeGenerator::new);
		pack.addProvider(WorldGenerator::new);
		pack.addProvider(LangUsGenerator::new);
		pack.addProvider(LangFrGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {

		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModWorldConfigsFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModWorldPlacedFeatures::bootstrap);
	}
}
