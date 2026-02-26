package fr.ethernyx.stellamecanics.compatibility.rei;

import fr.ethernyx.stellamecanics.block.entities.forgeStellaire.gui.ForgeStellaireScreen;
import fr.ethernyx.stellamecanics.builders.recipes.forgeStellaire.ForgeStellaireRecipe;
import fr.ethernyx.stellamecanics.compatibility.rei.forgeStellaire.ForgeStellaireCategory;
import fr.ethernyx.stellamecanics.compatibility.rei.forgeStellaire.ForgeStellaireDisplay;
import fr.ethernyx.stellamecanics.init.ModBlocks;
import fr.ethernyx.stellamecanics.init.ModRecipeTypes;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.display.DynamicDisplayGenerator;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.client.view.ViewSearchBuilder;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StellamecanicsREIClient implements REIClientPlugin {

    private List<ForgeStellaireDisplay> getAllDisplays() {
        MinecraftClient client = MinecraftClient.getInstance();
        Collection<RecipeEntry<ForgeStellaireRecipe>> recipes;

        if (client.getServer() != null) {
            recipes = client.getServer().getRecipeManager().getAllOfType(ModRecipeTypes.FORGE_STELLAIRE);
        } else {
            recipes = client.getNetworkHandler().getRecipeManager().getSynchronizedRecipes()
                    .getAllOfType(ModRecipeTypes.FORGE_STELLAIRE);
        }

        return recipes.stream().map(ForgeStellaireDisplay::new).collect(Collectors.toList());
    }

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new ForgeStellaireCategory());
        registry.addWorkstations(ForgeStellaireCategory.FORGE_STELLAIRE, EntryStacks.of(ModBlocks.FORGE_STELLAIRE));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerDisplayGenerator(
                ForgeStellaireCategory.FORGE_STELLAIRE,
                new DynamicDisplayGenerator<>() {
                    @Override
                    public Optional<List<ForgeStellaireDisplay>> getRecipeFor(EntryStack<?> entry) {
                        if (!(entry.getValue() instanceof ItemStack stack)) return Optional.empty();

                        List<ForgeStellaireDisplay> result = getAllDisplays().stream()
                                .filter(d -> {
                                    return ItemStack.areItemsEqual(d.getRecipe().result(), stack);
                                })
                                .collect(Collectors.toList());
                        return result.isEmpty() ? Optional.empty() : Optional.of(result);
                    }

                    @Override
                    public Optional<List<ForgeStellaireDisplay>> getUsageFor(EntryStack<?> entry) {
                        if (!entry.getType().equals(VanillaEntryTypes.ITEM)) return Optional.empty();
                        ItemStack stack = entry.castValue();

                        List<ForgeStellaireDisplay> result = getAllDisplays().stream()
                                .filter(d -> d.getRecipe().inputItem().test(stack))
                                .collect(Collectors.toList());

                        return result.isEmpty() ? Optional.empty() : Optional.of(result);
                    }

                    @Override
                    public Optional<List<ForgeStellaireDisplay>> generate(ViewSearchBuilder builder) {
                        if (!builder.getRecipesFor().isEmpty() || !builder.getUsagesFor().isEmpty()) {
                            return Optional.empty();
                        }
                        return Optional.of(getAllDisplays());
                    }
                }
        );


    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 186) / 2) + 30, 20, 25), ForgeStellaireScreen.class,
                ForgeStellaireCategory.FORGE_STELLAIRE);
    }
}
