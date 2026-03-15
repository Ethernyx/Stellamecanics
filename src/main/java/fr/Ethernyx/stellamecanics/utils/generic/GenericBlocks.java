package fr.ethernyx.stellamecanics.utils.generic;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyBlock;
import fr.ethernyx.stellamecanics.utils.generator.LootType;
import fr.ethernyx.stellamecanics.utils.generator.MyLootTable;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GenericBlocks extends Block implements IMyBlock {
    private final String id;
    private final Map<String, String> translate;
    private final List<TagKey<Block>> tags;
    private final List<RecipeBuilder> recipes;
    private final MyLootTable lootTable;

    public GenericBlocks(String id, MyLootTable lootTable,Map<String, String> translate, List<TagKey<Block>> tags, List<RecipeBuilder> recipes, float hardness, float resistance, boolean requiresTool) {
        super(buildSettings(id, hardness, resistance, requiresTool));
        this.id = id;
        this.translate = translate;
        this.tags = tags == null ? List.of() : tags;
        this.recipes = recipes == null ? List.of() : recipes;
        this.lootTable = lootTable;
    }

    private static Settings buildSettings(String id, float hardness, float resistance, boolean requiresTool) {
        Settings settings = Settings.create()
                .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Stellamecanics.MOD_ID, id)))
                .strength(hardness, resistance);
        if (requiresTool) settings = settings.requiresTool();
        return settings;
    }

    @Override public String getId() { return id; }
    @Override public String getTranslate(String lang) { return translate.get(lang); }
    @Override public List<TagKey<Block>> getTags() { return tags; }
    @Override public List<RecipeBuilder> getRecipe() { return recipes; }
    @Override public MyLootTable getLootTable() { return lootTable; }

    public static class Builder {
        private final String id;
        private final Map<String, String> translate = new LinkedHashMap<>();
        private final List<TagKey<Block>> tags = new ArrayList<>();
        private final List<RecipeBuilder> recipes = new ArrayList<>();
        private MyLootTable lootTable = new MyLootTable(LootType.NONE);
        private float hardness = 3f;
        private float resistance = 15f;
        private boolean requiresTool = true;

        private Builder(String id) { this.id = id; }

        public Builder addTranslate(String key, Object value) {
            translate.put(key, String.valueOf(value));
            return this;
        }

        public Builder addTag(TagKey<Block> tag) {
            tags.add(tag);
            return this;
        }

        public Builder addRecipe(RecipeBuilder recipe) {
            recipes.add(recipe);
            return this;
        }

        public Builder lootTable(MyLootTable lootTable) {
            this.lootTable = lootTable;
            return this;
        }

        public Builder hardness(float hardness) {
            this.hardness = hardness;
            return this;
        }

        public Builder resistance(float resistance) {
            this.resistance = resistance;
            return this;
        }

        public Builder notrequiresTool() {
            this.requiresTool = false;
            return this;
        }

        public GenericBlocks build() {
            if (id == null || id.isBlank()) throw new IllegalArgumentException("id must not be empty");
            if (translate.isEmpty()) throw new IllegalStateException("au moins une traduction est requise");
            return new GenericBlocks(id, lootTable, translate, tags, recipes, hardness, resistance, requiresTool);
        }
    }

    public static Builder builder(String id) { return new Builder(id); }
}
