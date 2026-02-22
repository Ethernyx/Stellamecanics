package fr.ethernyx.stellamecanics.utils.recipe;

import java.util.List;

public class RecipeBuilder {
    private final String recipeName;
    private final RecipeType type;
    private final List<MyIngredient> input;
    private final List<MyIngredient> fluid;
    private final List<MyIngredient> output;
    private final List<String> pattern;
    private final List<MyIngredient> unlock;

    public RecipeBuilder(String recipeName, RecipeType type, List<MyIngredient> input, List<MyIngredient> output) {
        this.recipeName = recipeName;
        this.type = type;
        this.input = input;
        this.output = output;
        this.unlock = null;
        this.pattern = null;
        this.fluid = null;
    }

    public RecipeBuilder(String recipeName, RecipeType type,List<MyIngredient> input, List<MyIngredient> output, List<String> pattern, List<MyIngredient> unlock) {
        this.recipeName = recipeName;
        this.type = type;
        this.input = input;
        this.output = output;
        this.unlock = unlock;
        this.pattern = pattern;
        this.fluid = null;
    }

    public RecipeBuilder(String recipeName, RecipeType type, List<MyIngredient> input1, List<MyIngredient> fluid, List<MyIngredient> output) {
        this.recipeName = recipeName;
        this.type = type;
        this.input = input1;
        this.output = output;
        this.unlock = null;
        this.pattern = null;
        this.fluid = fluid;
    }

    public String getRecipeName() { return recipeName; }

    public RecipeType getType() {
        return type;
    }

    public List<MyIngredient> getInput() {
        return input;
    }

    public List<MyIngredient> getOutput() {
        return output;
    }

    public List<String> getPattern() {
        return pattern;
    }

    public List<MyIngredient> getUnlock() {
        return unlock;
    }

    public List<MyIngredient> getFluid() { return fluid; }
}
