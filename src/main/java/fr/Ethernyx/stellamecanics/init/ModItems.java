package fr.Ethernyx.stellamecanics.init;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.utils.CustomArmorMaterials;
import fr.Ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

    public static final RegistryObject<Item> SOLARIUM_INGOT = ITEMS.register("solarium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> LUNARIUM_INGOT = ITEMS.register("lunarium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> STELLARIUM_INGOT = ITEMS.register("stellarium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> MAGNETITE_RAW = ITEMS.register("magnetite_raw", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_RAW = ITEMS.register("zirconium_raw", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_RAW = ITEMS.register("iridium_raw", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCALOY_INGOT = ITEMS.register("zircaloy_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> OSMIRIDIUM_INGOT = ITEMS.register("osmiridium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));

    public static final RegistryObject<Item> SOLARIUM_HELMET = ITEMS.register("solarium_helmet", () -> new ArmorItem(CustomArmorMaterials.SOLARIUM_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> SOLARIUM_CHESTPLATE = ITEMS.register("solarium_chestplate", () -> new ArmorItem(CustomArmorMaterials.SOLARIUM_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> SOLARIUM_LEGGINGS = ITEMS.register("solarium_leggings", () -> new ArmorItem(CustomArmorMaterials.SOLARIUM_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> SOLARIUM_BOOTS = ITEMS.register("solarium_boots", () -> new ArmorItem(CustomArmorMaterials.SOLARIUM_ARMOR, EquipmentSlotType.FEET, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> LUNARIUM_HELMET = ITEMS.register("lunarium_helmet", () -> new ArmorItem(CustomArmorMaterials.LUNARIUM_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> LUNARIUM_CHESTPLATE = ITEMS.register("lunarium_chestplate", () -> new ArmorItem(CustomArmorMaterials.LUNARIUM_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> LUNARIUM_LEGGINGS = ITEMS.register("lunarium_leggings", () -> new ArmorItem(CustomArmorMaterials.LUNARIUM_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> LUNARIUM_BOOTS = ITEMS.register("lunarium_boots", () -> new ArmorItem(CustomArmorMaterials.LUNARIUM_ARMOR, EquipmentSlotType.FEET, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> LUNARIUM_PICKAXE = ITEMS.register("lunarium_pickaxe", () -> new PickaxeItem(CustomItemTiers.LUNARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> LUNARIUM_SHOVEL = ITEMS.register("lunarium_shovel", () -> new ShovelItem(CustomItemTiers.LUNARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> LUNARIUM_AXE = ITEMS.register("lunarium_axe", () -> new AxeItem(CustomItemTiers.LUNARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> LUNARIUM_SWORD = ITEMS.register("lunarium_sword", () -> new SwordItem(CustomItemTiers.LUNARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> LUNARIUM_HOE = ITEMS.register("lunarium_hoe", () -> new HoeItem(CustomItemTiers.LUNARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> SOLARIUM_PICKAXE = ITEMS.register("solarium_pickaxe", () -> new PickaxeItem(CustomItemTiers.SOLARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> SOLARIUM_SHOVEL = ITEMS.register("solarium_shovel", () -> new ShovelItem(CustomItemTiers.SOLARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> SOLARIUM_AXE = ITEMS.register("solarium_axe", () -> new AxeItem(CustomItemTiers.SOLARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> SOLARIUM_SWORD = ITEMS.register("solarium_sword", () -> new SwordItem(CustomItemTiers.SOLARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> SOLARIUM_HOE = ITEMS.register("solarium_hoe", () -> new HoeItem(CustomItemTiers.SOLARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));


}
