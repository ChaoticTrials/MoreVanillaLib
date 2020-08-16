package de.melanx.morevanillalib.api;

import de.melanx.morevanillalib.LibConfigHandler;
import de.melanx.morevanillalib.core.LibDamageSource;
import de.melanx.morevanillalib.util.ToolUtil;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BigBreakItem extends PickaxeItem {
    private final IItemTier toolMaterial;

    public BigBreakItem(IItemTier toolMaterial, float attackSpeed) {
        super(toolMaterial, 0, attackSpeed, new Item.Properties().group(ItemGroup.TOOLS));
        this.toolMaterial = toolMaterial;
    }

    @Override
    public boolean canPlayerBreakBlockWhileHolding(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        int radius = 1;
        if (player.isCrouching()) {
            radius = 0;
        }

        float originHardness = world.getBlockState(pos).getBlockHardness(null, null);

        // only do a 3x3 break if the player's tool is effective on the block they are breaking
        // this makes it so breaking gravel doesn't break nearby stone
        if (player.getHeldItemMainhand().canHarvestBlock(world.getBlockState(pos))) {
            BlockBreaker.breakInRadius(world, player, radius, (breakState) -> {
                double hardness = breakState.getBlockHardness(null, null);
                boolean isEffective = player.getHeldItemMainhand().canHarvestBlock(breakState);
                boolean verifyHardness = hardness < originHardness * 5 && hardness > 0;
                return isEffective && verifyHardness;
            });
        }

        return true;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ToolUtil.extraDrop(attacker.getEntityWorld(), target.getPosition(), this.getToolMaterial());
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        if (!world.isRemote && state.getBlockHardness(world, pos) != 0.0F) {
            int chance = LibConfigHandler.damageByPaperToolsChance.get();
            if (this.getToolMaterial() == BigBreakMaterials.PAPER && LibConfigHandler.damageByPaperTools.get() && new Random().nextInt(1000) < chance)
                entityLiving.attackEntityFrom(LibDamageSource.PAPER_CUT, new Random().nextInt(LibConfigHandler.maxPaperDamage.get()) + LibConfigHandler.minPaperDamage.get());
        }
        if (!this.canHarvestBlock(state)) {
            ToolUtil.extraDrop(world, pos, this.getToolMaterial());
        }
        return super.onBlockDestroyed(stack, world, state, pos, entityLiving);
    }

    @Override
    public void onCreated(ItemStack stack, World world, PlayerEntity player) {
        if (this.getToolMaterial() == BigBreakMaterials.SLIME)
            stack.addEnchantment(Enchantments.KNOCKBACK, 3);
    }

    @Override
    public int getBurnTime(ItemStack stack) {
        if (getToolMaterial() == BigBreakMaterials.WOOD)
            return 400;
        return 0;
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.TOOLS || group == ItemGroup.SEARCH) {
            ItemStack item = new ItemStack(this);
            if (this.getToolMaterial() == BigBreakMaterials.SLIME) {
                item.addEnchantment(Enchantments.KNOCKBACK, 3);
            }
            items.add(item);
        }
    }

    public IItemTier getToolMaterial() {
        return toolMaterial;
    }

}
