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
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.Ethernyx.stellamecanics.utils.generator.LinkIItemProvidderAndAidInfoGenerator;
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
    public static Map<String, LinkIItemProvidderAndAidInfoGenerator> MAP_ITEMS = new HashMap<>();

    public static final RegistryObject<Item> MAGNETITE_RAW = createItem(new MagnetiteRaw(), MagnetiteRaw::new);

    public static final RegistryObject<Item> SOLARIUM_INGOT = createItem(new SolariumIngot(), SolariumIngot::new);
    public static final RegistryObject<Item> SOLARIUM_RAW = createItem(new SolariumRaw(), SolariumRaw::new);
    public static final RegistryObject<Item> SOLARIUM_AXE = createItem(new SolariumAxe(), SolariumAxe::new);
    public static final RegistryObject<Item> SOLARIUM_HOE = createItem(new SolariumHoe(), SolariumHoe::new);
    public static final RegistryObject<Item> SOLARIUM_PICKAXE = createItem(new SolariumPickaxe(), SolariumPickaxe::new);
    public static final RegistryObject<Item> SOLARIUM_SHOVEL = createItem(new SolariumShovel(), SolariumShovel::new);
    public static final RegistryObject<Item> SOLARIUM_SWORD = createItem(new SolariumSword(), SolariumSword::new);
    public static final RegistryObject<Item> SOLARIUM_HELMET = createItem(new SolariumHelmet(), SolariumHelmet::new);
    public static final RegistryObject<Item> SOLARIUM_CHESTPLATE = createItem(new SolariumChestplate(), SolariumChestplate::new);
    public static final RegistryObject<Item> SOLARIUM_LEGGINGS = createItem(new SolariumLeggings(), SolariumLeggings::new);
    public static final RegistryObject<Item> SOLARIUM_BOOTS = createItem(new SolariumBoots(), SolariumBoots::new);

    public static final  RegistryObject<Item> LUNARIUM_INGOT = createItem(new LunariumIngot(), LunariumIngot::new);
    public static final RegistryObject<Item> LUNARIUM_RAW = createItem(new LunariumRaw(), LunariumRaw::new);
    public static final RegistryObject<Item> LUNARIUM_AXE = createItem(new LunariumAxe(), LunariumAxe::new);
    public static final RegistryObject<Item> LUNARIUM_HOE = createItem(new LunariumHoe(), LunariumHoe::new);
    public static final RegistryObject<Item> LUNARIUM_PICKAXE = createItem(new LunariumPickaxe(), LunariumPickaxe::new);
    public static final RegistryObject<Item> LUNARIUM_SHOVEL = createItem(new LunariumShovel(), LunariumShovel::new);
    public static final RegistryObject<Item> LUNARIUM_SWORD = createItem(new LunariumSword(), LunariumSword::new);
    public static final RegistryObject<Item> LUNARIUM_HELMET = createItem(new LunariumHelmet(), LunariumHelmet::new);
    public static final RegistryObject<Item> LUNARIUM_CHESTPLATE = createItem(new LunariumChestplate(), LunariumChestplate::new);
    public static final RegistryObject<Item> LUNARIUM_LEGGINGS = createItem(new LunariumLeggings(), LunariumLeggings::new);
    public static final RegistryObject<Item> LUNARIUM_BOOTS = createItem(new LunariumBoots(), LunariumBoots::new);

    public static final RegistryObject<Item> STELLARIUM_INGOT = createItem(new StellariumIngot(), StellariumIngot::new);
    public static final RegistryObject<Item> STELLARIUM_AXE = createItem(new StellariumAxe(), StellariumAxe::new);
    public static final RegistryObject<Item> STELLARIUM_HOE = createItem(new StellariumHoe(), StellariumHoe::new);
    public static final RegistryObject<Item> STELLARIUM_PICKAXE = createItem(new StellariumPickaxe(), StellariumPickaxe::new);
    public static final RegistryObject<Item> STELLARIUM_SHOVEL = createItem(new StellariumShovel(), StellariumShovel::new);
    public static final RegistryObject<Item> STELLARIUM_SWORD = createItem(new StellariumSword(), StellariumSword::new);
    public static final RegistryObject<Item> STELLARIUM_HELMET = createItem(new StellariumHelmet(), StellariumHelmet::new);
    public static final RegistryObject<Item> STELLARIUM_CHESTPLATE = createItem(new StellariumChestplate(), StellariumChestplate::new);
    public static final RegistryObject<Item> STELLARIUM_LEGGINGS = createItem(new StellariumLeggings(), StellariumLeggings::new);
    public static final RegistryObject<Item> STELLARIUM_BOOTS = createItem(new StellariumBoots(), StellariumBoots::new);

    public static final RegistryObject<Item> ZIRCONIUM_INGOT = createItem(new ZirconiumIngot(), ZirconiumIngot::new);
    public static final RegistryObject<Item> ZIRCONIUM_RAW = createItem(new ZirconiumRaw(), ZirconiumRaw::new);
    public static final RegistryObject<Item> ZIRCONIUM_AXE = createItem(new ZirconiumAxe(), ZirconiumAxe::new);
    public static final RegistryObject<Item> ZIRCONIUM_HOE = createItem(new ZirconiumHoe(), ZirconiumHoe::new);
    public static final RegistryObject<Item> ZIRCONIUM_PICKAXE = createItem(new ZirconiumPickaxe(), ZirconiumPickaxe::new);
    public static final RegistryObject<Item> ZIRCONIUM_SHOVEL = createItem(new ZirconiumShovel(), ZirconiumShovel::new);
    public static final RegistryObject<Item> ZIRCONIUM_SWORD = createItem(new ZirconiumSword(), ZirconiumSword::new);
    public static final RegistryObject<Item> ZIRCONIUM_HELMET = createItem(new ZirconiumHelmet(), ZirconiumHelmet::new);
    public static final RegistryObject<Item> ZIRCONIUM_CHESTPLATE = createItem(new ZirconiumChestplate(), ZirconiumChestplate::new);
    public static final RegistryObject<Item> ZIRCONIUM_LEGGINGS = createItem(new ZirconiumLeggings(), ZirconiumLeggings::new);
    public static final RegistryObject<Item> ZIRCONIUM_BOOTS = createItem(new ZirconiumBoots(), ZirconiumBoots::new);

    public static final RegistryObject<Item> IRIDIUM_INGOT = createItem(new IridiumIngot(), IridiumIngot::new);
    public static final RegistryObject<Item> IRIDIUM_RAW = createItem(new IridiumRaw(), IridiumRaw::new);
    public static final RegistryObject<Item> IRIDIUM_AXE = createItem(new IridiumAxe(), IridiumAxe::new);
    public static final RegistryObject<Item> IRIDIUM_HOE = createItem(new IridiumHoe(), IridiumHoe::new);
    public static final RegistryObject<Item> IRIDIUM_PICKAXE = createItem(new IridiumPickaxe(), IridiumPickaxe::new);
    public static final RegistryObject<Item> IRIDIUM_SHOVEL = createItem(new IridiumShovel(), IridiumShovel::new);
    public static final RegistryObject<Item> IRIDIUM_SWORD = createItem(new IridiumSword(), IridiumSword::new);
    public static final RegistryObject<Item> IRIDIUM_HELMET = createItem(new IridiumHelmet(), IridiumHelmet::new);
    public static final RegistryObject<Item> IRIDIUM_CHESTPLATE = createItem(new IridiumChestplate(), IridiumChestplate::new);
    public static final RegistryObject<Item> IRIDIUM_LEGGINGS = createItem(new IridiumLeggings(), IridiumLeggings::new);
    public static final RegistryObject<Item> IRIDIUM_BOOTS = createItem(new IridiumBoots(), IridiumBoots::new);

    public static final RegistryObject<Item> ZIRCALOY_INGOT = createItem(new ZircaloyIngot(), ZircaloyIngot::new);
    public static final RegistryObject<Item> ZIRCALOY_AXE = createItem(new ZircaloyAxe(), ZircaloyAxe::new);
    public static final RegistryObject<Item> ZIRCALOY_HOE = createItem(new ZircaloyHoe(), ZircaloyHoe::new);
    public static final RegistryObject<Item> ZIRCALOY_PICKAXE = createItem(new ZircaloyPickaxe(), ZircaloyPickaxe::new);
    public static final RegistryObject<Item> ZIRCALOY_SHOVEL = createItem(new ZircaloyShovel(), ZircaloyShovel::new);
    public static final RegistryObject<Item> ZIRCALOY_SWORD = createItem(new ZircaloySword(), ZircaloySword::new);
    public static final RegistryObject<Item> ZIRCALOY_HELMET = createItem(new ZircaloyHelmet(), ZircaloyHelmet::new);
    public static final RegistryObject<Item> ZIRCALOY_CHESTPLATE = createItem(new ZircaloyChestplate(), ZircaloyChestplate::new);
    public static final RegistryObject<Item> ZIRCALOY_LEGGINGS = createItem(new ZircaloyLeggings(), ZircaloyLeggings::new);
    public static final RegistryObject<Item> ZIRCALOY_BOOTS = createItem(new ZircaloyBoots(), ZircaloyBoots::new);

    public static final RegistryObject<Item> OSMIRIDIUM_INGOT = createItem(new OsmiridiumIngot(), OsmiridiumIngot::new);
    public static final RegistryObject<Item> OSMIRIDIUM_AXE = createItem(new OsmiridiumAxe(), OsmiridiumAxe::new);
    public static final RegistryObject<Item> OSMIRIDIUM_HOE = createItem(new OsmiridiumHoe(), OsmiridiumHoe::new);
    public static final RegistryObject<Item> OSMIRIDIUM_PICKAXE = createItem(new OsmiridiumPickaxe(), OsmiridiumPickaxe::new);
    public static final RegistryObject<Item> OSMIRIDIUM_SHOVEL = createItem(new OsmiridiumShovel(), OsmiridiumShovel::new);
    public static final RegistryObject<Item> OSMIRIDIUM_SWORD = createItem(new OsmiridiumSword(), OsmiridiumSword::new);
    public static final RegistryObject<Item> OSMIRIDIUM_HELMET = createItem(new OsmiridiumHelmet(), OsmiridiumHelmet::new);
    public static final RegistryObject<Item> OSMIRIDIUM_CHESTPLATE = createItem(new OsmiridiumChestplate(), OsmiridiumChestplate::new);
    public static final RegistryObject<Item> OSMIRIDIUM_LEGGINGS = createItem(new OsmiridiumLeggings(), OsmiridiumLeggings::new);
    public static final RegistryObject<Item> OSMIRIDIUM_BOOTS = createItem(new OsmiridiumBoots(), OsmiridiumBoots::new);

    
    public static RegistryObject<Item> createItem(ICommun my_class, Supplier< ? extends Item> supplier) {
        RegistryObject<Item> item = ITEMS.register(my_class.getId(), supplier);
        MAP_ITEMS.put(my_class.getId(), new LinkIItemProvidderAndAidInfoGenerator(item, my_class.getData(), InstanceType.ITEM));
        return item;
    }

}
