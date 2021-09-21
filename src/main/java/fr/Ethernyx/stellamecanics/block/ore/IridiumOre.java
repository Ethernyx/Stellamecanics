package fr.Ethernyx.stellamecanics.block.ore;

import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
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

public class IridiumOre extends Block {
    private final String id = "iridium_ore";
    private final String modelType = "simpleblock";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Minerai de iridium"); put("en_us", "Iridium ore");
    }};

    private AidInfoGenerator data;

    public IridiumOre() {
        super(AbstractBlock.Properties.of(Material.STONE).strength(3f, 15f).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops());
    }

    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.BLOCK);
        this.data.recipe.put("ore_to_iridium_ingot", new RecipeBuilder(RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(ModBlocks.IRIDIUM_ORE.get())),
                new ArrayList<>(Collections.singletonList(new RecipeIngredient(ModItems.IRIDIUM_INGOT.get(), 1)))));
        return this.data;
    }

    public String getId() {
        return this.id;
    }
}