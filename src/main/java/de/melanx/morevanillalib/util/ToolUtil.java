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

    public static ActionResultType toolUse(ItemUseContext context, ToolType toolType) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        BlockPos pos = context.getPos();
        ItemStack stack = context.getItem();
        Direction side = context.getFace();

        if (player != null
                && player.canPlayerEdit(pos, side, stack)
                && ((side != Direction.DOWN && world.isAirBlock(pos.up())) || toolType == ToolType.AXE)) {

            BlockState state = world.getBlockState(pos);
            BlockState modifiedState = state.getToolModifiedState(world, pos, player, stack, toolType);
            if (modifiedState != null) {
                SoundEvent sound;
                if (ToolType.AXE == toolType) {
                    sound = SoundEvents.ITEM_AXE_STRIP;
                } else if (ToolType.SHOVEL == toolType) {
                    sound = SoundEvents.ITEM_SHOVEL_FLATTEN;
                } else {
                    sound = SoundEvents.ITEM_HOE_TILL;
                }

                world.playSound(player, pos, sound, SoundCategory.BLOCKS, 1, 1);
            } else if (state.getBlock() instanceof CampfireBlock && state.get(CampfireBlock.LIT)) {
                if (!world.isRemote) {
                    world.playEvent(player, 1009, pos, 0);
                }
                CampfireBlock.extinguish(world, pos, state);
                modifiedState = state.with(CampfireBlock.LIT, false);
            }

            if (modifiedState != null) {
                if (!world.isRemote) {
                    world.setBlockState(pos, modifiedState, 11);
                    stack.damageItem(1, player, playerEntity -> playerEntity.sendBreakAnimation(context.getHand()));
                }

                return ActionResultType.successOrConsume(world.isRemote);
            }
        }

        return ActionResultType.PASS;
    }
}
