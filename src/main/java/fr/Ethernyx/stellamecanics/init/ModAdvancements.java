package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.utils.CriterionType;
import fr.ethernyx.stellamecanics.utils.CustomAdvancements;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModAdvancements {
    public static Map<String, CustomAdvancements> ADVANCEMENTS = new LinkedHashMap<>();

    public static final CustomAdvancements ROOT = addNewAdvancement(root(
            "root",
            ModItems.STELLARIUM_INGOT,
            Identifier.of("minecraft", "gui/advancements/backgrounds/adventure"),
            Map.of("fr_fr", "Stellamecanics", "en_us", "Stellamecanics"),
            Map.of("fr_fr", "", "en_us", "")));

    public static final CustomAdvancements FIRST_IRIDIUM = addNewAdvancement(advancement(
            "first_iridium",
            ModItems.IRIDIUM_INGOT,
            ROOT,
            Map.of("fr_fr", "Le début de l'aventure", "en_us", "The beginning"),
            Map.of("fr_fr", "Trouvez votre premier lingot d'iridium", "en_us", "Find your first iridium ingot"),
            AdvancementFrame.TASK,
            CriterionType.INVENTORY,
            List.of(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1)),
            true, true, false));

    public static final CustomAdvancements IRIDIUM_TOOLS = addNewAdvancement(advancement(
            "iridium_tools",
            ModItems.IRIDIUM_PICKAXE,
            FIRST_IRIDIUM,
            Map.of("fr_fr", "De nouveaux outils ?", "en_us", "New tools ?"),
            Map.of("fr_fr", "Crafter tous les outils en iridium", "en_us", "Craft all iridium tools"),
            AdvancementFrame.TASK,
            CriterionType.INVENTORY,
            List.of(new MyIngredient("iridium_pickaxe", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_axe", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_shovel", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_hoe", InstanceType.ITEM, 1)),
            true, true, false
    ));

    public static final CustomAdvancements IRIDIUM_ARMOR = addNewAdvancement(advancement(
            "iridium_armor",
            ModItems.IRIDIUM_CHESTPLATE,
            FIRST_IRIDIUM,
            Map.of("fr_fr", "Une nouvelle armure ?", "en_us", "New armor ?"),
            Map.of("fr_fr", "Crafter toutes les pièce d'armure en iridium", "en_us", "Craft all iridium armor piece"),
            AdvancementFrame.TASK,
            CriterionType.INVENTORY,
            List.of(new MyIngredient("iridium_helmet", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_chestplate", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_leggings", InstanceType.ITEM, 1),
                    new MyIngredient("iridium_boots", InstanceType.ITEM, 1)),
            true, true, false
    ));

    public static final  CustomAdvancements CRAFTING_STELLAR_FORGE = addNewAdvancement(advancement(
            "crafting_stellar_forge",
            ModBlocks.FORGE_STELLAIRE,
            FIRST_IRIDIUM,
            Map.of("fr_fr", "Il est temps de forger!!", "en_us", "It's forging time"),
            Map.of("fr_fr", "Crafter votre forge stellaire et commencez à forger votre chemin", "en_us", "Craft your stellar forge and start building your path"),
            AdvancementFrame.CHALLENGE,
            CriterionType.INVENTORY,
            List.of(new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1)),
            true, true, false
    ));

    public static final CustomAdvancements FIRST_SOLARIUM = addNewAdvancement(advancement(
            "first_solarium",
            ModItems.SOLARIUM_INGOT,
            CRAFTING_STELLAR_FORGE,
            Map.of("fr_fr", "Aoucht c'est chaud !!", "en_us", "Aoucht it’s hot!!"),
            Map.of("fr_fr", "Trouvez votre premier lingot de solarium", "en_us", "Find your first solarium ingot"),
            AdvancementFrame.TASK,
            CriterionType.INVENTORY,
            List.of(new MyIngredient("solarium_ingot", InstanceType.ITEM, 1)),
            true, true, false));

    public static final CustomAdvancements FIRST_LUNARIUM = addNewAdvancement(advancement(
            "first_lunarium",
            ModItems.LUNARIUM_INGOT,
            CRAFTING_STELLAR_FORGE,
            Map.of("fr_fr", "Un clair de lune solide ?", "en_us", "Solid moonshine?"),
            Map.of("fr_fr", "Craftez votre premier lingot de lunarium", "en_us", "craft your first lunarium ingot"),
            AdvancementFrame.TASK,
            CriterionType.INVENTORY,
            List.of(new MyIngredient("lunarium_ingot", InstanceType.ITEM, 1)),
            true, true, false));

    public static final CustomAdvancements FIRST_ZIRCONIUM = addNewAdvancement(advancement(
            "first_zirconium",
            ModItems.ZIRCONIUM_INGOT,
            CRAFTING_STELLAR_FORGE,
            Map.of("fr_fr", "Zirconium me voilà", "en_us", "Zirconium here I come"),
            Map.of("fr_fr", "craftez votre premier lingot de zirconium", "en_us", "craft your first zirconium ingot"),
            AdvancementFrame.TASK,
            CriterionType.INVENTORY,
            List.of(new MyIngredient("zirconium_ingot", InstanceType.ITEM, 1)),
            true, true, false));

    public static final CustomAdvancements FIRST_ZIRCALOY = addNewAdvancement(advancement(
            "first_zircaloy",
            ModItems.ZIRCALOY_INGOT,
            FIRST_ZIRCONIUM,
            Map.of("fr_fr", "Zircaloy me voilà", "en_us", "Zircaloy here I come"),
            Map.of("fr_fr", "craftez votre premier lingot de zircaloy", "en_us", "craft your first zircaloy ingot"),
            AdvancementFrame.TASK,
            CriterionType.INVENTORY,
            List.of(new MyIngredient("zircaloy_ingot", InstanceType.ITEM, 1)),
            true, true, false));

    public static final CustomAdvancements FIRST_OSMIRIDIUM = addNewAdvancement(advancement(
            "first_osmiridium",
            ModItems.OSMIRIDIUM_INGOT,
            CRAFTING_STELLAR_FORGE,
            Map.of("fr_fr", "Osmiridium me voilà", "en_us", "Osmiridium here I come"),
            Map.of("fr_fr", "craftez votre premier lingot d'osmiridium", "en_us", "craft your first osmiridium ingot"),
            AdvancementFrame.TASK,
            CriterionType.INVENTORY,
            List.of(new MyIngredient("osmiridium_ingot", InstanceType.ITEM, 1)),
            true, true, false));

    public static final CustomAdvancements FIRST_STELLARIUM = addNewAdvancement(advancement(
            "first_stellarium",
            ModItems.STELLARIUM_INGOT,
            FIRST_SOLARIUM,
            Map.of("fr_fr", "Une étoile est née", "en_us", "A star is born"),
            Map.of("fr_fr", "craftez votre premier lingot de stellarium", "en_us", "craft your first stellarium ingot"),
            AdvancementFrame.TASK,
            CriterionType.INVENTORY,
            List.of(new MyIngredient("stellarium_ingot", InstanceType.ITEM, 1)),
            true, true, false));

    public static final CustomAdvancements STELLARIUM_ARMOR = addNewAdvancement(advancement(
            "stellarium_armor",
            ModItems.STELLARIUM_CHESTPLATE,
            FIRST_STELLARIUM,
            Map.of("fr_fr", "Une armure magnifique", "en_us", "A magnifique armor"),
            Map.of("fr_fr", "Craftez toutes les pièces d'armure en stellarium", "en_us", "Craft all stellarium armor pieces"),
            AdvancementFrame.CHALLENGE,
            CriterionType.INVENTORY,
            List.of(new MyIngredient("stellarium_helmet", InstanceType.ITEM, 1),
                    new MyIngredient("stellarium_chestplate", InstanceType.ITEM, 1),
                    new MyIngredient("stellarium_leggings", InstanceType.ITEM, 1),
                    new MyIngredient("stellarium_boots", InstanceType.ITEM, 1)),
            true, true, false));

    public static final CustomAdvancements COLLECTOR = addNewAdvancement(advancement(
            "collector",
            Items.ARMOR_STAND,
            STELLARIUM_ARMOR,
            Map.of("fr_fr", "Amasseur compulsif", "en_us", "Compulsive hoarder"),
            Map.of("fr_fr", "Avoir toutes les armures", "en_us", "Having all armors"),
            AdvancementFrame.CHALLENGE,
            CriterionType.INVENTORY,
            List.of(new MyIngredient("stellarium_helmet", InstanceType.ITEM, 1),
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
                    new MyIngredient("iridium_boots", InstanceType.ITEM, 1)),
            true, true, false));

    public static final CustomAdvancements DOUBLE_MINERAI =  addNewAdvancement(advancement(
            "double_minerai",
            ModItems.IRIDIUM_RAW,
            CRAFTING_STELLAR_FORGE,
            Map.of("fr_fr", "Je crois que je vois double", "en_us", "I think I see double"),
            Map.of("fr_fr", "Doublez certaines de vos ressources grace à la forge stellaire", "en_us", "Double some of your resources with the Stellar Forge"),
            AdvancementFrame.CHALLENGE,
            CriterionType.FORGE_CRAFTING,
            List.of(new MyIngredient("forge_stellaire_raw_to_iridium_ingot", InstanceType.RECIPE, 1),
                    new MyIngredient("forge_stellaire_raw_to_lunarium_ingot", InstanceType.RECIPE, 1),
                    new MyIngredient("forge_stellaire_raw_to_solarium_ingot", InstanceType.RECIPE, 1),
                    new MyIngredient("forge_stellaire_raw_to_zirconium_ingot", InstanceType.RECIPE, 1)),
            true, true, false));

    public static CustomAdvancements root(String id, ItemConvertible icon, Identifier background, Map<String, String> title, Map<String, String> description) {
        return new CustomAdvancements(id, null, icon, AdvancementFrame.TASK, background, title, description, false, false, false, CriterionType.NONE, null);
    }
    public static CustomAdvancements advancement(String id, ItemConvertible icon, CustomAdvancements parent, Map<String, String> title, Map<String, String> description, AdvancementFrame frame, CriterionType criterionType, List<MyIngredient> listItems, boolean showToast, boolean announceToChat, boolean hidden) {
        return new CustomAdvancements(id, parent, icon, frame, null, title, description, showToast, announceToChat, hidden, criterionType, listItems);
    }

    public static CustomAdvancements addNewAdvancement(CustomAdvancements advancement) {
        ADVANCEMENTS.put(advancement.getId(), advancement);
        return advancement;
    }

    public static void registerModAdvancements() {
        Stellamecanics.LOGGER.debug("Registering Mod Advancements for " + Stellamecanics.MOD_ID);
    }
}
