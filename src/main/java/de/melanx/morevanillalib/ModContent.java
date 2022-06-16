package de.melanx.morevanillalib;

import de.melanx.morevanillalib.core.modifier.*;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "LOOT_MODIFIER_SERIALIZERS")
public class ModContent {

    public static final GlobalLootModifierSerializer<AutoSmeltModifier> autoSmelt = new AutoSmeltModifier.Serializer();
    public static final GlobalLootModifierSerializer<GlowstoneToolModifier> glowstoneDrops = new GlowstoneToolModifier.Serializer();
    public static final GlobalLootModifierSerializer<DoubleDropModifier> doubleDrops = new DoubleDropModifier.Serializer();
    public static final GlobalLootModifierSerializer<ExtraDropsModifier> extraDrops = new ExtraDropsModifier.Serializer();
    public static final GlobalLootModifierSerializer<HeadDropModifier> headDrops = new HeadDropModifier.Serializer();
}
