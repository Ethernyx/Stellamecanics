package fr.Ethernyx.stellamecanics.item.armor.stellarium;

import fr.Ethernyx.stellamecanics.utils.CustomArmorMaterials;
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class StellariumLeggings extends ArmorItem implements ICommun {
    private final String id = "stellarium_leggings";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Pantalon en stellarium"); put("en_us", "Stellarium leggings");
    }};

    private AidInfoGenerator data;

    public StellariumLeggings() {
        super(CustomArmorMaterials.STELLARIUM_ARMOR, EquipmentSlotType.LEGS, new Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
