package de.melanx.morevanillalib.api.ranged;

import de.melanx.morevanillalib.api.BaseToolItem;
import de.melanx.morevanillalib.api.IConfigurableTier;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class RangeItem extends BaseToolItem {

    public RangeItem(IConfigurableTier toolMaterial, Tag<Block> mineable, Item.Properties properties) {
        super(toolMaterial, mineable, properties);
    }

    @Override
    public boolean canAttackBlock(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, Player player) {
        int radius = 1;
        if (player.isCrouching()) {
            radius = 0;
        }

        float originHardness = level.getBlockState(pos).getDestroySpeed(level, pos);

        // only do a 3x3 break if the player's tool is effective on the block they are breaking
        // this makes it so breaking gravel doesn't break nearby stone
        if (player.getMainHandItem().isCorrectToolForDrops(level.getBlockState(pos))) {
            BlockBreaker.breakInRadius(level, player, radius, pos, (breakState) -> {
                double hardness = breakState.getDestroySpeed(level, pos);
                boolean isEffective = player.getMainHandItem().isCorrectToolForDrops(breakState);
                boolean verifyHardness = hardness < originHardness * 5 && hardness > 0;
                return isEffective && verifyHardness;
            });
        }

        return true;
    }

    @Override
    public int getBurnTime(@Nonnull ItemStack stack, @Nullable RecipeType<?> recipeType) {
        if (this.getToolMaterial() == RangeMaterials.WOODEN) {
            return 400;
        }

        return 0;
    }
}
