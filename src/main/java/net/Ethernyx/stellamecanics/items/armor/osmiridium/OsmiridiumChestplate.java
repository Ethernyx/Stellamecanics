package net.Ethernyx.stellamecanics.items.armor.osmiridium;

import net.Ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.Ethernyx.stellamecanics.utils.ModItemsGroup;
import net.Ethernyx.stellamecanics.utils.generator.AidInfoGenerator;
import net.Ethernyx.stellamecanics.utils.generator.InstanceType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.Ethernyx.stellamecanics.utils.generator.ICommun;

import java.util.HashMap;
import java.util.Map;

public class OsmiridiumChestplate extends ArmorItem  implements ICommun {
    private static final String id = "osmiridium_chestplate";
    private final String modelType = "item/generated";
    private final Map<String, String> translate = new HashMap<String, String>() {{
        put("fr_fr", "Plastron en osmiridium"); put("en_us", "Osmiridium chestplate");
    }};

    private AidInfoGenerator data;

    public OsmiridiumChestplate() {
        super(CustomArmorMaterials.OSMIRIDIUM_ARMOR, EquipmentSlot.CHEST, new Item.Settings().group(ModItemsGroup.STELLAMECANICS));
        this.data = new AidInfoGenerator(this.id, this.modelType, this.translate, InstanceType.ITEM);
    }
    public static String getId() { return id;}
    public AidInfoGenerator getData() { return data; }
}
