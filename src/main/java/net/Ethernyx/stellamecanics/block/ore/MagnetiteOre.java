package net.Ethernyx.stellamecanics.block.ore;

import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.ICommun;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.Ethernyx.stellamecanics.utils.generator.LootType;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.tag.BlockTags;

import java.util.HashMap;
import java.util.Map;

public class MagnetiteOre extends Block implements ICommun {
    private static final String id = "magnetite_ore";
    private final String modelType = "simpleblock";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Minerai de magnétite"); put("en_us", "Magnetite ore");
    }};

    private AidInfoGenerator data;

    public MagnetiteOre() {
        super(FabricBlockSettings.of(Material.STONE).strength(3f, 15f).requiresTool());
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.BLOCK);
        this.data.setLootType(LootType.LUCKY_ORE, new RecipeIngredient("magnetite_raw", InstanceType.ITEM, 3));
        this.data.addTag(BlockTags.PICKAXE_MINEABLE);
        this.data.addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
