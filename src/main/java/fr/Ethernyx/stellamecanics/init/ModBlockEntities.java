package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.ForgeStellaireEntity;
import fr.ethernyx.stellamecanics.interfaces.IMyBlock;
import fr.ethernyx.stellamecanics.interfaces.IMyBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ModBlockEntities {
    public static BlockEntityType<ForgeStellaireEntity> FORGE_STELLAIRE = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(Stellamecanics.MOD_ID, ForgeStellaireEntity.ID),
            FabricBlockEntityTypeBuilder.create(
                    ForgeStellaireEntity::new,
                    (Block) ModBlocks.BLOCKS.get(ForgeStellaireEntity.IDBLOCK)
            ).build()
    );

    public static void registerModBlockEntities() {
        Stellamecanics.LOGGER.debug("Registering Mod Block Entities for " + Stellamecanics.MOD_ID);
        ForgeStellaireEntity.registerStorages();
    }
}
