package fr.Ethernyx.stellamecanics.utils.recipe;

import net.minecraft.util.IItemProvider;

import java.util.List;

public class RecipeBuilder {
    private final RecipeType type;
    private final List<IItemProvider> input;
    private final List<RecipeIngredient> output;
    private final List<String> pattern;
    private final List<IItemProvider> unlock;

    public RecipeBuilder(RecipeType type, List<IItemProvider> input, List<RecipeIngredient> output) {
        this.type = type;
        this.input = input;
        this.output = output;
        this.unlock = null;
        this.pattern = null;
    }

    public RecipeBuilder(RecipeType type, List<IItemProvider> input, List<RecipeIngredient> output, List<String> pattern, List<IItemProvider> unlock) {
        this.type = type;
        this.input = input;
        this.output = output;
        this.unlock = unlock;
        this.pattern = pattern;
    }

    public RecipeType getType() {
        return type;
    }

    public List<IItemProvider> getInput() {
        return input;
    }

    public List<RecipeIngredient> getOutput() {
        return output;
    }

    public List<String> getPattern() {
        return pattern;
    }

    public List<IItemProvider> getUnlock() {
        return unlock;
    }
}
