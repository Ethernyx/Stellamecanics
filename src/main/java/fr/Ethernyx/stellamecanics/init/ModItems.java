package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.items.armor.iridium.IridiumBoots;
import fr.ethernyx.stellamecanics.items.armor.iridium.IridiumChestplate;
import fr.ethernyx.stellamecanics.items.armor.iridium.IridiumHelmet;
import fr.ethernyx.stellamecanics.items.armor.iridium.IridiumLeggings;
import fr.ethernyx.stellamecanics.items.armor.lunarium.LunariumBoots;
import fr.ethernyx.stellamecanics.items.armor.lunarium.LunariumChestplate;
import fr.ethernyx.stellamecanics.items.armor.lunarium.LunariumHelmet;
import fr.ethernyx.stellamecanics.items.armor.lunarium.LunariumLeggings;
import fr.ethernyx.stellamecanics.items.armor.osmiridium.OsmiridiumBoots;
import fr.ethernyx.stellamecanics.items.armor.osmiridium.OsmiridiumChestplate;
import fr.ethernyx.stellamecanics.items.armor.osmiridium.OsmiridiumHelmet;
import fr.ethernyx.stellamecanics.items.armor.osmiridium.OsmiridiumLeggings;
import fr.ethernyx.stellamecanics.items.armor.solarium.SolariumBoots;
import fr.ethernyx.stellamecanics.items.armor.solarium.SolariumChestplate;
import fr.ethernyx.stellamecanics.items.armor.solarium.SolariumHelmet;
import fr.ethernyx.stellamecanics.items.armor.solarium.SolariumLeggings;
import fr.ethernyx.stellamecanics.items.armor.stellarium.StellariumBoots;
import fr.ethernyx.stellamecanics.items.armor.stellarium.StellariumChestplate;
import fr.ethernyx.stellamecanics.items.armor.stellarium.StellariumHelmet;
import fr.ethernyx.stellamecanics.items.armor.stellarium.StellariumLeggings;
import fr.ethernyx.stellamecanics.items.armor.zircaloy.ZircaloyBoots;
import fr.ethernyx.stellamecanics.items.armor.zircaloy.ZircaloyChestplate;
import fr.ethernyx.stellamecanics.items.armor.zircaloy.ZircaloyHelmet;
import fr.ethernyx.stellamecanics.items.armor.zircaloy.ZircaloyLeggings;
import fr.ethernyx.stellamecanics.items.armor.zirconium.ZirconiumBoots;
import fr.ethernyx.stellamecanics.items.armor.zirconium.ZirconiumChestplate;
import fr.ethernyx.stellamecanics.items.armor.zirconium.ZirconiumHelmet;
import fr.ethernyx.stellamecanics.items.armor.zirconium.ZirconiumLeggings;
import fr.ethernyx.stellamecanics.items.ore.*;
import fr.ethernyx.stellamecanics.items.tool.iridium.*;
import fr.ethernyx.stellamecanics.items.tool.lunarium.*;
import fr.ethernyx.stellamecanics.items.tool.osmiridium.*;
import fr.ethernyx.stellamecanics.items.tool.solarium.*;
import fr.ethernyx.stellamecanics.items.tool.stellarium.*;
import fr.ethernyx.stellamecanics.items.tool.zircaloy.*;
import fr.ethernyx.stellamecanics.items.tool.zirconium.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ModItems {
    public static Map<String, IMyItem> ITEMS = new HashMap<>();

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

    public static Item addNewItem(String name, IMyItem item) {
        ITEMS.put(name, item);
        return Registry.register(Registries.ITEM, Identifier.of(Stellamecanics.MOD_ID, name), (Item)item);
    }

    public static void registerModItems() { Stellamecanics.LOGGER.debug("Registering Mod Items for " + Stellamecanics.MOD_ID); }
}
