package fr.Ethernyx.stellamecanics.block.tileentity;

import fr.Ethernyx.stellamecanics.init.ModTileEntities;
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.HashMap;
import java.util.Map;

public class ForgeStellaireBlock extends Block implements ICommun {
    private final String id = "forge_stellaire";
    private final String modelType = "simpleblock";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Forge Stellaire"); put("en_us", "Stellaire forge");
    }};

    private AidInfoGenerator data;

    public ForgeStellaireBlock() {
        super(AbstractBlock.Properties.of(Material.HEAVY_METAL).strength(3f, 15f).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.BLOCK);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.FORGE_STELLAIRE_TILE_ENTITY.get().create();
    }

    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }

}
