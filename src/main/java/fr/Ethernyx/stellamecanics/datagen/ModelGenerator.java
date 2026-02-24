package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModFluids;
import fr.ethernyx.stellamecanics.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.ModelVariantOperator;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.AxisRotation;
import net.minecraft.util.math.Direction;

public class ModelGenerator extends FabricModelProvider {

    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator gen) {
        ModBlocks.BLOCKS.forEach((id, block) -> {
            if (block.getModelType() == Models.CUBE_ALL) {
                // Bloc simple → une seule texture sur toutes les faces
                gen.registerSimpleCubeAll((Block) block);
            } else if (block.getModelType() == Models.CUBE) {
                // Bloc avec 6 faces distinctes + orientation horizontale
                // Chemin attendu : assets/stellamecanics/textures/block/<id>/<id>_<face>.png
                String base = "block/" + block.getId() + "/" + block.getId();
                TextureMap textures = new TextureMap()
                        .put(TextureKey.TOP,    Identifier.of(Stellamecanics.MOD_ID, base + "_top"))
                        .put(TextureKey.BOTTOM, Identifier.of(Stellamecanics.MOD_ID, base + "_bottom"))
                        .put(TextureKey.NORTH,  Identifier.of(Stellamecanics.MOD_ID, base + "_north"))
                        .put(TextureKey.SOUTH,  Identifier.of(Stellamecanics.MOD_ID, base + "_south"))
                        .put(TextureKey.WEST,   Identifier.of(Stellamecanics.MOD_ID, base + "_west"))
                        .put(TextureKey.EAST,   Identifier.of(Stellamecanics.MOD_ID, base + "_east"));

                // upload() génère le JSON du modèle et retourne son Identifier
                Identifier modelId = block.getModelType().upload(
                        (Block) block, textures, gen.modelCollector
                );
                // Blockstate horizontal : on construit manuellement la map FACING → rotation Y
                // (équivalent interne de createBlockStateWithHorizontalRotation, qui est private)
                gen.blockStateCollector.accept(
                        VariantsBlockModelDefinitionCreator.of((Block) block).with(
                                BlockStateVariantMap.models(Properties.HORIZONTAL_FACING)
                                        .register(Direction.NORTH, BlockStateModelGenerator.createWeightedVariant(modelId)
                                                .apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R0)))
                                        .register(Direction.EAST, BlockStateModelGenerator.createWeightedVariant(modelId)
                                                .apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)))
                                        .register(Direction.SOUTH, BlockStateModelGenerator.createWeightedVariant(modelId)
                                                .apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)))
                                        .register(Direction.WEST, BlockStateModelGenerator.createWeightedVariant(modelId)
                                                .apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)))
                        ));
            }
        });

        ModFluids.FLUIDS.forEach((id, fluid) -> {
            BlockStateModelGenerator.createSingletonBlockState(
                    fluid.getBlock(),
                    BlockStateModelGenerator.createWeightedVariant(
                            ModelIds.getMinecraftNamespacedBlock("water")
                    )
            );
        });
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        ModItems.ITEMS.forEach((key, item) -> {
            itemModelGenerator.register((Item) item, item.getModelType());
        });
        ModFluids.FLUIDS.forEach((id, fluid) -> {
            itemModelGenerator.register(fluid.getBucket(), Models.GENERATED);
        });
    }
}