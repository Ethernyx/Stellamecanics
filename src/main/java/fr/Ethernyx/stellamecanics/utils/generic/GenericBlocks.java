package fr.ethernyx.stellamecanics.utils.generic;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyBlock;
import fr.ethernyx.stellamecanics.utils.generator.MyLootTable;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.minecraft.block.Block;
import net.minecraft.client.data.Model;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class GenericBlocks extends Block implements IMyBlock {
    private final String id;
    private final Map<String, String> translate;
    private final List<TagKey<Block>> tags;
    private final List<RecipeBuilder> recipes;
    private final MyLootTable lootTable;

    public GenericBlocks(String id, MyLootTable lootTable,Map<String, String> translate, List<TagKey<Block>> tags, List<RecipeBuilder> recipes) {
        super(Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                Identifier.of(Stellamecanics.MOD_ID, id))).strength(3f, 15f).requiresTool());
        this.id = id;
        this.translate = translate;
        this.tags = tags == null ? List.of() : tags;
        this.recipes = recipes == null ? List.of() : recipes;
        this.lootTable = lootTable;
    }

    @Override public String getId() { return id; }
    @Override public String getTranslate(String lang) { return translate.get(lang); }
    @Override public List<TagKey<Block>> getTags() { return tags; }
    @Override public List<RecipeBuilder> getRecipe() { return recipes; }
    @Override public MyLootTable getLootTable() { return lootTable; }
}
