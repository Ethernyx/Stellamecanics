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
Chaque bloc, item ou fluide est défini en **une seule déclaration** dans son registre (`ModBlocks`, `ModItems`, `ModFluids`) en passant toutes ses propriétés (traductions, tags, recettes, loot table) directement au constructeur.

```java
// Exemple : ajouter un bloc simple
public static final Block MON_BLOC = addNewBlock(
    new GenericBlocks("mon_bloc",
        new MyLootTable(LootType.NORMAL, ...),
        Map.of("fr_fr", "Mon Bloc", "en_us", "My Block"),
        List.of(BlockTags.PICKAXE_MINEABLE),
        List.of(/* recettes */)
    ));
```

Le datagen lit ensuite ces déclarations pour générer automatiquement modèles, traductions, tags et loot tables.

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
    .description("fr_fr", "...")      // optionnel
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
