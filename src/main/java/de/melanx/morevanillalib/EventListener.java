package de.melanx.morevanillalib;

import de.melanx.morevanillalib.data.ModTags;
import de.melanx.morevanillalib.util.ToolUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventListener {

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getMainHandItem();
        if (FeatureConfig.PaperDamage.enabled && item.is(ModTags.Items.PAPER_TOOLS)
                && player.level().random.nextDouble() < FeatureConfig.PaperDamage.chance
                && event.getState().getDestroySpeed(player.level(), event.getPos()) != 0.0f) {
            ToolUtil.paperDamage(player);
        }
    }

    @SubscribeEvent
    public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        if (!player.level().isClientSide
                && player.getMainHandItem().is(ModTags.Items.PAPER_TOOLS)
                && FeatureConfig.PaperDamage.enabled
                && player.level().random.nextDouble() < FeatureConfig.PaperDamage.chance
                && event.getUseItem() == Event.Result.ALLOW) {
            ToolUtil.paperDamage(player);
        }
    }

    @SubscribeEvent
    public void onPlayerAttackTarget(AttackEntityEvent event) {
        if (event.getTarget() instanceof LivingEntity target
                && !target.level().isClientSide
                && event.getEntity().getMainHandItem().is(ModTags.Items.PAPER_TOOLS)
                && FeatureConfig.PaperDamage.enabled
                && target.level().random.nextDouble() < FeatureConfig.PaperDamage.chance) {
            ToolUtil.paperDamage(event.getEntity());
        }
    }

    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent event) {
        if (!(event.getSource().getEntity() instanceof Player player)) {
            return;
        }

        LivingEntity entity = event.getEntity();
        ItemStack item = player.getMainHandItem();
        if ((item.is(ModTags.Items.BONE_TOOLS) && entity instanceof AbstractSkeleton)
                || (item.is(ModTags.Items.ENDER_TOOLS) && (entity instanceof EnderMan || entity instanceof Endermite))
                || (item.is(ModTags.Items.FIERY_TOOLS) && entity instanceof MagmaCube)
                || (item.is(ModTags.Items.PRISMARINE_TOOLS) && entity instanceof Guardian)
                || (item.is(ModTags.Items.SLIME_TOOLS) && (entity instanceof Slime && !(entity instanceof MagmaCube)))) {
            ToolUtil.moreDamage(event);
        }
    }
}
