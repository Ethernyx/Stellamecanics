package fr.Ethernyx.stellamecanics.utils.generator;

import fr.Ethernyx.stellamecanics.item.*;

import java.util.ArrayList;
import java.util.List;

public class SerealizerGenerator {

    private List<AidInfoGenerator> datas = new ArrayList<>();

    public SerealizerGenerator() {
        this.datas.add(new LunariumIngot().getData());
        this.datas.add(new SolariumIngot().getData());
        this.datas.add(new StellariumIngot().getData());
        this.datas.add(new IridiumIngot().getData());
        this.datas.add(new ZirconiumIngot().getData());
        this.datas.add(new ZircaloyIngot().getData());
        this.datas.add(new OsmiridiumIngot().getData());
    }

    public List<AidInfoGenerator> getDatas() {
        return this.datas;
    }
}
