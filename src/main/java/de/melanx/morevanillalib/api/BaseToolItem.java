package de.melanx.morevanillalib.api;

import com.google.common.collect.ImmutableSet;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;

public class BaseToolItem extends ToolItem {

    private final IConfigurableTier toolMaterial;

    public BaseToolItem(IConfigurableTier tier, Properties properties) {
        super(0, tier.getAttackSpeed(), tier, ImmutableSet.of(), properties);
        this.toolMaterial = tier;
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        if (this.toolMaterial == BigBreakMaterials.WOOD) {
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
}
