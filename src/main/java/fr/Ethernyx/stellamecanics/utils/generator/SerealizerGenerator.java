package fr.Ethernyx.stellamecanics.utils.generator;

import fr.Ethernyx.stellamecanics.item.LunariumIngot;
import net.minecraft.util.IItemProvider;

import java.util.ArrayList;
import java.util.List;

public class SerealizerGenerator {

    private List<AidInfoGenerator> datas = new ArrayList<>();

    public SerealizerGenerator() {
        this.datas.add(new LunariumIngot().getData());
    }

    public List<AidInfoGenerator> getDatas() {
        return this.datas;
    }
}
