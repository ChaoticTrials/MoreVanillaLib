package de.melanx.morevanillalib.api;

import de.melanx.morevanillalib.LibConfigHandler;
import de.melanx.morevanillalib.util.ToolUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.play.server.SChangeBlockPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class BlockBreaker {

    private BlockBreaker() {
        // NO-OP
    }

    /**
     * Breaks blocks within the given radius on the axis the playerEntity is facing.
     * If the playerEntity is facing the X axis and the radius is 1, a 3x3 area will be destroyed on the X axis.
     *
     * @param world          world the playerEntity is in
     * @param playerEntity   the playerEntity
     * @param radius         radius to break
     * @param breakValidator check to see if a block can be broken
     */
    public static void breakInRadius(World world, PlayerEntity playerEntity, int radius, IBreakValidator breakValidator, boolean damageTool) {
        if (!world.isRemote) {
            List<BlockPos> brokenBlocks = getBreakBlocks(world, playerEntity, radius);
            ItemStack heldItem = playerEntity.getHeldItemMainhand();
            IItemTier toolMaterial = ((BigBreakItem) heldItem.getItem()).getToolMaterial();
            int silktouch = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, heldItem);
            int fortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, heldItem);
            for (BlockPos pos : brokenBlocks) {
                BlockState state = world.getBlockState(pos);
                if (breakValidator.canBreak(state)) {
                    world.removeBlock(pos, false);
                    if (playerEntity.abilities.isCreativeMode) {
                        if (state.removedByPlayer(world, pos, playerEntity, true, state.getFluidState()))
                            state.getBlock().onPlayerDestroy(world, pos, state);
                    } else {
                        heldItem.getItem().onBlockDestroyed(heldItem, world, state, pos, playerEntity);
                        TileEntity tileEntity = world.getTileEntity(pos);
                        state.getBlock().onPlayerDestroy(world, pos, state);
                        state.getBlock().harvestBlock(world, playerEntity, pos, state, tileEntity, heldItem);
                        state.getBlock().dropXpOnBlockBreak(world, pos, state.getBlock().getExpDrop(state, world, pos, fortune, silktouch));
                        spawnExtraDrops(toolMaterial, world, state.getBlock(), pos, heldItem);
                    }
                    if (damageTool) {
                        heldItem.damageItem(1, playerEntity, player -> {
                        });
                    }
                    world.playEvent(2001, pos, Block.getStateId(state));
                    ((ServerPlayerEntity) playerEntity).connection.sendPacket(new SChangeBlockPacket(world, pos));
                }
            }
        }
    }

    private static void spawnExtraDrops(IItemTier toolMaterial, World world, Block block, BlockPos pos, ItemStack heldItem) {
        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, heldItem) >= 1) return;

        ToolUtil.extraDrop(world, pos, toolMaterial);
        if (LibConfigHandler.doubleDrop.get()) {
            switch ((BigBreakMaterials) toolMaterial) {
                case DIAMOND:
                    if (block == Blocks.DIAMOND_ORE) {
                        ItemStack drop = new ItemStack(Items.DIAMOND);
                        int chance = LibConfigHandler.diamondDoubleDropChance.get();
                        if (world.rand.nextInt(1000) < chance && LibConfigHandler.diamondDoubleDrop.get()) {
                            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
                        }
                    }
                case COAL:
                    if (block == Blocks.COAL_ORE) {
                        ItemStack drop = new ItemStack(Items.COAL);
                        int chance = LibConfigHandler.coalDoubleDropChance.get();
                        if (world.rand.nextInt(1000) < chance && LibConfigHandler.coalDoubleDrop.get())
                            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
                    }
                case EMERALD:
                    if (block == Blocks.EMERALD_ORE) {
                        ItemStack drop = new ItemStack(Items.EMERALD);
                        int chance = LibConfigHandler.emeraldDoubleDropChance.get();
                        if (world.rand.nextInt(1000) < chance && LibConfigHandler.emeraldDoubleDrop.get())
                            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
                    }
                case LAPIS:
                    if (block == Blocks.LAPIS_ORE) {
                        ItemStack drop = new ItemStack(Items.LAPIS_LAZULI);
                        int chance = LibConfigHandler.lapisDoubleDropChance.get();
                        if (world.rand.nextInt(1000) < chance && LibConfigHandler.lapisDoubleDrop.get()) {
                            int i = world.rand.nextInt(3);
                            drop.setCount(i + 1);
                            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
                        }
                    }
                case QUARTZ:
                    if (block == Blocks.NETHER_QUARTZ_ORE) {
                        ItemStack drop = new ItemStack(Items.QUARTZ);
                        int chance = LibConfigHandler.quartzDoubleDropChance.get();
                        if (world.rand.nextInt(1000) < chance && LibConfigHandler.quartzDoubleDrop.get())
                            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
                    }
                case REDSTONE:
                    if (block == Blocks.REDSTONE_ORE) {
                        ItemStack drop = new ItemStack(Items.REDSTONE);
                        int chance = LibConfigHandler.redstoneDoubleDropChance.get();
                        if (world.rand.nextInt(1000) < chance && LibConfigHandler.redstoneDoubleDrop.get()) {
                            int i = world.rand.nextInt(3);
                            drop.setCount(i + 1);
                            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
                        }
                    }
            }
        }
    }

    private static void dropItems(World world, List<ItemStack> stacks, BlockPos pos) {
        for (ItemStack stack : stacks) {
            ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.addEntity(itemEntity);
        }
    }

    /**
     * Returns a list of the blocks that would be broken in breakInRadius, but doesn't break them.
     *
     * @param world  world of player
     * @param player player breaking
     * @param radius radius to break in
     * @return a list of blocks that would be broken with the given radius and tool
     */
    public static List<BlockPos> getBreakBlocks(World world, PlayerEntity player, int radius) {
        ArrayList<BlockPos> potentialBrokenBlocks = new ArrayList<>();

        Vec3d eyePosition = player.getEyePosition(1);
        Vec3d rotation = player.getLook(1);
        Vec3d combined = eyePosition.add(rotation.x * 5, rotation.y * 5, rotation.z * 5);

        BlockRayTraceResult rayTraceResult = world.rayTraceBlocks(new RayTraceContext(eyePosition, combined, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, player));

        if (rayTraceResult.getType() == RayTraceResult.Type.BLOCK) {
            Direction.Axis axis = rayTraceResult.getFace().getAxis();
            ArrayList<BlockPos> positions = new ArrayList<>();

            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        positions.add(new BlockPos(x, y, z));
                    }
                }
            }

            BlockPos origin = rayTraceResult.getPos();

            for (BlockPos pos : positions) {
                if (axis == Direction.Axis.Y) {
                    if (pos.getY() == 0) {
                        potentialBrokenBlocks.add(origin.add(pos));
                    }
                } else if (axis == Direction.Axis.X) {
                    if (pos.getX() == 0) {
                        potentialBrokenBlocks.add(origin.add(pos));
                    }
                } else if (axis == Direction.Axis.Z) {
                    if (pos.getZ() == 0) {
                        potentialBrokenBlocks.add(origin.add(pos));
                    }
                }
            }
        }

        return potentialBrokenBlocks;
    }

}
