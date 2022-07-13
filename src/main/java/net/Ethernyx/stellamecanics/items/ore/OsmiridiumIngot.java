package net.Ethernyx.stellamecanics.items.ore;

import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.item.Item;
import net.Ethernyx.stellamecanics.utils.generator.ICommun;

import java.util.*;

public class OsmiridiumIngot extends Item  implements ICommun {
    private static final String id = "osmiridium_ingot";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Lingot de osmiridium"); put("en_us", "Osmiridium ingot");
    }};

    private AidInfoGenerator data;

    public OsmiridiumIngot() {
        super(new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        // block
        this.data.recipe.put("osmiridium_block",
                new RecipeBuilder(RecipeType.SHAPE,
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("osmiridium_ingot", InstanceType.ITEM, 1))),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("osmiridium_block", InstanceType.BLOCK, 1))),
                        new ArrayList<>(Arrays.asList("000", "000", "000")),
                        new ArrayList<>(Collections.singletonList(new RecipeIngredient("osmiridium_ingot", InstanceType.ITEM, 1)))));
        // tools
        this.data.recipe.put("osmiridium_tool", new RecipeBuilder(RecipeType.TOOLS,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("osmiridium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("osmiridium_axe", InstanceType.ITEM, 1),
                        new RecipeIngredient("osmiridium_hoe", InstanceType.ITEM, 1),
                        new RecipeIngredient("osmiridium_pickaxe", InstanceType.ITEM, 1),
                        new RecipeIngredient("osmiridium_shovel", InstanceType.ITEM, 1),
                        new RecipeIngredient("osmiridium_sword", InstanceType.ITEM, 1)))));
        // armures
        this.data.recipe.put("osmiridium_armor", new RecipeBuilder(RecipeType.ARMOR,
                new ArrayList<>(Collections.singletonList(new RecipeIngredient("osmiridium_ingot", InstanceType.ITEM, 1))),
                new ArrayList<>(Arrays.asList(new RecipeIngredient("osmiridium_boots", InstanceType.ITEM, 1),
                        new RecipeIngredient("osmiridium_chestplate", InstanceType.ITEM, 1),
                        new RecipeIngredient("osmiridium_helmet", InstanceType.ITEM, 1),
                        new RecipeIngredient("osmiridium_leggings", InstanceType.ITEM, 1)))));
    }
    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
