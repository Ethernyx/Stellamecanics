package fr.Ethernyx.stellamecanics.data.lang;

import fr.Ethernyx.stellamecanics.Main;
import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.ArrayList;
import java.util.List;

public class LangGenerator extends LanguageProvider {
    private final List<AidInfoGenerator> aids;

    public LangGenerator(DataGenerator gen, String modid, String locale, List<AidInfoGenerator> aids) {
        super(gen, modid, locale);
        this.aids = aids;
    }

    @Override
    protected void addTranslations() {
        for (AidInfoGenerator item : this.aids){
            switch (item.getType()) {
                case ITEM:
                    add("item." + Main.MOD_ID + "." + item.getId(), item.getTranslate(this.getName().substring("Languages: ".length())));
                    break;
                case BLOCK:
                    add("block." + Main.MOD_ID + "." + item.getId(), item.getTranslate(this.getName().substring("Languages: ".length())));
                    break;
                default:
                    break;
            }
        }

        add("itemGroup.stellamecanics_tab", "Stellamecanics");
    }
}
