package de.melanx.morevanillalib.api;

import de.melanx.morevanillalib.config.FeatureConfig;
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
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SChangeBlockPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;

import java.util.ArrayList;
import java.util.List;

public class BlockBreaker {

    private BlockBreaker() {
        // NO-OP
    }

    /**
     * Breaks blocks within the given radius on the axis the player is facing.
     * If the player is facing the X axis and the radius is 1, a 3x3 area will be destroyed on the X axis.
     *
     * @param world          world the player is in
     * @param player         the player
     * @param radius         radius to break
     * @param breakValidator check to see if a block can be broken
     */
    public static void breakInRadius(World world, PlayerEntity player, int radius, BlockPos originPos, IBreakValidator breakValidator) {
        if (!world.isRemote) {
            List<BlockPos> brokenBlocks = getBreakBlocks(world, player, radius, originPos);
            ItemStack heldItem = player.getHeldItemMainhand();
            IItemTier toolMaterial = ((BigBreakItem) heldItem.getItem()).getToolMaterial();
            for (BlockPos pos : brokenBlocks) {
                BlockState state = world.getBlockState(pos);
                if (breakValidator.canBreak(state)) {
                    ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                    if (player.abilities.isCreativeMode) {
                        if (state.removedByPlayer(world, pos, player, true, state.getFluidState()))
                            state.getBlock().onPlayerDestroy(world, pos, state);
                    } else {
                        BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(world, pos, state, player);
                        MinecraftForge.EVENT_BUS.post(event);

                        if (event.isCanceled()) {
                            // Forge copy
                            serverPlayer.connection.sendPacket(new SChangeBlockPacket(world, pos));
                            TileEntity tile = world.getTileEntity(pos);
                            if (tile != null) {
                                IPacket<?> packet = tile.getUpdatePacket();
                                if (packet != null) {
                                    serverPlayer.connection.sendPacket(packet);
                                }
                            }
                        } else {
                            heldItem.getItem().onBlockDestroyed(heldItem, world, state, pos, player);
                            TileEntity tileEntity = world.getTileEntity(pos);
                            state.getBlock().onPlayerDestroy(world, pos, state);
                            state.getBlock().harvestBlock(world, player, pos, state, tileEntity, heldItem);
                            state.getBlock().dropXpOnBlockBreak((ServerWorld) world, pos, event.getExpToDrop());
                            spawnExtraDrops(toolMaterial, world, state.getBlock(), pos, heldItem);

                            world.removeBlock(pos, false);
                            world.playEvent(2001, pos, Block.getStateId(state));
                            serverPlayer.connection.sendPacket(new SChangeBlockPacket(world, pos));
                        }
                    }
                }
            }
        }
    }

    private static void spawnExtraDrops(IItemTier toolMaterial, World world, Block block, BlockPos pos, ItemStack heldItem) {
        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, heldItem) >= 1) return;

        ToolUtil.extraDrop(world, pos, toolMaterial);
        if (FeatureConfig.DoubleDrop.enabledAll) {
            switch ((BigBreakMaterials) toolMaterial) {
                // TODO check ore tag, not just block
                // TODO use loot modifier
                case DIAMOND:
                    if (block == Blocks.DIAMOND_ORE) {
                        ItemStack drop = new ItemStack(Items.DIAMOND);
                        if (FeatureConfig.DoubleDrop.Diamond.enabled && world.rand.nextDouble() < FeatureConfig.DoubleDrop.Diamond.chance) {
                            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
                        }
                    }
                case COAL:
                    if (block == Blocks.COAL_ORE) {
                        ItemStack drop = new ItemStack(Items.COAL);
                        if (FeatureConfig.DoubleDrop.Coal.enabled && world.rand.nextDouble() < FeatureConfig.DoubleDrop.Coal.chance)
                            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
                    }
                case EMERALD:
                    if (block == Blocks.EMERALD_ORE) {
                        ItemStack drop = new ItemStack(Items.EMERALD);
                        if (FeatureConfig.DoubleDrop.Emerald.enabled && world.rand.nextDouble() < FeatureConfig.DoubleDrop.Emerald.chance)
                            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
                    }
                case LAPIS:
                    if (block == Blocks.LAPIS_ORE) {
                        ItemStack drop = new ItemStack(Items.LAPIS_LAZULI);
                        if (FeatureConfig.DoubleDrop.Lapis.enabled && world.rand.nextDouble() < FeatureConfig.DoubleDrop.Lapis.chance) {
                            int i = world.rand.nextInt(3);
                            drop.setCount(i + 1);
                            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
                        }
                    }
                case QUARTZ:
                    if (block == Blocks.NETHER_QUARTZ_ORE) {
                        ItemStack drop = new ItemStack(Items.QUARTZ);
                        if (FeatureConfig.DoubleDrop.Quartz.enabled && world.rand.nextDouble() < FeatureConfig.DoubleDrop.Quartz.chance)
                            world.addEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
                    }
                case REDSTONE:
                    if (block == Blocks.REDSTONE_ORE) {
                        ItemStack drop = new ItemStack(Items.REDSTONE);
                        if (FeatureConfig.DoubleDrop.Redstone.enabled && world.rand.nextDouble() < FeatureConfig.DoubleDrop.Redstone.chance) {
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
    public static List<BlockPos> getBreakBlocks(World world, PlayerEntity player, int radius, BlockPos originPosition) {
        ArrayList<BlockPos> potentialBrokenBlocks = new ArrayList<>();

        Vector3d eyePosition = player.getEyePosition(1);
        Vector3d rotation = player.getLook(1);
        Vector3d combined = eyePosition.add(rotation.x * 5, rotation.y * 5, rotation.z * 5);

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

            for (BlockPos pos : positions) {
                if (axis == Direction.Axis.Y) {
                    if (pos.getY() == 0) {
                        potentialBrokenBlocks.add(originPosition.add(pos));
                    }
                } else if (axis == Direction.Axis.X) {
                    if (pos.getX() == 0) {
                        potentialBrokenBlocks.add(originPosition.add(pos));
                    }
                } else if (axis == Direction.Axis.Z) {
                    if (pos.getZ() == 0) {
                        potentialBrokenBlocks.add(originPosition.add(pos));
                    }
                }
            }
            potentialBrokenBlocks.remove(originPosition);
        }

        return potentialBrokenBlocks;
    }

}
