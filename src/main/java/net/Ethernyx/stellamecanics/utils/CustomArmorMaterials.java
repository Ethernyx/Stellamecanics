package net.Ethernyx.stellamecanics.utils;

import net.Ethernyx.stellamecanics.Main;
import net.Ethernyx.stellamecanics.init.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;



import java.util.function.Supplier;

public enum CustomArmorMaterials implements ArmorMaterial {

    SOLARIUM_ARMOR(Main.MOD_ID + ":solarium", 50, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.2F, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("solarium_ingot").item); }),
    LUNARIUM_ARMOR(Main.MOD_ID + ":lunarium", 50, new int[]{4, 7, 9, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5F, 0.3F, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("lunarium_ingot").item); }),
    ZIRCONIUM_ARMOR(Main.MOD_ID + ":zirconium", 50, new int[]{3, 7, 9, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.2F, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("zirconium_ingot").item); }),
    IRIDIUM_ARMOR(Main.MOD_ID + ":iridium", 50, new int[]{2, 5, 7, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0F, 0F, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("iridium_ingot").item); }),
    ZIRCALOY_ARMOR(Main.MOD_ID + ":zircaloy", 50, new int[]{4, 7, 9, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.5F, 0.3F, () -> {  return Ingredient.ofItems(ModItems.ITEMS.get("zircaloy_ingot").item); }),
    OSMIRIDIUM_ARMOR(Main.MOD_ID + ":osmiridium", 50, new int[]{3, 7, 9, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.2F, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("osmiridium_ingot").item); }),
    STELLARIUM_ARMOR(Main.MOD_ID + ":stellarium", 50, new int[]{ 4, 7, 9, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.5F, 0.4F, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("stellarium_ingot").item); });

    private static final int[] BASE_DURABILITY = new int[4];
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredientSupplier;

    private CustomArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = repairIngredientSupplier;
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

}
