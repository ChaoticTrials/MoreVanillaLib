package de.melanx.morevanillalib.api.ranged;

import de.melanx.morevanillalib.api.BaseToolItem;
import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.util.ToolUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import java.util.Set;

public class BigBreakItem extends BaseToolItem {
    private final Set<Material> effectiveOnMaterial;

    public BigBreakItem(IConfigurableTier toolMaterial, Set<Material> effectiveOnMaterial, ToolType toolType) {
        super(toolMaterial, new Item.Properties().addToolType(toolType, toolMaterial.getLevel()));
        this.effectiveOnMaterial = effectiveOnMaterial;
    }

    @Override
    public boolean canAttackBlock(@Nonnull BlockState state, @Nonnull World level, @Nonnull BlockPos pos, PlayerEntity player) {
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
    public boolean mineBlock(@Nonnull ItemStack stack, World level, @Nonnull BlockState state, @Nonnull BlockPos pos, @Nonnull LivingEntity entityLiving) {
        if (!level.isClientSide && state.getDestroySpeed(level, pos) != 0.0F) {
            if (this.getToolMaterial() == BigBreakMaterials.PAPER && FeatureConfig.PaperDamage.enabled && level.random.nextDouble() < FeatureConfig.PaperDamage.chance) {
                ToolUtil.paperDamage(entityLiving);
            }
        }

        return super.mineBlock(stack, level, state, pos, entityLiving);
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
        return effectiveOnMaterial.contains(state.getMaterial()) ? this.speed : super.getDestroySpeed(stack, state);
    }

    @Override
    public int getBurnTime(@Nonnull ItemStack stack) {
        if (this.getToolMaterial() == BigBreakMaterials.WOODEN) {
            return 400;
        }

        return 0;
    }
}
