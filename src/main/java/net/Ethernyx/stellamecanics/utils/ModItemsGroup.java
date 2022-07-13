package net.Ethernyx.stellamecanics.utils;

import net.Ethernyx.stellamecanics.Main;
import net.Ethernyx.stellamecanics.init.ModItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemsGroup {
    public static final ItemGroup STELLAMECANICS = FabricItemGroupBuilder.build(new Identifier(Main.MOD_ID, "stellamecanics_tab"), () -> new ItemStack(ModItems.ITEMS.get("stellarium_ingot").item));
}
