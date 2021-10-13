package fr.Ethernyx.stellamecanics.utils.generator;

import fr.Ethernyx.stellamecanics.init.ModItems;


import java.util.ArrayList;
import java.util.List;

public class SerealizerGenerator {

    private List<AidInfoGenerator> datas = new ArrayList<>();

    public SerealizerGenerator() {
        for (LinkIItemProvidderAndAidInfoGenerator elem : ModItems.MAP_ITEMS.values()) { this.datas.add(elem.data); }
    }

    public List<AidInfoGenerator> getDatas() {
        return this.datas;
    }
}
