package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.MoreVanillaLib;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DeathMessageType;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.DamageTypeProviderBase;

public class DamageTypesProvider extends DamageTypeProviderBase {

    public static final ResourceKey<DamageType> PAPER_CUT = ResourceKey.create(Registries.DAMAGE_TYPE, MoreVanillaLib.getInstance().resource("paper_cut"));

    public final Holder<DamageType> paperCut = this.damageType("paperCut", 0.0f)
            .deathMessageType(DeathMessageType.INTENTIONAL_GAME_DESIGN)
            .build();

    public DamageTypesProvider(DatagenContext ctx) {
        super(ctx);
    }
}
