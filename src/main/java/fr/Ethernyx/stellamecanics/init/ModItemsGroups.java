package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroups {

    public static final ItemGroup STELLAMECANICS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Stellamecanics.MOD_ID, "stellamecanics_tab"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.SOLARIUM_INGOT))
                    .displayName(Text.translatable("itemgroup.stellamecanics.stellamecanics_tab"))
                    .entries((displayContext, entries) -> {
                        ModItems.ITEMS.forEach((key, item) -> {
                            entries.add(item);
                        });
                        ModBlocks.BLOCKS.forEach((key, block) -> {
                            entries.add((ItemConvertible) block);
                        });
                        ModFluids.FLUIDS.forEach((key, fluid) -> {
                            entries.add(fluid.getBucket());
                        });
                    }).build());

    public static void registerItemsGroups() {
        Stellamecanics.LOGGER.info("Registering Items Groups for " + Stellamecanics.MOD_ID);
    }
}
