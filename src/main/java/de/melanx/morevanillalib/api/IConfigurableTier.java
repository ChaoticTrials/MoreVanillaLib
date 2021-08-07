package de.melanx.morevanillalib.api;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public interface IConfigurableTier extends IItemTier {
    int getMaxUses();

    float getEfficiency();

    float getAttackDamage();

    default float getAttackSpeed() {
        return 0.0F;
    }

    int getHarvestLevel();

    int getEnchantability();

    @Nonnull
    default Ingredient getRepairMaterial() {
        return Ingredient.EMPTY;
    }

    @Nonnull
    default Ingredient getCraftingIngredient() {
        return Ingredient.EMPTY;
    }

    default String getName() {
        return "";
    }

    default boolean isVanilla() {
        return false;
    }
}
