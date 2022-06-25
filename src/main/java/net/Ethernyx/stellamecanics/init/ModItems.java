package net.Ethernyx.stellamecanics.init;

import net.Ethernyx.stellamecanics.Main;
import net.Ethernyx.stellamecanics.items.armor.iridium.*;
import net.Ethernyx.stellamecanics.items.armor.lunarium.*;
import net.Ethernyx.stellamecanics.items.armor.osmiridium.*;
import net.Ethernyx.stellamecanics.items.armor.solarium.*;
import net.Ethernyx.stellamecanics.items.armor.stellarium.*;
import net.Ethernyx.stellamecanics.items.armor.zircaloy.*;
import net.Ethernyx.stellamecanics.items.armor.zirconium.*;
import net.Ethernyx.stellamecanics.items.ore.*;
import net.Ethernyx.stellamecanics.items.tool.iridium.*;
import net.Ethernyx.stellamecanics.items.tool.lunarium.*;
import net.Ethernyx.stellamecanics.items.tool.osmiridium.*;
import net.Ethernyx.stellamecanics.items.tool.solarium.*;
import net.Ethernyx.stellamecanics.items.tool.stellarium.*;
import net.Ethernyx.stellamecanics.items.tool.zircaloy.*;
import net.Ethernyx.stellamecanics.items.tool.zirconium.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class ModItems {

    public static Map<String, Item> ITEMS = new HashMap<>();

    public static final Item MAGNETITE_RAW = addNewItem(MagnetiteRaw.getId(), new MagnetiteRaw());

    public static final Item SOLARIUM_INGOT = addNewItem(SolariumIngot.getId(), new SolariumIngot());
    public static final Item SOLARIUM_RAW = addNewItem(SolariumRaw.getId(), new SolariumRaw());
    public static final Item SOLARIUM_AXE = addNewItem(SolariumAxe.getId(), new SolariumAxe());
    public static final Item SOLARIUM_HOE = addNewItem(SolariumHoe.getId(), new SolariumHoe());
    public static final Item SOLARIUM_PICKAXE = addNewItem(SolariumPickaxe.getId(), new SolariumPickaxe());
    public static final Item SOLARIUM_SHOVEL = addNewItem(SolariumShovel.getId(), new SolariumShovel());
    public static final Item SOLARIUM_SWORD = addNewItem(SolariumSword.getId(), new SolariumSword());
    public static final Item SOLARIUM_HELMET = addNewItem(SolariumHelmet.getId(), new SolariumHelmet());
    public static final Item SOLARIUM_CHESTPLATE = addNewItem(SolariumChestplate.getId(), new SolariumChestplate());
    public static final Item SOLARIUM_LEGGINGS = addNewItem(SolariumLeggings.getId(), new SolariumLeggings());
    public static final Item SOLARIUM_BOOTS = addNewItem(SolariumBoots.getId(), new SolariumBoots());

    public static final  Item LUNARIUM_INGOT = addNewItem(LunariumIngot.getId(), new LunariumIngot());
    public static final Item LUNARIUM_RAW = addNewItem(LunariumRaw.getId(), new LunariumRaw());
    public static final Item LUNARIUM_AXE = addNewItem(LunariumAxe.getId(), new LunariumAxe());
    public static final Item LUNARIUM_HOE = addNewItem(LunariumHoe.getId(), new LunariumHoe());
    public static final Item LUNARIUM_PICKAXE = addNewItem(LunariumPickaxe.getId(), new LunariumPickaxe());
    public static final Item LUNARIUM_SHOVEL = addNewItem(LunariumShovel.getId(), new LunariumShovel());
    public static final Item LUNARIUM_SWORD = addNewItem(LunariumSword.getId(), new LunariumSword());
    public static final Item LUNARIUM_HELMET = addNewItem(LunariumHelmet.getId(), new LunariumHelmet());
    public static final Item LUNARIUM_CHESTPLATE = addNewItem(LunariumChestplate.getId(), new LunariumChestplate());
    public static final Item LUNARIUM_LEGGINGS = addNewItem(LunariumLeggings.getId(), new LunariumLeggings());
    public static final Item LUNARIUM_BOOTS = addNewItem(LunariumBoots.getId(), new LunariumBoots());

    public static final Item STELLARIUM_INGOT = addNewItem(StellariumIngot.getId(), new StellariumIngot());
    public static final Item STELLARIUM_AXE = addNewItem(StellariumAxe.getId(), new StellariumAxe());
    public static final Item STELLARIUM_HOE = addNewItem(StellariumHoe.getId(), new StellariumHoe());
    public static final Item STELLARIUM_PICKAXE = addNewItem(StellariumPickaxe.getId(), new StellariumPickaxe());
    public static final Item STELLARIUM_SHOVEL = addNewItem(StellariumShovel.getId(), new StellariumShovel());
    public static final Item STELLARIUM_SWORD = addNewItem(StellariumSword.getId(), new StellariumSword());
    public static final Item STELLARIUM_HELMET = addNewItem(StellariumHelmet.getId(), new StellariumHelmet());
    public static final Item STELLARIUM_CHESTPLATE = addNewItem(StellariumChestplate.getId(), new StellariumChestplate());
    public static final Item STELLARIUM_LEGGINGS = addNewItem(StellariumLeggings.getId(), new StellariumLeggings());
    public static final Item STELLARIUM_BOOTS = addNewItem(StellariumBoots.getId(), new StellariumBoots());

    public static final Item ZIRCONIUM_INGOT = addNewItem(ZirconiumIngot.getId(), new ZirconiumIngot());
    public static final Item ZIRCONIUM_RAW = addNewItem(ZirconiumRaw.getId(), new ZirconiumRaw());
    public static final Item ZIRCONIUM_AXE = addNewItem(ZirconiumAxe.getId(), new ZirconiumAxe());
    public static final Item ZIRCONIUM_HOE = addNewItem(ZirconiumHoe.getId(), new ZirconiumHoe());
    public static final Item ZIRCONIUM_PICKAXE = addNewItem(ZirconiumPickaxe.getId(), new ZirconiumPickaxe());
    public static final Item ZIRCONIUM_SHOVEL = addNewItem(ZirconiumShovel.getId(), new ZirconiumShovel());
    public static final Item ZIRCONIUM_SWORD = addNewItem(ZirconiumSword.getId(), new ZirconiumSword());
    public static final Item ZIRCONIUM_HELMET = addNewItem(ZirconiumHelmet.getId(), new ZirconiumHelmet());
    public static final Item ZIRCONIUM_CHESTPLATE = addNewItem(ZirconiumChestplate.getId(), new ZirconiumChestplate());
    public static final Item ZIRCONIUM_LEGGINGS = addNewItem(ZirconiumLeggings.getId(), new ZirconiumLeggings());
    public static final Item ZIRCONIUM_BOOTS = addNewItem(ZirconiumBoots.getId(), new ZirconiumBoots());

    public static final Item IRIDIUM_INGOT = addNewItem(IridiumIngot.getId(), new IridiumIngot());
    public static final Item IRIDIUM_RAW = addNewItem(IridiumRaw.getId(), new IridiumRaw());
    public static final Item IRIDIUM_AXE = addNewItem(IridiumAxe.getId(), new IridiumAxe());
    public static final Item IRIDIUM_HOE = addNewItem(IridiumHoe.getId(), new IridiumHoe());
    public static final Item IRIDIUM_PICKAXE = addNewItem(IridiumPickaxe.getId(), new IridiumPickaxe());
    public static final Item IRIDIUM_SHOVEL = addNewItem(IridiumShovel.getId(), new IridiumShovel());
    public static final Item IRIDIUM_SWORD = addNewItem(IridiumSword.getId(), new IridiumSword());
    public static final Item IRIDIUM_HELMET = addNewItem(IridiumHelmet.getId(), new IridiumHelmet());
    public static final Item IRIDIUM_CHESTPLATE = addNewItem(IridiumChestplate.getId(), new IridiumChestplate());
    public static final Item IRIDIUM_LEGGINGS = addNewItem(IridiumLeggings.getId(), new IridiumLeggings());
    public static final Item IRIDIUM_BOOTS = addNewItem(IridiumBoots.getId(), new IridiumBoots());

    public static final Item ZIRCALOY_INGOT = addNewItem(ZircaloyIngot.getId(), new ZircaloyIngot());
    public static final Item ZIRCALOY_AXE = addNewItem(ZircaloyAxe.getId(), new ZircaloyAxe());
    public static final Item ZIRCALOY_HOE = addNewItem(ZircaloyHoe.getId(), new ZircaloyHoe());
    public static final Item ZIRCALOY_PICKAXE = addNewItem(ZircaloyPickaxe.getId(), new ZircaloyPickaxe());
    public static final Item ZIRCALOY_SHOVEL = addNewItem(ZircaloyShovel.getId(), new ZircaloyShovel());
    public static final Item ZIRCALOY_SWORD = addNewItem(ZircaloySword.getId(), new ZircaloySword());
    public static final Item ZIRCALOY_HELMET = addNewItem(ZircaloyHelmet.getId(), new ZircaloyHelmet());
    public static final Item ZIRCALOY_CHESTPLATE = addNewItem(ZircaloyChestplate.getId(), new ZircaloyChestplate());
    public static final Item ZIRCALOY_LEGGINGS = addNewItem(ZircaloyLeggings.getId(), new ZircaloyLeggings());
    public static final Item ZIRCALOY_BOOTS = addNewItem(ZircaloyBoots.getId(), new ZircaloyBoots());

    public static final Item OSMIRIDIUM_INGOT = addNewItem(OsmiridiumIngot.getId(), new OsmiridiumIngot());
    public static final Item OSMIRIDIUM_AXE = addNewItem(OsmiridiumAxe.getId(), new OsmiridiumAxe());
    public static final Item OSMIRIDIUM_HOE = addNewItem(OsmiridiumHoe.getId(), new OsmiridiumHoe());
    public static final Item OSMIRIDIUM_PICKAXE = addNewItem(OsmiridiumPickaxe.getId(), new OsmiridiumPickaxe());
    public static final Item OSMIRIDIUM_SHOVEL = addNewItem(OsmiridiumShovel.getId(), new OsmiridiumShovel());
    public static final Item OSMIRIDIUM_SWORD = addNewItem(OsmiridiumSword.getId(), new OsmiridiumSword());
    public static final Item OSMIRIDIUM_HELMET = addNewItem(OsmiridiumHelmet.getId(), new OsmiridiumHelmet());
    public static final Item OSMIRIDIUM_CHESTPLATE = addNewItem(OsmiridiumChestplate.getId(), new OsmiridiumChestplate());
    public static final Item OSMIRIDIUM_LEGGINGS = addNewItem(OsmiridiumLeggings.getId(), new OsmiridiumLeggings());
    public static final Item OSMIRIDIUM_BOOTS = addNewItem(OsmiridiumBoots.getId(), new OsmiridiumBoots());
    
    private static Item addNewItem(String name, Item item) {
        ITEMS.put(name, item);
        return Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, name), item);
    }

    public static void registerModItem() {
        Main.LOGGER.debug("Registering Mod Items for " + Main.MOD_ID);
    }
}
