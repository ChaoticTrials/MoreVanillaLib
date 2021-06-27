package de.melanx.morevanillalib.util;

import com.google.common.collect.Sets;
import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.core.LibDamageSource;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import java.util.Random;
import java.util.Set;

public class ToolUtil {

    // TODO 1.17 replace with tags
    public static final Set<Material> PICKAXE_MATERIALS = Sets.newHashSet(Material.STONE, Material.HEAVY_METAL, Material.METAL);
    public static final Set<Material> AXE_MATERIALS = Sets.newHashSet(Material.WOOD, Material.NETHER_WOOD, Material.PLANT, Material.REPLACEABLE_PLANT, Material.BAMBOO, Material.VEGETABLE);

    public static void moreDamage(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof PlayerEntity) {
            Random rand = event.getEntityLiving().level.random;

            if (FeatureConfig.ExtraDamage.enabled && rand.nextDouble() < FeatureConfig.ExtraDamage.chance) {
                float multiplier = (float) (rand.nextFloat() * FeatureConfig.ExtraDamage.maxMultiplier);
                event.setAmount(event.getAmount() * multiplier);
            }
        }
    }

    public static boolean isPlayerKill(LivingDropsEvent event) {
        return event.isRecentlyHit() && event.getSource().getEntity() != null && event.getSource().getEntity() instanceof PlayerEntity;
    }

    public static void paperDamage(LivingEntity entity) {
        entity.hurt(LibDamageSource.PAPER_CUT, Math.max(FeatureConfig.PaperDamage.minDamage, entity.level.random.nextFloat() * FeatureConfig.PaperDamage.maxDamage));
    }

    public static ActionResultType toolUse(ItemUseContext context, ToolType toolType) {
        World level = context.getLevel();
        PlayerEntity player = context.getPlayer();
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

                level.playSound(player, pos, sound, SoundCategory.BLOCKS, 1, 1);
            } else if (state.getBlock() instanceof CampfireBlock && state.getValue(CampfireBlock.LIT)) {
                if (!level.isClientSide) {
                    level.levelEvent(player, 1009, pos, 0);
                }
                CampfireBlock.dowse(level, pos, state);
                modifiedState = state.setValue(CampfireBlock.LIT, false);
            }

            if (modifiedState != null) {
                if (!level.isClientSide) {
                    level.setBlock(pos, modifiedState, 11);
                    stack.hurtAndBreak(1, player, playerEntity -> playerEntity.broadcastBreakEvent(context.getHand()));
                }

                return ActionResultType.sidedSuccess(level.isClientSide);
            }
        }

        return ActionResultType.PASS;
    }
}
