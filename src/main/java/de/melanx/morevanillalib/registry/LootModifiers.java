package de.melanx.morevanillalib.registry;

import com.mojang.serialization.MapCodec;
import de.melanx.morevanillalib.core.modifier.*;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "GLOBAL_LOOT_MODIFIER_SERIALIZERS")
public class LootModifiers {

    public static final MapCodec<AutoSmeltModifier> autoSmelt = AutoSmeltModifier.CODEC;
    public static final MapCodec<GlowstoneToolModifier> glowstoneDrops = GlowstoneToolModifier.CODEC;
    public static final MapCodec<DoubleDropModifier> doubleDrops = DoubleDropModifier.CODEC;
    public static final MapCodec<ExtraDropsModifier> extraDrops = ExtraDropsModifier.CODEC;
    public static final MapCodec<HeadDropModifier> headDrops = HeadDropModifier.CODEC;
}
