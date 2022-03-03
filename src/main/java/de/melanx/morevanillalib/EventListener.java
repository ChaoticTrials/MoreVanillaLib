package de.melanx.morevanillalib;

import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventListener {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onEntityAttackFrom(LivingAttackEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity entity) {
            if (entity.getMainHandItem().is(ModTags.Items.SLIME_TOOLS) || entity.getOffhandItem().is(ModTags.Items.SLIME_TOOLS)) {
                LivingEntity target = event.getEntityLiving();
                target.knockback(1.5F, Mth.sin((float) (entity.yRot * Math.PI / 180)), -Mth.cos((float) (entity.yRot * Math.PI / 180)));
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

        if (player.getMainHandItem().is(ModTags.Items.SLIME_TOOLS) || player.getOffhandItem().is(ModTags.Items.SLIME_TOOLS)) {
            target.push(-Mth.sin((float) (player.yRot * Math.PI / 180)) * 1.5F, 0.1D, Mth.cos((float) (player.yRot * Math.PI / 180)) * 1.5F);
            player.setDeltaMovement(player.getDeltaMovement().multiply(0.6, 1, 0.6));
            player.setSprinting(false);
        }
    }
}
