package fr.Ethernyx.stellamecanics.utils;

import fr.Ethernyx.stellamecanics.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {
    public static final ItemGroup STELLAMECANICS_TAB = new ItemGroup("stellamecanics_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.STELLARIUM_INGOT.get());
        }
    };
}
