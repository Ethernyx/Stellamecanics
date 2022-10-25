package net.Ethernyx.stellamecanics.utils.generator;

import net.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.Ethernyx.stellamecanics.utils.recipe.RecipeIngredient;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;

import java.util.*;

public class AidInfoGenerator {
    protected final String id;
    protected final String modelType;
    protected final InstanceType type;
    protected final Map<String, String> translate;
    protected boolean hasScreen = false;
    public Map<String, RecipeBuilder> recipe = new HashMap<>();
    protected LootType lootType = LootType.NORMAL;
    protected RecipeIngredient lootOutput = null;
    protected List<TagKey<Block>> BlockTags = new ArrayList<>();

    public AidInfoGenerator(String id, String modelType, Map<String, String> translate, InstanceType type) {
        this.id = id;
        this.modelType = modelType;
        this.translate = translate;
        this.type = type;
    }

    public void setHasScreen(boolean hasScreen) { this.hasScreen = hasScreen; }

    public LootType getLootType() { return lootType; }

    public void setLootType(LootType lootType) { this.lootType = lootType; }
    public void setLootType(LootType lootType, RecipeIngredient output) { this.lootType = lootType; this.lootOutput = output; }

    public RecipeIngredient getLootOutput() { return lootOutput; }

    public String getId() {
        return this.id;
    }

    public String getModelType() {
        return this.modelType;
    }

    public boolean hasScreen() { return this.hasScreen;}

    public InstanceType getType() {
        return this.type;
    }

    public String getTranslate(String lang) {
        return this.translate.get(lang);
    }

    public Map<String, RecipeBuilder> getRecipe() {
        return this.recipe;
    }

    public void addTag(TagKey<Block> tag) {
        this.BlockTags.add(tag);
    }

    public int removeTag(TagKey<Block> tag) {
        for (int i = 0; i < this.BlockTags.size(); i++) {
            if (Objects.equals(this.BlockTags.get(i), tag)) { this.BlockTags.remove(i); return 0; }
        }
        return 1;
    }

    public List<TagKey<Block>> getTags() { return this.BlockTags; }


}
