package net.Ethernyx.stellamecanics.block;

import net.Ethernyx.stellamecanics.init.ModTags;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.ICommun;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.Ethernyx.stellamecanics.utils.generator.LootType;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.tag.BlockTags;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StellariumBlock extends Block implements ICommun {
    private static final String id = "stellarium_block";
    private final String modelType = "simpleblock";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Bloc de stellarium"); put("en_us", "Stellarium block");
    }};

    private AidInfoGenerator data;

    public StellariumBlock() {
        super(FabricBlockSettings.of(Material.METAL).strength(3f, 15f).requiresTool());
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.BLOCK);

        this.data.recipe.put("stellarium_ingot", new RecipeBuilder(RecipeType.SHAPELLESS,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("stellarium_block", InstanceType.BLOCK, 1))),
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("stellarium_ingot", InstanceType.ITEM, 9)))));
        this.data.setLootType(LootType.NORMAL);
        this.data.addTag(BlockTags.PICKAXE_MINEABLE);
        this.data.addTag(ModTags.NEEDS_TOOL_LEVEL_6);
    }
    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
