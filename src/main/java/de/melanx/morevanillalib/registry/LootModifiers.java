package de.melanx.morevanillalib.registry;

import com.mojang.serialization.Codec;
import de.melanx.morevanillalib.core.modifier.*;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "GLOBAL_LOOT_MODIFIER_SERIALIZERS")
public class LootModifiers {

    public static final Codec<AutoSmeltModifier> autoSmelt = AutoSmeltModifier.CODEC;
    public static final Codec<GlowstoneToolModifier> glowstoneDrops = GlowstoneToolModifier.CODEC;
    public static final Codec<DoubleDropModifier> doubleDrops = DoubleDropModifier.CODEC;
    public static final Codec<ExtraDropsModifier> extraDrops = ExtraDropsModifier.CODEC;
    public static final Codec<HeadDropModifier> headDrops = HeadDropModifier.CODEC;
}
