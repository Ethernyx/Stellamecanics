package fr.Ethernyx.stellamecanics.block;

import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SolariumBlock extends Block implements ICommun {
    private final String id = "solarium_block";
    private final String modelType = "simpleblock";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Bloc de solarium"); put("en_us", "Solarium block");
    }};

    private AidInfoGenerator data;

    public SolariumBlock() {
        super(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.BLOCK);

        this.data.recipe.put("solarium_ingot", new RecipeBuilder(RecipeType.SHAPELLESS,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("solarium_block", InstanceType.BLOCK, 1))),
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("solarium_ingot", InstanceType.ITEM, 9)))));
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
