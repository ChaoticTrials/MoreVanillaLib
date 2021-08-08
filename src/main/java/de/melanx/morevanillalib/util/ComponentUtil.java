package de.melanx.morevanillalib.util;

import de.melanx.morevanillalib.MoreVanillaLib;
import net.minecraft.network.chat.TranslatableComponent;

public class ComponentUtil {

    public static TranslatableComponent getJeiDesc(String s, Object... replacements) {
        return new TranslatableComponent("jei." + MoreVanillaLib.getInstance().modid + "." + s + ".desc", replacements);
    }

    public static TranslatableComponent getTooltip(String s, Object... replacements) {
        return new TranslatableComponent("tooltip." + MoreVanillaLib.getInstance().modid + "." + s, replacements);
    }
}
