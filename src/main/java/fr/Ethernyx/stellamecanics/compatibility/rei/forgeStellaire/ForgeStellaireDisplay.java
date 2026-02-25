package fr.ethernyx.stellamecanics.compatibility.rei.forgeStellaire;

import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.fluid.Fluid;
import net.minecraft.recipe.RecipeEntry;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ForgeStellaireDisplay extends BasicDisplay {
    private final Fluid fluid;
    private final long fluidAmount;

    public ForgeStellaireDisplay(RecipeEntry<ForgeStellaireRecipe> recipe) {
        super(List.of(EntryIngredients.ofIngredient(recipe.value().getIngredientPlacement().getIngredients().get(0))),
                List.of(EntryIngredient.of(EntryStacks.of(recipe.value().result()))));
        fluid = recipe.value().fluid();
        fluidAmount = recipe.value().fluidAmount();
    }

    public Fluid getFluid() { return fluid; }
    public long getFluidAmount() { return fluidAmount; }

    @Override public CategoryIdentifier<?> getCategoryIdentifier() { return ForgeStellaireCategory.FORGE_STELLAIRE; }

    @Override public @Nullable DisplaySerializer<? extends Display> getSerializer() { return null; }
}
