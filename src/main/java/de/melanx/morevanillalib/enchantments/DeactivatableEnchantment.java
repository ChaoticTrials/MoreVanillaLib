package de.melanx.morevanillalib.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import javax.annotation.Nonnull;

public class DeactivatableEnchantment extends Enchantment {

    private final boolean condition;

    protected DeactivatableEnchantment(Rarity rarityIn, EnchantmentCategory typeIn, EquipmentSlot[] slots, boolean condition) {
        super(rarityIn, typeIn, slots);
        this.condition = condition;
    }

    @Override
    protected boolean checkCompatibility(@Nonnull Enchantment other) {
        return this.condition && super.checkCompatibility(other);
    }

    @Override
    public boolean isTradeable() {
        return this.condition;
    }

    @Override
    public boolean isDiscoverable() {
        return this.condition;
    }

    @Override
    public boolean canApplyAtEnchantingTable(@Nonnull ItemStack stack) {
        return this.condition && super.canApplyAtEnchantingTable(stack);
    }

    @Override
    public boolean isAllowedOnBooks() {
        return this.condition;
    }
}
