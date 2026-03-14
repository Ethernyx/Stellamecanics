package fr.ethernyx.stellamecanics.utils;

import fr.ethernyx.stellamecanics.builders.advancements.criterionTypes.NoneCondition;
import fr.ethernyx.stellamecanics.interfaces.IMyAdvancementCondition;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
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
    private final IMyAdvancementCondition condition;

    public CustomAdvancements(String id, CustomAdvancements parent, ItemConvertible icon, AdvancementFrame frame, Identifier background, Map<String, String> title, Map<String, String> description, boolean showToast, boolean announceToChat, boolean hidden, IMyAdvancementCondition condition) {
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
        this.condition = condition;
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
    public IMyAdvancementCondition getCondition() { return condition; }

    public static class Builder {
        private final String id;
        private AdvancementFrame frame =  AdvancementFrame.TASK;
        private ItemConvertible icon;
        private final Map<String, String> title = new LinkedHashMap<>();
        private final Map<String, String> description = new LinkedHashMap<>();
        private CustomAdvancements parent = null;
        private Identifier background = null;
        private boolean showToast = true;
        private boolean announceToChat = true;
        private boolean hidden = false;
        private IMyAdvancementCondition condition = new NoneCondition();

        private Builder(String id) {
            this.id = id;
        }

        public Builder icon(ItemConvertible icon) {
            this.icon = icon;
            return this;
        }

        public Builder frame(AdvancementFrame frame) {
            this.frame = frame;
            return this;
        }

        public Builder title(String lang, String value) {
            this.title.put(lang, value);
            return this;
        }

        public Builder description(String lang, String value) {
            this.description.put(lang, value);
            return this;
        }

        public Builder parent(CustomAdvancements parent) {
            this.parent = parent;
            return this;
        }

        public Builder background(Identifier background) {
            this.background = background;
            return this;
        }

        public Builder showToast(boolean showToast) {
            this.showToast = showToast;
            return this;
        }

        public Builder announceToChat(boolean announceToChat) {
            this.announceToChat = announceToChat;
            return this;
        }

        public Builder hidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        public Builder condition(IMyAdvancementCondition condition) {
            this.condition = condition;
            return this;
        }

        public CustomAdvancements build() {
            if (icon == null)
                throw new IllegalStateException("Advancement '" + id + "' : icon est obligatoire");
            if (title.isEmpty())
                throw new IllegalStateException("Advancement '" + id + "' : title est obligatoire");
            if (parent != null && description.isEmpty())
                throw new IllegalStateException("Advancement '" + id + "' : description est obligatoire");

            return new CustomAdvancements(
                    id,
                    parent,
                    icon,
                    frame,
                    background,
                    title,
                    description,
                    showToast,
                    announceToChat,
                    hidden,
                    condition
            );
        }
    }

    public static Builder builder(String id) {
        return new Builder(id);
    }
}
