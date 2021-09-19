package fr.Ethernyx.stellamecanics.data.lang;

import fr.Ethernyx.stellamecanics.init.ModBlocks;
import fr.Ethernyx.stellamecanics.init.ModItems;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.ArrayList;

public class LangGenerator extends LanguageProvider {

    private ArrayList<LangKey> tab = new ArrayList<>();
    public LangGenerator(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    static class LangKey {
        public final String fr;
        public final String en;
        public final IItemProvider item;

        LangKey(IItemProvider item, String fr, String en) {
            this.fr = fr;
            this.en = en;
            this.item = item;
        }
    }

    @Override
    protected void addTranslations() {
        if (this.tab.size() == 0) this.mapTranslation();

        for (LangKey langKey : this.tab) {
            if (langKey.item instanceof Block) add((Block) langKey.item, (this.getName().contains("fr_fr") ? langKey.fr : langKey.en));
            if (langKey.item instanceof Item) add((Item) langKey.item, (this.getName().contains("fr_fr") ? langKey.fr : langKey.en));
            if (langKey.item instanceof Enchantment) add((Enchantment) langKey.item, (this.getName().contains("fr_fr") ? langKey.fr : langKey.en));
        }

        add("itemGroup.stellamecanics_tab", "Stellamecanics");
    }

    private void mapTranslation() {
        this.tab.add(new LangKey(ModItems.SOLARIUM_INGOT.get(), "Lingot de solarium", "Solarium Ingot"));
        this.tab.add(new LangKey(ModItems.LUNARIUM_INGOT.get(), "Lingot de lunarium", "Lunarium Ingot"));
        this.tab.add(new LangKey(ModItems.STELLARIUM_INGOT.get(), "Lingot de stellarium", "Stellarium Ingot"));
        this.tab.add(new LangKey(ModItems.MAGNETITE_RAW.get(), "Magnetite brute", "Magnetite Raw"));
        this.tab.add(new LangKey(ModItems.ZIRCONIUM_RAW.get(), "Zirconium brut", "Zirconium Raw"));
        this.tab.add(new LangKey(ModItems.IRIDIUM_RAW.get(), "Iridium brut", "Iridium Raw"));
        this.tab.add(new LangKey(ModItems.SOLARIUM_RAW.get(), "Solarium brut", "Solarium Raw"));
        this.tab.add(new LangKey(ModItems.LUNARIUM_RAW.get(), "Lunarium brut", "Lunarium Raw"));
        this.tab.add(new LangKey(ModItems.ZIRCONIUM_INGOT.get(), "Lingot de zirconium", "Zirconium Ingot"));
        this.tab.add(new LangKey(ModItems.IRIDIUM_INGOT.get(), "Lingot d'iridium", "Iridium Ingot"));
        this.tab.add(new LangKey(ModItems.ZIRCALOY_INGOT.get(), "Lingot de zircaloy", "Zircaloy Ingot"));
        this.tab.add(new LangKey(ModItems.OSMIRIDIUM_INGOT.get(), "Lingot d'osmiridium", "Osmiridium Ingot"));
        this.tab.add(new LangKey(ModItems.SOLARIUM_HELMET.get(), "Casque en solarium", "Solarium Helmet"));
        this.tab.add(new LangKey(ModItems.SOLARIUM_CHESTPLATE.get(), "Plastron en solarium", "Solarium Chesplate"));
        this.tab.add(new LangKey(ModItems.SOLARIUM_LEGGINGS.get(), "Pantalon en solarium", "Solarium Leggings"));
        this.tab.add(new LangKey(ModItems.SOLARIUM_BOOTS.get(), "Bottes en solarium", "Solarium Boots"));
        this.tab.add(new LangKey(ModItems.LUNARIUM_HELMET.get(), "Casque en lunarium", "Lunarium Helmet"));
        this.tab.add(new LangKey(ModItems.LUNARIUM_CHESTPLATE.get(), "Plastron en lunarium", "Lunarium Chesplate"));
        this.tab.add(new LangKey(ModItems.LUNARIUM_LEGGINGS.get(), "Pantalon en lunarium", "Lunarium Leggings"));
        this.tab.add(new LangKey(ModItems.LUNARIUM_BOOTS.get(), "Bottes en lunarium", "Lunarium Boots"));
        this.tab.add(new LangKey(ModItems.LUNARIUM_PICKAXE.get(), "Pioche en lunarium", "Lunarium Pickaxe"));
        this.tab.add(new LangKey(ModItems.LUNARIUM_SHOVEL.get(), "Pelle en lunarium", "Lunarium Shovel"));
        this.tab.add(new LangKey(ModItems.LUNARIUM_AXE.get(), "Hache en lunarium", "Lunarium Axe"));
        this.tab.add(new LangKey(ModItems.LUNARIUM_SWORD.get(), "Epee en lunarium", "Lunarium Sword"));
        this.tab.add(new LangKey(ModItems.LUNARIUM_HOE.get(), "Houe en lunarium", "Lunarium Hoe"));
        this.tab.add(new LangKey(ModItems.SOLARIUM_PICKAXE.get(), "Pioche en solarium", "Solarium Pickaxe"));
        this.tab.add(new LangKey(ModItems.SOLARIUM_SHOVEL.get(), "Pelle en solarium", "Solarium Shovel"));
        this.tab.add(new LangKey(ModItems.SOLARIUM_AXE.get(), "Hache en solarium", "Solarium Axe"));
        this.tab.add(new LangKey(ModItems.SOLARIUM_SWORD.get(), "Epee en solarium", "Solarium Sword"));
        this.tab.add(new LangKey(ModItems.SOLARIUM_HOE.get(), "Houe en solarium", "Solarium Hoe"));
        this.tab.add(new LangKey(ModItems.STELLARIUM_PICKAXE.get(), "Pioche en stellarium", "Stellarium Pickaxe"));
        this.tab.add(new LangKey(ModItems.STELLARIUM_SHOVEL.get(), "Pelle en stellarium", "Stellarium Shovel"));
        this.tab.add(new LangKey(ModItems.STELLARIUM_AXE.get(), "Hache en stellarium", "Stellarium Axe"));
        this.tab.add(new LangKey(ModItems.STELLARIUM_SWORD.get(), "Epee en stellarium", "Stellarium Sword"));
        this.tab.add(new LangKey(ModItems.STELLARIUM_HOE.get(), "Houe en stellarium", "Stellarium Hoe"));
        this.tab.add(new LangKey(ModItems.STELLARIUM_HELMET.get(), "Casque en stellarium", "Stellarium Helmet"));
        this.tab.add(new LangKey(ModItems.STELLARIUM_CHESTPLATE.get(), "Plastron en stellarium", "Stellarium Chesplate"));
        this.tab.add(new LangKey(ModItems.STELLARIUM_LEGGINGS.get(), "Pantalon en stellarium", "Stellarium Leggings"));
        this.tab.add(new LangKey(ModItems.STELLARIUM_BOOTS.get(), "Bottes en stellarium", "Stellarium Boots"));
        this.tab.add(new LangKey(ModItems.ZIRCONIUM_PICKAXE.get(), "Pioche en zirconium", "Zirconium Pickaxe"));
        this.tab.add(new LangKey(ModItems.ZIRCONIUM_SHOVEL.get(), "Pelle en zirconium", "Zirconium Shovel"));
        this.tab.add(new LangKey(ModItems.ZIRCONIUM_AXE.get(), "Hache en zirconium", "Zirconium Axe"));
        this.tab.add(new LangKey(ModItems.ZIRCONIUM_SWORD.get(), "Epee en zirconium", "Zirconium Sword"));
        this.tab.add(new LangKey(ModItems.ZIRCONIUM_HOE.get(), "Houe en zirconium", "Zirconium Hoe"));
        this.tab.add(new LangKey(ModItems.ZIRCONIUM_HELMET.get(), "Casque en zirconium", "Zirconium Helmet"));
        this.tab.add(new LangKey(ModItems.ZIRCONIUM_CHESTPLATE.get(), "Plastron en zirconium", "Zirconium Chesplate"));
        this.tab.add(new LangKey(ModItems.ZIRCONIUM_LEGGINGS.get(), "Pantalon en zirconium", "Zirconium Leggings"));
        this.tab.add(new LangKey(ModItems.ZIRCONIUM_BOOTS.get(), "Bottes en zirconium", "Zirconium Boots"));
        this.tab.add(new LangKey(ModItems.IRIDIUM_PICKAXE.get(), "Pioche en iridium", "Iridium Pickaxe"));
        this.tab.add(new LangKey(ModItems.IRIDIUM_SHOVEL.get(), "Pelle en iridium", "Iridium Shovel"));
        this.tab.add(new LangKey(ModItems.IRIDIUM_AXE.get(), "Hache en iridium", "Iridium Axe"));
        this.tab.add(new LangKey(ModItems.IRIDIUM_SWORD.get(), "Epee en iridium", "Iridium Sword"));
        this.tab.add(new LangKey(ModItems.IRIDIUM_HOE.get(), "Houe en iridium", "Iridium Hoe"));
        this.tab.add(new LangKey(ModItems.IRIDIUM_HELMET.get(), "Casque en iridium", "Iridium Helmet"));
        this.tab.add(new LangKey(ModItems.IRIDIUM_CHESTPLATE.get(), "Plastron en iridium", "Iridium Chesplate"));
        this.tab.add(new LangKey(ModItems.IRIDIUM_LEGGINGS.get(), "Pantalon en iridium", "Iridium Leggings"));
        this.tab.add(new LangKey(ModItems.IRIDIUM_BOOTS.get(), "Bottes en iridium", "Iridium Boots"));
        this.tab.add(new LangKey(ModItems.ZIRCALOY_PICKAXE.get(), "Pioche en zircaloy", "Zircaloy Pickaxe"));
        this.tab.add(new LangKey(ModItems.ZIRCALOY_SHOVEL.get(), "Pelle en zircaloy", "Zircaloy Shovel"));
        this.tab.add(new LangKey(ModItems.ZIRCALOY_AXE.get(), "Hache en zircaloy", "Zircaloy Axe"));
        this.tab.add(new LangKey(ModItems.ZIRCALOY_SWORD.get(), "Epee en zircaloy", "Zircaloy Sword"));
        this.tab.add(new LangKey(ModItems.ZIRCALOY_HOE.get(), "Houe en zircaloy", "Zircaloy Hoe"));
        this.tab.add(new LangKey(ModItems.ZIRCALOY_HELMET.get(), "Casque en zircaloy", "Zircaloy Helmet"));
        this.tab.add(new LangKey(ModItems.ZIRCALOY_CHESTPLATE.get(), "Plastron en zircaloy", "Zircaloy Chesplate"));
        this.tab.add(new LangKey(ModItems.ZIRCALOY_LEGGINGS.get(), "Pantalon en zircaloy", "Zircaloy Leggings"));
        this.tab.add(new LangKey(ModItems.ZIRCALOY_BOOTS.get(), "Bottes en zircaloy", "Zircaloy Boots"));
        this.tab.add(new LangKey(ModItems.OSMIRIDIUM_PICKAXE.get(), "Pioche en osmiridium", "Osmiridium Pickaxe"));
        this.tab.add(new LangKey(ModItems.OSMIRIDIUM_SHOVEL.get(), "Pelle en osmiridium", "Osmiridium Shovel"));
        this.tab.add(new LangKey(ModItems.OSMIRIDIUM_AXE.get(), "Hache en osmiridium", "Osmiridium Axe"));
        this.tab.add(new LangKey(ModItems.OSMIRIDIUM_SWORD.get(), "Epee en osmiridium", "Osmiridium Sword"));
        this.tab.add(new LangKey(ModItems.OSMIRIDIUM_HOE.get(), "Houe en osmiridium", "Osmiridium Hoe"));
        this.tab.add(new LangKey(ModItems.OSMIRIDIUM_HELMET.get(), "Casque en osmiridium", "Osmiridium Helmet"));
        this.tab.add(new LangKey(ModItems.OSMIRIDIUM_CHESTPLATE.get(), "Plastron en osmiridium", "Osmiridium Chesplate"));
        this.tab.add(new LangKey(ModItems.OSMIRIDIUM_LEGGINGS.get(), "Pantalon en osmiridium", "Osmiridium Leggings"));
        this.tab.add(new LangKey(ModItems.OSMIRIDIUM_BOOTS.get(), "Bottes en osmiridium", "Osmiridium Boots"));

        this.tab.add(new LangKey(ModBlocks.MAGNETITE_ORE.get(), "Minerai de magnetite", "Magnetite Ore"));
        this.tab.add(new LangKey(ModBlocks.ZIRCONIUM_ORE.get(), "Minerai de zirconium", "Zirconium Ore"));
        this.tab.add(new LangKey(ModBlocks.IRIDIUM_ORE.get(), "Minerai d'iridium", "Iridium Ore"));
        this.tab.add(new LangKey(ModBlocks.SOLARIUM_ORE.get(), "Minerai de solarium", "Solarium Ore"));
        this.tab.add(new LangKey(ModBlocks.LUNARIUM_ORE.get(), "Minerai de lunarium", "Lunarium Ore"));
        this.tab.add(new LangKey(ModBlocks.ZIRCONIUM_BLOCK.get(), "Bloc de zirconium", "Zirconium Block"));
        this.tab.add(new LangKey(ModBlocks.IRIDIUM_BLOCK.get(), "Bloc d'iridium", "Iridium Block"));
        this.tab.add(new LangKey(ModBlocks.ZIRCALOY_BLOCK.get(), "Bloc de zircaloy", "Zircaloy Block"));
        this.tab.add(new LangKey(ModBlocks.OSMIRIDIUM_BLOCK.get(), "Bloc d'osmiridium", "Osmiridium Block"));
        this.tab.add(new LangKey(ModBlocks.SOLARIUM_BLOCK.get(), "Bloc de solarium", "Solarium Block"));
        this.tab.add(new LangKey(ModBlocks.LUNARIUM_BLOCK.get(), "Bloc de lunarium", "Lunarium Block"));
        this.tab.add(new LangKey(ModBlocks.STELLARIUM_BLOCK.get(), "Bloc de stellarium", "Stellarium Block"));
    }
}
