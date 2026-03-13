package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.builders.advancements.criterionTypes.ForgedItemCondition;
import fr.ethernyx.stellamecanics.builders.advancements.criterionTypes.HasItemCondition;
import fr.ethernyx.stellamecanics.builders.advancements.criterionTypes.NoneCondition;
import fr.ethernyx.stellamecanics.utils.CustomAdvancements;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
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
            .title("fr_fr", "Stellamecanics")
            .title("en_us", "Stellamecanics")
            .condition(new NoneCondition())
            .build());

    public static final CustomAdvancements FIRST_IRIDIUM = addNewAdvancement(CustomAdvancements.builder("first_iridium")
            .icon(ModItems.IRIDIUM_INGOT)
            .parent(ROOT)
            .title("fr_fr", "Le début de l'aventure")
            .title("en_us", "The beginning")
            .description("fr_fr", "Trouvez votre premier lingot d'iridium")
            .description("en_us", "Find your first iridium ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements IRIDIUM_TOOLS = addNewAdvancement(CustomAdvancements.builder("iridium_tools")
            .icon(ModItems.IRIDIUM_PICKAXE)
            .parent(FIRST_IRIDIUM)
            .title("fr_fr", "De nouveaux outils ?")
            .title("en_us", "New tools ?")
            .description("fr_fr", "Crafter tous les outils en iridium")
            .description("en_us", "Craft all iridium tools")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("iridium_pickaxe", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_axe", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_shovel", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_hoe", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements IRIDIUM_ARMOR = addNewAdvancement(CustomAdvancements.builder("iridium_armor")
            .icon(ModItems.IRIDIUM_CHESTPLATE)
            .parent(FIRST_IRIDIUM)
            .title("fr_fr", "Une nouvelle armure ?")
            .title("en_us", "New armor ?")
            .description("fr_fr", "Crafter toutes les pièces d'armure en iridium")
            .description("en_us", "Craft all iridium armor pieces")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("iridium_helmet", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_chestplate", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_leggings", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_boots", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements CRAFTING_STELLAR_FORGE = addNewAdvancement(CustomAdvancements.builder("crafting_stellar_forge")
            .icon(ModBlocks.FORGE_STELLAIRE)
            .parent(FIRST_IRIDIUM)
            .title("fr_fr", "Il est temps de forger!!")
            .title("en_us", "It's forging time")
            .description("fr_fr", "Crafter votre forge stellaire et commencez à forger votre chemin")
            .description("en_us", "Craft your stellar forge and start building your path")
            .frame(AdvancementFrame.CHALLENGE)
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1))))
            .build());

    public static final CustomAdvancements FIRST_SOLARIUM = addNewAdvancement(CustomAdvancements.builder("first_solarium")
            .icon(ModItems.SOLARIUM_INGOT)
            .parent(CRAFTING_STELLAR_FORGE)
            .title("fr_fr", "Aoucht c'est chaud !!")
            .title("en_us", "Aoucht it's hot!!")
            .description("fr_fr", "Trouvez votre premier lingot de solarium")
            .description("en_us", "Find your first solarium ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("solarium_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements FIRST_LUNARIUM = addNewAdvancement(CustomAdvancements.builder("first_lunarium")
            .icon(ModItems.LUNARIUM_INGOT)
            .parent(CRAFTING_STELLAR_FORGE)
            .title("fr_fr", "Un clair de lune solide ?")
            .title("en_us", "Solid moonshine?")
            .description("fr_fr", "Craftez votre premier lingot de lunarium")
            .description("en_us", "Craft your first lunarium ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements FIRST_ZIRCONIUM = addNewAdvancement(CustomAdvancements.builder("first_zirconium")
            .icon(ModItems.ZIRCONIUM_INGOT)
            .parent(CRAFTING_STELLAR_FORGE)
            .title("fr_fr", "Zirconium me voilà")
            .title("en_us", "Zirconium here I come")
            .description("fr_fr", "Craftez votre premier lingot de zirconium")
            .description("en_us", "Craft your first zirconium ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements FIRST_ZIRCALOY = addNewAdvancement(CustomAdvancements.builder("first_zircaloy")
            .icon(ModItems.ZIRCALOY_INGOT)
            .parent(FIRST_ZIRCONIUM)
            .title("fr_fr", "Zircaloy me voilà")
            .title("en_us", "Zircaloy here I come")
            .description("fr_fr", "Craftez votre premier lingot de zircaloy")
            .description("en_us", "Craft your first zircaloy ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements FIRST_OSMIRIDIUM = addNewAdvancement(CustomAdvancements.builder("first_osmiridium")
            .icon(ModItems.OSMIRIDIUM_INGOT)
            .parent(CRAFTING_STELLAR_FORGE)
            .title("fr_fr", "Osmiridium me voilà")
            .title("en_us", "Osmiridium here I come")
            .description("fr_fr", "Craftez votre premier lingot d'osmiridium")
            .description("en_us", "Craft your first osmiridium ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements FIRST_STELLARIUM = addNewAdvancement(CustomAdvancements.builder("first_stellarium")
            .icon(ModItems.STELLARIUM_INGOT)
            .parent(FIRST_SOLARIUM)
            .title("fr_fr", "Une étoile est née")
            .title("en_us", "A star is born")
            .description("fr_fr", "Craftez votre premier lingot de stellarium")
            .description("en_us", "Craft your first stellarium ingot")
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements STELLARIUM_ARMOR = addNewAdvancement(CustomAdvancements.builder("stellarium_armor")
            .icon(ModItems.STELLARIUM_CHESTPLATE)
            .parent(FIRST_STELLARIUM)
            .title("fr_fr", "Une armure magnifique")
            .title("en_us", "A magnifique armor")
            .description("fr_fr", "Craftez toutes les pièces d'armure en stellarium")
            .description("en_us", "Craft all stellarium armor pieces")
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
            .title("fr_fr", "Amasseur compulsif")
            .title("en_us", "Compulsive hoarder")
            .description("fr_fr", "Avoir toutes les armures")
            .description("en_us", "Having all armors")
            .frame(AdvancementFrame.CHALLENGE)
            .condition(new HasItemCondition(List.of(
                    new MyIngredient("stellarium_helmet", InstanceType.ITEM, 1),
                    new MyIngredient("stellarium_chestplate", InstanceType.ITEM, 1),
                    new MyIngredient("stellarium_leggings", InstanceType.ITEM, 1),
                    new MyIngredient("stellarium_boots", InstanceType.ITEM, 1),
                    new MyIngredient("osmiridium_helmet", InstanceType.ITEM, 1),
                    new MyIngredient("osmiridium_chestplate", InstanceType.ITEM, 1),
                    new MyIngredient("osmiridium_leggings", InstanceType.ITEM, 1),
                    new MyIngredient("osmiridium_boots", InstanceType.ITEM, 1),
                    new MyIngredient("zircaloy_helmet", InstanceType.ITEM, 1),
                    new MyIngredient("zircaloy_chestplate", InstanceType.ITEM, 1),
                    new MyIngredient("zircaloy_leggings", InstanceType.ITEM, 1),
                    new MyIngredient("zircaloy_boots", InstanceType.ITEM, 1),
                    new MyIngredient("zirconium_helmet", InstanceType.ITEM, 1),
                    new MyIngredient("zirconium_chestplate", InstanceType.ITEM, 1),
                    new MyIngredient("zirconium_leggings", InstanceType.ITEM, 1),
                    new MyIngredient("zirconium_boots", InstanceType.ITEM, 1),
                    new MyIngredient("solarium_helmet", InstanceType.ITEM, 1),
                    new MyIngredient("solarium_chestplate", InstanceType.ITEM, 1),
                    new MyIngredient("solarium_leggings", InstanceType.ITEM, 1),
                    new MyIngredient("solarium_boots", InstanceType.ITEM, 1),
                    new MyIngredient("lunarium_helmet", InstanceType.ITEM, 1),
                    new MyIngredient("lunarium_chestplate", InstanceType.ITEM, 1),
                    new MyIngredient("lunarium_leggings", InstanceType.ITEM, 1),
                    new MyIngredient("lunarium_boots", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_helmet", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_chestplate", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_leggings", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_boots", InstanceType.ITEM, 1))))
            .build());

    public static final CustomAdvancements DOUBLE_MINERAI = addNewAdvancement(CustomAdvancements.builder("double_minerai")
            .icon(ModItems.IRIDIUM_RAW)
            .parent(CRAFTING_STELLAR_FORGE)
            .title("fr_fr", "Je crois que je vois double")
            .title("en_us", "I think I see double")
            .description("fr_fr", "Doublez certaines de vos ressources grâce à la forge stellaire")
            .description("en_us", "Double some of your resources with the Stellar Forge")
            .frame(AdvancementFrame.CHALLENGE)
            .condition(new ForgedItemCondition(List.of(
                    "forge_stellaire_raw_to_iridium_ingot",
                    "forge_stellaire_raw_to_lunarium_ingot",
                    "forge_stellaire_raw_to_solarium_ingot",
                    "forge_stellaire_raw_to_zirconium_ingot")))
            .build());

    public static CustomAdvancements addNewAdvancement(CustomAdvancements advancement) {
        ADVANCEMENTS.put(advancement.getId(), advancement);
        return advancement;
    }

    public static void registerModAdvancements() {
        Stellamecanics.LOGGER.debug("Registering Mod Advancements for " + Stellamecanics.MOD_ID);
    }
}