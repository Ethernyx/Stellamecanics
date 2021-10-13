package fr.Ethernyx.stellamecanics.item.armor.solarium;

import fr.Ethernyx.stellamecanics.utils.CustomArmorMaterials;
import fr.Ethernyx.stellamecanics.utils.ICommun;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class SolariumChestplate extends ArmorItem implements ICommun {
    private final String id = "solarium_chestplate";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Plastron en solarium"); put("en_us", "Solarium chestplate");
    }};

    private AidInfoGenerator data;

    public SolariumChestplate() {
        super(CustomArmorMaterials.SOLARIUM_ARMOR, EquipmentSlotType.CHEST, new Item.Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
