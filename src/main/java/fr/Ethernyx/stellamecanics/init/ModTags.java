package fr.ethernyx.stellamecanics.init;

import fr.ethernyx.stellamecanics.Stellamecanics;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEED_IRIDIUM_TOOL = createTag("need_iridium_tool");
        public static final TagKey<Block> FORBIDDEN_IRIDIUM_TOOL = createTag("forbidden_iridium_tool");
        public static final TagKey<Block> NEED_SOLARIUM_TOOL = createTag("need_solarium_tool");
        public static final TagKey<Block> FORBIDDEN_SOLARIUM_TOOL = createTag("forbidden_solarium_tool");
        public static final TagKey<Block> NEED_LUNARIUM_TOOL = createTag("need_lunarium_tool");
        public static final TagKey<Block> FORBIDDEN_LUNARIUM_TOOL = createTag("forbidden_lunarium_tool");
        public static final TagKey<Block> NEED_OSMIRIDIUM_TOOL = createTag("need_osmiridium_tool");
        public static final TagKey<Block> FORBIDDEN_OSMIRIDIUM_TOOL = createTag("forbidden_osmiridium_tool");
        public static final TagKey<Block> NEED_STELLARIUM_TOOL = createTag("need_stellarium_tool");
        public static final TagKey<Block> FORBIDDEN_STELLARIUM_TOOL = createTag("forbidden_stellarium_tool");
        public static final TagKey<Block> NEED_ZIRCALOY_TOOL = createTag("need_zircaloy_tool");
        public static final TagKey<Block> FORBIDDEN_ZIRCALOY_TOOL = createTag("forbidden_zircaloy_tool");
        public static final TagKey<Block> NEED_ZIRCONIUM_TOOL = createTag("need_zirconium_tool");
        public static final TagKey<Block> FORBIDDEN_ZIRCONIUM_TOOL = createTag("forbidden_zirconium_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Stellamecanics.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> IRIDIUM_TOOL = createTag(("iridium_tool"));
        public static final TagKey<Item> IRIDIUM_REPAIR = createTag(("iridium_repair"));
        public static final TagKey<Item> SOLARIUM_REPAIR = createTag(("solarium_repair"));
        public static final TagKey<Item> LUNARIUM_REPAIR = createTag(("lunarium_repair"));
        public static final TagKey<Item> OSMIRIDIUM_REPAIR = createTag(("osmiridium_repair"));
        public static final TagKey<Item> ZIRCALOY_REPAIR = createTag(("zircaloy_repair"));
        public static final TagKey<Item> ZIRCONIUM_REPAIR = createTag(("zirconium_repair"));
        public static final TagKey<Item> STELLARIUM_REPAIR = createTag(("zirconium_repair"));

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Stellamecanics.MOD_ID, name));
        }
    }

    public static void registerModTags() { Stellamecanics.LOGGER.debug("Registering Mod Tags for " + Stellamecanics.MOD_ID); }
}
