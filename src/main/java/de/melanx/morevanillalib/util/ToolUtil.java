package de.melanx.morevanillalib.util;

import com.google.common.collect.Sets;
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
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.minecraftforge.common.ToolActions.*;

public class ToolUtil {

    public static final Set<ToolAction> DEFAULT_AIOT_ACTIONS = Stream.of(
            AXE_DIG, AXE_STRIP, AXE_SCRAPE, AXE_WAX_OFF,
            HOE_DIG, /*TODO HOE_TILL,*/
            SHOVEL_DIG, SHOVEL_FLATTEN,
            PICKAXE_DIG,
            SWORD_DIG
    ).collect(Collectors.toCollection(Sets::newIdentityHashSet));

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

    public static void paperDamage(@Nullable LivingEntity entity) {
        if (entity != null) {
            entity.hurt(LibDamageSource.PAPER_CUT, Math.max(FeatureConfig.PaperDamage.minDamage, entity.level.random.nextFloat() * FeatureConfig.PaperDamage.maxDamage));
        }
    }

    public static InteractionResult toolUse(UseOnContext context, ToolAction toolAction) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        ItemStack stack = context.getItemInHand();
        Direction side = context.getClickedFace();

        if (player != null
                && player.mayUseItemAt(pos, side, stack)
                && ((side != Direction.DOWN && level.isEmptyBlock(pos.above())) || AXE_STRIP == toolAction)) {

            BlockState state = level.getBlockState(pos);
            BlockState modifiedState = state.getToolModifiedState(level, pos, player, stack, toolAction);
            if (modifiedState != null) {
                SoundEvent sound;
                if (DEFAULT_AXE_ACTIONS.contains(toolAction)) {
                    if (toolAction == AXE_STRIP) {
                        sound = SoundEvents.AXE_STRIP;
                    } else if (toolAction == AXE_SCRAPE) {
                        sound = SoundEvents.AXE_SCRAPE;
                    } else {
                        sound = SoundEvents.AXE_WAX_OFF;
                    }
                } else if (DEFAULT_SHOVEL_ACTIONS.contains(toolAction)) {
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
