package fr.Ethernyx.stellamecanics.data.model;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.data.lang.LangGenerator;
import fr.Ethernyx.stellamecanics.init.ModItems;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.SerealizerGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;


public class ItemModelGenerator extends ItemModelProvider {
    static class JsonItem {
        final String name;
        final ModelFile type;

        JsonItem(String name, ModelFile type) {
            this.name = name;
            this.type = type;
        }
    }

    private ArrayList<String> BLOCKS = new ArrayList<>();
    private ArrayList<JsonItem> ITEMS = new ArrayList<>();
    private final List<AidInfoGenerator> aids;

    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper, List<AidInfoGenerator> aids) {
        super(generator, Main.MOD_ID, existingFileHelper);
        this.aids = aids;
    }

    @Override
    protected void registerModels() {

        if (this.BLOCKS.size() == 0) this.indexBlocks();
        if (this.ITEMS.size() == 0) this.indexItems();

        for (String block : this.BLOCKS) withExistingParent(block, modLoc("block/" + block));



        for (JsonItem item : this.ITEMS) builder(item.type, item.name);

        for (AidInfoGenerator model : this.aids) {
            switch (model.getType()) {
                case ITEM:
                case ENCHANTMENT:
                    builder(getExistingFile(mcLoc(model.getModelType())), model.getId());
                    break;
                case BLOCK:
                    withExistingParent(model.getId(), modLoc("block/" + model.getId()));
                    break;
                default:
                    break;
            }
        }
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }

    private void indexBlocks() {
        this.BLOCKS.add("solarium_block");
        this.BLOCKS.add("lunarium_block");
        this.BLOCKS.add("stellarium_block");
        this.BLOCKS.add("zirconium_block");
        this.BLOCKS.add("iridium_block");
        this.BLOCKS.add("zircaloy_block");
        this.BLOCKS.add("osmiridium_block");
        this.BLOCKS.add("magnetite_ore");
        this.BLOCKS.add("zirconium_ore");
        this.BLOCKS.add("iridium_ore");
    }

    private void indexItems() {
        final ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        final ModelFile itemHandeld = getExistingFile(mcLoc("item/handheld"));

        this.ITEMS.add(new JsonItem("solarium_ingot", itemGenerated));
       // this.ITEMS.add(new JsonItem("lunarium_ingot", itemGenerated));
        this.ITEMS.add(new JsonItem("stellarium_ingot", itemGenerated));
        this.ITEMS.add(new JsonItem("magnetite_raw", itemGenerated));
        this.ITEMS.add(new JsonItem("zirconium_raw", itemGenerated));
        this.ITEMS.add(new JsonItem("iridium_raw", itemGenerated));
        this.ITEMS.add(new JsonItem("zirconium_ingot", itemGenerated));
        this.ITEMS.add(new JsonItem("iridium_ingot", itemGenerated));
        this.ITEMS.add(new JsonItem("zircaloy_ingot", itemGenerated));
        this.ITEMS.add(new JsonItem("osmiridium_ingot", itemGenerated));
        this.ITEMS.add(new JsonItem("solarium_pickaxe", itemHandeld));
        this.ITEMS.add(new JsonItem("solarium_axe", itemHandeld));
        this.ITEMS.add(new JsonItem("solarium_shovel", itemHandeld));
        this.ITEMS.add(new JsonItem("solarium_sword", itemHandeld));
       // this.ITEMS.add(new JsonItem("solarium_hoe", itemHandeld));
        this.ITEMS.add(new JsonItem("lunarium_pickaxe", itemHandeld));
        this.ITEMS.add(new JsonItem("lunarium_axe", itemHandeld));
        this.ITEMS.add(new JsonItem("lunarium_shovel", itemHandeld));
        this.ITEMS.add(new JsonItem("lunarium_sword", itemHandeld));
        // this.ITEMS.add(new JsonItem("lunarium_hoe", itemHandeld));
        this.ITEMS.add(new JsonItem("stellarium_pickaxe", itemHandeld));
        this.ITEMS.add(new JsonItem("stellarium_axe", itemHandeld));
        this.ITEMS.add(new JsonItem("stellarium_shovel", itemHandeld));
        this.ITEMS.add(new JsonItem("stellarium_sword", itemHandeld));
        // this.ITEMS.add(new JsonItem("stellarium_hoe", itemHandeld));
        this.ITEMS.add(new JsonItem("zirconium_pickaxe", itemHandeld));
        this.ITEMS.add(new JsonItem("zirconium_axe", itemHandeld));
        this.ITEMS.add(new JsonItem("zirconium_shovel", itemHandeld));
        this.ITEMS.add(new JsonItem("zirconium_sword", itemHandeld));
        this.ITEMS.add(new JsonItem("zirconium_hoe", itemHandeld));
        this.ITEMS.add(new JsonItem("zirconium_boots", itemGenerated));
        this.ITEMS.add(new JsonItem("zirconium_leggings", itemGenerated));
        this.ITEMS.add(new JsonItem("zirconium_chestplate", itemGenerated));
        this.ITEMS.add(new JsonItem("zirconium_helmet", itemGenerated));
        this.ITEMS.add(new JsonItem("iridium_pickaxe", itemHandeld));
        this.ITEMS.add(new JsonItem("iridium_axe", itemHandeld));
        this.ITEMS.add(new JsonItem("iridium_shovel", itemHandeld));
        this.ITEMS.add(new JsonItem("iridium_sword", itemHandeld));
        // this.ITEMS.add(new JsonItem("iridium_hoe", itemHandeld));
        this.ITEMS.add(new JsonItem("zircaloy_pickaxe", itemHandeld));
        this.ITEMS.add(new JsonItem("zircaloy_axe", itemHandeld));
        this.ITEMS.add(new JsonItem("zircaloy_shovel", itemHandeld));
        this.ITEMS.add(new JsonItem("zircaloy_sword", itemHandeld));
        // this.ITEMS.add(new JsonItem("zircaloy_hoe", itemHandeld));
        this.ITEMS.add(new JsonItem("osmiridium_pickaxe", itemHandeld));
        this.ITEMS.add(new JsonItem("osmiridium_axe", itemHandeld));
        this.ITEMS.add(new JsonItem("osmiridium_shovel", itemHandeld));
        this.ITEMS.add(new JsonItem("osmiridium_sword", itemHandeld));
        // this.ITEMS.add(new JsonItem("osmiridium_hoe", itemHandeld));
    }

}
