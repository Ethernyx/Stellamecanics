package fr.Ethernyx.stellamecanics.block.ore;

import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import java.util.*;

public class MagnetiteOre extends Block implements ICommun {
    private final String id = "magnetite_ore";
    private final String modelType = "simpleblock";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Minerai de magnétite"); put("en_us", "Magnetite ore");
    }};

    private AidInfoGenerator data;

    public MagnetiteOre() {
        super(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops());
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.BLOCK);
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
