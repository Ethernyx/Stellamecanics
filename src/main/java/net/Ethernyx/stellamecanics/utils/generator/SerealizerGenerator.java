package net.Ethernyx.stellamecanics.utils.generator;

import net.Ethernyx.stellamecanics.init.ModItems;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class SerealizerGenerator {

    private List<AidInfoGenerator> datas = new ArrayList<>();

    public SerealizerGenerator() {
        for (LinkIItemProvidderAndAidInfoGenerator elem : ModItems.ITEMS.values()) { this.datas.add(elem.data); }
    }

    public List<AidInfoGenerator> getDatas() {
        return this.datas;
    }
}
