package fr.Ethernyx.stellamecanics.utils.generator;

import fr.Ethernyx.stellamecanics.block.*;
import fr.Ethernyx.stellamecanics.block.ore.*;
import fr.Ethernyx.stellamecanics.block.tileentity.ForgeStellaireBlock;
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
import fr.Ethernyx.stellamecanics.utils.IIModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;

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
        this.datas.add(new SolariumRaw().getData());
        this.datas.add(new LunariumRaw().getData());
        this.datas.add(new IridiumRaw().getData());
        this.datas.add(new ZirconiumRaw().getData());

        this.datas.add(new SolariumAxe().getData());
        this.datas.add(new SolariumHoe().getData());
        this.datas.add(new SolariumPickaxe().getData());
        this.datas.add(new SolariumShovel().getData());
        this.datas.add(new SolariumSword().getData());

        this.datas.add(new LunariumAxe().getData());
        this.datas.add(new LunariumHoe().getData());
        this.datas.add(new LunariumPickaxe().getData());
        this.datas.add(new LunariumShovel().getData());
        this.datas.add(new LunariumSword().getData());

        this.datas.add(new IridiumAxe().getData());
        this.datas.add(new IridiumHoe().getData());
        this.datas.add(new IridiumPickaxe().getData());
        this.datas.add(new IridiumShovel().getData());
        this.datas.add(new IridiumSword().getData());

        this.datas.add(new OsmiridiumAxe().getData());
        this.datas.add(new OsmiridiumHoe().getData());
        this.datas.add(new OsmiridiumPickaxe().getData());
        this.datas.add(new OsmiridiumShovel().getData());
        this.datas.add(new OsmiridiumSword().getData());

        this.datas.add(new StellariumAxe().getData());
        this.datas.add(new StellariumHoe().getData());
        this.datas.add(new StellariumPickaxe().getData());
        this.datas.add(new StellariumShovel().getData());
        this.datas.add(new StellariumSword().getData());

        this.datas.add(new ZircaloyAxe().getData());
        this.datas.add(new ZircaloyHoe().getData());
        this.datas.add(new ZircaloyPickaxe().getData());
        this.datas.add(new ZircaloyShovel().getData());
        this.datas.add(new ZircaloySword().getData());

        this.datas.add(new ZirconiumAxe().getData());
        this.datas.add(new ZirconiumHoe().getData());
        this.datas.add(new ZirconiumPickaxe().getData());
        this.datas.add(new ZirconiumShovel().getData());
        this.datas.add(new ZirconiumSword().getData());

        this.datas.add(new SolariumBoots().getData());
        this.datas.add(new SolariumChestplate().getData());
        this.datas.add(new SolariumHelmet().getData());
        this.datas.add(new SolariumLeggings().getData());

        this.datas.add(new LunariumBoots().getData());
        this.datas.add(new LunariumChestplate().getData());
        this.datas.add(new LunariumHelmet().getData());
        this.datas.add(new LunariumLeggings().getData());

        this.datas.add(new IridiumBoots().getData());
        this.datas.add(new IridiumChestplate().getData());
        this.datas.add(new IridiumHelmet().getData());
        this.datas.add(new IridiumLeggings().getData());

        this.datas.add(new StellariumBoots().getData());
        this.datas.add(new StellariumChestplate().getData());
        this.datas.add(new StellariumHelmet().getData());
        this.datas.add(new StellariumLeggings().getData());

        this.datas.add(new OsmiridiumBoots().getData());
        this.datas.add(new OsmiridiumChestplate().getData());
        this.datas.add(new OsmiridiumHelmet().getData());
        this.datas.add(new OsmiridiumLeggings().getData());

        this.datas.add(new ZircaloyBoots().getData());
        this.datas.add(new ZircaloyChestplate().getData());
        this.datas.add(new ZircaloyHelmet().getData());
        this.datas.add(new ZircaloyLeggings().getData());

        this.datas.add(new ZirconiumBoots().getData());
        this.datas.add(new ZirconiumChestplate().getData());
        this.datas.add(new ZirconiumHelmet().getData());
        this.datas.add(new ZirconiumLeggings().getData());

        this.datas.add(new SolariumOre().getData());
        this.datas.add(new LunariumOre().getData());
        this.datas.add(new MagnetiteOre().getData());
        this.datas.add(new IridiumOre().getData());
        this.datas.add(new ZirconiumOre().getData());

        this.datas.add(new IridiumBlock().getData());
        this.datas.add(new LunariumBlock().getData());
        this.datas.add(new OsmiridiumBlock().getData());
        this.datas.add(new SolariumBlock().getData());
        this.datas.add(new StellariumBlock().getData());
        this.datas.add(new ZircaloyBlock().getData());
        this.datas.add(new ZirconiumBlock().getData());

       // this.datas.add(new ForgeStellaireBlock().getData());
    }

    public List<AidInfoGenerator> getDatas() {
        return this.datas;
    }
}
