# Ajouter un nouveau matériau

Ce guide décrit toutes les étapes pour ajouter un matériau complet (lingot, brut, bloc, outils, armure, fluide, advancement) au mod Stellamecanics.

L'exemple utilisé est un matériau fictif appelé **Adamantium**.

---

## Checklist rapide

- [ ] 1. Tags item et bloc dans `ModTags`
- [ ] 2. Tier outil dans `CustomItemTiers`
- [ ] 3. Matériau d'armure dans `CustomArmorMaterials`
- [ ] 4. Items dans `ModItems`
- [ ] 5. Bloc dans `ModBlocks`
- [ ] 6. Fluide dans `ModFluids` *(si nécessaire)*
- [ ] 7. Advancement dans `ModAdvancements` *(si nécessaire)*
- [ ] 8. Génération de monde dans `ModWorldConfigsFeatures` et `ModWorldPlacedFeatures` *(si minerai)*
- [ ] 9. Textures
- [ ] 10. Relancer le datagen

---

## Étape 1 — Tags dans `ModTags`

Ajouter les tags item pour les outils, armes, armures et la réparation, ainsi que le tag bloc pour le niveau de minage.

```java
// Dans ModTags.Items
public static final TagKey<Item> ADAMANTIUM_TOOL   = createTag(new GenericItemTags("adamantium_tool",   List.of()));
public static final TagKey<Item> ADAMANTIUM_WEAPON  = createTag(new GenericItemTags("adamantium_weapon",  List.of()));
public static final TagKey<Item> ADAMANTIUM_ARMOR   = createTag(new GenericItemTags("adamantium_armor",   List.of()));
public static final TagKey<Item> ADAMANTIUM_REPAIR  = createTag(new GenericItemTags("adamantium_repair",  List.of()));
```

> Le tag bloc de niveau de minage existe déjà (`need_lvl_4`, `need_lvl_5`, `need_lvl_6`). Réutilise celui qui correspond au tier voulu.

---

## Étape 2 — Tier outil dans `CustomItemTiers`

```java
// Dans CustomItemTiers
public static ToolMaterial ADAMANTIUM = new ToolMaterial(
    ModTags.Blocks.BLOCKTAGS.get("need_lvl_6").getTag(),  // niveau de minage requis
    5040,       // durabilité
    7.2f,       // vitesse de minage
    1.5f,       // dégâts bonus
    10,         // enchantabilité
    ModTags.Items.ADAMANTIUM_REPAIR
);
```

---

## Étape 3 — Matériau d'armure dans `CustomArmorMaterials`

```java
// Dans CustomArmorMaterials
public static final ArmorMaterial ADAMANTIUM_ARMOR = new ArmorMaterial(
    500,  // durabilité de base
    Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS,      3);
        map.put(EquipmentType.LEGGINGS,   6);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET,     3);
        map.put(EquipmentType.BODY,       6);
    }),
    10,                                          // enchantabilité
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
    2f,                                          // toughness
    0.2f,                                        // knockback resistance
    ModTags.Items.ADAMANTIUM_REPAIR,
    RegistryKey.of(REGISTRY_KEY, Identifier.of(Stellamecanics.MOD_ID, "adamantium_armor"))
);
```

> N'oublie pas de créer la texture d'équipement dans `assets/stellamecanics/textures/models/armor/adamantium_armor_*.png`.

---

## Étape 4 — Items dans `ModItems`

Ajouter dans l'ordre : lingot, brut, outils, armure.

```java
// Lingot (avec ses recettes)
public static final Item ADAMANTIUM_INGOT = addNewItem(GenericItems.builder("adamantium_ingot", ItemsType.INGOT)
    .translate("fr_fr", "Lingot d'adamantium")
    .translate("en_us", "Adamantium ingot")
    .tag(ModTags.Items.ADAMANTIUM_REPAIR)
    .recipe(RecipeBuilder.builder("adamantium_block", RecipeType.SHAPE)
        .input(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 1))
        .output(new MyIngredient("adamantium_block", InstanceType.BLOCK, 1))
        .pattern(List.of("000", "000", "000"))
        .unlock(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 1))
        .build())
    .recipe(RecipeBuilder.builder("adamantium_tool", RecipeType.TOOLS)
        .input(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 1))
        .output(new MyIngredient("adamantium_axe",     InstanceType.ITEM, 1))
        .output(new MyIngredient("adamantium_hoe",     InstanceType.ITEM, 1))
        .output(new MyIngredient("adamantium_pickaxe", InstanceType.ITEM, 1))
        .output(new MyIngredient("adamantium_shovel",  InstanceType.ITEM, 1))
        .output(new MyIngredient("adamantium_sword",   InstanceType.ITEM, 1))
        .build())
    .recipe(RecipeBuilder.builder("adamantium_armor", RecipeType.ARMOR)
        .input(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 1))
        .output(new MyIngredient("adamantium_boots",      InstanceType.ITEM, 1))
        .output(new MyIngredient("adamantium_chestplate", InstanceType.ITEM, 1))
        .output(new MyIngredient("adamantium_helmet",     InstanceType.ITEM, 1))
        .output(new MyIngredient("adamantium_leggings",   InstanceType.ITEM, 1))
        .build())
    .build());

// Brut (avec fusion et recette forge)
public static final Item ADAMANTIUM_RAW = addNewItem(GenericItems.builder("adamantium_raw", ItemsType.RAW)
    .translate("fr_fr", "Adamantium brut")
    .translate("en_us", "Adamantium raw")
    .tag(ModTags.Items.ADAMANTIUM_REPAIR)
    .recipe(RecipeBuilder.builder("raw_to_adamantium_ingot", RecipeType.ORE)
        .input(new MyIngredient("adamantium_raw",    InstanceType.ITEM, 1))
        .output(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 1))
        .build())
    // Optionnel : recette FORGE pour doubler
    // .recipe(RecipeBuilder.builder("raw_to_adamantium_ingot", RecipeType.FORGE)
    //     .input(new MyIngredient("adamantium_raw", InstanceType.ITEM, 1))
    //     .fluid(new MyIngredient("..._fluid_still", InstanceType.FLUID, 200))
    //     .output(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 2))
    //     .build())
    .build());

// Outils
public static final Item ADAMANTIUM_AXE     = addNewItem(GenericItems.builder("adamantium_axe",     ItemsType.AXE)     .translate("fr_fr", "Hache en adamantium")  .translate("en_us", "Adamantium axe")     .toolMaterial(CustomItemTiers.ADAMANTIUM) .tag(ModTags.Items.ADAMANTIUM_TOOL)   .build());
public static final Item ADAMANTIUM_HOE     = addNewItem(GenericItems.builder("adamantium_hoe",     ItemsType.HOE)     .translate("fr_fr", "Houe en adamantium")   .translate("en_us", "Adamantium hoe")     .toolMaterial(CustomItemTiers.ADAMANTIUM) .tag(ModTags.Items.ADAMANTIUM_TOOL)   .build());
public static final Item ADAMANTIUM_PICKAXE = addNewItem(GenericItems.builder("adamantium_pickaxe", ItemsType.PICKAXE) .translate("fr_fr", "Pioche en adamantium") .translate("en_us", "Adamantium pickaxe") .toolMaterial(CustomItemTiers.ADAMANTIUM) .tag(ModTags.Items.ADAMANTIUM_TOOL)   .build());
public static final Item ADAMANTIUM_SHOVEL  = addNewItem(GenericItems.builder("adamantium_shovel",  ItemsType.SHOVEL)  .translate("fr_fr", "Pelle en adamantium")  .translate("en_us", "Adamantium shovel")  .toolMaterial(CustomItemTiers.ADAMANTIUM) .tag(ModTags.Items.ADAMANTIUM_TOOL)   .build());
public static final Item ADAMANTIUM_SWORD   = addNewItem(GenericItems.builder("adamantium_sword",   ItemsType.SWORD)   .translate("fr_fr", "Épée en adamantium")   .translate("en_us", "Adamantium sword")   .toolMaterial(CustomItemTiers.ADAMANTIUM) .tag(ModTags.Items.ADAMANTIUM_WEAPON) .build());

// Armure
public static final Item ADAMANTIUM_HELMET     = addNewItem(GenericItems.builder("adamantium_helmet",     ItemsType.HELMET)     .translate("fr_fr", "Casque en adamantium")   .translate("en_us", "Adamantium helmet")     .armorMaterial(CustomArmorMaterials.ADAMANTIUM_ARMOR) .tag(ModTags.Items.ADAMANTIUM_ARMOR) .build());
public static final Item ADAMANTIUM_CHESTPLATE = addNewItem(GenericItems.builder("adamantium_chestplate", ItemsType.CHESTPLATE) .translate("fr_fr", "Plastron en adamantium") .translate("en_us", "Adamantium chestplate") .armorMaterial(CustomArmorMaterials.ADAMANTIUM_ARMOR) .tag(ModTags.Items.ADAMANTIUM_ARMOR) .build());
public static final Item ADAMANTIUM_LEGGINGS   = addNewItem(GenericItems.builder("adamantium_leggings",   ItemsType.LEGGINGS)   .translate("fr_fr", "Pantalon en adamantium") .translate("en_us", "Adamantium leggings")   .armorMaterial(CustomArmorMaterials.ADAMANTIUM_ARMOR) .tag(ModTags.Items.ADAMANTIUM_ARMOR) .build());
public static final Item ADAMANTIUM_BOOTS      = addNewItem(GenericItems.builder("adamantium_boots",      ItemsType.BOOTS)      .translate("fr_fr", "Bottes en adamantium")   .translate("en_us", "Adamantium boots")      .armorMaterial(CustomArmorMaterials.ADAMANTIUM_ARMOR) .tag(ModTags.Items.ADAMANTIUM_ARMOR) .build());
```

---

## Étape 5 — Bloc dans `ModBlocks`

```java
// Minerai
public static final Block ADAMANTIUM_ORE = addNewBlock(
    new GenericBlocks("adamantium_ore",
        new MyLootTable(LootType.ORE, new MyIngredient("adamantium_raw", InstanceType.ITEM, 1)),
        Map.of("fr_fr", "Minerai d'adamantium", "en_us", "Adamantium ore"),
        List.of(BlockTags.PICKAXE_MINEABLE, ModTags.Blocks.BLOCKTAGS.get("need_lvl_6").getTag()),
        List.of(RecipeBuilder.builder("ore_to_adamantium_ingot", RecipeType.ORE)
            .input(new MyIngredient("adamantium_ore",   InstanceType.BLOCK, 1))
            .output(new MyIngredient("adamantium_ingot", InstanceType.ITEM,  1))
            .build())
    ));

// Bloc de stockage (9 lingots → 1 bloc, 1 bloc → 9 lingots)
public static final Block ADAMANTIUM_BLOCK = addNewBlock(
    new GenericBlocks("adamantium_block",
        new MyLootTable(LootType.NORMAL, new MyIngredient("adamantium_block", InstanceType.BLOCK, 1)),
        Map.of("fr_fr", "Bloc d'adamantium", "en_us", "Adamantium block"),
        List.of(BlockTags.PICKAXE_MINEABLE, ModTags.Blocks.BLOCKTAGS.get("need_lvl_6").getTag()),
        List.of(RecipeBuilder.builder("adamantium_ingot", RecipeType.SHAPELLESS)
            .input(new MyIngredient("adamantium_block", InstanceType.BLOCK, 1))
            .output(new MyIngredient("adamantium_ingot", InstanceType.ITEM,  9))
            .build())
    ));
```

---

## Étape 6 — Fluide dans `ModFluids` *(optionnel)*

Si le matériau nécessite un fluide propre (pour la Forge Stellaire par exemple) :

```java
public static final FluidListType ADAMANTIUM_FLUID = addNewFluid(GenericFluids.builder()
        .still("adamantium_fluid_still")
        .flowing("adamantium_fluid_flowing")
        .block("adamantium_fluid_block",   Map.of("fr_fr", "Adamantium",          "en_us", "Adamantium"))
        .bucket("adamantium_fluid_bucket", Map.of("fr_fr", "Bucket d'adamantium",  "en_us", "Adamantium bucket"))
        .bucketTags(List.of(ConventionalItemTags.BUCKETS))
        .blockTags(List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE))
        .fluidTags(List.of(FluidTags.LAVA))   // même tag still + flowing
        .color(0xAAAAAA)                       // ← couleur hexadécimale du fluide (ARGB sans alpha)
        .build());
```

> Si ce fluide doit être utilisable dans la Forge Stellaire, ajoute-le au tag `forge_stellaire_fluid_input_left` ou `forge_stellaire_fluid_input_right` dans `ModTags.Fluids` et utilise `.stillTags()` + `.flowingTags()` séparément à la place de `.fluidTags()` (voir Solarium et Lunarium dans `ModFluids` comme exemples).

---

## Étape 7 — Advancement dans `ModAdvancements` *(optionnel)*

```java
public static final CustomAdvancements FIRST_ADAMANTIUM = addNewAdvancement(
    CustomAdvancements.builder("first_adamantium")
        .icon(ModItems.ADAMANTIUM_INGOT)
        .parent(CRAFTING_STELLAR_FORGE)
        .title("fr_fr", "De l'adamantium !")
        .title("en_us", "Adamantium!")
        .description("fr_fr", "Obtenez votre premier lingot d'adamantium")
        .description("en_us", "Get your first adamantium ingot")
        .condition(new HasItemCondition(List.of(
            new MyIngredient("adamantium_ingot", InstanceType.ITEM, 1))))
        .build()
);
```

Pour un advancement lié à une recette de Forge Stellaire, utilise `ForgedItemCondition` à la place :

```java
.condition(new ForgedItemCondition(List.of("forge_stellaire_raw_to_adamantium_ingot")))
```

> Les IDs passés à `ForgedItemCondition` doivent inclure le préfixe `forge_stellaire_` puisqu'il fait partie de l'ID réel de la recette.

---

## Étape 8 — Génération de monde *(si minerai)*

Dans `ModWorldConfigsFeatures` :
```java
public static final RegistryKey<ConfiguredFeature<?, ?>> OVERWORLD_ADAMANTIUM_ORES =
    registerFeatureConfig("adamantium_ore",
        Map.of(STONE_REPLACEABLES, ModBlocks.ADAMANTIUM_ORE.getDefaultState()), 6);
```

Dans `ModWorldPlacedFeatures` :
```java
public static final RegistryKey<PlacedFeature> ADAMANTIUM_ORE_PLACED =
    registerPlacedFeature("adamantium_ore", DimensionOptions.OVERWORLD, 10, 2, 80, ModifierPlacementType.UNIFORM);
```

> Le nom passé à `registerPlacedFeature` doit correspondre exactement à la clé dans `ModWorldConfigsFeatures.CONFIG_FEATURE`.

---

## Étape 9 — Textures

Créer les fichiers suivants dans `src/main/resources/assets/stellamecanics/textures/` :

```
item/adamantium_ingot.png
item/adamantium_raw.png
item/adamantium_axe.png
item/adamantium_hoe.png
item/adamantium_pickaxe.png
item/adamantium_shovel.png
item/adamantium_sword.png
item/adamantium_helmet.png
item/adamantium_chestplate.png
item/adamantium_leggings.png
item/adamantium_boots.png
item/adamantium_fluid_bucket.png

block/adamantium_ore.png
block/adamantium_block.png
block/adamantium_fluid_block.png   ← si fluide

models/armor/adamantium_armor_1.png   ← couche 1 (casque, plastron, bottes)
models/armor/adamantium_armor_2.png   ← couche 2 (pantalon)
```

---

## Étape 10 — Relancer le datagen

```bash
./gradlew runDatagen
```

Cela génère automatiquement dans `src/main/generated/` :
- Les modèles de blocs et d'items
- Les blockstates
- Les tags
- Les loot tables
- Les recettes
- Les fichiers de langue (`en_us.json`, `fr_fr.json`)
- Les advancements

> Ne modifie jamais manuellement les fichiers dans `src/main/generated/` — ils sont écrasés à chaque datagen.
