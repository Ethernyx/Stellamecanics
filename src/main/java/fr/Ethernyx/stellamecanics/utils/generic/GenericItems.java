package fr.ethernyx.stellamecanics.utils.generic;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomItemTiers;
import fr.ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class GenericItems extends Item implements IMyItem {
    private final String id;
    private final Map<String, String> translate;
    private final List<TagKey<Item>> tags;
    private final List<RecipeBuilder> recipes;
    private final Model model;


    public GenericItems(String id, ItemsType itemsType, ToolMaterial toolMaterial, ArmorMaterial armorMaterial, Map<String, String> translate, List<TagKey<Item>> tags, List<RecipeBuilder> recipes) {
        super(buildingSettings(id, itemsType, toolMaterial, armorMaterial));
        this.id = id;
        this.translate = translate;
        this.tags = tags == null ? List.of() : tags;
        this.recipes = recipes == null  ? List.of() : recipes;
        switch (itemsType) {
            case PICKAXE:
            case SHOVEL:
            case HOE:
            case AXE:
            case SWORD:
                model = Models.HANDHELD;;
                break;
            default:
                model = Models.GENERATED;
                break;
        }
    }

    @Override public String getId() { return id; }
    @Override public String getTranslate(String lang) { return translate.get(lang); }
    @Override public List<TagKey<Item>> getTags() { return tags; }
    @Override public List<RecipeBuilder> getRecipe() { return recipes; }
    @Override public Model getModelType() { return model; }

    private static Settings buildingSettings(String id, ItemsType itemsType, ToolMaterial material, ArmorMaterial armorMaterial) {
        Settings settings = new Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM,
                        Identifier.of(Stellamecanics.MOD_ID, id)));
        return switch (itemsType) {
            case AXE     -> settings.axe(material, 6f, -3.2f);
            case PICKAXE -> settings.pickaxe(material, 1f, -2.8f);
            case SWORD   -> settings.sword(material, 3f, -2.4f);
            case SHOVEL  -> settings.shovel(material, 1.5f, -3f);
            case HOE     -> settings.hoe(material, 0f, -3f);
            case HELMET ->  settings.armor(armorMaterial, EquipmentType.HELMET);
            case CHESTPLATE -> settings.armor(armorMaterial, EquipmentType.CHESTPLATE);
            case LEGGINGS -> settings.armor(armorMaterial, EquipmentType.LEGGINGS);
            case BOOTS -> settings.armor(armorMaterial, EquipmentType.BOOTS);
            default      -> settings;
        };
    }
}
