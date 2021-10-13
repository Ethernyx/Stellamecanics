package fr.Ethernyx.stellamecanics.utils.generator;

import fr.Ethernyx.stellamecanics.block.*;
import fr.Ethernyx.stellamecanics.block.ore.*;
import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
import fr.Ethernyx.stellamecanics.item.ore.*;
import fr.Ethernyx.stellamecanics.item.tool.lunarium.*;
import fr.Ethernyx.stellamecanics.item.tool.solarium.*;
import fr.Ethernyx.stellamecanics.item.tool.iridium.*;
import fr.Ethernyx.stellamecanics.item.tool.osmiridium.*;
import fr.Ethernyx.stellamecanics.item.tool.stellarium.*;
import fr.Ethernyx.stellamecanics.item.tool.zircaloy.*;
import fr.Ethernyx.stellamecanics.item.tool.zirconium.*;
import fr.Ethernyx.stellamecanics.item.armor.lunarium.*;
import fr.Ethernyx.stellamecanics.item.armor.solarium.*;
import fr.Ethernyx.stellamecanics.item.armor.iridium.*;
import fr.Ethernyx.stellamecanics.item.armor.osmiridium.*;
import fr.Ethernyx.stellamecanics.item.armor.stellarium.*;
import fr.Ethernyx.stellamecanics.item.armor.zircaloy.*;
import fr.Ethernyx.stellamecanics.item.armor.zirconium.*;
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.recipe.RecipeBuilder;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SerealizerGenerator {

    private List<AidInfoGenerator> datas = new ArrayList<>();

    public SerealizerGenerator() {
        for (LinkIItemProvidderAndAidInfoGenerator elem : ModItems.MAP_ITEMS.values()) { this.datas.add(elem.data); }
    }

    public List<AidInfoGenerator> getDatas() {
        return this.datas;
    }
}
