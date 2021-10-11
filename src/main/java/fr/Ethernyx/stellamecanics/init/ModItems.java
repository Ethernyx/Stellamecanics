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
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
    public static Map<String, RegistryObject<Item>> MAP_ITEMS = new HashMap<>();

    public static final RegistryObject<Item> MAGNETITE_RAW = createItem(new MagnetiteRaw().getId(), MagnetiteRaw::new);

    public static final RegistryObject<Item> SOLARIUM_INGOT = createItem(new SolariumIngot().getId(), SolariumIngot::new);
    public static final RegistryObject<Item> SOLARIUM_RAW = createItem(new SolariumRaw().getId(), SolariumRaw::new);
    public static final RegistryObject<Item> SOLARIUM_AXE = createItem(new SolariumAxe().getId(), SolariumAxe::new);
    public static final RegistryObject<Item> SOLARIUM_HOE = createItem(new SolariumHoe().getId(), SolariumHoe::new);
    public static final RegistryObject<Item> SOLARIUM_PICKAXE = createItem(new SolariumPickaxe().getId(), SolariumPickaxe::new);
    public static final RegistryObject<Item> SOLARIUM_SHOVEL = createItem(new SolariumShovel().getId(), SolariumShovel::new);
    public static final RegistryObject<Item> SOLARIUM_SWORD = createItem(new SolariumSword().getId(), SolariumSword::new);
    public static final RegistryObject<Item> SOLARIUM_HELMET = createItem(new SolariumHelmet().getId(), SolariumHelmet::new);
    public static final RegistryObject<Item> SOLARIUM_CHESTPLATE = createItem(new SolariumChestplate().getId(), SolariumChestplate::new);
    public static final RegistryObject<Item> SOLARIUM_LEGGINGS = createItem(new SolariumLeggings().getId(), SolariumLeggings::new);
    public static final RegistryObject<Item> SOLARIUM_BOOTS = createItem(new SolariumBoots().getId(), SolariumBoots::new);

    public static final  RegistryObject<Item> LUNARIUM_INGOT = createItem(new LunariumIngot().getId(), LunariumIngot::new);
    public static final RegistryObject<Item> LUNARIUM_RAW = createItem(new LunariumRaw().getId(), LunariumRaw::new);
    public static final RegistryObject<Item> LUNARIUM_AXE = createItem(new LunariumAxe().getId(), LunariumAxe::new);
    public static final RegistryObject<Item> LUNARIUM_HOE = createItem(new LunariumHoe().getId(), LunariumHoe::new);
    public static final RegistryObject<Item> LUNARIUM_PICKAXE = createItem(new LunariumPickaxe().getId(), LunariumPickaxe::new);
    public static final RegistryObject<Item> LUNARIUM_SHOVEL = createItem(new LunariumShovel().getId(), LunariumShovel::new);
    public static final RegistryObject<Item> LUNARIUM_SWORD = createItem(new LunariumSword().getId(), LunariumSword::new);
    public static final RegistryObject<Item> LUNARIUM_HELMET = createItem(new LunariumHelmet().getId(), LunariumHelmet::new);
    public static final RegistryObject<Item> LUNARIUM_CHESTPLATE = createItem(new LunariumChestplate().getId(), LunariumChestplate::new);
    public static final RegistryObject<Item> LUNARIUM_LEGGINGS = createItem(new LunariumLeggings().getId(), LunariumLeggings::new);
    public static final RegistryObject<Item> LUNARIUM_BOOTS = createItem(new LunariumBoots().getId(), LunariumBoots::new);

    public static final RegistryObject<Item> STELLARIUM_INGOT = createItem(new StellariumIngot().getId(), StellariumIngot::new);
    public static final RegistryObject<Item> STELLARIUM_AXE = createItem(new StellariumAxe().getId(), StellariumAxe::new);
    public static final RegistryObject<Item> STELLARIUM_HOE = createItem(new StellariumHoe().getId(), StellariumHoe::new);
    public static final RegistryObject<Item> STELLARIUM_PICKAXE = createItem(new StellariumPickaxe().getId(), StellariumPickaxe::new);
    public static final RegistryObject<Item> STELLARIUM_SHOVEL = createItem(new StellariumShovel().getId(), StellariumShovel::new);
    public static final RegistryObject<Item> STELLARIUM_SWORD = createItem(new StellariumSword().getId(), StellariumSword::new);
    public static final RegistryObject<Item> STELLARIUM_HELMET = createItem(new StellariumHelmet().getId(), StellariumHelmet::new);
    public static final RegistryObject<Item> STELLARIUM_CHESTPLATE = createItem(new StellariumChestplate().getId(), StellariumChestplate::new);
    public static final RegistryObject<Item> STELLARIUM_LEGGINGS = createItem(new StellariumLeggings().getId(), StellariumLeggings::new);
    public static final RegistryObject<Item> STELLARIUM_BOOTS = createItem(new StellariumBoots().getId(), StellariumBoots::new);

    public static final RegistryObject<Item> ZIRCONIUM_INGOT = createItem(new ZirconiumIngot().getId(), ZirconiumIngot::new);
    public static final RegistryObject<Item> ZIRCONIUM_RAW = createItem(new ZirconiumRaw().getId(), ZirconiumRaw::new);
    public static final RegistryObject<Item> ZIRCONIUM_AXE = createItem(new ZirconiumAxe().getId(), ZirconiumAxe::new);
    public static final RegistryObject<Item> ZIRCONIUM_HOE = createItem(new ZirconiumHoe().getId(), ZirconiumHoe::new);
    public static final RegistryObject<Item> ZIRCONIUM_PICKAXE = createItem(new ZirconiumPickaxe().getId(), ZirconiumPickaxe::new);
    public static final RegistryObject<Item> ZIRCONIUM_SHOVEL = createItem(new ZirconiumShovel().getId(), ZirconiumShovel::new);
    public static final RegistryObject<Item> ZIRCONIUM_SWORD = createItem(new ZirconiumSword().getId(), ZirconiumSword::new);
    public static final RegistryObject<Item> ZIRCONIUM_HELMET = createItem(new ZirconiumHelmet().getId(), ZirconiumHelmet::new);
    public static final RegistryObject<Item> ZIRCONIUM_CHESTPLATE = createItem(new ZirconiumChestplate().getId(), ZirconiumChestplate::new);
    public static final RegistryObject<Item> ZIRCONIUM_LEGGINGS = createItem(new ZirconiumLeggings().getId(), ZirconiumLeggings::new);
    public static final RegistryObject<Item> ZIRCONIUM_BOOTS = createItem(new ZirconiumBoots().getId(), ZirconiumBoots::new);

    public static final RegistryObject<Item> IRIDIUM_INGOT = createItem(new IridiumIngot().getId(), IridiumIngot::new);
    public static final RegistryObject<Item> IRIDIUM_RAW = createItem(new IridiumRaw().getId(), IridiumRaw::new);
    public static final RegistryObject<Item> IRIDIUM_AXE = createItem(new IridiumAxe().getId(), IridiumAxe::new);
    public static final RegistryObject<Item> IRIDIUM_HOE = createItem(new IridiumHoe().getId(), IridiumHoe::new);
    public static final RegistryObject<Item> IRIDIUM_PICKAXE = createItem(new IridiumPickaxe().getId(), IridiumPickaxe::new);
    public static final RegistryObject<Item> IRIDIUM_SHOVEL = createItem(new IridiumShovel().getId(), IridiumShovel::new);
    public static final RegistryObject<Item> IRIDIUM_SWORD = createItem(new IridiumSword().getId(), IridiumSword::new);
    public static final RegistryObject<Item> IRIDIUM_HELMET = createItem(new IridiumHelmet().getId(), IridiumHelmet::new);
    public static final RegistryObject<Item> IRIDIUM_CHESTPLATE = createItem(new IridiumChestplate().getId(), IridiumChestplate::new);
    public static final RegistryObject<Item> IRIDIUM_LEGGINGS = createItem(new IridiumLeggings().getId(), IridiumLeggings::new);
    public static final RegistryObject<Item> IRIDIUM_BOOTS = createItem(new IridiumBoots().getId(), IridiumBoots::new);

    public static final RegistryObject<Item> ZIRCALOY_INGOT = createItem(new ZircaloyIngot().getId(), ZircaloyIngot::new);
    public static final RegistryObject<Item> ZIRCALOY_AXE = createItem(new ZircaloyAxe().getId(), ZircaloyAxe::new);
    public static final RegistryObject<Item> ZIRCALOY_HOE = createItem(new ZircaloyHoe().getId(), ZircaloyHoe::new);
    public static final RegistryObject<Item> ZIRCALOY_PICKAXE = createItem(new ZircaloyPickaxe().getId(), ZircaloyPickaxe::new);
    public static final RegistryObject<Item> ZIRCALOY_SHOVEL = createItem(new ZircaloyShovel().getId(), ZircaloyShovel::new);
    public static final RegistryObject<Item> ZIRCALOY_SWORD = createItem(new ZircaloySword().getId(), ZircaloySword::new);
    public static final RegistryObject<Item> ZIRCALOY_HELMET = createItem(new ZircaloyHelmet().getId(), ZircaloyHelmet::new);
    public static final RegistryObject<Item> ZIRCALOY_CHESTPLATE = createItem(new ZircaloyChestplate().getId(), ZircaloyChestplate::new);
    public static final RegistryObject<Item> ZIRCALOY_LEGGINGS = createItem(new ZircaloyLeggings().getId(), ZircaloyLeggings::new);
    public static final RegistryObject<Item> ZIRCALOY_BOOTS = createItem(new ZircaloyBoots().getId(), ZircaloyBoots::new);

    public static final RegistryObject<Item> OSMIRIDIUM_INGOT = createItem(new OsmiridiumIngot().getId(), OsmiridiumIngot::new);
    public static final RegistryObject<Item> OSMIRIDIUM_AXE = createItem(new OsmiridiumAxe().getId(), OsmiridiumAxe::new);
    public static final RegistryObject<Item> OSMIRIDIUM_HOE = createItem(new OsmiridiumHoe().getId(), OsmiridiumHoe::new);
    public static final RegistryObject<Item> OSMIRIDIUM_PICKAXE = createItem(new OsmiridiumPickaxe().getId(), OsmiridiumPickaxe::new);
    public static final RegistryObject<Item> OSMIRIDIUM_SHOVEL = createItem(new OsmiridiumShovel().getId(), OsmiridiumShovel::new);
    public static final RegistryObject<Item> OSMIRIDIUM_SWORD = createItem(new OsmiridiumSword().getId(), OsmiridiumSword::new);
    public static final RegistryObject<Item> OSMIRIDIUM_HELMET = createItem(new OsmiridiumHelmet().getId(), OsmiridiumHelmet::new);
    public static final RegistryObject<Item> OSMIRIDIUM_CHESTPLATE = createItem(new OsmiridiumChestplate().getId(), OsmiridiumChestplate::new);
    public static final RegistryObject<Item> OSMIRIDIUM_LEGGINGS = createItem(new OsmiridiumLeggings().getId(), OsmiridiumLeggings::new);
    public static final RegistryObject<Item> OSMIRIDIUM_BOOTS = createItem(new OsmiridiumBoots().getId(), OsmiridiumBoots::new);


    public static RegistryObject<Item> createItem(String name, Supplier<? extends Item> supplier) {
        RegistryObject<Item> item = ITEMS.register(name, supplier);
        MAP_ITEMS.put(name, item);
        return item;
    }

}
