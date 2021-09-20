package fr.Ethernyx.stellamecanics.utils.generator;

import fr.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;

import java.util.HashMap;
import java.util.Map;

public class AidInfoGenerator {
    protected final String id;
    protected final String modelType;
    protected final InstanceType type;
    protected final Map<String, String> translate;
    public Map<String, RecipeBuilder> recipe = new HashMap<>();

    public AidInfoGenerator(String id, String modelType, Map<String, String> translate, InstanceType type) {
        this.id = id;
        this.modelType = modelType;
        this.translate = translate;
        this.type = type;
    }

    public String getId() {
        return this.id;
    }
    public String getModelType() {
        return this.modelType;
    }

    public InstanceType getType() {
        return this.type;
    }

    public String getTranslate(String lang) {
        return this.translate.get(lang);
    }

    public Map<String, RecipeBuilder> getRecipe() {
        return this.recipe;
    }
}
