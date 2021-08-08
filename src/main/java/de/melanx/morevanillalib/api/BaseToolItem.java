package de.melanx.morevanillalib.api;

import de.melanx.morevanillalib.api.normal.ToolMaterials;
import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.data.ModTags;
import de.melanx.morevanillalib.util.ComponentUtil;
import de.melanx.morevanillalib.util.ToolUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.Tag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BaseToolItem extends DiggerItem {

    protected final IConfigurableTier toolMaterial;

    public BaseToolItem(IConfigurableTier tier, Tag<Block> blocks, Properties properties) {
        super(0, tier.getAttackSpeed(), tier, blocks, properties);
        this.toolMaterial = tier;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult result = super.useOn(context);

        if (!context.getLevel().isClientSide && ModTags.Items.PAPER_TOOLS.contains(this) && FeatureConfig.PaperDamage.enabled
                && context.getLevel().random.nextDouble() < FeatureConfig.PaperDamage.chance) {
            ToolUtil.paperDamage(context.getPlayer());
        }

        return result;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.hurtEnemy(stack, target, attacker);

        if (!target.level.isClientSide && ModTags.Items.PAPER_TOOLS.contains(this) && FeatureConfig.PaperDamage.enabled
                && target.level.random.nextDouble() < FeatureConfig.PaperDamage.chance) {
            ToolUtil.paperDamage(attacker);
        }

        return result;
    }

    @Override
    public boolean mineBlock(@Nonnull ItemStack stack, @Nonnull Level level, @Nonnull BlockState state, @Nonnull BlockPos pos, @Nonnull LivingEntity entityLiving) {
        boolean result = super.mineBlock(stack, level, state, pos, entityLiving);

        if (!level.isClientSide && state.getDestroySpeed(level, pos) != 0.0F && ModTags.Items.PAPER_TOOLS.contains(this)
                && FeatureConfig.PaperDamage.enabled && level.random.nextDouble() < FeatureConfig.PaperDamage.chance) {
            ToolUtil.paperDamage(entityLiving);
        }

        return result;
    }

    @Override
    public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
        if (FeatureConfig.vanillaOnly) {
            if (this.toolMaterial.isVanilla() || this.toolMaterial instanceof ToolMaterials) {
                super.fillItemCategory(group, items);
            }
        } else {
            super.fillItemCategory(group, items);
        }
    }

    public IConfigurableTier getToolMaterial() {
        return this.toolMaterial;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment == Enchantments.KNOCKBACK && ModTags.Items.SLIME_TOOLS.contains(stack.getItem())) {
            return false;
        }

        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if (!this.toolMaterial.isVanilla() && FeatureConfig.vanillaOnly && !(this.toolMaterial instanceof ToolMaterials)) {
            tooltip.add(ComponentUtil.getTooltip("disabled_item").withStyle(ChatFormatting.DARK_RED));
        } else {
            if (Screen.hasShiftDown()) {
                tooltip.add(ComponentUtil.getTooltip("durability", this.toolMaterial.getUses()).withStyle(ChatFormatting.GRAY));
                tooltip.add(ComponentUtil.getTooltip("harvest_level", this.toolMaterial.getLevel()).withStyle(ChatFormatting.GRAY));
                tooltip.add(ComponentUtil.getTooltip("repairing_item", this.toolMaterial.getRepairIngredient().getItems()[0].getItem().getDescription().getString()).withStyle(ChatFormatting.GRAY));
            } else {
                tooltip.add(ComponentUtil.getTooltip("more_information").withStyle(ChatFormatting.ITALIC, ChatFormatting.GRAY));
            }
        }

        super.appendHoverText(stack, level, tooltip, flag);
    }
}
