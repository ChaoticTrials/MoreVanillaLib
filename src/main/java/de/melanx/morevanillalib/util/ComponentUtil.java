package de.melanx.morevanillalib.util;

import de.melanx.morevanillalib.MoreVanillaLib;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class ComponentUtil {

    public static MutableComponent getJeiDesc(String s, Object... replacements) {
        return Component.translatable("jei." + MoreVanillaLib.getInstance().modid + "." + s + ".desc", replacements);
    }

    public static MutableComponent getTooltip(String s, Object... replacements) {
        return Component.translatable("tooltip." + MoreVanillaLib.getInstance().modid + "." + s, replacements);
    }
}
