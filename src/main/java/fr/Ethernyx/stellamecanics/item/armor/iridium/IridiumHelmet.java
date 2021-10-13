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

public class IridiumHelmet extends ArmorItem implements ICommun {
    private final String id = "iridium_helmet";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Casque en iridium"); put("en_us", "Iridium helmet");
    }};

    private AidInfoGenerator data;

    public IridiumHelmet() {
        super(CustomArmorMaterials.IRIDIUM_ARMOR, EquipmentSlotType.HEAD, new Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
