package net.Ethernyx.stellamecanics.utils;

import net.Ethernyx.stellamecanics.init.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;


import java.util.function.Supplier;

public enum CustomItemTiers implements ToolMaterial {

    SOLARIUM(5, 3360, 4.8f, 2f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("solarium_ingot").item); }),
    LUNARIUM(5, 4200, 6f, 1.5f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("lunarium_ingot").item); }),
    ZIRCONIUM(4, 1680, 2.4f, 1.5f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("zirconium_ingot").item); }),
    IRIDIUM(4, 3360, 4.8f, 1.5f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("iridium_ingot").item); }),
    ZIRCALOY(4, 3360, 4.8f, 1.5f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("zircaloy_ingot").item); }),
    OSMIRIDIUM(6, 5040, 7.2f, 1.5f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("osmiridium_ingot").item); }),
    STELLARIUM(6, 5040, 7.2f, 1.5f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("stellarium_ingot").item); })
    ;

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private CustomItemTiers(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
