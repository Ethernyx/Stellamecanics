package fr.Ethernyx.stellamecanics.utils.recipe;

import net.minecraft.util.IItemProvider;

public class RecipeIngredient {
    private final IItemProvider item;
    private final int nb;

    public RecipeIngredient(IItemProvider item, int nb) {
        this.item = item;
        this.nb = nb;
    }

    public IItemProvider getItem() {
        return item;
    }

    public int getNb() {
        return nb;
    }
}
