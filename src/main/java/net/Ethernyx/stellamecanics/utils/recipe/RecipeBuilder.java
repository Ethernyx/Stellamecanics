package net.Ethernyx.stellamecanics.utils.recipe;

import java.util.List;

public class RecipeBuilder {
    private final RecipeType type;
    private final List<RecipeIngredient> input;
    private final List<RecipeIngredient> output;
    private final List<String> pattern;
    private final List<RecipeIngredient> unlock;

    public RecipeBuilder(RecipeType type, List<RecipeIngredient> input, List<RecipeIngredient> output) {
        this.type = type;
        this.input = input;
        this.output = output;
        this.unlock = null;
        this.pattern = null;
    }

    public RecipeBuilder(RecipeType type,List<RecipeIngredient> input, List<RecipeIngredient> output, List<String> pattern, List<RecipeIngredient> unlock) {
        this.type = type;
        this.input = input;
        this.output = output;
        this.unlock = unlock;
        this.pattern = pattern;
    }

    public RecipeType getType() {
        return type;
    }

    public List<RecipeIngredient> getInput() {
        return input;
    }

    public List<RecipeIngredient> getOutput() {
        return output;
    }

    public List<String> getPattern() {
        return pattern;
    }

    public List<RecipeIngredient> getUnlock() {
        return unlock;
    }
}
