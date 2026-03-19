package fr.ethernyx.stellamecanics.utils.recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeBuilder {
    private final String recipeName;
    private final RecipeType type;
    private final List<MyIngredient> input;
    private final List<MyIngredient> fluid;
    private final List<MyIngredient> output;
    private final List<String> pattern;
    private final List<MyIngredient> unlock;

    public RecipeBuilder(String recipeName, RecipeType type, List<MyIngredient> input, List<MyIngredient> fluid, List<MyIngredient> output, List<String> pattern, List<MyIngredient> unlock) {
        this.recipeName = recipeName;
        this.type = type;
        this.input = input;
        this.fluid = fluid;
        this.output = output;
        this.unlock = unlock;
        this.pattern = pattern;
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

    public static class Builder {
        private final String recipeName;
        private final RecipeType type;
        private final List<MyIngredient> input = new ArrayList<>();
        private final List<MyIngredient> fluid = new ArrayList<>();
        private final List<MyIngredient> output = new ArrayList<>();
        private final List<String> pattern = new ArrayList<>();
        private final List<MyIngredient> unlock = new ArrayList<>();

        private Builder(String recipeName, RecipeType type) {
            this.recipeName = recipeName;
            this.type = type;
        }

        public Builder addInput(MyIngredient ingredient) {
            this.input.add(ingredient);
            return this;
        }

        public Builder inputs(List<MyIngredient> ingredients) {
            this.input.addAll(ingredients);
            return this;
        }

        public Builder addOutput(MyIngredient ingredient) {
            this.output.add(ingredient);
            return this;
        }

        public Builder outputs(List<MyIngredient> ingredients) {
            this.output.addAll(ingredients);
            return this;
        }

        public Builder pattern(List<String> pattern) {
            this.pattern.addAll(pattern);
            return this;
        }

        public Builder addFluid(MyIngredient ingredient) {
            this.fluid.add(ingredient);
            return this;
        }

        public Builder unlock(MyIngredient ingredient) {
            this.unlock.add(ingredient);
            return this;
        }

        public RecipeBuilder build() {
            if (recipeName == null || recipeName.isBlank()) throw new IllegalArgumentException("recipeName must not be empty");
            if (input.isEmpty()) throw new IllegalArgumentException("input must not be empty");
            if (output.isEmpty()) throw new IllegalArgumentException("output must not be empty");

            switch (type) {
                case SHAPE -> {
                    if (pattern.isEmpty())
                        throw new IllegalArgumentException("SHAPE : pattern must not be empty");
                    if (unlock.isEmpty())
                        throw new IllegalArgumentException("SHAPE : unlock must not be empty");
                    long distinctChars = pattern.stream()
                            .flatMapToInt(String::chars)
                            .filter(c -> c != ' ')
                            .distinct()
                            .count();
                    if (input.size() != distinctChars)
                        throw new IllegalArgumentException(
                                "SHAPE : " + input.size() + " input(s) fournis mais le pattern attend "
                                        + distinctChars + " caractère(s) distinct(s)");
                }
                case FORGE -> { if (fluid.isEmpty()) throw new IllegalArgumentException("FORGE : fluid must not be empty"); }
                case TOOLS -> { if (output.size() < 5) throw new IllegalArgumentException("TOOLS : output must have 5 items (axe, hoe, pickaxe, shovel, sword)"); }
                case ARMOR -> { if (output.size() < 4) throw new IllegalArgumentException("ARMOR : output must have 4 items (boots, chestplate, helmet, leggings)"); }
                case SMITH -> { if (input.size() < 2) throw new IllegalArgumentException("SMITH : input must have 2 items"); }
                case ORE, SHAPELLESS, SMELT, BLAST -> { }
            }
            return new RecipeBuilder(recipeName, type, input, fluid, output, pattern, unlock);
        }
    }

    public static Builder builder(String recipeName, RecipeType type) { return new Builder(recipeName, type); }
}
