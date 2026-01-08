package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        if (!ModItems.ITEMS.isEmpty()) {
            ModItems.ITEMS.forEach((key, item) -> {
                if (!item.getTags().isEmpty()) {
                    item.getTags().forEach((tag) -> {
                        valueLookupBuilder(tag).add((Item) item);
                    });
                }
            });
        }
    }
}
