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
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import java.util.Set;

public class BigBreakItem extends BaseToolItem {
    private final Set<Material> effectiveOnMaterial;

    public BigBreakItem(IConfigurableTier toolMaterial, Set<Material> effectiveOnMaterial, ToolType toolType) {
        super(toolMaterial, new Item.Properties().group(ItemGroup.TOOLS).addToolType(toolType, toolMaterial.getHarvestLevel()));
        this.effectiveOnMaterial = effectiveOnMaterial;
    }

    @Override
    public boolean canPlayerBreakBlockWhileHolding(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos, PlayerEntity player) {
        int radius = 1;
        if (player.isCrouching()) {
            radius = 0;
        }

        float originHardness = world.getBlockState(pos).getBlockHardness(world, pos);

        // only do a 3x3 break if the player's tool is effective on the block they are breaking
        // this makes it so breaking gravel doesn't break nearby stone
        if (player.getHeldItemMainhand().canHarvestBlock(world.getBlockState(pos))) {
            BlockBreaker.breakInRadius(world, player, radius, pos, (breakState) -> {
                double hardness = breakState.getBlockHardness(world, pos);
                boolean isEffective = player.getHeldItemMainhand().canHarvestBlock(breakState);
                boolean verifyHardness = hardness < originHardness * 5 && hardness > 0;
                return isEffective && verifyHardness;
            });
        }

        return true;
    }

    @Override
    public boolean onBlockDestroyed(@Nonnull ItemStack stack, World world, @Nonnull BlockState state, @Nonnull BlockPos pos, @Nonnull LivingEntity entityLiving) {
        if (!world.isRemote && state.getBlockHardness(world, pos) != 0.0F) {
            if (this.getToolMaterial() == BigBreakMaterials.PAPER && FeatureConfig.PaperDamage.enabled && world.rand.nextDouble() < FeatureConfig.PaperDamage.chance) {
                ToolUtil.paperDamage(entityLiving);
            }
        }

        return super.onBlockDestroyed(stack, world, state, pos, entityLiving);
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
        return effectiveOnMaterial.contains(state.getMaterial()) ? this.efficiency : super.getDestroySpeed(stack, state);
    }

    @Override
    public int getBurnTime(@Nonnull ItemStack stack) {
        if (this.getToolMaterial() == BigBreakMaterials.WOODEN) {
            return 400;
        }

        return 0;
    }
}
