package fr.ethernyx.stellamecanics.utils.generator;

import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;

public class MyLootTable {
    private final LootType type;
    private MyIngredient output;

    public MyLootTable(LootType type) {
        this.type = type;
    }

    public MyLootTable(LootType type, MyIngredient output) {
        this.type = type;
        this.output = output;
    }

    public LootType getType() {
        return type;
    }

    public MyIngredient getOutput() {
        return output;
    }

}
