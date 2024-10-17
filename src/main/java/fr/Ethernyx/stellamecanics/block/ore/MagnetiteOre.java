package fr.ethernyx.stellamecanics.block.ore;

import fr.ethernyx.stellamecanics.interfaces.IMyBlock;
import fr.ethernyx.stellamecanics.utils.generator.InstanceType;
import fr.ethernyx.stellamecanics.utils.generator.LootType;
import fr.ethernyx.stellamecanics.utils.generator.MyLootTable;
import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import net.minecraft.block.Block;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagnetiteOre extends Block implements IMyBlock {
    public static String getId() {
        return "magnetite_ore";
    }

    @Override
    public String getTranslate(String lang) {
        Map<String, String> langs = new HashMap<String, String>() {{
            put("fr_fr", "Minerai de magnétite");
            put("en_us", "Magnetite ore");
        }};
        return langs.get(lang);
    }

    public MagnetiteOre() {
        super(Settings.create().strength(3f, 15f).requiresTool());
        /*this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.BLOCK);
        this.data.setLootType(LootType.LUCKY_ORE, new MyIngredient("magnetite_raw", InstanceType.ITEM, 3));
        this.data.addTag(BlockTags.PICKAXE_MINEABLE);
        this.data.addTag(BlockTags.NEEDS_DIAMOND_TOOL);*/
    }

    @Override
    public MyLootTable getLootTable() {
        return new MyLootTable(LootType.LUCKY_ORE, new MyIngredient("magnetite_raw", InstanceType.ITEM, 3));
    }

    @Override
    public List<TagKey<Block>> getTags() {
        List<TagKey<Block>> tags = new ArrayList<>();
        tags.add(BlockTags.PICKAXE_MINEABLE);
        tags.add(BlockTags.NEEDS_DIAMOND_TOOL);
        return tags;
    }
}
