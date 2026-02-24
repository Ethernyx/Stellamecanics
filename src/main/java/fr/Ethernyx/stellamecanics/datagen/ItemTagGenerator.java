package fr.ethernyx.stellamecanics.datagen;

import fr.ethernyx.stellamecanics.init.ModFluids;
import fr.ethernyx.stellamecanics.init.ModItems;
import fr.ethernyx.stellamecanics.init.ModTags;
import fr.ethernyx.stellamecanics.interfaces.IMyFlowingFluid;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        if (!ModTags.Items.ITEMTAGS.isEmpty()) {
            ModTags.Items.ITEMTAGS.forEach((name, tag) -> {
                tag.legacy().forEach((legacyTag) -> {
                    valueLookupBuilder(tag.getTag()).addTag(legacyTag);
                });
                valueLookupBuilder(tag.getTag()).setReplace(tag.isreplace());
            });
        }
        if (!ModItems.ITEMS.isEmpty()) {
            ModItems.ITEMS.forEach((key, item) -> {
                if (!item.getTags().isEmpty()) {
                    item.getTags().forEach((tag) -> {
                        valueLookupBuilder(tag).add((Item) item);
                    });
                }
            });
        }

        ModFluids.FLUIDS.forEach((key, fluid) -> {
            if (!((IMyFlowingFluid) fluid.getStill()).getBucketTag().isEmpty()) {
                ((IMyFlowingFluid) fluid.getStill()).getBucketTag().forEach((tag) -> {
                    valueLookupBuilder(tag).add(fluid.getBucket());
                });
            }
        });
    }
}
