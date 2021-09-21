package fr.Ethernyx.stellamecanics.item.armor.zircaloy;

import fr.Ethernyx.stellamecanics.utils.CustomArmorMaterials;
import fr.Ethernyx.stellamecanics.utils.ModItemGroups;
import fr.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import fr.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class ZircaloyChestplate extends ArmorItem {
    private final String id = "zircaloy_chestplate";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Plastron en zircaloy"); put("en_us", "Zircaloy chestplate");
    }};

    private AidInfoGenerator data;

    public ZircaloyChestplate() {
        super(CustomArmorMaterials.ZIRCALOY_ARMOR, EquipmentSlotType.CHEST, new Properties().tab(ModItemGroups.STELLAMECANICS_TAB));
    }

    public AidInfoGenerator getData(){
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
        return this.data;
    }

    public String getId() {
        return this.id;
    }
}
