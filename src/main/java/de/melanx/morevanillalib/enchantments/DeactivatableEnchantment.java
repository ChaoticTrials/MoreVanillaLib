package de.melanx.morevanillalib.enchantments;

import de.melanx.morevanillalib.config.FeatureConfig;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import javax.annotation.Nonnull;

public class DeactivatableEnchantment extends Enchantment {

    protected DeactivatableEnchantment(Rarity rarityIn, EnchantmentCategory typeIn, EquipmentSlot[] slots) {
        super(rarityIn, typeIn, slots);
    }

    @Override
    protected boolean checkCompatibility(@Nonnull Enchantment other) {
        return FeatureConfig.enchantments && super.checkCompatibility(other);
    }

    @Override
    public boolean isTradeable() {
        return FeatureConfig.enchantments;
    }

    @Override
    public boolean isDiscoverable() {
        return FeatureConfig.enchantments;
    }

    @Override
    public boolean canApplyAtEnchantingTable(@Nonnull ItemStack stack) {
        return FeatureConfig.enchantments && super.canApplyAtEnchantingTable(stack);
    }

    @Override
    public boolean isAllowedOnBooks() {
        return FeatureConfig.enchantments;
    }
}
