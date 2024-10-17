package fr.ethernyx.stellamecanics.utils;

import com.google.common.base.Suppliers;
import fr.ethernyx.stellamecanics.init.ModItems;
import fr.ethernyx.stellamecanics.init.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum CustomItemTiers implements ToolMaterial {

    SOLARIUM(ModTags.Blocks.FORBIDDEN_SOLARIUM_TOOL, 3360, 4.8f, 2f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("solarium_ingot")); }),
    LUNARIUM(ModTags.Blocks.FORBIDDEN_LUNARIUM_TOOL, 4200, 6f, 1.5f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("lunarium_ingot")); }),
    ZIRCONIUM(ModTags.Blocks.FORBIDDEN_ZIRCONIUM_TOOL, 1680, 2.4f, 1.5f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("zirconium_ingot")); }),
    IRIDIUM(ModTags.Blocks.FORBIDDEN_IRIDIUM_TOOL, 3360, 4.8f, 1.5f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("iridium_ingot")); }),
    ZIRCALOY(ModTags.Blocks.FORBIDDEN_ZIRCALOY_TOOL, 3360, 4.8f, 1.5f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("zircaloy_ingot")); }),
    OSMIRIDIUM(ModTags.Blocks.FORBIDDEN_OSMIRIDIUM_TOOL, 5040, 7.2f, 1.5f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("osmiridium_ingot")); }),
    STELLARIUM(ModTags.Blocks.FORBIDDEN_STELLARIUM_TOOL, 5040, 7.2f, 1.5f, 10, () -> { return Ingredient.ofItems(ModItems.ITEMS.get("stellarium_ingot")); })
    ;
    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    CustomItemTiers(final TagKey<Block> inverseTag, final int itemDurability,final float miningSpeed,
                     final float attackDamage, final int enchantability,final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
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
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
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
