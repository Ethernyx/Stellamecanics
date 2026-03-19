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

Les méthodes du builder `GenericItems` à utiliser :

| Méthode | Usage |
|---|---|
| `.addTranslate(lang, texte)` | Ajouter une traduction |
| `.addTag(tag)` | Ajouter un tag item |
| `.addRecipe(RecipeBuilder)` | Ajouter une recette |
| `.toolMaterial(ToolMaterial)` | Définir le matériau d'outil |
| `.armorMaterial(ArmorMaterial)` | Définir le matériau d'armure |

Pour les recettes TOOLS et ARMOR, utilise `.outputs(List.of(...))` pour passer tous les items d'un coup. Pour les recettes avec un seul output, utilise `.addOutput(...)`.

```java
// Lingot (avec ses recettes)
public static final Item ADAMANTIUM_INGOT = addNewItem(GenericItems.builder("adamantium_ingot", ItemsType.INGOT)
    .addTranslate("fr_fr", "Lingot d'adamantium")
    .addTranslate("en_us", "Adamantium ingot")
    .addTag(ModTags.Items.ADAMANTIUM_REPAIR)
    .addRecipe(RecipeBuilder.builder("adamantium_block", RecipeType.SHAPE)
        .addInput(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 1))
        .addOutput(new MyIngredient("adamantium_block", InstanceType.BLOCK, 1))
        .pattern(List.of("000", "000", "000"))
        .unlock(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 1))
        .build())
    .addRecipe(RecipeBuilder.builder("adamantium_tool", RecipeType.TOOLS)
        .addInput(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 1))
        .outputs(List.of(
            new MyIngredient("adamantium_axe",     InstanceType.ITEM, 1),
            new MyIngredient("adamantium_hoe",     InstanceType.ITEM, 1),
            new MyIngredient("adamantium_pickaxe", InstanceType.ITEM, 1),
            new MyIngredient("adamantium_shovel",  InstanceType.ITEM, 1),
            new MyIngredient("adamantium_sword",   InstanceType.ITEM, 1)))
        .build())
    .addRecipe(RecipeBuilder.builder("adamantium_armor", RecipeType.ARMOR)
        .addInput(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 1))
        .outputs(List.of(
            new MyIngredient("adamantium_boots",      InstanceType.ITEM, 1),
            new MyIngredient("adamantium_chestplate", InstanceType.ITEM, 1),
            new MyIngredient("adamantium_helmet",     InstanceType.ITEM, 1),
            new MyIngredient("adamantium_leggings",   InstanceType.ITEM, 1)))
        .build())
    .build());

// Brut (avec fusion et recette forge)
public static final Item ADAMANTIUM_RAW = addNewItem(GenericItems.builder("adamantium_raw", ItemsType.RAW)
    .addTranslate("fr_fr", "Adamantium brut")
    .addTranslate("en_us", "Adamantium raw")
    .addTag(ModTags.Items.ADAMANTIUM_REPAIR)
    .addRecipe(RecipeBuilder.builder("raw_to_adamantium_ingot", RecipeType.ORE)
        .addInput(new MyIngredient("adamantium_raw",    InstanceType.ITEM, 1))
        .addOutput(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 1))
        .build())
    // Optionnel : recette FORGE pour doubler
    // .addRecipe(RecipeBuilder.builder("raw_to_adamantium_ingot", RecipeType.FORGE)
    //     .addInput(new MyIngredient("adamantium_raw", InstanceType.ITEM, 1))
    //     .addFluid(new MyIngredient("..._fluid_still", InstanceType.FLUID, 200))
    //     .addOutput(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 2))
    //     .build())
    .build());

// Outils
public static final Item ADAMANTIUM_AXE     = addNewItem(GenericItems.builder("adamantium_axe",     ItemsType.AXE)     .addTranslate("fr_fr", "Hache en adamantium")  .addTranslate("en_us", "Adamantium axe")     .toolMaterial(CustomItemTiers.ADAMANTIUM) .addTag(ModTags.Items.ADAMANTIUM_TOOL)   .build());
public static final Item ADAMANTIUM_HOE     = addNewItem(GenericItems.builder("adamantium_hoe",     ItemsType.HOE)     .addTranslate("fr_fr", "Houe en adamantium")   .addTranslate("en_us", "Adamantium hoe")     .toolMaterial(CustomItemTiers.ADAMANTIUM) .addTag(ModTags.Items.ADAMANTIUM_TOOL)   .build());
public static final Item ADAMANTIUM_PICKAXE = addNewItem(GenericItems.builder("adamantium_pickaxe", ItemsType.PICKAXE) .addTranslate("fr_fr", "Pioche en adamantium") .addTranslate("en_us", "Adamantium pickaxe") .toolMaterial(CustomItemTiers.ADAMANTIUM) .addTag(ModTags.Items.ADAMANTIUM_TOOL)   .build());
public static final Item ADAMANTIUM_SHOVEL  = addNewItem(GenericItems.builder("adamantium_shovel",  ItemsType.SHOVEL)  .addTranslate("fr_fr", "Pelle en adamantium")  .addTranslate("en_us", "Adamantium shovel")  .toolMaterial(CustomItemTiers.ADAMANTIUM) .addTag(ModTags.Items.ADAMANTIUM_TOOL)   .build());
public static final Item ADAMANTIUM_SWORD   = addNewItem(GenericItems.builder("adamantium_sword",   ItemsType.SWORD)   .addTranslate("fr_fr", "Épée en adamantium")   .addTranslate("en_us", "Adamantium sword")   .toolMaterial(CustomItemTiers.ADAMANTIUM) .addTag(ModTags.Items.ADAMANTIUM_WEAPON) .build());

// Armure
public static final Item ADAMANTIUM_HELMET     = addNewItem(GenericItems.builder("adamantium_helmet",     ItemsType.HELMET)     .addTranslate("fr_fr", "Casque en adamantium")   .addTranslate("en_us", "Adamantium helmet")     .armorMaterial(CustomArmorMaterials.ADAMANTIUM_ARMOR) .addTag(ModTags.Items.ADAMANTIUM_ARMOR) .build());
public static final Item ADAMANTIUM_CHESTPLATE = addNewItem(GenericItems.builder("adamantium_chestplate", ItemsType.CHESTPLATE) .addTranslate("fr_fr", "Plastron en adamantium") .addTranslate("en_us", "Adamantium chestplate") .armorMaterial(CustomArmorMaterials.ADAMANTIUM_ARMOR) .addTag(ModTags.Items.ADAMANTIUM_ARMOR) .build());
public static final Item ADAMANTIUM_LEGGINGS   = addNewItem(GenericItems.builder("adamantium_leggings",   ItemsType.LEGGINGS)   .addTranslate("fr_fr", "Pantalon en adamantium") .addTranslate("en_us", "Adamantium leggings")   .armorMaterial(CustomArmorMaterials.ADAMANTIUM_ARMOR) .addTag(ModTags.Items.ADAMANTIUM_ARMOR) .build());
public static final Item ADAMANTIUM_BOOTS      = addNewItem(GenericItems.builder("adamantium_boots",      ItemsType.BOOTS)      .addTranslate("fr_fr", "Bottes en adamantium")   .addTranslate("en_us", "Adamantium boots")      .armorMaterial(CustomArmorMaterials.ADAMANTIUM_ARMOR) .addTag(ModTags.Items.ADAMANTIUM_ARMOR) .build());
```

---

## Étape 5 — Bloc dans `ModBlocks`

Les méthodes du builder `GenericBlocks` à utiliser :

| Méthode | Usage |
|---|---|
| `.addTranslate(lang, texte)` | Ajouter une traduction |
| `.addTag(tag)` | Ajouter un tag bloc |
| `.addRecipe(RecipeBuilder)` | Ajouter une recette |
| `.lootTable(MyLootTable)` | Définir la loot table |
| `.hardness(float)` | Résistance à la destruction (défaut : `3f`) |
| `.resistance(float)` | Résistance aux explosions (défaut : `15f`) |
| `.requiresNoTool()` | Peut être cassé à la main |

```java
// Minerai
public static final Block ADAMANTIUM_ORE = addNewBlock(GenericBlocks.builder("adamantium_ore")
        .lootTable(new MyLootTable(LootType.ORE, new MyIngredient("adamantium_raw", InstanceType.ITEM, 1)))
        .addTranslate("fr_fr", "Minerai d'adamantium")
        .addTranslate("en_us", "Adamantium ore")
        .addTag(BlockTags.PICKAXE_MINEABLE)
        .addTag(ModTags.Blocks.NEED_LVL_6)
        .addRecipe(RecipeBuilder.builder("ore_to_adamantium_ingot", RecipeType.ORE)
                .addInput(new MyIngredient("adamantium_ore", InstanceType.BLOCK, 1))
                .addOutput(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 1))
                .build())
        .build());

// Bloc de stockage (9 lingots → 1 bloc, 1 bloc → 9 lingots)
public static final Block ADAMANTIUM_BLOCK = addNewBlock(GenericBlocks.builder("adamantium_block")
        .lootTable(new MyLootTable(LootType.NORMAL, new MyIngredient("adamantium_block", InstanceType.BLOCK, 1)))
        .addTranslate("fr_fr", "Bloc d'adamantium")
        .addTranslate("en_us", "Adamantium block")
        .addTag(BlockTags.PICKAXE_MINEABLE)
        .addTag(ModTags.Blocks.NEED_LVL_6)
        .addRecipe(RecipeBuilder.builder("adamantium_ingot", RecipeType.SHAPELLESS)
                .addInput(new MyIngredient("adamantium_block", InstanceType.BLOCK, 1))
                .addOutput(new MyIngredient("adamantium_ingot", InstanceType.ITEM, 9))
                .build())
        .build());
```

---

## Étape 6 — Fluide dans `ModFluids` *(optionnel)*

Les méthodes du builder `GenericFluids` à utiliser :

| Méthode | Usage |
|---|---|
| `.addBucketTag(tag)` | Ajouter un tag bucket unitaire |
| `.bucketTags(List)` | Ajouter plusieurs tags bucket |
| `.addBlockTag(tag)` | Ajouter un tag bloc unitaire |
| `.blockTags(List)` | Ajouter plusieurs tags bloc |
| `.addFluidTag(tag)` | Ajouter un tag sur still **et** flowing |
| `.fluidTags(List)` | Ajouter plusieurs tags sur still **et** flowing |
| `.addStillTag(tag)` | Ajouter un tag sur still uniquement |
| `.addFlowingTag(tag)` | Ajouter un tag sur flowing uniquement |

```java
public static final FluidListType ADAMANTIUM_FLUID = addNewFluid(GenericFluids.builder()
        .still("adamantium_fluid_still")
        .flowing("adamantium_fluid_flowing")
        .block("adamantium_fluid_block",   Map.of("fr_fr", "Adamantium",          "en_us", "Adamantium"))
        .bucket("adamantium_fluid_bucket", Map.of("fr_fr", "Bucket d'adamantium",  "en_us", "Adamantium bucket"))
        .addBucketTag(ConventionalItemTags.BUCKETS)
        .blockTags(List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE))
        .addFluidTag(FluidTags.LAVA)      // même tag still + flowing
        .color(0xAAAAAA)                  // couleur hexadécimale du fluide
        .build());
```

> Si ce fluide doit être utilisable dans la Forge Stellaire, utilise `.fluidTags(List.of(FluidTags.WATER, ModTags.Fluids.FORGE_STELLAIRE_FLUID_INPUT_LEFT))` pour le tank gauche (Solarium), ou `FORGE_STELLAIRE_FLUID_INPUT_RIGHT` pour le tank droit (Lunarium). Consulte `ModFluids` (Solarium et Lunarium) comme exemples.

---

## Étape 7 — Advancement dans `ModAdvancements` *(optionnel)*

```java
public static final CustomAdvancements FIRST_ADAMANTIUM = addNewAdvancement(
    CustomAdvancements.builder("first_adamantium")
        .icon(ModItems.ADAMANTIUM_INGOT)
        .parent(CRAFTING_STELLAR_FORGE)
        .addTitle("fr_fr", "De l'adamantium !")
        .addTitle("en_us", "Adamantium!")
        .addDesc("fr_fr", "Obtenez votre premier lingot d'adamantium")
        .addDesc("en_us", "Get your first adamantium ingot")
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
