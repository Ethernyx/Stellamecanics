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
    private final List<AidInfoGenerator> aids;

    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper, List<AidInfoGenerator> aids) {
        super(generator, Main.MOD_ID, existingFileHelper);
        this.aids = aids;
    }

    @Override
    protected void registerModels() {
        for (AidInfoGenerator item : this.aids) {
            switch (item.getType()) {
                case ITEM:
                case ENCHANTMENT:
                    builder(getExistingFile(mcLoc(item.getModelType())), item.getId());
                    break;
                case BLOCK:
                    withExistingParent(item.getId(), modLoc("block/" + item.getId()));
                    break;
                default:
                    break;
            }
        }
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
