package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.builders.advancements.criterionTypes.ForgedItemCondition;
import fr.ethernyx.stellamecanics.builders.advancements.criterionTypes.HasItemCondition;
import fr.ethernyx.stellamecanics.builders.advancements.criterionTypes.NoneCondition;
import fr.ethernyx.stellamecanics.utils.CustomAdvancements;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeType;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModAdvancements {
    public static Map<String, CustomAdvancements> ADVANCEMENTS = new LinkedHashMap<>();

    public static final CustomAdvancements ROOT = addNewAdvancement(CustomAdvancements.builder("root")
            .icon(ModItems.STELLARIUM_INGOT)
            .background(Identifier.of("minecraft", "gui/advancements/backgrounds/adventure"))
            .addTitle("fr_fr", "Stellamecanics")
            .addTitle("en_us", "Stellamecanics")
            .condition(new NoneCondition())
            .build());

    public static final CustomAdvancements FIRST_IRIDIUM = addNewAdvancement(CustomAdvancements.builder("first_iridium")
            .icon(ModItems.IRIDIUM_INGOT)
            .parent(ROOT)
            .addTitle("fr_fr", "Le début de l'aventure")
            .addTitle("en_us", "The beginning")
            .addDesc("fr_fr", "Trouvez votre premier lingot d'iridium")
            .addDesc("en_us", "Find your first iridium ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements IRIDIUM_TOOLS = addNewAdvancement(CustomAdvancements.builder("iridium_tools")
            .icon(ModItems.IRIDIUM_PICKAXE)
            .parent(FIRST_IRIDIUM)
            .addTitle("fr_fr", "De nouveaux outils ?")
            .addTitle("en_us", "New tools ?")
            .addDesc("fr_fr", "Crafter tous les outils en iridium")
            .addDesc("en_us", "Craft all iridium tools")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("iridium_pickaxe", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_axe", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_shovel", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_hoe", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements IRIDIUM_ARMOR = addNewAdvancement(CustomAdvancements.builder("iridium_armor")
            .icon(ModItems.IRIDIUM_CHESTPLATE)
            .parent(FIRST_IRIDIUM)
            .addTitle("fr_fr", "Une nouvelle armure ?")
            .addTitle("en_us", "New armor ?")
            .addDesc("fr_fr", "Crafter toutes les pièces d'armure en iridium")
            .addDesc("en_us", "Craft all iridium armor pieces")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("iridium_helmet", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_chestplate", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_leggings", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_boots", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements CRAFTING_STELLAR_FORGE = addNewAdvancement(CustomAdvancements.builder("crafting_stellar_forge")
            .icon(ModBlocks.FORGE_STELLAIRE)
            .parent(FIRST_IRIDIUM)
            .addTitle("fr_fr", "Il est temps de forger!!")
            .addTitle("en_us", "It's forging time")
            .addDesc("fr_fr", "Crafter votre forge stellaire et commencez à forger votre chemin")
            .addDesc("en_us", "Craft your stellar forge and start building your path")
            .frame(AdvancementFrame.CHALLENGE)
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1))))
            .build());

    public static final CustomAdvancements FIRST_SOLARIUM = addNewAdvancement(CustomAdvancements.builder("first_solarium")
            .icon(ModItems.SOLARIUM_INGOT)
            .parent(CRAFTING_STELLAR_FORGE)
            .addTitle("fr_fr", "Aoucht c'est chaud !!")
            .addTitle("en_us", "Aoucht it's hot!!")
            .addDesc("fr_fr", "Trouvez votre premier lingot de solarium")
            .addDesc("en_us", "Find your first solarium ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements FIRST_LUNARIUM = addNewAdvancement(CustomAdvancements.builder("first_lunarium")
            .icon(ModItems.LUNARIUM_INGOT)
            .parent(CRAFTING_STELLAR_FORGE)
            .addTitle("fr_fr", "Un clair de lune solide ?")
            .addTitle("en_us", "Solid moonshine?")
            .addDesc("fr_fr", "Craftez votre premier lingot de lunarium")
            .addDesc("en_us", "Craft your first lunarium ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements FIRST_ZIRCONIUM = addNewAdvancement(CustomAdvancements.builder("first_zirconium")
            .icon(ModItems.ZIRCONIUM_INGOT)
            .parent(CRAFTING_STELLAR_FORGE)
            .addTitle("fr_fr", "Zirconium me voilà")
            .addTitle("en_us", "Zirconium here I come")
            .addDesc("fr_fr", "Craftez votre premier lingot de zirconium")
            .addDesc("en_us", "Craft your first zirconium ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements FIRST_ZIRCALOY = addNewAdvancement(CustomAdvancements.builder("first_zircaloy")
            .icon(ModItems.ZIRCALOY_INGOT)
            .parent(FIRST_ZIRCONIUM)
            .addTitle("fr_fr", "Zircaloy me voilà")
            .addTitle("en_us", "Zircaloy here I come")
            .addDesc("fr_fr", "Craftez votre premier lingot de zircaloy")
            .addDesc("en_us", "Craft your first zircaloy ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements FIRST_OSMIRIDIUM = addNewAdvancement(CustomAdvancements.builder("first_osmiridium")
            .icon(ModItems.OSMIRIDIUM_INGOT)
            .parent(CRAFTING_STELLAR_FORGE)
            .addTitle("fr_fr", "Osmiridium me voilà")
            .addTitle("en_us", "Osmiridium here I come")
            .addDesc("fr_fr", "Craftez votre premier lingot d'osmiridium")
            .addDesc("en_us", "Craft your first osmiridium ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements FIRST_STELLARIUM = addNewAdvancement(CustomAdvancements.builder("first_stellarium")
            .icon(ModItems.STELLARIUM_INGOT)
            .parent(FIRST_SOLARIUM)
            .addTitle("fr_fr", "Une étoile est née")
            .addTitle("en_us", "A star is born")
            .addDesc("fr_fr", "Craftez votre premier lingot de stellarium")
            .addDesc("en_us", "Craft your first stellarium ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements STELLARIUM_ARMOR = addNewAdvancement(CustomAdvancements.builder("stellarium_armor")
            .icon(ModItems.STELLARIUM_CHESTPLATE)
            .parent(FIRST_STELLARIUM)
            .addTitle("fr_fr", "Une armure magnifique")
            .addTitle("en_us", "A magnifique armor")
            .addDesc("fr_fr", "Craftez toutes les pièces d'armure en stellarium")
            .addDesc("en_us", "Craft all stellarium armor pieces")
            .frame(AdvancementFrame.CHALLENGE)
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("stellarium_helmet", InstanceType.ITEM, 1),
                    new MyIngredient("stellarium_chestplate", InstanceType.ITEM, 1),
                    new MyIngredient("stellarium_leggings", InstanceType.ITEM, 1),
                    new MyIngredient("stellarium_boots", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements COLLECTOR = addNewAdvancement(CustomAdvancements.builder("collector")
            .icon(Items.ARMOR_STAND)
            .parent(STELLARIUM_ARMOR)
            .addTitle("fr_fr", "Amasseur compulsif")
            .addTitle("en_us", "Compulsive hoarder")
            .addDesc("fr_fr", "Avoir toutes les armures")
            .addDesc("en_us", "Having all armors")
            .frame(AdvancementFrame.CHALLENGE)
            .condition(new ForgedItemCondition(List.of(
                    ForgedItemCondition.addRecipe("stellarium_helmet", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("stellarium_chestplate", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("stellarium_leggings", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("stellarium_boots", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("osmiridium_helmet", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("osmiridium_chestplate", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("osmiridium_leggings", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("osmiridium_boots", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("zircaloy_helmet", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("zircaloy_chestplate", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("zircaloy_leggings", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("zircaloy_boots", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("zirconium_helmet", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("zirconium_chestplate", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("zirconium_leggings", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("zirconium_boots", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("solarium_helmet", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("solarium_chestplate", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("solarium_leggings", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("solarium_boots", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("lunarium_helmet", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("lunarium_chestplate", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("lunarium_leggings", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("lunarium_boots", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("iridium_helmet", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("iridium_chestplate", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("iridium_leggings", RecipeType.SHAPELLESS),
                    ForgedItemCondition.addRecipe("iridium_boots", RecipeType.SHAPELLESS)
            ), true))
            .build());

    public static final CustomAdvancements DOUBLE_MINERAI = addNewAdvancement(CustomAdvancements.builder("double_minerai")
            .icon(ModItems.IRIDIUM_RAW)
            .parent(CRAFTING_STELLAR_FORGE)
            .addTitle("fr_fr", "Je crois que je vois double")
            .addTitle("en_us", "I think I see double")
            .addDesc("fr_fr", "Doublez certaines de vos ressources grâce à la forge stellaire")
            .addDesc("en_us", "Double some of your resources with the Stellar Forge")
            .frame(AdvancementFrame.CHALLENGE)
            .condition(new ForgedItemCondition(List.of(
                    ForgedItemCondition.addRecipe("forge_stellaire_raw_to_iridium_ingot", RecipeType.FORGE),
                    ForgedItemCondition.addRecipe("forge_stellaire_raw_to_lunarium_ingot", RecipeType.FORGE),
                    ForgedItemCondition.addRecipe("forge_stellaire_raw_to_solarium_ingot", RecipeType.FORGE),
                    ForgedItemCondition.addRecipe("forge_stellaire_raw_to_zirconium_ingot", RecipeType.FORGE))))
            .build());

    public static CustomAdvancements addNewAdvancement(CustomAdvancements advancement) {
        ADVANCEMENTS.put(advancement.getId(), advancement);
        return advancement;
    }

    public static void registerModAdvancements() {
        Stellamecanics.LOGGER.debug("Registering Mod Advancements for " + Stellamecanics.MOD_ID);
    }
}