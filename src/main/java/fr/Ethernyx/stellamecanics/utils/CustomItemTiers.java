package fr.ethernyx.stellamecanics.utils;

import fr.ethernyx.stellamecanics.init.ModTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class CustomItemTiers {

    public static ToolMaterial SOLARIUM = new ToolMaterial(ModTags.Blocks.BLOCKTAGS.get("need_lvl_5").getTag(), 3360, 4.8f, 2f, 10, ModTags.Items.SOLARIUM_REPAIR);
    public static ToolMaterial LUNARIUM = new ToolMaterial(ModTags.Blocks.BLOCKTAGS.get("need_lvl_5").getTag(), 4200, 6f, 1.5f, 10, ModTags.Items.LUNARIUM_REPAIR);
    public static ToolMaterial ZIRCONIUM = new ToolMaterial(ModTags.Blocks.BLOCKTAGS.get("need_lvl_4").getTag(), 1680, 2.4f, 1.5f, 10, ModTags.Items.ZIRCONIUM_REPAIR);
    public static ToolMaterial IRIDIUM = new ToolMaterial(BlockTags.NEEDS_DIAMOND_TOOL, 3360, 4.8f, 1.5f, 10, ModTags.Items.IRIDIUM_REPAIR);
    public static ToolMaterial ZIRCALOY = new ToolMaterial(ModTags.Blocks.BLOCKTAGS.get("need_lvl_6").getTag(), 3360, 4.8f, 1.5f, 10, ModTags.Items.ZIRCALOY_REPAIR);
    public static ToolMaterial OSMIRIDIUM = new ToolMaterial(ModTags.Blocks.BLOCKTAGS.get("need_lvl_6").getTag(), 5040, 7.2f, 1.5f, 10, ModTags.Items.OSMIRIDIUM_REPAIR);
    public static ToolMaterial STELLARIUM = new ToolMaterial(ModTags.Blocks.BLOCKTAGS.get("need_lvl_6").getTag(), 5040, 7.2f, 1.5f, 10, ModTags.Items.STELLARIUM_REPAIR);

}
