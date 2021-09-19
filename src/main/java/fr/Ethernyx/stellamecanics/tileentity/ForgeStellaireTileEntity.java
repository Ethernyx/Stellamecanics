package fr.Ethernyx.stellamecanics.tileentity;

import fr.Ethernyx.stellamecanics.init.ModTileEntities;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ForgeStellaireTileEntity extends TileEntity implements ITickableTileEntity {
    public ForgeStellaireTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ForgeStellaireTileEntity() {
        this(ModTileEntities.FORGE_STELLAIRE_TILE_ENTITY.get());
    }

    @Override
    public void tick() {
    }
}
