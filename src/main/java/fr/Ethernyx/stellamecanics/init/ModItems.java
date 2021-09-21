package fr.Ethernyx.stellamecanics.init;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.item.armor.iridium.IridiumBoots;
import fr.Ethernyx.stellamecanics.item.armor.iridium.IridiumChestplate;
import fr.Ethernyx.stellamecanics.item.armor.iridium.IridiumHelmet;
import fr.Ethernyx.stellamecanics.item.armor.iridium.IridiumLeggings;
import fr.Ethernyx.stellamecanics.item.armor.lunarium.LunariumBoots;
import fr.Ethernyx.stellamecanics.item.armor.lunarium.LunariumChestplate;
import fr.Ethernyx.stellamecanics.item.armor.lunarium.LunariumHelmet;
import fr.Ethernyx.stellamecanics.item.armor.lunarium.LunariumLeggings;
import fr.Ethernyx.stellamecanics.item.armor.osmiridium.OsmiridiumBoots;
import fr.Ethernyx.stellamecanics.item.armor.osmiridium.OsmiridiumChestplate;
import fr.Ethernyx.stellamecanics.item.armor.osmiridium.OsmiridiumHelmet;
import fr.Ethernyx.stellamecanics.item.armor.osmiridium.OsmiridiumLeggings;
import fr.Ethernyx.stellamecanics.item.armor.solarium.SolariumBoots;
import fr.Ethernyx.stellamecanics.item.armor.solarium.SolariumChestplate;
import fr.Ethernyx.stellamecanics.item.armor.solarium.SolariumHelmet;
import fr.Ethernyx.stellamecanics.item.armor.solarium.SolariumLeggings;
import fr.Ethernyx.stellamecanics.item.armor.stellarium.StellariumBoots;
import fr.Ethernyx.stellamecanics.item.armor.stellarium.StellariumChestplate;
import fr.Ethernyx.stellamecanics.item.armor.stellarium.StellariumHelmet;
import fr.Ethernyx.stellamecanics.item.armor.stellarium.StellariumLeggings;
import fr.Ethernyx.stellamecanics.item.armor.zircaloy.ZircaloyBoots;
import fr.Ethernyx.stellamecanics.item.armor.zircaloy.ZircaloyChestplate;
import fr.Ethernyx.stellamecanics.item.armor.zircaloy.ZircaloyHelmet;
import fr.Ethernyx.stellamecanics.item.armor.zircaloy.ZircaloyLeggings;
import fr.Ethernyx.stellamecanics.item.armor.zirconium.ZirconiumBoots;
import fr.Ethernyx.stellamecanics.item.armor.zirconium.ZirconiumChestplate;
import fr.Ethernyx.stellamecanics.item.armor.zirconium.ZirconiumHelmet;
import fr.Ethernyx.stellamecanics.item.armor.zirconium.ZirconiumLeggings;
import fr.Ethernyx.stellamecanics.item.ore.*;
import fr.Ethernyx.stellamecanics.item.tool.iridium.*;
import fr.Ethernyx.stellamecanics.item.tool.lunarium.*;
import fr.Ethernyx.stellamecanics.item.tool.osmiridium.*;
import fr.Ethernyx.stellamecanics.item.tool.solarium.*;
import fr.Ethernyx.stellamecanics.item.tool.stellarium.*;
import fr.Ethernyx.stellamecanics.item.tool.zircaloy.*;
import fr.Ethernyx.stellamecanics.item.tool.zirconium.*;
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

    public static final RegistryObject<Item> MAGNETITE_RAW = ITEMS.register(new MagnetiteRaw().getId(), MagnetiteRaw::new);

    public static final RegistryObject<Item> SOLARIUM_INGOT = ITEMS.register(new SolariumIngot().getId(), SolariumIngot::new);
    public static final RegistryObject<Item> SOLARIUM_RAW = ITEMS.register(new SolariumRaw().getId(), SolariumRaw::new);
    public static final RegistryObject<Item> SOLARIUM_AXE = ITEMS.register(new SolariumAxe().getId(), SolariumAxe::new);
    public static final RegistryObject<Item> SOLARIUM_HOE = ITEMS.register(new SolariumHoe().getId(), SolariumHoe::new);
    public static final RegistryObject<Item> SOLARIUM_PICKAXE = ITEMS.register(new SolariumPickaxe().getId(), SolariumPickaxe::new);
    public static final RegistryObject<Item> SOLARIUM_SHOVEL = ITEMS.register(new SolariumShovel().getId(), SolariumShovel::new);
    public static final RegistryObject<Item> SOLARIUM_SWORD = ITEMS.register(new SolariumSword().getId(), SolariumSword::new);
    public static final RegistryObject<Item> SOLARIUM_HELMET = ITEMS.register(new SolariumHelmet().getId(), SolariumHelmet::new);
    public static final RegistryObject<Item> SOLARIUM_CHESTPLATE = ITEMS.register(new SolariumChestplate().getId(), SolariumChestplate::new);
    public static final RegistryObject<Item> SOLARIUM_LEGGINGS = ITEMS.register(new SolariumLeggings().getId(), SolariumLeggings::new);
    public static final RegistryObject<Item> SOLARIUM_BOOTS = ITEMS.register(new SolariumBoots().getId(), SolariumBoots::new);

    public static final  RegistryObject<Item> LUNARIUM_INGOT = ITEMS.register(new LunariumIngot().getId(), LunariumIngot::new);
    public static final RegistryObject<Item> LUNARIUM_RAW = ITEMS.register(new LunariumRaw().getId(), LunariumRaw::new);
    public static final RegistryObject<Item> LUNARIUM_AXE = ITEMS.register(new LunariumAxe().getId(), LunariumAxe::new);
    public static final RegistryObject<Item> LUNARIUM_HOE = ITEMS.register(new LunariumHoe().getId(), LunariumHoe::new);
    public static final RegistryObject<Item> LUNARIUM_PICKAXE = ITEMS.register(new LunariumPickaxe().getId(), LunariumPickaxe::new);
    public static final RegistryObject<Item> LUNARIUM_SHOVEL = ITEMS.register(new LunariumShovel().getId(), LunariumShovel::new);
    public static final RegistryObject<Item> LUNARIUM_SWORD = ITEMS.register(new LunariumSword().getId(), LunariumSword::new);
    public static final RegistryObject<Item> LUNARIUM_HELMET = ITEMS.register(new LunariumHelmet().getId(), LunariumHelmet::new);
    public static final RegistryObject<Item> LUNARIUM_CHESTPLATE = ITEMS.register(new LunariumChestplate().getId(), LunariumChestplate::new);
    public static final RegistryObject<Item> LUNARIUM_LEGGINGS = ITEMS.register(new LunariumLeggings().getId(), LunariumLeggings::new);
    public static final RegistryObject<Item> LUNARIUM_BOOTS = ITEMS.register(new LunariumBoots().getId(), LunariumBoots::new);

    public static final RegistryObject<Item> STELLARIUM_INGOT = ITEMS.register(new StellariumIngot().getId(), StellariumIngot::new);
    public static final RegistryObject<Item> STELLARIUM_AXE = ITEMS.register(new StellariumAxe().getId(), StellariumAxe::new);
    public static final RegistryObject<Item> STELLARIUM_HOE = ITEMS.register(new StellariumHoe().getId(), StellariumHoe::new);
    public static final RegistryObject<Item> STELLARIUM_PICKAXE = ITEMS.register(new StellariumPickaxe().getId(), StellariumPickaxe::new);
    public static final RegistryObject<Item> STELLARIUM_SHOVEL = ITEMS.register(new StellariumShovel().getId(), StellariumShovel::new);
    public static final RegistryObject<Item> STELLARIUM_SWORD = ITEMS.register(new StellariumSword().getId(), StellariumSword::new);
    public static final RegistryObject<Item> STELLARIUM_HELMET = ITEMS.register(new StellariumHelmet().getId(), StellariumHelmet::new);
    public static final RegistryObject<Item> STELLARIUM_CHESTPLATE = ITEMS.register(new StellariumChestplate().getId(), StellariumChestplate::new);
    public static final RegistryObject<Item> STELLARIUM_LEGGINGS = ITEMS.register(new StellariumLeggings().getId(), StellariumLeggings::new);
    public static final RegistryObject<Item> STELLARIUM_BOOTS = ITEMS.register(new StellariumBoots().getId(), StellariumBoots::new);

    public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register(new ZirconiumIngot().getId(), ZirconiumIngot::new);
    public static final RegistryObject<Item> ZIRCONIUM_RAW = ITEMS.register(new ZirconiumRaw().getId(), ZirconiumRaw::new);
    public static final RegistryObject<Item> ZIRCONIUM_AXE = ITEMS.register(new ZirconiumAxe().getId(), ZirconiumAxe::new);
    public static final RegistryObject<Item> ZIRCONIUM_HOE = ITEMS.register(new ZirconiumHoe().getId(), ZirconiumHoe::new);
    public static final RegistryObject<Item> ZIRCONIUM_PICKAXE = ITEMS.register(new ZirconiumPickaxe().getId(), ZirconiumPickaxe::new);
    public static final RegistryObject<Item> ZIRCONIUM_SHOVEL = ITEMS.register(new ZirconiumShovel().getId(), ZirconiumShovel::new);
    public static final RegistryObject<Item> ZIRCONIUM_SWORD = ITEMS.register(new ZirconiumSword().getId(), ZirconiumSword::new);
    public static final RegistryObject<Item> ZIRCONIUM_HELMET = ITEMS.register(new ZirconiumHelmet().getId(), ZirconiumHelmet::new);
    public static final RegistryObject<Item> ZIRCONIUM_CHESTPLATE = ITEMS.register(new ZirconiumChestplate().getId(), ZirconiumChestplate::new);
    public static final RegistryObject<Item> ZIRCONIUM_LEGGINGS = ITEMS.register(new ZirconiumLeggings().getId(), ZirconiumLeggings::new);
    public static final RegistryObject<Item> ZIRCONIUM_BOOTS = ITEMS.register(new ZirconiumBoots().getId(), ZirconiumBoots::new);

    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register(new IridiumIngot().getId(), IridiumIngot::new);
    public static final RegistryObject<Item> IRIDIUM_RAW = ITEMS.register(new IridiumRaw().getId(), IridiumRaw::new);
    public static final RegistryObject<Item> IRIDIUM_AXE = ITEMS.register(new IridiumAxe().getId(), IridiumAxe::new);
    public static final RegistryObject<Item> IRIDIUM_HOE = ITEMS.register(new IridiumHoe().getId(), IridiumHoe::new);
    public static final RegistryObject<Item> IRIDIUM_PICKAXE = ITEMS.register(new IridiumPickaxe().getId(), IridiumPickaxe::new);
    public static final RegistryObject<Item> IRIDIUM_SHOVEL = ITEMS.register(new IridiumShovel().getId(), IridiumShovel::new);
    public static final RegistryObject<Item> IRIDIUM_SWORD = ITEMS.register(new IridiumSword().getId(), IridiumSword::new);
    public static final RegistryObject<Item> IRIDIUM_HELMET = ITEMS.register(new IridiumHelmet().getId(), IridiumHelmet::new);
    public static final RegistryObject<Item> IRIDIUM_CHESTPLATE = ITEMS.register(new IridiumChestplate().getId(), IridiumChestplate::new);
    public static final RegistryObject<Item> IRIDIUM_LEGGINGS = ITEMS.register(new IridiumLeggings().getId(), IridiumLeggings::new);
    public static final RegistryObject<Item> IRIDIUM_BOOTS = ITEMS.register(new IridiumBoots().getId(), IridiumBoots::new);

    public static final RegistryObject<Item> ZIRCALOY_INGOT = ITEMS.register(new ZircaloyIngot().getId(), ZircaloyIngot::new);
    public static final RegistryObject<Item> ZIRCALOY_AXE = ITEMS.register(new ZircaloyAxe().getId(), ZircaloyAxe::new);
    public static final RegistryObject<Item> ZIRCALOY_HOE = ITEMS.register(new ZircaloyHoe().getId(), ZircaloyHoe::new);
    public static final RegistryObject<Item> ZIRCALOY_PICKAXE = ITEMS.register(new ZircaloyPickaxe().getId(), ZircaloyPickaxe::new);
    public static final RegistryObject<Item> ZIRCALOY_SHOVEL = ITEMS.register(new ZircaloyShovel().getId(), ZircaloyShovel::new);
    public static final RegistryObject<Item> ZIRCALOY_SWORD = ITEMS.register(new ZircaloySword().getId(), ZircaloySword::new);
    public static final RegistryObject<Item> ZIRCALOY_HELMET = ITEMS.register(new ZircaloyHelmet().getId(), ZircaloyHelmet::new);
    public static final RegistryObject<Item> ZIRCALOY_CHESTPLATE = ITEMS.register(new ZircaloyChestplate().getId(), ZircaloyChestplate::new);
    public static final RegistryObject<Item> ZIRCALOY_LEGGINGS = ITEMS.register(new ZircaloyLeggings().getId(), ZircaloyLeggings::new);
    public static final RegistryObject<Item> ZIRCALOY_BOOTS = ITEMS.register(new ZircaloyBoots().getId(), ZircaloyBoots::new);

    public static final RegistryObject<Item> OSMIRIDIUM_INGOT = ITEMS.register(new OsmiridiumIngot().getId(), OsmiridiumIngot::new);
    public static final RegistryObject<Item> OSMIRIDIUM_AXE = ITEMS.register(new OsmiridiumAxe().getId(), OsmiridiumAxe::new);
    public static final RegistryObject<Item> OSMIRIDIUM_HOE = ITEMS.register(new OsmiridiumHoe().getId(), OsmiridiumHoe::new);
    public static final RegistryObject<Item> OSMIRIDIUM_PICKAXE = ITEMS.register(new OsmiridiumPickaxe().getId(), OsmiridiumPickaxe::new);
    public static final RegistryObject<Item> OSMIRIDIUM_SHOVEL = ITEMS.register(new OsmiridiumShovel().getId(), OsmiridiumShovel::new);
    public static final RegistryObject<Item> OSMIRIDIUM_SWORD = ITEMS.register(new OsmiridiumSword().getId(), OsmiridiumSword::new);
    public static final RegistryObject<Item> OSMIRIDIUM_HELMET = ITEMS.register(new OsmiridiumHelmet().getId(), OsmiridiumHelmet::new);
    public static final RegistryObject<Item> OSMIRIDIUM_CHESTPLATE = ITEMS.register(new OsmiridiumChestplate().getId(), OsmiridiumChestplate::new);
    public static final RegistryObject<Item> OSMIRIDIUM_LEGGINGS = ITEMS.register(new OsmiridiumLeggings().getId(), OsmiridiumLeggings::new);
    public static final RegistryObject<Item> OSMIRIDIUM_BOOTS = ITEMS.register(new OsmiridiumBoots().getId(), OsmiridiumBoots::new);

}
