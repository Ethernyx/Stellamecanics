package net.Ethernyx.stellamecanics.utils.recipe;

import net.Ethernyx.stellamecanics.utils.generator.InstanceType;

public class RecipeIngredient {
    private final String name;
    private final int nb;
    private final InstanceType type;

    public RecipeIngredient(String name, InstanceType type, int nb) {
        this.name = name;
        this.nb = nb;
        this.type = type;
    }
    public InstanceType getType() { return type; }
    public String getItem() {
        return name;
    }
    public int getNb() {
        return nb;
    }
}
