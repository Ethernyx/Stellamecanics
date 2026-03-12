package fr.ethernyx.stellamecanics.utils;

import fr.ethernyx.stellamecanics.utils.recipe.MyIngredient;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class CustomAdvancements {
    private final String id;
    private final AdvancementFrame frame;
    private final CustomAdvancements parent;// null si root
    private final Map<String, String> title;
    private final Map<String, String> description;
    private final boolean showToast;
    private final boolean announceToChat;
    private final boolean hidden;
    private final ItemConvertible icon;
    private final Identifier background;
    private final List<MyIngredient> items;
    private final CriterionType type;

    public CustomAdvancements(String id, CustomAdvancements parent, ItemConvertible icon, AdvancementFrame frame, Identifier background, Map<String, String> title, Map<String, String> description, boolean showToast, boolean announceToChat, boolean hidden, CriterionType type, List<MyIngredient> items) {
        this.id = id;
        this.frame = frame;
        this.parent = parent;
        this.title = title;
        this.description = description;
        this.showToast = showToast;
        this.announceToChat = announceToChat;
        this.hidden = hidden;
        this.icon = icon;
        this.background = background;
        this.items = items;
        this.type = type;
    }

    public String getId() { return id; }
    public AdvancementFrame getFrame() { return frame; }
    public CustomAdvancements getParent() { return parent; }
    public String getTitle(String lang) { return title.get(lang); }
    public String getDescription(String lang) { return description.get(lang); }
    public boolean isShowToast() { return showToast; }
    public boolean isAnnounceToChat() { return announceToChat; }
    public boolean isHidden() { return hidden; }
    public ItemConvertible getIcon() { return icon; }
    public Identifier getBackground() { return background; }
    public List<MyIngredient> getItems() { return items; }
    public CriterionType getType() { return type; }
}
