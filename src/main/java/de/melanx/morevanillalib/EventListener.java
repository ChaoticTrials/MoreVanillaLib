package de.melanx.morevanillalib;

import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventListener {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onEntityAttackFrom(LivingAttackEvent event) {
        Entity entity = event.getSource().getEntity();
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            if (ModTags.Items.SLIME_TOOLS.contains(livingEntity.getMainHandItem().getItem()) || ModTags.Items.SLIME_TOOLS.contains(livingEntity.getMainHandItem().getItem())) {
                LivingEntity target = event.getEntityLiving();
                target.knockback(1.5F, MathHelper.sin((float) (entity.yRot * Math.PI / 180)), -MathHelper.cos((float) (entity.yRot * Math.PI / 180)));
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onPlayerAttackEntity(AttackEntityEvent event) {
        LivingEntity player = event.getPlayer();
        Entity target = event.getTarget();

        // Living entities are handled by `onEntityAttackFrom`
        if (target instanceof LivingEntity) {
            return;
        }

        if (ModTags.Items.SLIME_TOOLS.contains(player.getMainHandItem().getItem()) || ModTags.Items.SLIME_TOOLS.contains(player.getMainHandItem().getItem())) {
            target.push(-MathHelper.sin((float) (player.yRot * Math.PI / 180)) * 1.5F, 0.1D, MathHelper.cos((float) (player.yRot * Math.PI / 180)) * 1.5F);
            player.setDeltaMovement(player.getDeltaMovement().multiply(0.6, 1, 0.6));
            player.setSprinting(false);
        }
    }
}
