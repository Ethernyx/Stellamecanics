package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import fr.ethernyx.stellamecanics.utils.generic.GenericBlockTags;
import fr.ethernyx.stellamecanics.utils.generic.GenericFluidTags;
import fr.ethernyx.stellamecanics.utils.generic.GenericItemTags;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModTags {
    public static class Blocks {
        public static Map<String, GenericBlockTags> BLOCKTAGS = new HashMap<>();
        public static final TagKey<Block> NEED_LVL_4 = createTag(new GenericBlockTags("need_lvl_4", List.of(BlockTags.NEEDS_DIAMOND_TOOL)));
        public static final TagKey<Block> NEED_LVL_5 = createTag(new GenericBlockTags("need_lvl_5", List.of(NEED_LVL_4)));
        public static final TagKey<Block> NEED_LVL_6 = createTag(new GenericBlockTags("need_lvl_6", List.of(NEED_LVL_5)));;

        private static TagKey<Block> createTag(GenericBlockTags tag) {
            BLOCKTAGS.put(tag.getName(), tag);
            return tag.getTag();
        }
    }

    public static class Items {
        public static Map<String, GenericItemTags> ITEMTAGS = new HashMap<>();
        public static final TagKey<Item> IRIDIUM_TOOL = createTag(new GenericItemTags("iridium_tool", List.of()));
        public static final TagKey<Item> SOLARIUM_TOOL = createTag(new GenericItemTags("solarium_tool", List.of()));
        public static final TagKey<Item> LUNARIUM_TOOL = createTag(new GenericItemTags("lunarium_tool", List.of()));
        public static final TagKey<Item> OSMIRIDIUM_TOOL = createTag(new GenericItemTags("osmiridium_tool", List.of()));
        public static final TagKey<Item> ZIRCONIUM_TOOL = createTag(new GenericItemTags("zirconium_tool", List.of()));
        public static final TagKey<Item> ZIRCALOY_TOOL = createTag(new GenericItemTags("zircaloy_tool", List.of()));
        public static final TagKey<Item> STELLARIUM_TOOL = createTag(new GenericItemTags("stellarium_tool", List.of()));
        public static final TagKey<Item> IRIDIUM_WEAPON = createTag(new GenericItemTags("iridium_weapon", List.of()));
        public static final TagKey<Item> SOLARIUM_WEAPON = createTag(new GenericItemTags("solarium_weapon", List.of()));
        public static final TagKey<Item> LUNARIUM_WEAPON = createTag(new GenericItemTags("lunarium_weapon", List.of()));
        public static final TagKey<Item> OSMIRIDIUM_WEAPON = createTag(new GenericItemTags("osmiridium_weapon", List.of()));
        public static final TagKey<Item> ZIRCONIUM_WEAPON = createTag(new GenericItemTags("zirconium_weapon", List.of()));
        public static final TagKey<Item> ZIRCALOY_WEAPON = createTag(new GenericItemTags("zircaloy_weapon", List.of()));
        public static final TagKey<Item> STELLARIUM_WEAPON = createTag(new GenericItemTags("stellarium_weapon", List.of()));
        public static final TagKey<Item> IRIDIUM_ARMOR = createTag(new GenericItemTags("iridium_armor", List.of()));
        public static final TagKey<Item> SOLARIUM_ARMOR = createTag(new GenericItemTags("solarium_armor", List.of()));
        public static final TagKey<Item> LUNARIUM_ARMOR = createTag(new GenericItemTags("lunarium_armor", List.of()));
        public static final TagKey<Item> OSMIRIDIUM_ARMOR = createTag(new GenericItemTags("osmiridium_armor", List.of()));
        public static final TagKey<Item> ZIRCONIUM_ARMOR = createTag(new GenericItemTags("zirconium_armor", List.of()));
        public static final TagKey<Item> ZIRCALOY_ARMOR = createTag(new GenericItemTags("zircaloy_armor", List.of()));
        public static final TagKey<Item> STELLARIUM_ARMOR = createTag(new GenericItemTags("stellarium_armor", List.of()));
        public static final TagKey<Item> IRIDIUM_REPAIR = createTag(new GenericItemTags("iridium_repair", List.of()));
        public static final TagKey<Item> SOLARIUM_REPAIR = createTag(new GenericItemTags("solarium_repair", List.of()));
        public static final TagKey<Item> LUNARIUM_REPAIR = createTag(new GenericItemTags("lunarium_repair", List.of()));
        public static final TagKey<Item> OSMIRIDIUM_REPAIR = createTag(new GenericItemTags("osmiridium_repair", List.of()));
        public static final TagKey<Item> ZIRCALOY_REPAIR = createTag(new GenericItemTags("zircaloy_repair", List.of()));
        public static final TagKey<Item> ZIRCONIUM_REPAIR = createTag(new GenericItemTags("zirconium_repair", List.of()));
        public static final TagKey<Item> STELLARIUM_REPAIR = createTag(new GenericItemTags("stellarium_repair", List.of()));

        private static TagKey<Item> createTag(GenericItemTags tag) {
            ITEMTAGS.put(tag.getName(), tag);
            return tag.getTag();
        }
    }

    public static class Fluids {
        public static Map<String, GenericFluidTags> FLUIDTAGS = new HashMap<>();

        private static TagKey<Fluid> createTag(GenericFluidTags tag) {
            FLUIDTAGS.put(tag.getName(), tag);
            return tag.getTag();
        }
    }

    public static void registerModTags() { Stellamecanics.LOGGER.debug("Registering Mod Tags for " + Stellamecanics.MOD_ID); }
}
