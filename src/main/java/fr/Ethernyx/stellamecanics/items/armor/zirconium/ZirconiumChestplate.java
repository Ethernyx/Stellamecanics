package fr.ethernyx.stellamecanics.items.armor.zirconium;

import fr.ethernyx.stellamecanics.interfaces.IMyItem;
import fr.ethernyx.stellamecanics.utils.CustomArmorMaterials;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

import java.util.HashMap;
import java.util.Map;

public class ZirconiumChestplate extends ArmorItem  implements IMyItem {
    public static String getId() {
        return "zirconium_chestplate";
    }

    @Override
    public Model getModelType() {
        return Models.GENERATED;
    }
    @Override
    public String getTranslate(String lang) { 
        Map<String, String> langs = new HashMap<>() {{
            put("fr_fr", "Plastron en zirconium");
            put("en_us", "Zirconium chestplate");
        }};
        return langs.get(lang);
    }


    

    public ZirconiumChestplate() {
        super(CustomArmorMaterials.ZIRCONIUM_ARMOR, Type.CHESTPLATE, new Settings());
        /*this.data = new AidInfoGenerator(this.getId(), this.getModelType(), this.getTranslate(), InstanceType.ITEM);*/
    }
    
    
}
