package fr.ethernyx.stellamecanics.utils.recipe;

import fr.ethernyx.stellamecanics.utils.generator.InstanceType;

public class MyIngredient {
    private final String name;
    private final int nb;
    private final InstanceType type;

    public MyIngredient(String name, InstanceType type, int nb) {
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
