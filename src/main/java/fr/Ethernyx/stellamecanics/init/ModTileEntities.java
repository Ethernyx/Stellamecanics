package fr.Ethernyx.stellamecanics.init;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.tileentity.ForgeStellaireTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES= DeferredRegister
            .create(ForgeRegistries.TILE_ENTITIES, Main.MOD_ID);

    public static final RegistryObject<TileEntityType<ForgeStellaireTileEntity>> FORGE_STELLAIRE_TILE_ENTITY = TILE_ENTITIES
            .register("forge_stellaire",
                    () -> TileEntityType.Builder.of(ForgeStellaireTileEntity::new, ModBlocks.FORGE_STELLAIRE.get()).build(null));
}
