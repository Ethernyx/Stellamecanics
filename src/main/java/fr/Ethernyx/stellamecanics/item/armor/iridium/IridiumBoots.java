package fr.Ethernyx.stellamecanics.item.armor.iridium;

import fr.Ethernyx.stellamecanics.utils.CustomArmorMaterials;
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class IridiumBoots extends ArmorItem implements ICommun {
    private final String id = "iridium_boots";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Bottes en iridium"); put("en_us", "Iridium boots");
    }};

    private AidInfoGenerator data;

    public IridiumBoots() {
        super(CustomArmorMaterials.IRIDIUM_ARMOR, EquipmentSlotType.FEET, new Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
