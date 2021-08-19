package fr.Ethernyx.stellamecanics.init;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

    public static final RegistryObject<Item> SOLARIUM_INGOT = ITEMS.register("solarium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> LUNARIUM_INGOT = ITEMS.register("lunarium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> STELLARIUM_INGOT = ITEMS.register("stellarium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> MAGNETITE_RAW = ITEMS.register("magnetite_raw", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCALOY_INGOT = ITEMS.register("zircaloy_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> OSMIRIDIUM_INGOT = ITEMS.register("osmiridium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
}
