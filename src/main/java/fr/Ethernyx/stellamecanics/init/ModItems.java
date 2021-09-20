package fr.Ethernyx.stellamecanics.init;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.item.LunariumIngot;
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
  /*  public static final RegistryObject<Item> LUNARIUM_INGOT = ITEMS.register("lunarium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));*/
    public static final  RegistryObject<Item> LUNARIUM_INGOT = ITEMS.register(new LunariumIngot().getId(), LunariumIngot::new);


    public static final RegistryObject<Item> STELLARIUM_INGOT = ITEMS.register("stellarium_ingot", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> MAGNETITE_RAW = ITEMS.register("magnetite_raw", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_RAW = ITEMS.register("zirconium_raw", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_RAW = ITEMS.register("iridium_raw", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> SOLARIUM_RAW = ITEMS.register("solarium_raw", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> LUNARIUM_RAW = ITEMS.register("lunarium_raw", () -> new Item(new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
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
    public static final RegistryObject<Item> STELLARIUM_HELMET = ITEMS.register("stellarium_helmet", () -> new ArmorItem(CustomArmorMaterials.STELLARIUM_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> STELLARIUM_CHESTPLATE = ITEMS.register("stellarium_chestplate", () -> new ArmorItem(CustomArmorMaterials.STELLARIUM_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> STELLARIUM_LEGGINGS = ITEMS.register("stellarium_leggings", () -> new ArmorItem(CustomArmorMaterials.STELLARIUM_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> STELLARIUM_BOOTS = ITEMS.register("stellarium_boots", () -> new ArmorItem(CustomArmorMaterials.STELLARIUM_ARMOR, EquipmentSlotType.FEET, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> STELLARIUM_PICKAXE = ITEMS.register("stellarium_pickaxe", () -> new PickaxeItem(CustomItemTiers.STELLARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> STELLARIUM_SHOVEL = ITEMS.register("stellarium_shovel", () -> new ShovelItem(CustomItemTiers.STELLARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> STELLARIUM_AXE = ITEMS.register("stellarium_axe", () -> new AxeItem(CustomItemTiers.STELLARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> STELLARIUM_SWORD = ITEMS.register("stellarium_sword", () -> new SwordItem(CustomItemTiers.STELLARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> STELLARIUM_HOE = ITEMS.register("stellarium_hoe", () -> new HoeItem(CustomItemTiers.STELLARIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_HELMET = ITEMS.register("zirconium_helmet", () -> new ArmorItem(CustomArmorMaterials.ZIRCONIUM_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_CHESTPLATE = ITEMS.register("zirconium_chestplate", () -> new ArmorItem(CustomArmorMaterials.ZIRCONIUM_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_LEGGINGS = ITEMS.register("zirconium_leggings", () -> new ArmorItem(CustomArmorMaterials.ZIRCONIUM_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_BOOTS = ITEMS.register("zirconium_boots", () -> new ArmorItem(CustomArmorMaterials.ZIRCONIUM_ARMOR, EquipmentSlotType.FEET, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_PICKAXE = ITEMS.register("zirconium_pickaxe", () -> new PickaxeItem(CustomItemTiers.ZIRCONIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_SHOVEL = ITEMS.register("zirconium_shovel", () -> new ShovelItem(CustomItemTiers.ZIRCONIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_AXE = ITEMS.register("zirconium_axe", () -> new AxeItem(CustomItemTiers.ZIRCONIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_SWORD = ITEMS.register("zirconium_sword", () -> new SwordItem(CustomItemTiers.ZIRCONIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCONIUM_HOE = ITEMS.register("zirconium_hoe", () -> new HoeItem(CustomItemTiers.ZIRCONIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_HELMET = ITEMS.register("iridium_helmet", () -> new ArmorItem(CustomArmorMaterials.IRIDIUM_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_CHESTPLATE = ITEMS.register("iridium_chestplate", () -> new ArmorItem(CustomArmorMaterials.IRIDIUM_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_LEGGINGS = ITEMS.register("iridium_leggings", () -> new ArmorItem(CustomArmorMaterials.IRIDIUM_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_BOOTS = ITEMS.register("iridium_boots", () -> new ArmorItem(CustomArmorMaterials.IRIDIUM_ARMOR, EquipmentSlotType.FEET, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_PICKAXE = ITEMS.register("iridium_pickaxe", () -> new PickaxeItem(CustomItemTiers.IRIDIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_SHOVEL = ITEMS.register("iridium_shovel", () -> new ShovelItem(CustomItemTiers.IRIDIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_AXE = ITEMS.register("iridium_axe", () -> new AxeItem(CustomItemTiers.IRIDIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_SWORD = ITEMS.register("iridium_sword", () -> new SwordItem(CustomItemTiers.IRIDIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> IRIDIUM_HOE = ITEMS.register("iridium_hoe", () -> new HoeItem(CustomItemTiers.IRIDIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCALOY_HELMET = ITEMS.register("zircaloy_helmet", () -> new ArmorItem(CustomArmorMaterials.ZIRCALOY_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCALOY_CHESTPLATE = ITEMS.register("zircaloy_chestplate", () -> new ArmorItem(CustomArmorMaterials.ZIRCALOY_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCALOY_LEGGINGS = ITEMS.register("zircaloy_leggings", () -> new ArmorItem(CustomArmorMaterials.ZIRCALOY_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCALOY_BOOTS = ITEMS.register("zircaloy_boots", () -> new ArmorItem(CustomArmorMaterials.ZIRCALOY_ARMOR, EquipmentSlotType.FEET, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCALOY_PICKAXE = ITEMS.register("zircaloy_pickaxe", () -> new PickaxeItem(CustomItemTiers.ZIRCALOY, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCALOY_SHOVEL = ITEMS.register("zircaloy_shovel", () -> new ShovelItem(CustomItemTiers.ZIRCALOY, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCALOY_AXE = ITEMS.register("zircaloy_axe", () -> new AxeItem(CustomItemTiers.ZIRCALOY, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCALOY_SWORD = ITEMS.register("zircaloy_sword", () -> new SwordItem(CustomItemTiers.ZIRCALOY, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> ZIRCALOY_HOE = ITEMS.register("zircaloy_hoe", () -> new HoeItem(CustomItemTiers.ZIRCALOY, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> OSMIRIDIUM_HELMET = ITEMS.register("osmiridium_helmet", () -> new ArmorItem(CustomArmorMaterials.OSMIRIDIUM_ARMOR, EquipmentSlotType.HEAD, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> OSMIRIDIUM_CHESTPLATE = ITEMS.register("osmiridium_chestplate", () -> new ArmorItem(CustomArmorMaterials.OSMIRIDIUM_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> OSMIRIDIUM_LEGGINGS = ITEMS.register("osmiridium_leggings", () -> new ArmorItem(CustomArmorMaterials.OSMIRIDIUM_ARMOR, EquipmentSlotType.LEGS, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> OSMIRIDIUM_BOOTS = ITEMS.register("osmiridium_boots", () -> new ArmorItem(CustomArmorMaterials.OSMIRIDIUM_ARMOR, EquipmentSlotType.FEET, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> OSMIRIDIUM_PICKAXE = ITEMS.register("osmiridium_pickaxe", () -> new PickaxeItem(CustomItemTiers.OSMIRIDIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> OSMIRIDIUM_SHOVEL = ITEMS.register("osmiridium_shovel", () -> new ShovelItem(CustomItemTiers.OSMIRIDIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> OSMIRIDIUM_AXE = ITEMS.register("osmiridium_axe", () -> new AxeItem(CustomItemTiers.OSMIRIDIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> OSMIRIDIUM_SWORD = ITEMS.register("osmiridium_sword", () -> new SwordItem(CustomItemTiers.OSMIRIDIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
    public static final RegistryObject<Item> OSMIRIDIUM_HOE = ITEMS.register("osmiridium_hoe", () -> new HoeItem(CustomItemTiers.OSMIRIDIUM, 0, -2.4f, new Item.Properties().stacksTo(1).tab(ModItemGroups.STELLAMECANICS_TAB)));
}
