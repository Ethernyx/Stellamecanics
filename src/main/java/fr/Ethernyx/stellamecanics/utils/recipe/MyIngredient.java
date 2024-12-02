package fr.ethernyx.stellamecanics.utils.recipe;

import fr.ethernyx.stellamecanics.utils.generator.InstanceType;

public class MyIngredient {
    private final String name;
    private final int min;
    private final int max;
    private final InstanceType type;

    public MyIngredient(String name, InstanceType type, int nb) {
        this.name = name;
        this.type = type;
        this.max = nb;
        this.min = 1;
    }
    public MyIngredient(String name, InstanceType type, int min, int max) {
        this.name = name;
        this.type = type;
        this.max = max;
        this.min = min;
    }

    public InstanceType getType() { return type; }
    public String getItem() {
        return name;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getNb() {
        return max;
    }
}
