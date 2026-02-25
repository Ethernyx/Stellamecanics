package fr.ethernyx.stellamecanics.compatibility.rei.forgeStellaire;

import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.recipe.RecipeEntry;

import java.util.List;

public class ForgeStellaireDisplay extends BasicDisplay {
    public ForgeStellaireDisplay(RecipeEntry<ForgeStellaireRecipe> recipe) {
        super(List.of(EntryIngredients.ofIngredient(recipe.value().getIngredients().get(0))),
                List.of(EntryIngredient.of(EntryStacks.of(recipe.value().result(null)))));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return ForgeStellaireCategory.FORGE_STELLAIRE;
    }
}
