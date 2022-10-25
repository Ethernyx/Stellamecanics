package net.Ethernyx.stellamecanics.init;

import net.Ethernyx.stellamecanics.Main;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTags {

    public static final TagKey<Block> NEEDS_TOOL_LEVEL_4 = of("needs_tool_level_4");
    public static final TagKey<Block> NEEDS_TOOL_LEVEL_5 = of("needs_tool_level_5");
    public static final TagKey<Block> NEEDS_TOOL_LEVEL_6 = of("needs_tool_level_6");

    private ModTags() {
    }

    private static TagKey<Block> of(String id) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(Main.MOD_ID, id));
    }
    public static void registerModTags() {
        Main.LOGGER.debug("Registering Mod Tags for " + Main.MOD_ID);
    }
}
