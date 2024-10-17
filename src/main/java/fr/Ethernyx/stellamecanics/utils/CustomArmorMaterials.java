package fr.ethernyx.stellamecanics.utils;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.init.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class CustomArmorMaterials {

    public static final RegistryEntry<ArmorMaterial> SOLARIUM_ARMOR = registerArmorMaterial("solarium_armor",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 6);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.SOLARIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Stellamecanics.MOD_ID, "solarium_armor"))), 2f,0.2f));

    public static final RegistryEntry<ArmorMaterial> LUNARIUM_ARMOR = registerArmorMaterial("solarium_armor",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 4);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 7);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.LUNARIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Stellamecanics.MOD_ID, "solarium_armor"))), 3.5f,0.3f));

    public static final RegistryEntry<ArmorMaterial> ZIRCONIUM_ARMOR = registerArmorMaterial("solarium_armor",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 7);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.ZIRCONIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Stellamecanics.MOD_ID, "solarium_armor"))), 2f,0.2f));

    public static final RegistryEntry<ArmorMaterial> IRIDIUM_ARMOR = registerArmorMaterial("solarium_armor",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 5);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.IRIDIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Stellamecanics.MOD_ID, "solarium_armor"))), 0f,0f));

    public static final RegistryEntry<ArmorMaterial> ZIRCALOY_ARMOR = registerArmorMaterial("solarium_armor",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 4);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 7);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.ZIRCALOY_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Stellamecanics.MOD_ID, "solarium_armor"))), 4.5f,0.3f));

    public static final RegistryEntry<ArmorMaterial> OSMIRIDIUM_ARMOR = registerArmorMaterial("solarium_armor",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 7);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.OSMIRIDIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Stellamecanics.MOD_ID, "solarium_armor"))), 2f,0.2f));

    public static final RegistryEntry<ArmorMaterial> STELLARIUM_ARMOR = registerArmorMaterial("solarium_armor",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 4);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 7);
            }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModItems.STELLARIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(Stellamecanics.MOD_ID, "solarium_armor"))), 4.5f,0.4f));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Stellamecanics.MOD_ID, name), material.get());
    }

}
