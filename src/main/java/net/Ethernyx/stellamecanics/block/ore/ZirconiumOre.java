package net.Ethernyx.stellamecanics.block.ore;

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ZirconiumOre extends Block implements ICommun {
    private static final String id = "zirconium_ore";
    private final String modelType = "simpleblock";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Minerai de zirconium"); put("en_us", "Zirconium ore");
    }};

    private AidInfoGenerator data;

    public ZirconiumOre() {
        super(FabricBlockSettings.of(Material.STONE).strength(3f, 15f).requiresTool().breakInstantly());
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.BLOCK);
        this.data.recipe.put("ore_to_zirconium_ingot", new RecipeBuilder(RecipeType.ORE,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("zirconium_ore", InstanceType.BLOCK, 1))),
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("zirconium_ingot", InstanceType.ITEM, 1)))));
        this.data.setLootType(LootType.ORE, new RecipeIngredient("zirconium_raw", InstanceType.ITEM, 1));
    }
    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
