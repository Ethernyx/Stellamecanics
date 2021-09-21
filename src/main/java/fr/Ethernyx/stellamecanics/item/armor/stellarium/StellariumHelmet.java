package fr.Ethernyx.stellamecanics.item.armor.stellarium;

import fr.Ethernyx.stellamecanics.utils.CustomArmorMaterials;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class StellariumHelmet extends ArmorItem {
    private final String id = "stellarium_helmet";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Casque en stellarium"); put("en_us", "Stellarium helmet");
    }};

    private AidInfoGenerator data;

    public StellariumHelmet() {
        super(CustomArmorMaterials.STELLARIUM_ARMOR, EquipmentSlotType.HEAD, new Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
    }

    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        return this.data;
    }

    public String getId() {
        return this.id;
    }
}
