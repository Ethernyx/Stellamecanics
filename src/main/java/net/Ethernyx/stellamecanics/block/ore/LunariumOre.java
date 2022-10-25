package net.Ethernyx.stellamecanics.block.ore;

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

public class LunariumOre extends Block implements ICommun {
    private static final String id = "lunarium_ore";
    private final String modelType = "simpleblock";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Minerai de lunarium"); put("en_us", "Lunarium ore");
    }};
    private AidInfoGenerator data;

    public LunariumOre() {
        super(FabricBlockSettings.of(Material.STONE).strength(3f, 15f).requiresTool());
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.BLOCK);
        this.data.recipe.put("ore_to_lunarium_ingot", new RecipeBuilder(RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("lunarium_ore", InstanceType.BLOCK, 1))),
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("lunarium_ingot", InstanceType.ITEM, 1)))));
        this.data.setLootType(LootType.ORE, new RecipeIngredient("lunarium_raw", InstanceType.ITEM, 1));
        this.data.addTag(BlockTags.PICKAXE_MINEABLE);
        this.data.addTag(ModTags.NEEDS_TOOL_LEVEL_4);
    }
    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
