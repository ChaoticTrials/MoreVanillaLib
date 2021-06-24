package de.melanx.morevanillalib.util;

import com.google.common.collect.Sets;
import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.core.LibDamageSource;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.Random;
import java.util.Set;

public class ToolUtil {

    // TODO 1.17 replace with tags
    public static final Set<Material> PICKAXE_MATERIALS = Sets.newHashSet(Material.ROCK, Material.ANVIL, Material.IRON);
    public static final Set<Material> AXE_MATERIALS = Sets.newHashSet(Material.WOOD, Material.NETHER_WOOD, Material.PLANTS, Material.TALL_PLANTS, Material.BAMBOO, Material.GOURD);

    public static void moreDamage(LivingDamageEvent event) {
        if (event.getSource().getTrueSource() instanceof PlayerEntity) {
            Random rand = event.getEntityLiving().world.rand;

            if (FeatureConfig.ExtraDamage.enabled && rand.nextDouble() < FeatureConfig.ExtraDamage.chance) {
                float multiplier = (float) (rand.nextFloat() * FeatureConfig.ExtraDamage.maxMultiplier);
                event.setAmount(event.getAmount() * multiplier);
            }
        }
    }

    public static boolean isPlayerKill(LivingDropsEvent event) {
        return event.isRecentlyHit() && event.getSource().getTrueSource() != null && event.getSource().getTrueSource() instanceof PlayerEntity;
    }

    public static void paperDamage(LivingEntity entity) {
        entity.attackEntityFrom(LibDamageSource.PAPER_CUT, Math.max(FeatureConfig.PaperDamage.minDamage, entity.world.rand.nextFloat() * FeatureConfig.PaperDamage.maxDamage));
    }
}
