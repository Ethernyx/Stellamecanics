package fr.ethernyx.stellamecanics.utils;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class CustomArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));

    public static final ArmorMaterial SOLARIUM_ARMOR = new ArmorMaterial(500,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 6);
                map.put(EquipmentType.CHESTPLATE, 8);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 6);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2f, 0.2f, ModTags.Items.SOLARIUM_REPAIR, RegistryKey.of(REGISTRY_KEY, Identifier.of(Stellamecanics.MOD_ID, "solarium_armor")));

    public static final ArmorMaterial LUNARIUM_ARMOR = new ArmorMaterial(500,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 4);
                map.put(EquipmentType.LEGGINGS, 7);
                map.put(EquipmentType.CHESTPLATE, 9);
                map.put(EquipmentType.HELMET, 4);
                map.put(EquipmentType.BODY, 7);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5f,0.3f, ModTags.Items.LUNARIUM_REPAIR, RegistryKey.of(REGISTRY_KEY, Identifier.of(Stellamecanics.MOD_ID, "lunarium_armor")));

    public static final ArmorMaterial ZIRCONIUM_ARMOR = new ArmorMaterial(500,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 7);
                map.put(EquipmentType.CHESTPLATE, 9);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 7);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2f,0.2f, ModTags.Items.ZIRCONIUM_REPAIR, RegistryKey.of(REGISTRY_KEY, Identifier.of(Stellamecanics.MOD_ID, "zirconium_armor")));

    public static final ArmorMaterial IRIDIUM_ARMOR = new ArmorMaterial(500,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 2);
                map.put(EquipmentType.LEGGINGS, 5);
                map.put(EquipmentType.CHESTPLATE, 7);
                map.put(EquipmentType.HELMET, 2);
                map.put(EquipmentType.BODY, 5);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0f,0f, ModTags.Items.IRIDIUM_REPAIR, RegistryKey.of(REGISTRY_KEY, Identifier.of(Stellamecanics.MOD_ID, "iridium_armor")));

    public static final ArmorMaterial ZIRCALOY_ARMOR = new ArmorMaterial(500,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 4);
                map.put(EquipmentType.LEGGINGS, 7);
                map.put(EquipmentType.CHESTPLATE, 9);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 7);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.5f,0.3f, ModTags.Items.ZIRCALOY_REPAIR, RegistryKey.of(REGISTRY_KEY, Identifier.of(Stellamecanics.MOD_ID, "zircaloy_armor")));

    public static final ArmorMaterial OSMIRIDIUM_ARMOR = new ArmorMaterial(500,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 3);
                map.put(EquipmentType.LEGGINGS, 7);
                map.put(EquipmentType.CHESTPLATE, 9);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 7);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2f,0.2f,ModTags.Items.OSMIRIDIUM_REPAIR, RegistryKey.of(REGISTRY_KEY, Identifier.of(Stellamecanics.MOD_ID, "osmiridium_armor")));

    public static final ArmorMaterial STELLARIUM_ARMOR = new ArmorMaterial(500,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 4);
                map.put(EquipmentType.LEGGINGS, 7);
                map.put(EquipmentType.CHESTPLATE, 9);
                map.put(EquipmentType.HELMET, 3);
                map.put(EquipmentType.BODY, 7);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.5f,0.4f, ModTags.Items.STELLARIUM_REPAIR, RegistryKey.of(REGISTRY_KEY, Identifier.of(Stellamecanics.MOD_ID, "stellarium_armor")));

}
