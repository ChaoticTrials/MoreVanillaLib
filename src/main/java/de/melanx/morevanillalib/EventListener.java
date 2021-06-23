package de.melanx.morevanillalib;

import de.melanx.morevanillalib.util.ToolUtil;
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
        Entity entity = event.getSource().getTrueSource();
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) entity;
            if (ToolUtil.isSlimeTool(livingEntity.getHeldItemMainhand().getItem()) || ToolUtil.isSlimeTool(livingEntity.getHeldItemOffhand().getItem())) {
                LivingEntity target = event.getEntityLiving();
                target.applyKnockback(1.5F, MathHelper.sin((float) (entity.rotationYaw * Math.PI / 180)), -MathHelper.cos((float) (entity.rotationYaw * Math.PI / 180)));
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

        if (ToolUtil.isSlimeTool(player.getHeldItemMainhand().getItem()) || ToolUtil.isSlimeTool(player.getHeldItemOffhand().getItem())) {
            target.addVelocity(-MathHelper.sin((float) (player.rotationYaw * Math.PI / 180)) * 1.5F, 0.1D, MathHelper.cos((float) (player.rotationYaw * Math.PI / 180)) * 1.5F);
            player.setMotion(player.getMotion().mul(0.6, 1, 0.6));
            player.setSprinting(false);
        }
    }
}
