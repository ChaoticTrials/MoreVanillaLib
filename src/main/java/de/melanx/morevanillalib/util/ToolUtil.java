package de.melanx.morevanillalib.util;

import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.core.LibDamageSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.Random;

public class ToolUtil {

    public static void moreDamage(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof Player) {
            Random rand = event.getEntityLiving().level.random;

            if (FeatureConfig.ExtraDamage.enabled && rand.nextDouble() < FeatureConfig.ExtraDamage.chance) {
                float multiplier = (float) (rand.nextFloat() * FeatureConfig.ExtraDamage.maxMultiplier);
                event.setAmount(event.getAmount() * multiplier);
            }
        }
    }

    public static boolean isPlayerKill(LivingDropsEvent event) {
        return event.isRecentlyHit() && event.getSource().getEntity() != null && event.getSource().getEntity() instanceof Player;
    }

    public static void paperDamage(LivingEntity entity) {
        entity.hurt(LibDamageSource.PAPER_CUT, Math.max(FeatureConfig.PaperDamage.minDamage, entity.level.random.nextFloat() * FeatureConfig.PaperDamage.maxDamage));
    }

    public static InteractionResult toolUse(UseOnContext context, ToolType toolType) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        ItemStack stack = context.getItemInHand();
        Direction side = context.getClickedFace();

        if (player != null
                && player.mayUseItemAt(pos, side, stack)
                && ((side != Direction.DOWN && level.isEmptyBlock(pos.above())) || toolType == ToolType.AXE)) {

            BlockState state = level.getBlockState(pos);
            BlockState modifiedState = state.getToolModifiedState(level, pos, player, stack, toolType);
            if (modifiedState != null) {
                SoundEvent sound;
                if (ToolType.AXE == toolType) {
                    sound = SoundEvents.AXE_STRIP;
                } else if (ToolType.SHOVEL == toolType) {
                    sound = SoundEvents.SHOVEL_FLATTEN;
                } else {
                    sound = SoundEvents.HOE_TILL;
                }

                level.playSound(player, pos, sound, SoundSource.BLOCKS, 1, 1);
            } else if (state.getBlock() instanceof CampfireBlock && state.getValue(CampfireBlock.LIT)) {
                if (!level.isClientSide) {
                    level.levelEvent(player, 1009, pos, 0);
                }
                CampfireBlock.dowse(player, level, pos, state);
                modifiedState = state.setValue(CampfireBlock.LIT, false);
            }

            if (modifiedState != null) {
                if (!level.isClientSide) {
                    level.setBlock(pos, modifiedState, 11);
                    stack.hurtAndBreak(1, player, playerEntity -> playerEntity.broadcastBreakEvent(context.getHand()));
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }

        return InteractionResult.PASS;
    }
}
