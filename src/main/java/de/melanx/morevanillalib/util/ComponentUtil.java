package de.melanx.morevanillalib.util;

import de.melanx.morevanillalib.MoreVanillaLib;
import net.minecraft.util.text.TranslationTextComponent;

public class ComponentUtil {

    public static TranslationTextComponent getJeiDesc(String s, Object... replacements) {
        return new TranslationTextComponent("jei." + MoreVanillaLib.getInstance().modid + "." + s + ".desc", replacements);
    }

    public static TranslationTextComponent getTooltip(String s, Object... replacements) {
        return new TranslationTextComponent("tooltip." + MoreVanillaLib.getInstance().modid + "." + s, replacements);
    }
}
