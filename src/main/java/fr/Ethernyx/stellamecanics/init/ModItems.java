package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.ethernyx.stellamecanics.utils.generic.GenericItems;
import fr.ethernyx.stellamecanics.utils.generic.ItemsType;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItems {
    public static Map<String, IMyItem> ITEMS = new HashMap<>();

    public static final Item MAGNETITE_RAW = addNewItem(misc("magnetite_raw", ItemsType.RAW, Map.of("fr_fr", "Magnétite brut", "en_us", "Magnetite raw"), null, null));

    // ── SOLARIUM ──────────────────────────────────────────────────────────────
    public static final Item SOLARIUM_INGOT = addNewItem(misc("solarium_ingot", ItemsType.INGOT,
            Map.of("fr_fr", "Lingot de solarium", "en_us", "Solarium ingot"), null, List.of(
                    new RecipeBuilder("solarium_block", RecipeType.SHAPE,
                            List.of(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("solarium_block", InstanceType.BLOCK, 1)),
                            List.of("000", "000", "000"),
                            List.of(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))),
                    new RecipeBuilder("solarium_tool", RecipeType.TOOLS,
                            List.of(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("solarium_axe", InstanceType.ITEM, 1),
                                    new MyIngredient("solarium_hoe", InstanceType.ITEM, 1),
                                    new MyIngredient("solarium_pickaxe", InstanceType.ITEM, 1),
                                    new MyIngredient("solarium_shovel", InstanceType.ITEM, 1),
                                    new MyIngredient("solarium_sword", InstanceType.ITEM, 1))),
                    new RecipeBuilder("solarium_armor", RecipeType.ARMOR,
                            List.of(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("solarium_boots", InstanceType.ITEM, 1),
                                    new MyIngredient("solarium_chestplate", InstanceType.ITEM, 1),
                                    new MyIngredient("solarium_helmet", InstanceType.ITEM, 1),
                                    new MyIngredient("solarium_leggings", InstanceType.ITEM, 1))),
                    new RecipeBuilder("solarium_ingot_to_stellarium_ingot", RecipeType.FORGE,
                            List.of(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("lunarium_fluid_still", InstanceType.FLUID, 200)),
                            List.of(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1)))
            )));
    public static final Item SOLARIUM_RAW = addNewItem(misc("solarium_raw", ItemsType.RAW,
            Map.of("fr_fr", "Solarium brut", "en_us", "Solarium raw"), null, List.of(
                    new RecipeBuilder("raw_to_solarium_ingot", RecipeType.ORE,
                            List.of(new MyIngredient("solarium_raw", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))),
                    new RecipeBuilder("raw_to_solarium_ingot", RecipeType.FORGE,
                            List.of(new MyIngredient("solarium_raw", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("lunarium_fluid_still", InstanceType.FLUID, 200)),
                            List.of(new MyIngredient("solarium_ingot", InstanceType.ITEM, 2)))
            )));
    public static final Item SOLARIUM_AXE = addNewItem(tool("solarium_axe", ItemsType.AXE, CustomItemTiers.SOLARIUM, Map.of("fr_fr", "Hache en solarium", "en_us", "Solarium axe"), null, null));
    public static final Item SOLARIUM_HOE = addNewItem(tool("solarium_hoe", ItemsType.HOE, CustomItemTiers.SOLARIUM, Map.of("fr_fr", "Houe en solarium", "en_us", "Solarium hoe"), null, null));
    public static final Item SOLARIUM_PICKAXE = addNewItem(tool("solarium_pickaxe", ItemsType.PICKAXE, CustomItemTiers.SOLARIUM, Map.of("fr_fr", "Pioche en solarium", "en_us", "Solarium pickaxe"), null, null));
    public static final Item SOLARIUM_SHOVEL = addNewItem(tool("solarium_shovel", ItemsType.SHOVEL, CustomItemTiers.SOLARIUM, Map.of("fr_fr", "Pelle en solarium", "en_us", "Solarium shovel"), null, null));
    public static final Item SOLARIUM_SWORD = addNewItem(tool("solarium_sword", ItemsType.SWORD, CustomItemTiers.SOLARIUM, Map.of("fr_fr", "Epée en solarium", "en_us", "Solarium sword"), null, null));
    public static final Item SOLARIUM_HELMET = addNewItem(armor("solarium_helmet", ItemsType.HELMET, CustomArmorMaterials.SOLARIUM_ARMOR, Map.of("fr_fr", "Casque en solarium", "en_us", "Solarium helmet"), null, null));
    public static final Item SOLARIUM_CHESTPLATE = addNewItem(armor("solarium_chestplate", ItemsType.CHESTPLATE, CustomArmorMaterials.SOLARIUM_ARMOR, Map.of("fr_fr", "Plastron en solarium", "en_us", "Solarium chestplate"), null, null));
    public static final Item SOLARIUM_LEGGINGS = addNewItem(armor("solarium_leggings", ItemsType.LEGGINGS, CustomArmorMaterials.SOLARIUM_ARMOR, Map.of("fr_fr", "Pantalon en solarium", "en_us", "Solarium leggings"), null, null));
    public static final Item SOLARIUM_BOOTS = addNewItem(armor("solarium_boots", ItemsType.BOOTS, CustomArmorMaterials.SOLARIUM_ARMOR, Map.of("fr_fr", "Bottes en solarium", "en_us", "Solarium boots"), null, null));

    // ── LUNARIUM ──────────────────────────────────────────────────────────────
    public static final Item LUNARIUM_INGOT = addNewItem(misc("lunarium_ingot", ItemsType.INGOT,
            Map.of("fr_fr", "Lingot de lunarium", "en_us", "Lunarium ingot"), null, List.of(
                    new RecipeBuilder("lunarium_block", RecipeType.SHAPE,
                            List.of(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("lunarium_block", InstanceType.BLOCK, 1)),
                            List.of("000", "000", "000"),
                            List.of(new MyIngredient("lunarium_block", InstanceType.BLOCK, 1))),
                    new RecipeBuilder("lunarium_tool", RecipeType.TOOLS,
                            List.of(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("lunarium_axe", InstanceType.ITEM, 1),
                                    new MyIngredient("lunarium_hoe", InstanceType.ITEM, 1),
                                    new MyIngredient("lunarium_pickaxe", InstanceType.ITEM, 1),
                                    new MyIngredient("lunarium_shovel", InstanceType.ITEM, 1),
                                    new MyIngredient("lunarium_sword", InstanceType.ITEM, 1))),
                    new RecipeBuilder("lunarium_armor", RecipeType.ARMOR,
                            List.of(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("lunarium_boots", InstanceType.ITEM, 1),
                                    new MyIngredient("lunarium_chestplate", InstanceType.ITEM, 1),
                                    new MyIngredient("lunarium_helmet", InstanceType.ITEM, 1),
                                    new MyIngredient("lunarium_leggings", InstanceType.ITEM, 1))),
                    new RecipeBuilder("lunarium_ingot_to_stellarium_ingot", RecipeType.FORGE,
                            List.of(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("solarium_fluid_still", InstanceType.FLUID, 200)),
                            List.of(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1)))
            )));
    public static final Item LUNARIUM_RAW = addNewItem(misc("lunarium_raw", ItemsType.RAW,
            Map.of("fr_fr", "Lunarium brut", "en_us", "Lunarium raw"), null, List.of(
                    new RecipeBuilder("raw_to_lunarium_ingot", RecipeType.ORE,
                            List.of(new MyIngredient("lunarium_raw", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))),
                    new RecipeBuilder("raw_to_lunarium_ingot", RecipeType.FORGE,
                            List.of(new MyIngredient("lunarium_raw", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("solarium_fluid_still", InstanceType.FLUID, 200)),
                            List.of(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 2)))
            )));
    public static final Item LUNARIUM_AXE = addNewItem(tool("lunarium_axe", ItemsType.AXE, CustomItemTiers.LUNARIUM, Map.of("fr_fr", "Hache en lunarium", "en_us", "Lunarium axe"), null, null));
    public static final Item LUNARIUM_HOE = addNewItem(tool("lunarium_hoe", ItemsType.HOE, CustomItemTiers.LUNARIUM, Map.of("fr_fr", "Houe en lunarium", "en_us", "Lunarium hoe"), null, null));
    public static final Item LUNARIUM_PICKAXE = addNewItem(tool("lunarium_pickaxe", ItemsType.PICKAXE, CustomItemTiers.LUNARIUM, Map.of("fr_fr", "Pioche en lunarium", "en_us", "Lunarium pickaxe"), null, null));
    public static final Item LUNARIUM_SHOVEL = addNewItem(tool("lunarium_shovel", ItemsType.SHOVEL, CustomItemTiers.LUNARIUM, Map.of("fr_fr", "Pelle en lunarium", "en_us", "Lunarium shovel"), null, null));
    public static final Item LUNARIUM_SWORD = addNewItem(tool("lunarium_sword", ItemsType.SWORD, CustomItemTiers.LUNARIUM, Map.of("fr_fr", "Epée en lunarium", "en_us", "Lunarium sword"), null, null));
    public static final Item LUNARIUM_HELMET = addNewItem(armor("lunarium_helmet", ItemsType.HELMET, CustomArmorMaterials.LUNARIUM_ARMOR, Map.of("fr_fr", "Casque en lunarium", "en_us", "Lunarium helmet"), null, null));
    public static final Item LUNARIUM_CHESTPLATE = addNewItem(armor("lunarium_chestplate", ItemsType.CHESTPLATE, CustomArmorMaterials.LUNARIUM_ARMOR, Map.of("fr_fr", "Plastron en lunarium", "en_us", "Lunarium chestplate"), null, null));
    public static final Item LUNARIUM_LEGGINGS = addNewItem(armor("lunarium_leggings", ItemsType.LEGGINGS, CustomArmorMaterials.LUNARIUM_ARMOR, Map.of("fr_fr", "Pantalon en lunarium", "en_us", "Lunarium leggings"), null, null));
    public static final Item LUNARIUM_BOOTS = addNewItem(armor("lunarium_boots", ItemsType.BOOTS, CustomArmorMaterials.LUNARIUM_ARMOR, Map.of("fr_fr", "Bottes en lunarium", "en_us", "Lunarium boots"), null, null));

    // ── STELLARIUM ────────────────────────────────────────────────────────────
    public static final Item STELLARIUM_INGOT = addNewItem(misc("stellarium_ingot", ItemsType.INGOT,
            Map.of("fr_fr", "Lingot de stellarium", "en_us", "Stellarium ingot"), null, List.of(
                    new RecipeBuilder("stellarium_block", RecipeType.SHAPE,
                            List.of(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("stellarium_block", InstanceType.BLOCK, 1)),
                            List.of("000", "000", "000"),
                            List.of(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1))),
                    new RecipeBuilder("stellarium_tool", RecipeType.TOOLS,
                            List.of(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("stellarium_axe", InstanceType.ITEM, 1),
                                    new MyIngredient("stellarium_hoe", InstanceType.ITEM, 1),
                                    new MyIngredient("stellarium_pickaxe", InstanceType.ITEM, 1),
                                    new MyIngredient("stellarium_shovel", InstanceType.ITEM, 1),
                                    new MyIngredient("stellarium_sword", InstanceType.ITEM, 1))),
                    new RecipeBuilder("stellarium_armor", RecipeType.ARMOR,
                            List.of(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("stellarium_boots", InstanceType.ITEM, 1),
                                    new MyIngredient("stellarium_chestplate", InstanceType.ITEM, 1),
                                    new MyIngredient("stellarium_helmet", InstanceType.ITEM, 1),
                                    new MyIngredient("stellarium_leggings", InstanceType.ITEM, 1)))
            )));
    public static final Item STELLARIUM_AXE = addNewItem(tool("stellarium_axe", ItemsType.AXE, CustomItemTiers.STELLARIUM, Map.of("fr_fr", "Hache en stellarium", "en_us", "Stellarium axe"), null, null));
    public static final Item STELLARIUM_HOE = addNewItem(tool("stellarium_hoe", ItemsType.HOE, CustomItemTiers.STELLARIUM, Map.of("fr_fr", "Houe en stellarium", "en_us", "Stellarium hoe"), null, null));
    public static final Item STELLARIUM_PICKAXE = addNewItem(tool("stellarium_pickaxe", ItemsType.PICKAXE, CustomItemTiers.STELLARIUM, Map.of("fr_fr", "Pioche en stellarium", "en_us", "Stellarium pickaxe"), null, null));
    public static final Item STELLARIUM_SHOVEL = addNewItem(tool("stellarium_shovel", ItemsType.SHOVEL, CustomItemTiers.STELLARIUM, Map.of("fr_fr", "Pelle en stellarium", "en_us", "Stellarium shovel"), null, null));
    public static final Item STELLARIUM_SWORD = addNewItem(tool("stellarium_sword", ItemsType.SWORD, CustomItemTiers.STELLARIUM, Map.of("fr_fr", "Epée en stellarium", "en_us", "Stellarium sword"), null, null));
    public static final Item STELLARIUM_HELMET = addNewItem(armor("stellarium_helmet", ItemsType.HELMET, CustomArmorMaterials.STELLARIUM_ARMOR, Map.of("fr_fr", "Casque en stellarium", "en_us", "Stellarium helmet"), null, null));
    public static final Item STELLARIUM_CHESTPLATE = addNewItem(armor("stellarium_chestplate", ItemsType.CHESTPLATE, CustomArmorMaterials.STELLARIUM_ARMOR, Map.of("fr_fr", "Plastron en stellarium", "en_us", "Stellarium chestplate"), null, null));
    public static final Item STELLARIUM_LEGGINGS = addNewItem(armor("stellarium_leggings", ItemsType.LEGGINGS, CustomArmorMaterials.STELLARIUM_ARMOR, Map.of("fr_fr", "Pantalon en stellarium", "en_us", "Stellarium leggings"), null, null));
    public static final Item STELLARIUM_BOOTS = addNewItem(armor("stellarium_boots", ItemsType.BOOTS, CustomArmorMaterials.STELLARIUM_ARMOR, Map.of("fr_fr", "Bottes en stellarium", "en_us", "Stellarium boots"), null, null));

    // ── ZIRCONIUM ─────────────────────────────────────────────────────────────
    public static final Item ZIRCONIUM_INGOT = addNewItem(misc("zirconium_ingot", ItemsType.INGOT,
            Map.of("fr_fr", "Lingot de zirconium", "en_us", "Zirconium ingot"), null, List.of(
                    new RecipeBuilder("zirconium_block", RecipeType.SHAPE,
                            List.of(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("zirconium_block", InstanceType.BLOCK, 1)),
                            List.of("000", "000", "000"),
                            List.of(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))),
                    new RecipeBuilder("zirconium_tool", RecipeType.TOOLS,
                            List.of(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("zirconium_axe", InstanceType.ITEM, 1),
                                    new MyIngredient("zirconium_hoe", InstanceType.ITEM, 1),
                                    new MyIngredient("zirconium_pickaxe", InstanceType.ITEM, 1),
                                    new MyIngredient("zirconium_shovel", InstanceType.ITEM, 1),
                                    new MyIngredient("zirconium_sword", InstanceType.ITEM, 1))),
                    new RecipeBuilder("zirconium_armor", RecipeType.ARMOR,
                            List.of(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("zirconium_boots", InstanceType.ITEM, 1),
                                    new MyIngredient("zirconium_chestplate", InstanceType.ITEM, 1),
                                    new MyIngredient("zirconium_helmet", InstanceType.ITEM, 1),
                                    new MyIngredient("zirconium_leggings", InstanceType.ITEM, 1))),
                    new RecipeBuilder("zirconium_ingot_to_zircaloy_ingot", RecipeType.FORGE,
                            List.of(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("solarium_fluid_still", InstanceType.FLUID, 200)),
                            List.of(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1)))
            )));
    public static final Item ZIRCONIUM_RAW = addNewItem(misc("zirconium_raw", ItemsType.RAW,
            Map.of("fr_fr", "Zirconium brut", "en_us", "Zirconium raw"), null, List.of(
                    new RecipeBuilder("raw_to_zirconium_ingot", RecipeType.ORE,
                            List.of(new MyIngredient("zirconium_raw", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))),
                    new RecipeBuilder("raw_to_zirconium_ingot", RecipeType.FORGE,
                            List.of(new MyIngredient("zirconium_raw", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("solarium_fluid_still", InstanceType.FLUID, 200)),
                            List.of(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 2)))
            )));
    public static final Item ZIRCONIUM_AXE = addNewItem(tool("zirconium_axe", ItemsType.AXE, CustomItemTiers.ZIRCONIUM, Map.of("fr_fr", "Hache en zirconium", "en_us", "Zirconium axe"), null, null));
    public static final Item ZIRCONIUM_HOE = addNewItem(tool("zirconium_hoe", ItemsType.HOE, CustomItemTiers.ZIRCONIUM, Map.of("fr_fr", "Houe en zirconium", "en_us", "Zirconium hoe"), null, null));
    public static final Item ZIRCONIUM_PICKAXE = addNewItem(tool("zirconium_pickaxe", ItemsType.PICKAXE, CustomItemTiers.ZIRCONIUM, Map.of("fr_fr", "Pioche en zirconium", "en_us", "Zirconium pickaxe"), null, null));
    public static final Item ZIRCONIUM_SHOVEL = addNewItem(tool("zirconium_shovel", ItemsType.SHOVEL, CustomItemTiers.ZIRCONIUM, Map.of("fr_fr", "Pelle en zirconium", "en_us", "Zirconium shovel"), null, null));
    public static final Item ZIRCONIUM_SWORD = addNewItem(tool("zirconium_sword", ItemsType.SWORD, CustomItemTiers.ZIRCONIUM, Map.of("fr_fr", "Epée en zirconium", "en_us", "Zirconium sword"), null, null));
    public static final Item ZIRCONIUM_HELMET = addNewItem(armor("zirconium_helmet", ItemsType.HELMET, CustomArmorMaterials.ZIRCONIUM_ARMOR, Map.of("fr_fr", "Casque en zirconium", "en_us", "Zirconium helmet"), null, null));
    public static final Item ZIRCONIUM_CHESTPLATE = addNewItem(armor("zirconium_chestplate", ItemsType.CHESTPLATE, CustomArmorMaterials.ZIRCONIUM_ARMOR, Map.of("fr_fr", "Plastron en zirconium", "en_us", "Zirconium chestplate"), null, null));
    public static final Item ZIRCONIUM_LEGGINGS = addNewItem(armor("zirconium_leggings", ItemsType.LEGGINGS, CustomArmorMaterials.ZIRCONIUM_ARMOR, Map.of("fr_fr", "Pantalon en zirconium", "en_us", "Zirconium leggings"), null, null));
    public static final Item ZIRCONIUM_BOOTS = addNewItem(armor("zirconium_boots", ItemsType.BOOTS, CustomArmorMaterials.ZIRCONIUM_ARMOR, Map.of("fr_fr", "Bottes en zirconium", "en_us", "Zirconium boots"), null, null));

    // ── IRIDIUM ───────────────────────────────────────────────────────────────
    public static final Item IRIDIUM_INGOT = addNewItem(misc("iridium_ingot", ItemsType.INGOT,
            Map.of("fr_fr", "Lingot de iridium", "en_us", "Iridium ingot"), null, List.of(
                    new RecipeBuilder("iridium_block", RecipeType.SHAPE,
                            List.of(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("iridium_block", InstanceType.BLOCK, 1)),
                            List.of("000", "000", "000"),
                            List.of(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))),
                    new RecipeBuilder("iridium_tool", RecipeType.TOOLS,
                            List.of(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("iridium_axe", InstanceType.ITEM, 1),
                                    new MyIngredient("iridium_hoe", InstanceType.ITEM, 1),
                                    new MyIngredient("iridium_pickaxe", InstanceType.ITEM, 1),
                                    new MyIngredient("iridium_shovel", InstanceType.ITEM, 1),
                                    new MyIngredient("iridium_sword", InstanceType.ITEM, 1))),
                    new RecipeBuilder("iridium_armor", RecipeType.ARMOR,
                            List.of(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("iridium_boots", InstanceType.ITEM, 1),
                                    new MyIngredient("iridium_chestplate", InstanceType.ITEM, 1),
                                    new MyIngredient("iridium_helmet", InstanceType.ITEM, 1),
                                    new MyIngredient("iridium_leggings", InstanceType.ITEM, 1))),
                    new RecipeBuilder("iridium_ingot_to_osmiridium_ingot", RecipeType.FORGE,
                            List.of(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("solarium_fluid_still", InstanceType.FLUID, 200)),
                            List.of(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1)))
            )));
    public static final Item IRIDIUM_RAW = addNewItem(misc("iridium_raw", ItemsType.RAW,
            Map.of("fr_fr", "Iridium brut", "en_us", "Iridium raw"), null, List.of(
                    new RecipeBuilder("raw_to_iridium_ingot", RecipeType.ORE,
                            List.of(new MyIngredient("iridium_raw", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))),
                    new RecipeBuilder("raw_to_iridium_ingot", RecipeType.FORGE,
                            List.of(new MyIngredient("iridium_raw", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("solarium_fluid_still", InstanceType.FLUID, 200)),
                            List.of(new MyIngredient("iridium_ingot", InstanceType.ITEM, 2)))
            )));
    public static final Item IRIDIUM_AXE = addNewItem(tool("iridium_axe", ItemsType.AXE, CustomItemTiers.IRIDIUM, Map.of("fr_fr", "Hache en iridium", "en_us", "Iridium axe"), null, null));
    public static final Item IRIDIUM_HOE = addNewItem(tool("iridium_hoe", ItemsType.HOE, CustomItemTiers.IRIDIUM, Map.of("fr_fr", "Houe en iridium", "en_us", "Iridium hoe"), null, null));
    public static final Item IRIDIUM_PICKAXE = addNewItem(tool("iridium_pickaxe", ItemsType.PICKAXE, CustomItemTiers.IRIDIUM, Map.of("fr_fr", "Pioche en iridium", "en_us", "Iridium pickaxe"), null, null));
    public static final Item IRIDIUM_SHOVEL = addNewItem(tool("iridium_shovel", ItemsType.SHOVEL, CustomItemTiers.IRIDIUM, Map.of("fr_fr", "Pelle en iridium", "en_us", "Iridium shovel"), null, null));
    public static final Item IRIDIUM_SWORD = addNewItem(tool("iridium_sword", ItemsType.SWORD, CustomItemTiers.IRIDIUM, Map.of("fr_fr", "Epée en iridium", "en_us", "Iridium sword"), null, null));
    public static final Item IRIDIUM_HELMET = addNewItem(armor("iridium_helmet", ItemsType.HELMET, CustomArmorMaterials.IRIDIUM_ARMOR, Map.of("fr_fr", "Casque en iridium", "en_us", "Iridium helmet"), null, null));
    public static final Item IRIDIUM_CHESTPLATE = addNewItem(armor("iridium_chestplate", ItemsType.CHESTPLATE, CustomArmorMaterials.IRIDIUM_ARMOR, Map.of("fr_fr", "Plastron en iridium", "en_us", "Iridium chestplate"), null, null));
    public static final Item IRIDIUM_LEGGINGS = addNewItem(armor("iridium_leggings", ItemsType.LEGGINGS, CustomArmorMaterials.IRIDIUM_ARMOR, Map.of("fr_fr", "Pantalon en iridium", "en_us", "Iridium leggings"), null, null));
    public static final Item IRIDIUM_BOOTS = addNewItem(armor("iridium_boots", ItemsType.BOOTS, CustomArmorMaterials.IRIDIUM_ARMOR, Map.of("fr_fr", "Bottes en iridium", "en_us", "Iridium boots"), null, null));

    // ── ZIRCALOY ──────────────────────────────────────────────────────────────
    public static final Item ZIRCALOY_INGOT = addNewItem(misc("zircaloy_ingot", ItemsType.INGOT,
            Map.of("fr_fr", "Lingot de zircaloy", "en_us", "Zircaloy ingot"), null, List.of(
                    new RecipeBuilder("zircaloy_block", RecipeType.SHAPE,
                            List.of(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("zircaloy_block", InstanceType.BLOCK, 1)),
                            List.of("000", "000", "000"),
                            List.of(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1))),
                    new RecipeBuilder("zircaloy_tool", RecipeType.TOOLS,
                            List.of(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("zircaloy_axe", InstanceType.ITEM, 1),
                                    new MyIngredient("zircaloy_hoe", InstanceType.ITEM, 1),
                                    new MyIngredient("zircaloy_pickaxe", InstanceType.ITEM, 1),
                                    new MyIngredient("zircaloy_shovel", InstanceType.ITEM, 1),
                                    new MyIngredient("zircaloy_sword", InstanceType.ITEM, 1))),
                    new RecipeBuilder("zircaloy_armor", RecipeType.ARMOR,
                            List.of(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("zircaloy_boots", InstanceType.ITEM, 1),
                                    new MyIngredient("zircaloy_chestplate", InstanceType.ITEM, 1),
                                    new MyIngredient("zircaloy_helmet", InstanceType.ITEM, 1),
                                    new MyIngredient("zircaloy_leggings", InstanceType.ITEM, 1)))
            )));
    public static final Item ZIRCALOY_AXE = addNewItem(tool("zircaloy_axe", ItemsType.AXE, CustomItemTiers.ZIRCALOY, Map.of("fr_fr", "Hache en zircaloy", "en_us", "Zircaloy axe"), null, null));
    public static final Item ZIRCALOY_HOE = addNewItem(tool("zircaloy_hoe", ItemsType.HOE, CustomItemTiers.ZIRCALOY, Map.of("fr_fr", "Houe en zircaloy", "en_us", "Zircaloy hoe"), null, null));
    public static final Item ZIRCALOY_PICKAXE = addNewItem(tool("zircaloy_pickaxe", ItemsType.PICKAXE, CustomItemTiers.ZIRCALOY, Map.of("fr_fr", "Pioche en zircaloy", "en_us", "Zircaloy pickaxe"), null, null));
    public static final Item ZIRCALOY_SHOVEL = addNewItem(tool("zircaloy_shovel", ItemsType.SHOVEL, CustomItemTiers.ZIRCALOY, Map.of("fr_fr", "Pelle en zircaloy", "en_us", "Zircaloy shovel"), null, null));
    public static final Item ZIRCALOY_SWORD = addNewItem(tool("zircaloy_sword", ItemsType.SWORD, CustomItemTiers.ZIRCALOY, Map.of("fr_fr", "Epée en zircaloy", "en_us", "Zircaloy sword"), null, null));
    public static final Item ZIRCALOY_HELMET = addNewItem(armor("zircaloy_helmet", ItemsType.HELMET, CustomArmorMaterials.ZIRCALOY_ARMOR, Map.of("fr_fr", "Casque en zircaloy", "en_us", "Zircaloy helmet"), null, null));
    public static final Item ZIRCALOY_CHESTPLATE = addNewItem(armor("zircaloy_chestplate", ItemsType.CHESTPLATE, CustomArmorMaterials.ZIRCALOY_ARMOR, Map.of("fr_fr", "Plastron en zircaloy", "en_us", "Zircaloy chestplate"), null, null));
    public static final Item ZIRCALOY_LEGGINGS = addNewItem(armor("zircaloy_leggings", ItemsType.LEGGINGS, CustomArmorMaterials.ZIRCALOY_ARMOR, Map.of("fr_fr", "Pantalon en zircaloy", "en_us", "Zircaloy leggings"), null, null));
    public static final Item ZIRCALOY_BOOTS = addNewItem(armor("zircaloy_boots", ItemsType.BOOTS, CustomArmorMaterials.ZIRCALOY_ARMOR, Map.of("fr_fr", "Bottes en zircaloy", "en_us", "Zircaloy boots"), null, null));

    // ── OSMIRIDIUM ────────────────────────────────────────────────────────────
    public static final Item OSMIRIDIUM_INGOT = addNewItem(misc("osmiridium_ingot", ItemsType.INGOT,
            Map.of("fr_fr", "Lingot de osmiridium", "en_us", "Osmiridium ingot"),null, List.of(
                    new RecipeBuilder("osmiridium_block", RecipeType.SHAPE,
                            List.of(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("osmiridium_block", InstanceType.BLOCK, 1)),
                            List.of("000", "000", "000"),
                            List.of(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1))),
                    new RecipeBuilder("osmiridium_tool", RecipeType.TOOLS,
                            List.of(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("osmiridium_axe", InstanceType.ITEM, 1),
                                    new MyIngredient("osmiridium_hoe", InstanceType.ITEM, 1),
                                    new MyIngredient("osmiridium_pickaxe", InstanceType.ITEM, 1),
                                    new MyIngredient("osmiridium_shovel", InstanceType.ITEM, 1),
                                    new MyIngredient("osmiridium_sword", InstanceType.ITEM, 1))),
                    new RecipeBuilder("osmiridium_armor", RecipeType.ARMOR,
                            List.of(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1)),
                            List.of(new MyIngredient("osmiridium_boots", InstanceType.ITEM, 1),
                                    new MyIngredient("osmiridium_chestplate", InstanceType.ITEM, 1),
                                    new MyIngredient("osmiridium_helmet", InstanceType.ITEM, 1),
                                    new MyIngredient("osmiridium_leggings", InstanceType.ITEM, 1)))
            )));
    public static final Item OSMIRIDIUM_AXE = addNewItem(tool("osmiridium_axe", ItemsType.AXE, CustomItemTiers.OSMIRIDIUM, Map.of("fr_fr", "Hache en osmiridium","en_us", "Osmiridium axe"),null,null));
    public static final Item OSMIRIDIUM_HOE = addNewItem(tool("osmiridium_hoe", ItemsType.HOE, CustomItemTiers.OSMIRIDIUM, Map.of("fr_fr", "Houe en osmiridium","en_us", "Osmiridium hoe"),null,null));
    public static final Item OSMIRIDIUM_PICKAXE = addNewItem(tool("osmiridium_pickaxe", ItemsType.PICKAXE, CustomItemTiers.OSMIRIDIUM, Map.of("fr_fr", "Pioche en osmiridium","en_us", "Osmiridium pickaxe"),null,null));
    public static final Item OSMIRIDIUM_SHOVEL = addNewItem(tool("osmiridium_shovel", ItemsType.SHOVEL, CustomItemTiers.OSMIRIDIUM, Map.of("fr_fr", "Pelle en osmiridium", "en_us", "Osmiridium shovel"),null,null));
    public static final Item OSMIRIDIUM_SWORD = addNewItem(tool("osmiridium_sword", ItemsType.SWORD, CustomItemTiers.OSMIRIDIUM, Map.of("fr_fr", "Epée en osmiridium", "en_us", "Osmiridium sword"),null,null));
    public static final Item OSMIRIDIUM_HELMET = addNewItem(armor("osmiridium_helmet", ItemsType.HELMET, CustomArmorMaterials.OSMIRIDIUM_ARMOR, Map.of("fr_fr", "Casque en osmiridium", "en_us", "Osmiridium helmet"),null, null));
    public static final Item OSMIRIDIUM_CHESTPLATE = addNewItem(armor("osmiridium_chestplate", ItemsType.CHESTPLATE, CustomArmorMaterials.OSMIRIDIUM_ARMOR, Map.of("fr_fr", "Plastron en osmiridium", "en_us", "Osmiridium chestplate"),null, null));
    public static final Item OSMIRIDIUM_LEGGINGS = addNewItem(armor("osmiridium_leggings", ItemsType.LEGGINGS, CustomArmorMaterials.OSMIRIDIUM_ARMOR, Map.of("fr_fr", "Pantalon en osmiridium","en_us", "Osmiridium leggings"),null, null));
    public static final Item OSMIRIDIUM_BOOTS = addNewItem(armor("osmiridium_boots", ItemsType.BOOTS, CustomArmorMaterials.OSMIRIDIUM_ARMOR, Map.of("fr_fr", "Bottes en osmiridium","en_us", "Osmiridium boots"),null,null));


    // ── Factory methods ───────────────────────────────────────────────────────
    public static GenericItems tool(String id, ItemsType type, ToolMaterial mat, Map<String, String> translate, List<TagKey<Item>> tags, List<RecipeBuilder> recipes) { return new GenericItems(id, type, mat,null, translate, tags, recipes); }
    public static GenericItems armor(String id, ItemsType type, ArmorMaterial mat, Map<String, String> translate, List<TagKey<Item>> tags, List<RecipeBuilder> recipes) { return new GenericItems(id, type, null, mat, translate, tags, recipes); }
    public static GenericItems misc(String id, ItemsType type, Map<String, String> translate, List<TagKey<Item>> tags, List<RecipeBuilder> recipes) { return new GenericItems(id, type, null, null, translate, tags, recipes); }


    // ── Registration ──────────────────────────────────────────────────────────
    public static <T extends Item & IMyItem> T addNewItem(T item) {
        Registry.register(Registries.ITEM, Identifier.of(Stellamecanics.MOD_ID, item.getId()), item);
        ITEMS.put(item.getId(), item);
        return item;
    }

    public static void registerModItems() { Stellamecanics.LOGGER.debug("Registering Mod Items for " + Stellamecanics.MOD_ID); }
}