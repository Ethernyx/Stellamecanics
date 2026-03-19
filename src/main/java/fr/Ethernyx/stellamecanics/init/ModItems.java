package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.ethernyx.stellamecanics.utils.generic.GenericItems;
import fr.ethernyx.stellamecanics.utils.ItemsType;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModItems {
    public static Map<String, IMyItem> ITEMS = new LinkedHashMap<>();

    public static final Item MAGNETITE_RAW = addNewItem(GenericItems.builder("magnetite_raw", ItemsType.RAW)
            .addTranslate("fr_fr", "Magnétite brut")
            .addTranslate("en_us", "Magnetite raw")
            .build());

    // ── SOLARIUM ──────────────────────────────────────────────────────────────
    public static final Item SOLARIUM_INGOT = addNewItem(GenericItems.builder("solarium_ingot", ItemsType.INGOT)
            .addTranslate("fr_fr", "Lingot de solarium")
            .addTranslate("en_us", "Solarium ingot")
            .addTag(ModTags.Items.SOLARIUM_REPAIR)
            .addRecipe(RecipeBuilder.builder("solarium_block", RecipeType.SHAPE)
                    .addInput(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))
                    .addOutput(new MyIngredient("solarium_block", InstanceType.BLOCK, 1))
                    .pattern(List.of("000", "000", "000"))
                    .unlock(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))
                    .build())
            .addRecipe(RecipeBuilder.builder("solarium_tool", RecipeType.TOOLS)
                    .addInput(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("solarium_axe", InstanceType.ITEM, 1),
                            new MyIngredient("solarium_hoe", InstanceType.ITEM, 1),
                            new MyIngredient("solarium_pickaxe", InstanceType.ITEM, 1),
                            new MyIngredient("solarium_shovel", InstanceType.ITEM, 1),
                            new MyIngredient("solarium_sword", InstanceType.ITEM, 1)))
                    .build())
            .addRecipe(RecipeBuilder.builder("solarium_armor", RecipeType.ARMOR)
                    .addInput(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("solarium_boots", InstanceType.ITEM, 1),
                            new MyIngredient("solarium_chestplate", InstanceType.ITEM, 1),
                            new MyIngredient("solarium_helmet", InstanceType.ITEM, 1),
                            new MyIngredient("solarium_leggings", InstanceType.ITEM, 1)))
                    .build())
            .addRecipe(RecipeBuilder.builder("solarium_ingot_to_stellarium_ingot", RecipeType.FORGE)
                    .addInput(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))
                    .addFluid(new MyIngredient("lunarium_fluid_still", InstanceType.FLUID, 200))
                    .addOutput(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1))
                    .build())
            .build());

    public static final Item SOLARIUM_RAW = addNewItem(GenericItems.builder("solarium_raw", ItemsType.RAW)
            .addTranslate("fr_fr", "Solarium brut")
            .addTranslate("en_us", "Solarium raw")
            .addTag(ModTags.Items.SOLARIUM_REPAIR)
            .addRecipe(RecipeBuilder.builder("raw_to_solarium_ingot", RecipeType.ORE)
                    .addInput(new MyIngredient("solarium_raw", InstanceType.ITEM, 1))
                    .addOutput(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))
                    .build())
            .addRecipe(RecipeBuilder.builder("raw_to_solarium_ingot", RecipeType.FORGE)
                    .addInput(new MyIngredient("solarium_raw", InstanceType.ITEM, 1))
                    .addFluid(new MyIngredient("lunarium_fluid_still", InstanceType.FLUID, 200))
                    .addOutput(new MyIngredient("solarium_ingot", InstanceType.ITEM, 2))
                    .build())
            .build());

    public static final Item SOLARIUM_AXE = addNewItem(GenericItems.builder("solarium_axe", ItemsType.AXE)
            .addTranslate("fr_fr", "Hache en solarium")
            .addTranslate("en_us", "Solarium axe")
            .addTag(ModTags.Items.SOLARIUM_TOOL)
            .toolMaterial(CustomItemTiers.SOLARIUM)
            .build());

    public static final Item SOLARIUM_HOE = addNewItem(GenericItems.builder("solarium_hoe", ItemsType.HOE)
            .addTranslate("fr_fr", "Houe en solarium")
            .addTranslate("en_us", "Solarium hoe")
            .addTag(ModTags.Items.SOLARIUM_TOOL)
            .toolMaterial(CustomItemTiers.SOLARIUM)
            .build());

    public static final Item SOLARIUM_PICKAXE = addNewItem(GenericItems.builder("solarium_pickaxe", ItemsType.PICKAXE)
            .addTranslate("fr_fr", "Pioche en solarium")
            .addTranslate("en_us", "Solarium pickaxe")
            .addTag(ModTags.Items.SOLARIUM_TOOL)
            .toolMaterial(CustomItemTiers.SOLARIUM)
            .build());

    public static final Item SOLARIUM_SHOVEL = addNewItem(GenericItems.builder("solarium_shovel", ItemsType.SHOVEL)
            .addTranslate("fr_fr", "Pelle en solarium")
            .addTranslate("en_us", "Solarium shovel")
            .addTag(ModTags.Items.SOLARIUM_TOOL)
            .toolMaterial(CustomItemTiers.SOLARIUM)
            .build());

    public static final Item SOLARIUM_SWORD = addNewItem(GenericItems.builder("solarium_sword", ItemsType.SWORD)
            .addTranslate("fr_fr", "Epée en solarium")
            .addTranslate("en_us", "Solarium sword")
            .addTag(ModTags.Items.SOLARIUM_WEAPON)
            .toolMaterial(CustomItemTiers.SOLARIUM)
            .build());

    public static final Item SOLARIUM_HELMET = addNewItem(GenericItems.builder("solarium_helmet", ItemsType.HELMET)
            .addTranslate("fr_fr", "Casque en solarium")
            .addTranslate("en_us", "Solarium helmet")
            .addTag(ModTags.Items.SOLARIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.SOLARIUM_ARMOR)
            .build());

    public static final Item SOLARIUM_CHESTPLATE = addNewItem(GenericItems.builder("solarium_chestplate", ItemsType.CHESTPLATE)
            .addTranslate("fr_fr", "Plastron en solarium")
            .addTranslate("en_us", "Solarium chestplate")
            .addTag(ModTags.Items.SOLARIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.SOLARIUM_ARMOR)
            .build());

    public static final Item SOLARIUM_LEGGINGS = addNewItem(GenericItems.builder("solarium_leggings", ItemsType.LEGGINGS)
            .addTranslate("fr_fr", "Pantalon en solarium")
            .addTranslate("en_us", "Solarium leggings")
            .addTag(ModTags.Items.SOLARIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.SOLARIUM_ARMOR)
            .build());
    public static final Item SOLARIUM_BOOTS = addNewItem(GenericItems.builder("solarium_boots", ItemsType.BOOTS)
            .addTranslate("fr_fr", "Bottes en solarium")
            .addTranslate("en_us", "Solarium boots")
            .addTag(ModTags.Items.SOLARIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.SOLARIUM_ARMOR)
            .build());

    // ── LUNARIUM ──────────────────────────────────────────────────────────────
    public static final Item LUNARIUM_INGOT = addNewItem(GenericItems.builder("lunarium_ingot", ItemsType.INGOT)
            .addTranslate("fr_fr", "Lingot de lunarium")
            .addTranslate("en_us", "Lunarium ingot")
            .addTag(ModTags.Items.LUNARIUM_REPAIR)
            .addRecipe(RecipeBuilder.builder("lunarium_block", RecipeType.SHAPE)
                    .addInput(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))
                    .addOutput(new MyIngredient("lunarium_block", InstanceType.BLOCK, 1))
                    .pattern(List.of("000", "000", "000"))
                    .unlock(new MyIngredient("lunarium_block", InstanceType.BLOCK, 1))
                    .build())
            .addRecipe(RecipeBuilder.builder("lunarium_tool", RecipeType.TOOLS)
                    .addInput(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("lunarium_axe", InstanceType.ITEM, 1),
                            new MyIngredient("lunarium_hoe", InstanceType.ITEM, 1),
                            new MyIngredient("lunarium_pickaxe", InstanceType.ITEM, 1),
                            new MyIngredient("lunarium_shovel", InstanceType.ITEM, 1),
                            new MyIngredient("lunarium_sword", InstanceType.ITEM, 1)))
                    .build())
            .addRecipe(RecipeBuilder.builder("lunarium_armor", RecipeType.ARMOR)
                    .addInput(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("lunarium_boots", InstanceType.ITEM, 1),
                            new MyIngredient("lunarium_chestplate", InstanceType.ITEM, 1),
                            new MyIngredient("lunarium_helmet", InstanceType.ITEM, 1),
                            new MyIngredient("lunarium_leggings", InstanceType.ITEM, 1)))
                    .build())
            .addRecipe(RecipeBuilder.builder("lunarium_ingot_to_stellarium_ingot", RecipeType.FORGE)
                    .addInput(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))
                    .addFluid(new MyIngredient("solarium_fluid_still", InstanceType.FLUID, 200))
                    .addOutput(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1))  // corrigé BLOCK → ITEM
                    .build())
            .build());

    public static final Item LUNARIUM_RAW = addNewItem(GenericItems.builder("lunarium_raw", ItemsType.RAW)
            .addTranslate("fr_fr", "Lunarium brut")
            .addTranslate("en_us", "Lunarium raw")
            .addTag(ModTags.Items.LUNARIUM_REPAIR)
            .addRecipe(RecipeBuilder.builder("raw_to_lunarium_ingot", RecipeType.ORE)
                    .addInput(new MyIngredient("lunarium_raw", InstanceType.ITEM, 1))
                    .addOutput(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))
                    .build())
            .addRecipe(RecipeBuilder.builder("raw_to_lunarium_ingot", RecipeType.FORGE)
                    .addInput(new MyIngredient("lunarium_raw", InstanceType.ITEM, 1))
                    .addFluid(new MyIngredient("solarium_fluid_still", InstanceType.FLUID, 200))
                    .addOutput(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 2))
                    .build())
            .build());

    public static final Item LUNARIUM_AXE = addNewItem(GenericItems.builder("lunarium_axe", ItemsType.AXE)
            .addTranslate("fr_fr", "Hache en lunarium")
            .addTranslate("en_us", "Lunarium axe")
            .addTag(ModTags.Items.LUNARIUM_TOOL)
            .toolMaterial(CustomItemTiers.LUNARIUM)
            .build());
    public static final Item LUNARIUM_HOE = addNewItem(GenericItems.builder("lunarium_hoe", ItemsType.HOE)
            .addTranslate("fr_fr", "Houe en lunarium")
            .addTranslate("en_us", "Lunarium hoe")
            .addTag(ModTags.Items.LUNARIUM_TOOL)
            .toolMaterial(CustomItemTiers.LUNARIUM)
            .build());
    public static final Item LUNARIUM_PICKAXE = addNewItem(GenericItems.builder("lunarium_pickaxe", ItemsType.PICKAXE)
            .addTranslate("fr_fr", "Pioche en lunarium")
            .addTranslate("en_us", "Lunarium pickaxe")
            .addTag(ModTags.Items.LUNARIUM_TOOL)
            .toolMaterial(CustomItemTiers.LUNARIUM)
            .build());
    public static final Item LUNARIUM_SHOVEL = addNewItem(GenericItems.builder("lunarium_shovel", ItemsType.SHOVEL)
            .addTranslate("fr_fr", "Pelle en lunarium")
            .addTranslate("en_us", "Lunarium shovel")
            .addTag(ModTags.Items.LUNARIUM_TOOL)
            .toolMaterial(CustomItemTiers.LUNARIUM)
            .build());
    public static final Item LUNARIUM_SWORD = addNewItem(GenericItems.builder("lunarium_sword", ItemsType.SWORD)
            .addTranslate("fr_fr", "Epée en lunarium")
            .addTranslate("en_us", "Lunarium sword")
            .addTag(ModTags.Items.LUNARIUM_WEAPON)
            .toolMaterial(CustomItemTiers.LUNARIUM)
            .build());
    public static final Item LUNARIUM_HELMET = addNewItem(GenericItems.builder("lunarium_helmet", ItemsType.HELMET)
            .addTranslate("fr_fr", "Casque en lunarium")
            .addTranslate("en_us", "Lunarium helmet")
            .addTag(ModTags.Items.LUNARIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.LUNARIUM_ARMOR)
            .build());
    public static final Item LUNARIUM_CHESTPLATE = addNewItem(GenericItems.builder("lunarium_chestplate", ItemsType.CHESTPLATE)
            .addTranslate("fr_fr", "Plastron en lunarium")
            .addTranslate("en_us", "Lunarium chestplate")
            .addTag(ModTags.Items.LUNARIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.LUNARIUM_ARMOR)
            .build());
    public static final Item LUNARIUM_LEGGINGS = addNewItem(GenericItems.builder("lunarium_leggings", ItemsType.LEGGINGS)
            .addTranslate("fr_fr", "Pantalon en lunarium")
            .addTranslate("en_us", "Lunarium leggings")
            .addTag(ModTags.Items.LUNARIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.LUNARIUM_ARMOR)
            .build());
    public static final Item LUNARIUM_BOOTS = addNewItem(GenericItems.builder("lunarium_boots", ItemsType.BOOTS)
            .addTranslate("fr_fr", "Bottes en lunarium")
            .addTranslate("en_us", "Lunarium boots")
            .addTag(ModTags.Items.LUNARIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.LUNARIUM_ARMOR)
            .build());

    // ── STELLARIUM ────────────────────────────────────────────────────────────
    public static final Item STELLARIUM_INGOT = addNewItem(GenericItems.builder("stellarium_ingot", ItemsType.INGOT)
            .addTranslate("fr_fr", "Lingot de stellarium")
            .addTranslate("en_us", "Stellarium ingot")
            .addTag(ModTags.Items.STELLARIUM_REPAIR)
            .addRecipe(RecipeBuilder.builder("stellarium_block", RecipeType.SHAPE)
                    .addInput(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1))
                    .addOutput(new MyIngredient("stellarium_block", InstanceType.BLOCK, 1))
                    .pattern(List.of("000", "000", "000"))
                    .unlock(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1))
                    .build())
            .addRecipe(RecipeBuilder.builder("stellarium_tool", RecipeType.TOOLS)
                    .addInput(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("stellarium_axe", InstanceType.ITEM, 1),
                            new MyIngredient("stellarium_hoe", InstanceType.ITEM, 1),
                            new MyIngredient("stellarium_pickaxe", InstanceType.ITEM, 1),
                            new MyIngredient("stellarium_shovel", InstanceType.ITEM, 1),
                            new MyIngredient("stellarium_sword", InstanceType.ITEM, 1)))
                    .build())
            .addRecipe(RecipeBuilder.builder("stellarium_armor", RecipeType.ARMOR)
                    .addInput(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("stellarium_boots", InstanceType.ITEM, 1),
                            new MyIngredient("stellarium_chestplate", InstanceType.ITEM, 1),
                            new MyIngredient("stellarium_helmet", InstanceType.ITEM, 1),
                            new MyIngredient("stellarium_leggings", InstanceType.ITEM, 1)))
                    .build())
            .build());

    public static final Item STELLARIUM_AXE = addNewItem(GenericItems.builder("stellarium_axe", ItemsType.AXE)
            .addTranslate("fr_fr", "Hache en stellarium")
            .addTranslate("en_us", "Stellarium axe")
            .addTag(ModTags.Items.STELLARIUM_TOOL)
            .toolMaterial(CustomItemTiers.STELLARIUM)
            .build());
    public static final Item STELLARIUM_HOE = addNewItem(GenericItems.builder("stellarium_hoe", ItemsType.HOE)
            .addTranslate("fr_fr", "Houe en stellarium")     .addTranslate("en_us", "Stellarium hoe")
            .addTag(ModTags.Items.STELLARIUM_TOOL)
            .toolMaterial(CustomItemTiers.STELLARIUM)
            .build());
    public static final Item STELLARIUM_PICKAXE = addNewItem(GenericItems.builder("stellarium_pickaxe", ItemsType.PICKAXE)
            .addTranslate("fr_fr", "Pioche en stellarium")   .addTranslate("en_us", "Stellarium pickaxe")
            .addTag(ModTags.Items.STELLARIUM_TOOL)
            .toolMaterial(CustomItemTiers.STELLARIUM)
            .build());
    public static final Item STELLARIUM_SHOVEL = addNewItem(GenericItems.builder("stellarium_shovel", ItemsType.SHOVEL)
            .addTranslate("fr_fr", "Pelle en stellarium")    .addTranslate("en_us", "Stellarium shovel")
            .addTag(ModTags.Items.STELLARIUM_TOOL)
            .toolMaterial(CustomItemTiers.STELLARIUM)
            .build());
    public static final Item STELLARIUM_SWORD = addNewItem(GenericItems.builder("stellarium_sword", ItemsType.SWORD)
            .addTranslate("fr_fr", "Epée en stellarium")
            .addTranslate("en_us", "Stellarium sword")
            .addTag(ModTags.Items.STELLARIUM_WEAPON)
            .toolMaterial(CustomItemTiers.STELLARIUM)
            .build());
    public static final Item STELLARIUM_HELMET = addNewItem(GenericItems.builder("stellarium_helmet", ItemsType.HELMET)
            .addTranslate("fr_fr", "Casque en stellarium")
            .addTranslate("en_us", "Stellarium helmet")
            .addTag(ModTags.Items.STELLARIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.STELLARIUM_ARMOR)
            .build());
    public static final Item STELLARIUM_CHESTPLATE = addNewItem(GenericItems.builder("stellarium_chestplate", ItemsType.CHESTPLATE)
            .addTranslate("fr_fr", "Plastron en stellarium")
            .addTranslate("en_us", "Stellarium chestplate")
            .addTag(ModTags.Items.STELLARIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.STELLARIUM_ARMOR)
            .build());
    public static final Item STELLARIUM_LEGGINGS = addNewItem(GenericItems.builder("stellarium_leggings", ItemsType.LEGGINGS)
            .addTranslate("fr_fr", "Pantalon en stellarium")
            .addTranslate("en_us", "Stellarium leggings")
            .addTag(ModTags.Items.STELLARIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.STELLARIUM_ARMOR)
            .build());
    public static final Item STELLARIUM_BOOTS = addNewItem(GenericItems.builder("stellarium_boots", ItemsType.BOOTS)
            .addTranslate("fr_fr", "Bottes en stellarium")
            .addTranslate("en_us", "Stellarium boots")
            .addTag(ModTags.Items.STELLARIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.STELLARIUM_ARMOR)
            .build());

    // ── ZIRCONIUM ─────────────────────────────────────────────────────────────
    public static final Item ZIRCONIUM_INGOT = addNewItem(GenericItems.builder("zirconium_ingot", ItemsType.INGOT)
            .addTranslate("fr_fr", "Lingot de zirconium")
            .addTranslate("en_us", "Zirconium ingot")
            .addTag(ModTags.Items.ZIRCONIUM_REPAIR)
            .addRecipe(RecipeBuilder.builder("zirconium_block", RecipeType.SHAPE)
                    .addInput(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))
                    .addOutput(new MyIngredient("zirconium_block", InstanceType.BLOCK, 1))
                    .pattern(List.of("000", "000", "000"))
                    .unlock(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))
                    .build())
            .addRecipe(RecipeBuilder.builder("zirconium_tool", RecipeType.TOOLS)
                    .addInput(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("zirconium_axe", InstanceType.ITEM, 1),
                            new MyIngredient("zirconium_hoe", InstanceType.ITEM, 1),
                            new MyIngredient("zirconium_pickaxe", InstanceType.ITEM, 1),
                            new MyIngredient("zirconium_shovel", InstanceType.ITEM, 1),
                            new MyIngredient("zirconium_sword", InstanceType.ITEM, 1)))
                    .build())
            .addRecipe(RecipeBuilder.builder("zirconium_armor", RecipeType.ARMOR)
                    .addInput(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("zirconium_boots", InstanceType.ITEM, 1),
                            new MyIngredient("zirconium_chestplate", InstanceType.ITEM, 1),
                            new MyIngredient("zirconium_helmet", InstanceType.ITEM, 1),
                            new MyIngredient("zirconium_leggings", InstanceType.ITEM, 1)))
                    .build())
            .addRecipe(RecipeBuilder.builder("zirconium_ingot_to_zircaloy_ingot", RecipeType.FORGE)
                    .addInput(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))
                    .addFluid(new MyIngredient("solarium_fluid_still", InstanceType.FLUID, 200))
                    .addOutput(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1))
                    .build())
            .build());

    public static final Item ZIRCONIUM_RAW = addNewItem(GenericItems.builder("zirconium_raw", ItemsType.RAW)
            .addTranslate("fr_fr", "Zirconium brut")
            .addTranslate("en_us", "Zirconium raw")
            .addTag(ModTags.Items.ZIRCONIUM_REPAIR)
            .addRecipe(RecipeBuilder.builder("raw_to_zirconium_ingot", RecipeType.ORE)
                    .addInput(new MyIngredient("zirconium_raw", InstanceType.ITEM, 1))
                    .addOutput(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))
                    .build())
            .addRecipe(RecipeBuilder.builder("raw_to_zirconium_ingot", RecipeType.FORGE)
                    .addInput(new MyIngredient("zirconium_raw", InstanceType.ITEM, 1))
                    .addFluid(new MyIngredient("solarium_fluid_still", InstanceType.FLUID, 200))
                    .addOutput(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 2))
                    .build())
            .build());

    public static final Item ZIRCONIUM_AXE = addNewItem(GenericItems.builder("zirconium_axe", ItemsType.AXE)
            .addTranslate("fr_fr", "Hache en zirconium")
            .addTranslate("en_us", "Zirconium axe")
            .addTag(ModTags.Items.ZIRCONIUM_TOOL)
            .toolMaterial(CustomItemTiers.ZIRCONIUM)
            .build());
    public static final Item ZIRCONIUM_HOE = addNewItem(GenericItems.builder("zirconium_hoe", ItemsType.HOE)
            .addTranslate("fr_fr", "Houe en zirconium")
            .addTranslate("en_us", "Zirconium hoe")
            .addTag(ModTags.Items.ZIRCONIUM_TOOL)
            .toolMaterial(CustomItemTiers.ZIRCONIUM)
            .build());
    public static final Item ZIRCONIUM_PICKAXE = addNewItem(GenericItems.builder("zirconium_pickaxe", ItemsType.PICKAXE)
            .addTranslate("fr_fr", "Pioche en zirconium")
            .addTranslate("en_us", "Zirconium pickaxe")
            .addTag(ModTags.Items.ZIRCONIUM_TOOL)
            .toolMaterial(CustomItemTiers.ZIRCONIUM)
            .build());
    public static final Item ZIRCONIUM_SHOVEL = addNewItem(GenericItems.builder("zirconium_shovel", ItemsType.SHOVEL)
            .addTranslate("fr_fr", "Pelle en zirconium")
            .addTranslate("en_us", "Zirconium shovel")
            .addTag(ModTags.Items.ZIRCONIUM_TOOL)
            .toolMaterial(CustomItemTiers.ZIRCONIUM)
            .build());
    public static final Item ZIRCONIUM_SWORD = addNewItem(GenericItems.builder("zirconium_sword", ItemsType.SWORD)
            .addTranslate("fr_fr", "Epée en zirconium")
            .addTranslate("en_us", "Zirconium sword")
            .addTag(ModTags.Items.ZIRCONIUM_WEAPON)
            .toolMaterial(CustomItemTiers.ZIRCONIUM)
            .build());
    public static final Item ZIRCONIUM_HELMET = addNewItem(GenericItems.builder("zirconium_helmet", ItemsType.HELMET)
            .addTranslate("fr_fr", "Casque en zirconium")
            .addTranslate("en_us", "Zirconium helmet")
            .addTag(ModTags.Items.ZIRCONIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.ZIRCONIUM_ARMOR)
            .build());
    public static final Item ZIRCONIUM_CHESTPLATE = addNewItem(GenericItems.builder("zirconium_chestplate", ItemsType.CHESTPLATE)
            .addTranslate("fr_fr", "Plastron en zirconium")
            .addTranslate("en_us", "Zirconium chestplate")
            .addTag(ModTags.Items.ZIRCONIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.ZIRCONIUM_ARMOR)
            .build());
    public static final Item ZIRCONIUM_LEGGINGS = addNewItem(GenericItems.builder("zirconium_leggings", ItemsType.LEGGINGS)
            .addTranslate("fr_fr", "Pantalon en zirconium")
            .addTranslate("en_us", "Zirconium leggings")
            .addTag(ModTags.Items.ZIRCONIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.ZIRCONIUM_ARMOR)
            .build());
    public static final Item ZIRCONIUM_BOOTS = addNewItem(GenericItems.builder("zirconium_boots", ItemsType.BOOTS)
            .addTranslate("fr_fr", "Bottes en zirconium")
            .addTranslate("en_us", "Zirconium boots")
            .addTag(ModTags.Items.ZIRCONIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.ZIRCONIUM_ARMOR)
            .build());

    // ── IRIDIUM ───────────────────────────────────────────────────────────────
    public static final Item IRIDIUM_INGOT = addNewItem(GenericItems.builder("iridium_ingot", ItemsType.INGOT)
            .addTranslate("fr_fr", "Lingot de iridium")
            .addTranslate("en_us", "Iridium ingot")
            .addTag(ModTags.Items.IRIDIUM_REPAIR)
            .addRecipe(RecipeBuilder.builder("iridium_block", RecipeType.SHAPE)
                    .addInput(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))
                    .addOutput(new MyIngredient("iridium_block", InstanceType.BLOCK, 1))
                    .pattern(List.of("000", "000", "000"))
                    .unlock(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))
                    .build())
            .addRecipe(RecipeBuilder.builder("iridium_tool", RecipeType.TOOLS)
                    .addInput(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("iridium_axe", InstanceType.ITEM, 1),
                            new MyIngredient("iridium_hoe", InstanceType.ITEM, 1),
                            new MyIngredient("iridium_pickaxe", InstanceType.ITEM, 1),
                            new MyIngredient("iridium_shovel", InstanceType.ITEM, 1),
                            new MyIngredient("iridium_sword", InstanceType.ITEM, 1)))
                    .build())
            .addRecipe(RecipeBuilder.builder("iridium_armor", RecipeType.ARMOR)
                    .addInput(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("iridium_boots", InstanceType.ITEM, 1),
                            new MyIngredient("iridium_chestplate", InstanceType.ITEM, 1),
                            new MyIngredient("iridium_helmet", InstanceType.ITEM, 1),
                            new MyIngredient("iridium_leggings", InstanceType.ITEM, 1)))
                    .build())
            .addRecipe(RecipeBuilder.builder("iridium_ingot_to_osmiridium_ingot", RecipeType.FORGE)
                    .addInput(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))
                    .addFluid(new MyIngredient("solarium_fluid_still", InstanceType.FLUID, 200))
                    .addOutput(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1))
                    .build())
            .build());

    public static final Item IRIDIUM_RAW = addNewItem(GenericItems.builder("iridium_raw", ItemsType.RAW)
            .addTranslate("fr_fr", "Iridium brut")
            .addTranslate("en_us", "Iridium raw")
            .addTag(ModTags.Items.IRIDIUM_REPAIR)
            .addRecipe(RecipeBuilder.builder("raw_to_iridium_ingot", RecipeType.ORE)
                    .addInput(new MyIngredient("iridium_raw", InstanceType.ITEM, 1))
                    .addOutput(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))
                    .build())
            .addRecipe(RecipeBuilder.builder("raw_to_iridium_ingot", RecipeType.FORGE)
                    .addInput(new MyIngredient("iridium_raw", InstanceType.ITEM, 1))
                    .addFluid(new MyIngredient("solarium_fluid_still", InstanceType.FLUID, 200))
                    .addOutput(new MyIngredient("iridium_ingot", InstanceType.ITEM, 2))
                    .build())
            .build());

    public static final Item IRIDIUM_AXE = addNewItem(GenericItems.builder("iridium_axe", ItemsType.AXE)
            .addTranslate("fr_fr", "Hache en iridium")
            .addTranslate("en_us", "Iridium axe")
            .addTag(ModTags.Items.IRIDIUM_TOOL)
            .toolMaterial(CustomItemTiers.IRIDIUM).build());
    public static final Item IRIDIUM_HOE = addNewItem(GenericItems.builder("iridium_hoe", ItemsType.HOE)
            .addTranslate("fr_fr", "Houe en iridium")
            .addTranslate("en_us", "Iridium hoe")
            .addTag(ModTags.Items.IRIDIUM_TOOL)
            .toolMaterial(CustomItemTiers.IRIDIUM)
            .build());
    public static final Item IRIDIUM_PICKAXE = addNewItem(GenericItems.builder("iridium_pickaxe", ItemsType.PICKAXE)
            .addTranslate("fr_fr", "Pioche en iridium")
            .addTranslate("en_us", "Iridium pickaxe")
            .addTag(ModTags.Items.IRIDIUM_TOOL)
            .toolMaterial(CustomItemTiers.IRIDIUM)
            .build());
    public static final Item IRIDIUM_SHOVEL = addNewItem(GenericItems.builder("iridium_shovel", ItemsType.SHOVEL)
            .addTranslate("fr_fr", "Pelle en iridium")
            .addTranslate("en_us", "Iridium shovel")
            .addTag(ModTags.Items.IRIDIUM_TOOL)
            .toolMaterial(CustomItemTiers.IRIDIUM)
            .build());
    public static final Item IRIDIUM_SWORD = addNewItem(GenericItems.builder("iridium_sword", ItemsType.SWORD)
            .addTranslate("fr_fr", "Epée en iridium")
            .addTranslate("en_us", "Iridium sword")
            .addTag(ModTags.Items.IRIDIUM_WEAPON)
            .toolMaterial(CustomItemTiers.IRIDIUM)
            .build());
    public static final Item IRIDIUM_HELMET = addNewItem(GenericItems.builder("iridium_helmet", ItemsType.HELMET)
            .addTranslate("fr_fr", "Casque en iridium")
            .addTranslate("en_us", "Iridium helmet")
            .addTag(ModTags.Items.IRIDIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.IRIDIUM_ARMOR)
            .build());
    public static final Item IRIDIUM_CHESTPLATE = addNewItem(GenericItems.builder("iridium_chestplate", ItemsType.CHESTPLATE)
            .addTranslate("fr_fr", "Plastron en iridium")
            .addTranslate("en_us", "Iridium chestplate")
            .addTag(ModTags.Items.IRIDIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.IRIDIUM_ARMOR)
            .build());
    public static final Item IRIDIUM_LEGGINGS = addNewItem(GenericItems.builder("iridium_leggings", ItemsType.LEGGINGS)
            .addTranslate("fr_fr", "Pantalon en iridium")
            .addTranslate("en_us", "Iridium leggings")
            .addTag(ModTags.Items.IRIDIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.IRIDIUM_ARMOR)
            .build());
    public static final Item IRIDIUM_BOOTS = addNewItem(GenericItems.builder("iridium_boots", ItemsType.BOOTS)
            .addTranslate("fr_fr", "Bottes en iridium")
            .addTranslate("en_us", "Iridium boots")
            .addTag(ModTags.Items.IRIDIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.IRIDIUM_ARMOR)
            .build());

    // ── ZIRCALOY ──────────────────────────────────────────────────────────────
    public static final Item ZIRCALOY_INGOT = addNewItem(GenericItems.builder("zircaloy_ingot", ItemsType.INGOT)
            .addTranslate("fr_fr", "Lingot de zircaloy")
            .addTranslate("en_us", "Zircaloy ingot")
            .addTag(ModTags.Items.ZIRCALOY_REPAIR)
            .addRecipe(RecipeBuilder.builder("zircaloy_block", RecipeType.SHAPE)
                    .addInput(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1))
                    .addOutput(new MyIngredient("zircaloy_block", InstanceType.BLOCK, 1))
                    .pattern(List.of("000", "000", "000"))
                    .unlock(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1))
                    .build())
            .addRecipe(RecipeBuilder.builder("zircaloy_tool", RecipeType.TOOLS)
                    .addInput(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("zircaloy_axe", InstanceType.ITEM, 1),
                            new MyIngredient("zircaloy_hoe", InstanceType.ITEM, 1),
                            new MyIngredient("zircaloy_pickaxe", InstanceType.ITEM, 1),
                            new MyIngredient("zircaloy_shovel", InstanceType.ITEM, 1),
                            new MyIngredient("zircaloy_sword", InstanceType.ITEM, 1)))
                    .build())
            .addRecipe(RecipeBuilder.builder("zircaloy_armor", RecipeType.ARMOR)
                    .addInput(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("zircaloy_boots", InstanceType.ITEM, 1),
                            new MyIngredient("zircaloy_chestplate", InstanceType.ITEM, 1),
                            new MyIngredient("zircaloy_helmet", InstanceType.ITEM, 1),
                            new MyIngredient("zircaloy_leggings", InstanceType.ITEM, 1)))
                    .build())
            .build());

    public static final Item ZIRCALOY_AXE = addNewItem(GenericItems.builder("zircaloy_axe", ItemsType.AXE)
            .addTranslate("fr_fr", "Hache en zircaloy")
            .addTranslate("en_us", "Zircaloy axe")
            .addTag(ModTags.Items.ZIRCALOY_TOOL)
            .toolMaterial(CustomItemTiers.ZIRCALOY)
            .build());
    public static final Item ZIRCALOY_HOE = addNewItem(GenericItems.builder("zircaloy_hoe", ItemsType.HOE)
            .addTranslate("fr_fr", "Houe en zircaloy")
            .addTranslate("en_us", "Zircaloy hoe")
            .addTag(ModTags.Items.ZIRCALOY_TOOL)
            .toolMaterial(CustomItemTiers.ZIRCALOY)
            .build());
    public static final Item ZIRCALOY_PICKAXE = addNewItem(GenericItems.builder("zircaloy_pickaxe", ItemsType.PICKAXE)
            .addTranslate("fr_fr", "Pioche en zircaloy")
            .addTranslate("en_us", "Zircaloy pickaxe")
            .addTag(ModTags.Items.ZIRCALOY_TOOL)
            .toolMaterial(CustomItemTiers.ZIRCALOY)
            .build());
    public static final Item ZIRCALOY_SHOVEL = addNewItem(GenericItems.builder("zircaloy_shovel", ItemsType.SHOVEL)
            .addTranslate("fr_fr", "Pelle en zircaloy")
            .addTranslate("en_us", "Zircaloy shovel")
            .addTag(ModTags.Items.ZIRCALOY_TOOL)
            .toolMaterial(CustomItemTiers.ZIRCALOY)
            .build());
    public static final Item ZIRCALOY_SWORD = addNewItem(GenericItems.builder("zircaloy_sword", ItemsType.SWORD)
            .addTranslate("fr_fr", "Epée en zircaloy")
            .addTranslate("en_us", "Zircaloy sword")
            .addTag(ModTags.Items.ZIRCALOY_WEAPON)
            .toolMaterial(CustomItemTiers.ZIRCALOY)
            .build());
    public static final Item ZIRCALOY_HELMET = addNewItem(GenericItems.builder("zircaloy_helmet", ItemsType.HELMET)
            .addTranslate("fr_fr", "Casque en zircaloy")
            .addTranslate("en_us", "Zircaloy helmet")
            .addTag(ModTags.Items.ZIRCALOY_ARMOR)
            .armorMaterial(CustomArmorMaterials.ZIRCALOY_ARMOR)
            .build());
    public static final Item ZIRCALOY_CHESTPLATE = addNewItem(GenericItems.builder("zircaloy_chestplate", ItemsType.CHESTPLATE)
            .addTranslate("fr_fr", "Plastron en zircaloy")
            .addTranslate("en_us", "Zircaloy chestplate")
            .addTag(ModTags.Items.ZIRCALOY_ARMOR)
            .armorMaterial(CustomArmorMaterials.ZIRCALOY_ARMOR)
            .build());
    public static final Item ZIRCALOY_LEGGINGS = addNewItem(GenericItems.builder("zircaloy_leggings", ItemsType.LEGGINGS)
            .addTranslate("fr_fr", "Pantalon en zircaloy")
            .addTranslate("en_us", "Zircaloy leggings")
            .addTag(ModTags.Items.ZIRCALOY_ARMOR)
            .armorMaterial(CustomArmorMaterials.ZIRCALOY_ARMOR)
            .build());
    public static final Item ZIRCALOY_BOOTS = addNewItem(GenericItems.builder("zircaloy_boots", ItemsType.BOOTS)
            .addTranslate("fr_fr", "Bottes en zircaloy")
            .addTranslate("en_us", "Zircaloy boots")
            .addTag(ModTags.Items.ZIRCALOY_ARMOR)
            .armorMaterial(CustomArmorMaterials.ZIRCALOY_ARMOR)
            .build());

    // ── OSMIRIDIUM ────────────────────────────────────────────────────────────
    public static final Item OSMIRIDIUM_INGOT = addNewItem(GenericItems.builder("osmiridium_ingot", ItemsType.INGOT)
            .addTranslate("fr_fr", "Lingot de osmiridium")
            .addTranslate("en_us", "Osmiridium ingot")
            .addTag(ModTags.Items.OSMIRIDIUM_REPAIR)
            .addRecipe(RecipeBuilder.builder("osmiridium_block", RecipeType.SHAPE)
                    .addInput(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1))
                    .addOutput(new MyIngredient("osmiridium_block", InstanceType.BLOCK, 1))
                    .pattern(List.of("000", "000", "000"))
                    .unlock(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1))
                    .build())
            .addRecipe(RecipeBuilder.builder("osmiridium_tool", RecipeType.TOOLS)
                    .addInput(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("osmiridium_axe", InstanceType.ITEM, 1),
                            new MyIngredient("osmiridium_hoe", InstanceType.ITEM, 1),
                            new MyIngredient("osmiridium_pickaxe", InstanceType.ITEM, 1),
                            new MyIngredient("osmiridium_shovel", InstanceType.ITEM, 1),
                            new MyIngredient("osmiridium_sword", InstanceType.ITEM, 1)))
                    .build())
            .addRecipe(RecipeBuilder.builder("osmiridium_armor", RecipeType.ARMOR)
                    .addInput(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1))
                    .outputs(List.of(
                            new MyIngredient("osmiridium_boots", InstanceType.ITEM, 1),
                            new MyIngredient("osmiridium_chestplate", InstanceType.ITEM, 1),
                            new MyIngredient("osmiridium_helmet", InstanceType.ITEM, 1),
                            new MyIngredient("osmiridium_leggings", InstanceType.ITEM, 1)))
                    .build())
            .build());

    public static final Item OSMIRIDIUM_AXE = addNewItem(GenericItems.builder("osmiridium_axe", ItemsType.AXE)
            .addTranslate("fr_fr", "Hache en osmiridium")
            .addTranslate("en_us", "Osmiridium axe")
            .addTag(ModTags.Items.OSMIRIDIUM_TOOL)
            .toolMaterial(CustomItemTiers.OSMIRIDIUM)
            .build());
    public static final Item OSMIRIDIUM_HOE = addNewItem(GenericItems.builder("osmiridium_hoe", ItemsType.HOE)
            .addTranslate("fr_fr", "Houe en osmiridium")
            .addTranslate("en_us", "Osmiridium hoe")
            .addTag(ModTags.Items.OSMIRIDIUM_TOOL)
            .toolMaterial(CustomItemTiers.OSMIRIDIUM)
            .build());
    public static final Item OSMIRIDIUM_PICKAXE = addNewItem(GenericItems.builder("osmiridium_pickaxe", ItemsType.PICKAXE)
            .addTranslate("fr_fr", "Pioche en osmiridium")
            .addTranslate("en_us", "Osmiridium pickaxe")
            .addTag(ModTags.Items.OSMIRIDIUM_TOOL)
            .toolMaterial(CustomItemTiers.OSMIRIDIUM)
            .build());
    public static final Item OSMIRIDIUM_SHOVEL = addNewItem(GenericItems.builder("osmiridium_shovel", ItemsType.SHOVEL)
            .addTranslate("fr_fr", "Pelle en osmiridium")
            .addTranslate("en_us", "Osmiridium shovel")
            .addTag(ModTags.Items.OSMIRIDIUM_TOOL)
            .toolMaterial(CustomItemTiers.OSMIRIDIUM)
            .build());
    public static final Item OSMIRIDIUM_SWORD = addNewItem(GenericItems.builder("osmiridium_sword", ItemsType.SWORD)
            .addTranslate("fr_fr", "Epée en osmiridium")
            .addTranslate("en_us", "Osmiridium sword")
            .addTag(ModTags.Items.OSMIRIDIUM_WEAPON)
            .toolMaterial(CustomItemTiers.OSMIRIDIUM)
            .build());
    public static final Item OSMIRIDIUM_HELMET = addNewItem(GenericItems.builder("osmiridium_helmet", ItemsType.HELMET)
            .addTranslate("fr_fr", "Casque en osmiridium")
            .addTranslate("en_us", "Osmiridium helmet")
            .addTag(ModTags.Items.OSMIRIDIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.OSMIRIDIUM_ARMOR)
            .build());
    public static final Item OSMIRIDIUM_CHESTPLATE = addNewItem(GenericItems.builder("osmiridium_chestplate", ItemsType.CHESTPLATE)
            .addTranslate("fr_fr", "Plastron en osmiridium")
            .addTranslate("en_us", "Osmiridium chestplate")
            .addTag(ModTags.Items.OSMIRIDIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.OSMIRIDIUM_ARMOR)
            .build());
    public static final Item OSMIRIDIUM_LEGGINGS = addNewItem(GenericItems.builder("osmiridium_leggings", ItemsType.LEGGINGS)
            .addTranslate("fr_fr", "Pantalon en osmiridium")
            .addTranslate("en_us", "Osmiridium leggings")
            .addTag(ModTags.Items.OSMIRIDIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.OSMIRIDIUM_ARMOR)
            .build());
    public static final Item OSMIRIDIUM_BOOTS = addNewItem(GenericItems.builder("osmiridium_boots", ItemsType.BOOTS)
            .addTranslate("fr_fr", "Bottes en osmiridium")
            .addTranslate("en_us", "Osmiridium boots")
            .addTag(ModTags.Items.OSMIRIDIUM_ARMOR)
            .armorMaterial(CustomArmorMaterials.OSMIRIDIUM_ARMOR)
            .build());


    // ── Registration ──────────────────────────────────────────────────────────
    public static <T extends Item & IMyItem> T addNewItem(T item) {
        Registry.register(Registries.ITEM, Identifier.of(Stellamecanics.MOD_ID, item.getId()), item);
        ITEMS.put(item.getId(), item);
        return item;
    }

    public static void registerModItems() { Stellamecanics.LOGGER.debug("Registering Mod Items for " + Stellamecanics.MOD_ID); }
}