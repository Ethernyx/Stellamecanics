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
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {
    public static Map<String, IMyItem> ITEMS = new HashMap<>();

    //public static final Item MAGNETITE_RAW = addNewItem(MagnetiteRaw.ID, MagnetiteRaw::new);
    public static final Item MAGNETITE_RAW = addNewItem(MagnetiteRaw.ID, MagnetiteRaw::new);

    public static final Item SOLARIUM_INGOT = addNewItem(SolariumIngot.ID, SolariumIngot::new);
    public static final Item SOLARIUM_RAW = addNewItem(SolariumRaw.ID, SolariumRaw::new);
    public static final Item SOLARIUM_AXE = addNewItem(SolariumAxe.ID, SolariumAxe::new);
    public static final Item SOLARIUM_HOE = addNewItem(SolariumHoe.ID, SolariumHoe::new);
    public static final Item SOLARIUM_PICKAXE = addNewItem(SolariumPickaxe.ID, SolariumPickaxe::new);
    public static final Item SOLARIUM_SHOVEL = addNewItem(SolariumShovel.ID, SolariumShovel::new);
    public static final Item SOLARIUM_SWORD = addNewItem(SolariumSword.ID, SolariumSword::new);
    public static final Item SOLARIUM_HELMET = addNewItem(SolariumHelmet.ID, SolariumHelmet::new);
    public static final Item SOLARIUM_CHESTPLATE = addNewItem(SolariumChestplate.ID, SolariumChestplate::new);
    public static final Item SOLARIUM_LEGGINGS = addNewItem(SolariumLeggings.ID, SolariumLeggings::new);
    public static final Item SOLARIUM_BOOTS = addNewItem(SolariumBoots.ID, SolariumBoots::new);

    public static final  Item LUNARIUM_INGOT = addNewItem(LunariumIngot.ID, LunariumIngot::new);
    public static final Item LUNARIUM_RAW = addNewItem(LunariumRaw.ID, LunariumRaw::new);
    public static final Item LUNARIUM_AXE = addNewItem(LunariumAxe.ID, LunariumAxe::new);
    public static final Item LUNARIUM_HOE = addNewItem(LunariumHoe.ID, LunariumHoe::new);
    public static final Item LUNARIUM_PICKAXE = addNewItem(LunariumPickaxe.ID, LunariumPickaxe::new);
    public static final Item LUNARIUM_SHOVEL = addNewItem(LunariumShovel.ID, LunariumShovel::new);
    public static final Item LUNARIUM_SWORD = addNewItem(LunariumSword.ID, LunariumSword::new);
    public static final Item LUNARIUM_HELMET = addNewItem(LunariumHelmet.ID, LunariumHelmet::new);
    public static final Item LUNARIUM_CHESTPLATE = addNewItem(LunariumChestplate.ID, LunariumChestplate::new);
    public static final Item LUNARIUM_LEGGINGS = addNewItem(LunariumLeggings.ID, LunariumLeggings::new);
    public static final Item LUNARIUM_BOOTS = addNewItem(LunariumBoots.ID, LunariumBoots::new);

    public static final Item STELLARIUM_INGOT = addNewItem(StellariumIngot.ID, StellariumIngot::new);
    public static final Item STELLARIUM_AXE = addNewItem(StellariumAxe.ID, StellariumAxe::new);
    public static final Item STELLARIUM_HOE = addNewItem(StellariumHoe.ID, StellariumHoe::new);
    public static final Item STELLARIUM_PICKAXE = addNewItem(StellariumPickaxe.ID, StellariumPickaxe::new);
    public static final Item STELLARIUM_SHOVEL = addNewItem(StellariumShovel.ID, StellariumShovel::new);
    public static final Item STELLARIUM_SWORD = addNewItem(StellariumSword.ID, StellariumSword::new);
    public static final Item STELLARIUM_HELMET = addNewItem(StellariumHelmet.ID, StellariumHelmet::new);
    public static final Item STELLARIUM_CHESTPLATE = addNewItem(StellariumChestplate.ID, StellariumChestplate::new);
    public static final Item STELLARIUM_LEGGINGS = addNewItem(StellariumLeggings.ID, StellariumLeggings::new);
    public static final Item STELLARIUM_BOOTS = addNewItem(StellariumBoots.ID, StellariumBoots::new);

    public static final Item ZIRCONIUM_INGOT = addNewItem(ZirconiumIngot.ID, ZirconiumIngot::new);
    public static final Item ZIRCONIUM_RAW = addNewItem(ZirconiumRaw.ID, ZirconiumRaw::new);
    public static final Item ZIRCONIUM_AXE = addNewItem(ZirconiumAxe.ID, ZirconiumAxe::new);
    public static final Item ZIRCONIUM_HOE = addNewItem(ZirconiumHoe.ID, ZirconiumHoe::new);
    public static final Item ZIRCONIUM_PICKAXE = addNewItem(ZirconiumPickaxe.ID, ZirconiumPickaxe::new);
    public static final Item ZIRCONIUM_SHOVEL = addNewItem(ZirconiumShovel.ID, ZirconiumShovel::new);
    public static final Item ZIRCONIUM_SWORD = addNewItem(ZirconiumSword.ID, ZirconiumSword::new);
    public static final Item ZIRCONIUM_HELMET = addNewItem(ZirconiumHelmet.ID, ZirconiumHelmet::new);
    public static final Item ZIRCONIUM_CHESTPLATE = addNewItem(ZirconiumChestplate.ID, ZirconiumChestplate::new);
    public static final Item ZIRCONIUM_LEGGINGS = addNewItem(ZirconiumLeggings.ID, ZirconiumLeggings::new);
    public static final Item ZIRCONIUM_BOOTS = addNewItem(ZirconiumBoots.ID, ZirconiumBoots::new);

    public static final Item IRIDIUM_INGOT = addNewItem(IridiumIngot.ID, IridiumIngot::new);
    public static final Item IRIDIUM_RAW = addNewItem(IridiumRaw.ID, IridiumRaw::new);
    public static final Item IRIDIUM_AXE = addNewItem(IridiumAxe.ID, IridiumAxe::new);
    public static final Item IRIDIUM_HOE = addNewItem(IridiumHoe.ID, IridiumHoe::new);
    public static final Item IRIDIUM_PICKAXE = addNewItem(IridiumPickaxe.ID, IridiumPickaxe::new);
    public static final Item IRIDIUM_SHOVEL = addNewItem(IridiumShovel.ID, IridiumShovel::new);
    public static final Item IRIDIUM_SWORD = addNewItem(IridiumSword.ID, IridiumSword::new);
    public static final Item IRIDIUM_HELMET = addNewItem(IridiumHelmet.ID, IridiumHelmet::new);
    public static final Item IRIDIUM_CHESTPLATE = addNewItem(IridiumChestplate.ID, IridiumChestplate::new);
    public static final Item IRIDIUM_LEGGINGS = addNewItem(IridiumLeggings.ID, IridiumLeggings::new);
    public static final Item IRIDIUM_BOOTS = addNewItem(IridiumBoots.ID, IridiumBoots::new);

    public static final Item ZIRCALOY_INGOT = addNewItem(ZircaloyIngot.ID, ZircaloyIngot::new);
    public static final Item ZIRCALOY_AXE = addNewItem(ZircaloyAxe.ID, ZircaloyAxe::new);
    public static final Item ZIRCALOY_HOE = addNewItem(ZircaloyHoe.ID, ZircaloyHoe::new);
    public static final Item ZIRCALOY_PICKAXE = addNewItem(ZircaloyPickaxe.ID, ZircaloyPickaxe::new);
    public static final Item ZIRCALOY_SHOVEL = addNewItem(ZircaloyShovel.ID, ZircaloyShovel::new);
    public static final Item ZIRCALOY_SWORD = addNewItem(ZircaloySword.ID, ZircaloySword::new);
    public static final Item ZIRCALOY_HELMET = addNewItem(ZircaloyHelmet.ID, ZircaloyHelmet::new);
    public static final Item ZIRCALOY_CHESTPLATE = addNewItem(ZircaloyChestplate.ID, ZircaloyChestplate::new);
    public static final Item ZIRCALOY_LEGGINGS = addNewItem(ZircaloyLeggings.ID, ZircaloyLeggings::new);
    public static final Item ZIRCALOY_BOOTS = addNewItem(ZircaloyBoots.ID, ZircaloyBoots::new);

    public static final Item OSMIRIDIUM_INGOT = addNewItem(OsmiridiumIngot.ID, OsmiridiumIngot::new);
    public static final Item OSMIRIDIUM_AXE = addNewItem(OsmiridiumAxe.ID, OsmiridiumAxe::new);
    public static final Item OSMIRIDIUM_HOE = addNewItem(OsmiridiumHoe.ID, OsmiridiumHoe::new);
    public static final Item OSMIRIDIUM_PICKAXE = addNewItem(OsmiridiumPickaxe.ID, OsmiridiumPickaxe::new);
    public static final Item OSMIRIDIUM_SHOVEL = addNewItem(OsmiridiumShovel.ID, OsmiridiumShovel::new);
    public static final Item OSMIRIDIUM_SWORD = addNewItem(OsmiridiumSword.ID, OsmiridiumSword::new);
    public static final Item OSMIRIDIUM_HELMET = addNewItem(OsmiridiumHelmet.ID, OsmiridiumHelmet::new);
    public static final Item OSMIRIDIUM_CHESTPLATE = addNewItem(OsmiridiumChestplate.ID, OsmiridiumChestplate::new);
    public static final Item OSMIRIDIUM_LEGGINGS = addNewItem(OsmiridiumLeggings.ID, OsmiridiumLeggings::new);
    public static final Item OSMIRIDIUM_BOOTS = addNewItem(OsmiridiumBoots.ID, OsmiridiumBoots::new);

   /* public static Item addNewItem(String name, Function<Item.Settings, Item> function) {
        ITEMS.put(name, (IMyItem) Registry.register(Registries.ITEM, Identifier.of(Stellamecanics.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Stellamecanics.MOD_ID, name))))));
        return (Item)ITEMS.get(name);
    }*/

    public static <T extends Item & IMyItem> T addNewItem(
            String name,
            Function<Item.Settings, T> factory
    ) {
        Identifier id = Identifier.of(Stellamecanics.MOD_ID, name);

        Item.Settings settings = new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, id));

        T item = factory.apply(settings);

        Registry.register(Registries.ITEM, id, item);
        ITEMS.put(name, item);
        return item;
    }

    public static void registerModItems() { Stellamecanics.LOGGER.debug("Registering Mod Items for " + Stellamecanics.MOD_ID); }
}
