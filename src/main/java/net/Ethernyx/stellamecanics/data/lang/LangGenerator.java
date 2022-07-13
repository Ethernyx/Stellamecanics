package net.Ethernyx.stellamecanics.data.lang;

import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;
import net.Ethernyx.stellamecanics.Main;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.List;


public class LangGenerator implements DataProvider {
    private static final Logger LOGGER = LogUtils.getLogger();
    private final List<AidInfoGenerator> aids;
    private final String lang;
    public JsonObject jsonLang = new JsonObject();
    private final DataGenerator.PathResolver path;

    public LangGenerator(FabricDataGenerator fabricDataGenerator, List<AidInfoGenerator> aids, String lang) {
        this.path = fabricDataGenerator.createPathResolver(DataGenerator.OutputType.RESOURCE_PACK, "lang");
        this.aids = aids;
        this.lang = lang;
    }

    protected void addTranslations() {
        for (AidInfoGenerator item : this.aids){
            switch (item.getType()) {
                case ITEM:
                    jsonLang.addProperty("item." + Main.MOD_ID + "." + item.getId(), item.getTranslate(this.lang));
                    break;
                case BLOCK:
                    jsonLang.addProperty("block." + Main.MOD_ID + "." + item.getId(), item.getTranslate(this.lang));
                    if (item.hasScreen()) jsonLang.addProperty("screen." + Main.MOD_ID + "." + item.getId() , item.getTranslate(this.lang));
                    break;
                default:
                    break;
            }
        }

        jsonLang.addProperty("itemGroup." + Main.MOD_ID  +".stellamecanics_tab", "Stellamecanics");
    }

    @Override
    public void run(DataWriter writer) {
        addTranslations();
        try {
            System.out.print(path.resolveJson(Identifier.tryParse(Main.MOD_ID + ":" + lang)));
            DataProvider.writeToPath(writer, jsonLang, path.resolveJson(Identifier.tryParse(Main.MOD_ID + ":" + lang)));
        } catch (IOException var4) {
            LOGGER.error("Couldn't save Lang {}", path, var4);
        }
    }

    @Override
    public String getName() {
        return "Language " + lang;
    }
}
