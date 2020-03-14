package de.melanx.morevanillalib.api;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

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
            for (BlockPos pos : brokenBlocks) {
                BlockState state = world.getBlockState(pos);
                if (breakValidator.canBreak(state)) {
                    world.removeBlock(pos, false);

                    if (!playerEntity.isCreative()) {
                        BlockPos offsetPos = new BlockPos(pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5);
                        dropItems(world, Block.getDrops(state, (ServerWorld) world, pos, null, playerEntity, playerEntity.getHeldItemMainhand()), offsetPos);
                        state.spawnAdditionalDrops(world, pos, playerEntity.getHeldItemMainhand());
                    }

                    if (damageTool) {
                        playerEntity.inventory.getCurrentItem().damageItem(1, playerEntity, player -> {
                        });
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
