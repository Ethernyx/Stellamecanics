# Stellamecanics

Mod Fabric pour Minecraft 1.21.10 ajoutant des matériaux avancés, des fluides et une **Forge Stellaire** permettant de transformer des ressources grâce à des fluides spéciaux.

---

## Prérequis

| Outil | Version |
|---|---|
| Java | 21 |
| Minecraft | 1.21.10 |
| Fabric Loader | 0.18.3+ |
| Fabric API | 0.138.4+1.21.10 |

Dépendances optionnelles au runtime : **REI** (Roughly Enough Items) pour la visualisation des recettes.

---

## Build

```bash
# Compiler le mod
./gradlew build

# Lancer le client en dev
./gradlew runClient

# Lancer le serveur en dev
./gradlew runServer

# Générer les fichiers de données (modèles, recettes, tags, loot tables, lang...)
./gradlew runDatagen
```

> ⚠️ Le datagen doit être relancé à chaque fois qu'un bloc, item, fluide, recette ou advancement est ajouté ou modifié.

---

## Architecture générale

```
src/main/java/fr/ethernyx/stellamecanics/
├── init/                   # Registres centraux (blocs, items, fluides, tags, advancements...)
├── block/entities/         # Block entities (ex: ForgeStellaire)
├── builders/               # Builders pour recettes et advancements custom
├── compatibility/rei/      # Intégration REI
├── datagen/                # Générateurs de données (modèles, recettes, tags, lang...)
├── interfaces/             # Interfaces partagées (IMyBlock, IMyItem, IMyFlowingFluid...)
├── network/                # Payloads réseau
├── utils/                  # Utilitaires (RecipeBuilder, MyIngredient, génériques...)
└── world/                  # Génération de monde (minerais)
```

### Principe clé : les classes génériques

Le mod repose sur un pattern générique pour éviter la duplication de code.
Chaque bloc, item ou fluide est défini en **une seule déclaration** dans son registre (`ModBlocks`, `ModItems`, `ModFluids`) en passant toutes ses propriétés (traductions, tags, recettes, loot table) directement au builder.

```java
// Exemple : ajouter un bloc simple
public static final Block MON_BLOC = addNewBlock(
    GenericBlocks.builder("mon_bloc")
        .lootTable(new MyLootTable(LootType.NORMAL, ...))
        .addTranslate("fr_fr", "Mon Bloc")
        .addTranslate("en_us", "My Block")
        .addTag(BlockTags.PICKAXE_MINEABLE)
        .build());
```

Le datagen lit ensuite ces déclarations pour générer automatiquement modèles, traductions, tags et loot tables.

---

## Conventions des builders

### RecipeBuilder

Le builder de recettes expose deux styles de méthodes selon les besoins :

| Méthode | Usage |
|---|---|
| `addInput(MyIngredient)` | Ajouter un ingrédient unitaire |
| `inputs(List<MyIngredient>)` | Ajouter plusieurs ingrédients d'un coup |
| `addOutput(MyIngredient)` | Ajouter une sortie unitaire |
| `outputs(List<MyIngredient>)` | Ajouter plusieurs sorties d'un coup |
| `addFluid(MyIngredient)` | Définir le fluide (recette FORGE) |
| `unlock(MyIngredient)` | Définir l'item de déverrouillage (recette SHAPE) |
| `pattern(List<String>)` | Définir le pattern (recette SHAPE) |

```java
// Exemple avec addInput / addOutput unitaires
RecipeBuilder.builder("ore_to_iridium_ingot", RecipeType.ORE)
    .addInput(new MyIngredient("iridium_ore", InstanceType.BLOCK, 1))
    .addOutput(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))
    .build()

// Exemple avec outputs() en lot (recette TOOLS)
RecipeBuilder.builder("iridium_tool", RecipeType.TOOLS)
    .addInput(new MyIngredient("iridium_ingot", InstanceType.ITEM, 1))
    .outputs(List.of(
        new MyIngredient("iridium_axe",     InstanceType.ITEM, 1),
        new MyIngredient("iridium_hoe",     InstanceType.ITEM, 1),
        new MyIngredient("iridium_pickaxe", InstanceType.ITEM, 1),
        new MyIngredient("iridium_shovel",  InstanceType.ITEM, 1),
        new MyIngredient("iridium_sword",   InstanceType.ITEM, 1)))
    .build()

// Exemple avec inputs() en lot (recette SHAPE multi-ingrédients)
RecipeBuilder.builder("forge_stellaire", RecipeType.SHAPE)
    .inputs(List.of(
        new MyIngredient("iridium_block",  InstanceType.BLOCK, 1),
        new MyIngredient("iridium_ingot",  InstanceType.ITEM, 1),
        new MyIngredient("furnace",        InstanceType.VANILLABLOCK, 1)))
    .addOutput(new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1))
    .pattern(List.of("0 0", "121", "111"))
    .unlock(new MyIngredient("forge_stellaire", InstanceType.BLOCK, 1))
    .build()
```

### GenericItems.Builder

```java
GenericItems.builder("mon_item", ItemsType.INGOT)
    .addTranslate("fr_fr", "Mon item")
    .addTranslate("en_us", "My item")
    .addTag(ModTags.Items.MON_TAG)
    .addRecipe(RecipeBuilder.builder(...).build())
    .build()
```

### GenericBlocks.Builder

```java
GenericBlocks.builder("mon_bloc")
    .lootTable(new MyLootTable(LootType.NORMAL, ...))
    .addTranslate("fr_fr", "Mon bloc")
    .addTranslate("en_us", "My block")
    .addTag(BlockTags.PICKAXE_MINEABLE)
    .addRecipe(RecipeBuilder.builder(...).build())
    .build()
```

Options avancées : `.hardness(float)`, `.resistance(float)`, `.notrequiresTool()`.

### GenericFluids.Builder

Le builder fluide expose deux styles de méthodes pour les tags :

| Méthode | Usage |
|---|---|
| `addBucketTag(TagKey<Item>)` | Ajouter un tag bucket unitaire |
| `bucketTags(List<TagKey<Item>>)` | Ajouter plusieurs tags bucket |
| `addBlockTag(TagKey<Block>)` | Ajouter un tag bloc unitaire |
| `blockTags(List<TagKey<Block>>)` | Ajouter plusieurs tags bloc |
| `addFluidTag(TagKey<Fluid>)` | Ajouter un tag sur still **et** flowing |
| `fluidTags(List<TagKey<Fluid>>)` | Ajouter plusieurs tags sur still **et** flowing |
| `addStillTag(TagKey<Fluid>)` | Ajouter un tag sur still uniquement |
| `stillTags(List<TagKey<Fluid>>)` | Ajouter plusieurs tags sur still uniquement |
| `addFlowingTag(TagKey<Fluid>)` | Ajouter un tag sur flowing uniquement |
| `flowingTags(List<TagKey<Fluid>>)` | Ajouter plusieurs tags sur flowing uniquement |

```java
// Fluide simple (même tags still + flowing)
GenericFluids.builder()
    .still("mon_fluid_still")
    .flowing("mon_fluid_flowing")
    .block("mon_fluid_block", Map.of("fr_fr", "Mon fluide", "en_us", "My fluid"))
    .bucket("mon_fluid_bucket", Map.of("fr_fr", "Bucket de mon fluide", "en_us", "My fluid bucket"))
    .addBucketTag(ConventionalItemTags.BUCKETS)
    .blockTags(List.of(BlockTags.REPLACEABLE, BlockTags.INVALID_SPAWN_INSIDE, BlockTags.FIRE))
    .addFluidTag(FluidTags.LAVA)
    .color(0xAAAAAA)
    .build()

// Fluide avec tags still/flowing distincts (ex: Forge Stellaire)
GenericFluids.builder()
    ...
    .fluidTags(List.of(FluidTags.WATER, ModTags.Fluids.FORGE_STELLAIRE_FLUID_INPUT_LEFT))
    .build()
```

> Si le fluide doit être utilisable dans la Forge Stellaire côté gauche, utilise `ModTags.Fluids.FORGE_STELLAIRE_FLUID_INPUT_LEFT`. Pour le côté droit, utilise `ModTags.Fluids.FORGE_STELLAIRE_FLUID_INPUT_RIGHT`.

---

## Matériaux disponibles

| Matériau | Source | Tier outil | Fluide associé |
|---|---|---|---|
| Iridium | Overworld (minerai) | 4 | Iridium fluid |
| Zirconium | Overworld (minerai) | 5 | Zirconium fluid |
| Solarium | Nether (minerai) | 6 | Solarium fluid |
| Lunarium | End (minerai) | 6 | Lunarium fluid |
| Zircaloy | Forge Stellaire | 6 | Zircaloy fluid |
| Osmiridium | Forge Stellaire | 6 | Osmiridium fluid |
| Stellarium | Forge Stellaire | 6 | Stellarium fluid |

Chaque matériau dispose d'un **lingot, d'un brut, d'un bloc, d'outils complets et d'une armure complète**.

---

## La Forge Stellaire

La Forge Stellaire est la machine centrale du mod. Elle dispose de :
- **1 slot d'entrée** (item)
- **1 slot de sortie** (item)
- **2 tanks de fluide** : Solarium (gauche) et Lunarium (droite)

### Remplissage des tanks

Faire un clic droit sur le **côté gauche** du bloc avec un bucket de Solarium remplit le tank Solarium.
Faire un clic droit sur le **côté droit** avec un bucket de Lunarium remplit le tank Lunarium.

Les tanks se remplissent aussi **automatiquement** :
- Le tank Solarium se remplit le **jour**
- Le tank Lunarium se remplit la **nuit**

### Compatibilité Transfer API (pipes)

| Direction | Contenu |
|---|---|
| Dessus (UP) | Slot d'entrée (items) |
| Dessous (DOWN) | Slot de sortie (items) |
| Sud (SOUTH) | Tank Solarium (fluide) |
| Nord (NORTH) | Tank Lunarium (fluide) |

### Format de recette JSON

```json
{
  "type": "stellamecanics:forge_stellaire",
  "ingredient": { "item": "stellamecanics:solarium_ingot" },
  "fluid": "stellamecanics:solarium_fluid_still",
  "fluid_amount": 200,
  "process_time": 50,
  "result": { "id": "stellamecanics:stellarium_ingot", "count": 1 }
}
```

---

## Conventions de nommage des recettes

> ⚠️ Ces conventions sont appliquées automatiquement par `MyRecipeGenerator` et `ForgeStellaireRecipeBuilder`. Les ignorer provoque des conflits d'ID silencieux.

| Type de recette | Suffixe/Préfixe automatique | Exemple d'ID final |
|---|---|---|
| `ORE` | Génère `_smelting` ET `_blasting` | `raw_to_iridium_ingot_smelting` |
| `FORGE` | Préfixe `forge_stellaire_` | `forge_stellaire_raw_to_iridium_ingot` |
| `TOOLS` | Suffixes `_axe`, `_hoe`, `_pickaxe`, `_shovel`, `_sword` | `iridium_tool_axe` |
| `ARMOR` | Suffixes `_boots`, `_chesplate`, `_helmet`, `_leggings` | `iridium_armor_boots` |

---

## Génération de monde

Les minerais sont déclarés dans `ModWorldConfigsFeatures` et `ModWorldPlacedFeatures`.

```java
// Exemple : ajouter un minerai dans l'overworld
registerFeatureConfig("mon_minerai", Map.of(STONE_REPLACEABLES, ModBlocks.MON_MINERAI.getDefaultState()), 6);
registerPlacedFeature("mon_minerai", DimensionOptions.OVERWORLD, 10, 2, 80, ModifierPlacementType.UNIFORM);
```

Les deux types de placement disponibles sont :
- `UNIFORM` : distribution uniforme entre yMin et yMax
- `TRAPEZOID` : distribution en trapèze (pic au centre, rare aux extrêmes)

---

## Advancements

Les advancements sont déclarés dans `ModAdvancements` via un **Builder** et générés par `AdvancementGenerator`.

```java
CustomAdvancements.builder("mon_advancement")
    .icon(ModItems.MON_ITEM)          // obligatoire
    .parent(MON_PARENT)               // null si root
    .title("fr_fr", "Mon titre")      // obligatoire
    .title("en_us", "My title")
    .description("fr_fr", "...")      // obligatoire si parent != null
    .description("en_us", "...")
    .frame(AdvancementFrame.TASK)     // défaut : TASK
    .condition(new HasItemCondition(...))
    .showToast(true)                  // défaut : true
    .announceToChat(true)             // défaut : true
    .hidden(false)                    // défaut : false
    .build()
```

Les conditions disponibles (`IMyAdvancementCondition`) dans `builders/advancements/criterionTypes/` :

| Classe | Déclenchement |
|---|---|
| `HasItemCondition(List<MyIngredient>)` | Quand le joueur a les items listés dans son inventaire |
| `ForgedItemCondition(List<String>)` | Quand le joueur craft une des recettes listées via la Forge Stellaire |
| `NoneCondition()` | Tick criterion — à réserver au root uniquement |

> ⚠️ `NoneCondition` se déclenche à chaque tick pour tous les joueurs. Ne l'utilise que pour le root.

---

## Ajouter un nouveau matériau

Voir [ADDING_MATERIAL.md](./ADDING_MATERIAL.md) pour le guide pas à pas complet.
