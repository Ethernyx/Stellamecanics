package fr.Ethernyx.stellamecanics.block;

import fr.Ethernyx.stellamecanics.init.ModTileEntities;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class ForgeStellaireBlock extends Block {
    public ForgeStellaireBlock() {
        super(AbstractBlock.Properties.of(Material.HEAVY_METAL).strength(3f, 15f).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.FORGE_STELLAIRE_TILE_ENTITY.get().create();
    }

}
