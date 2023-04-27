package de.melanx.morevanillalib.util;

import de.melanx.morevanillalib.FeatureConfig;
import de.melanx.morevanillalib.data.DamageTypesProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

import javax.annotation.Nullable;

public class ToolUtil {

    public static void moreDamage(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof Player) {
            RandomSource rand = event.getEntity().level.random;

            if (FeatureConfig.ExtraDamage.enabled && rand.nextDouble() < FeatureConfig.ExtraDamage.chance) {
                float multiplier = (float) (rand.nextFloat() * FeatureConfig.ExtraDamage.maxMultiplier);
                event.setAmount(event.getAmount() * multiplier);
            }
        }
    }

    public static void paperDamage(@Nullable LivingEntity entity) {
        if (entity != null && entity.level instanceof ServerLevel level) {
            Registry<DamageType> damageRegistry = level.getServer().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE);
            entity.hurt(new DamageSource(damageRegistry.getHolderOrThrow(DamageTypesProvider.PAPER_CUT)), Math.max(FeatureConfig.PaperDamage.minDamage, entity.level.random.nextFloat() * FeatureConfig.PaperDamage.maxDamage));
        }
    }
}
