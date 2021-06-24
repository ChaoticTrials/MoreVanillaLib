package de.melanx.morevanillalib.api;

import com.google.common.collect.ImmutableSet;
import de.melanx.morevanillalib.api.ranged.BigBreakMaterials;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BaseToolItem extends ToolItem {

    private final IConfigurableTier toolMaterial;

    public BaseToolItem(IConfigurableTier tier, Properties properties) {
        super(0, tier.getAttackSpeed(), tier, ImmutableSet.of(), properties);
        this.toolMaterial = tier;
    }

    @Override
    public int getBurnTime(ItemStack stack) {
        if (this.toolMaterial == BigBreakMaterials.WOODEN) {
            return 400;
        }

        return 0;
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
    public void addInformation(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {

        super.addInformation(stack, world, tooltip, flag);
    }
}
