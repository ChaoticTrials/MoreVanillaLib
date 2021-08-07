package de.melanx.morevanillalib.api;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class ItemTier implements IConfigurableTier {

    private ItemTier(int durability, float efficiency, float attackDamage, float attackSpeed, int harvestLevel, int enchantability, LazyValue<Ingredient> repairMaterial, LazyValue<Ingredient> craftingIngredient, String name, boolean vanilla, boolean aiot, boolean big) {
        this.durability = aiot ? durability * 5 : big ? durability * 7 : durability;
        this.efficiency = big ? efficiency / 3.5F : efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = big ? attackSpeed : attackSpeed * 1.2F;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
        this.craftingIngredient = craftingIngredient;
        this.name = name;
        this.vanilla = vanilla;
    }

    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final float attackSpeed;
    private final int harvestLevel;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;
    private final LazyValue<Ingredient> craftingIngredient;
    private final String name;
    private final boolean vanilla;

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public int getMaxUses() {
        return this.durability;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Nonnull
    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @Nonnull
    @Override
    public Ingredient getCraftingIngredient() {
        return this.craftingIngredient.getValue();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isVanilla() {
        return this.vanilla;
    }

    public static class Builder {
        private int durability = 1;
        private float efficiency;
        private float attackDamage;
        private float attackSpeed;
        private int harvestLevel;
        private int enchantability;
        private Supplier<Ingredient> repairMaterial = () -> Ingredient.EMPTY;
        private Supplier<Ingredient> craftingIngredient = () -> Ingredient.EMPTY;
        private String name = "";
        private boolean vanilla;
        private boolean aiot;
        private boolean big;

        public Builder durability(int durability) {
            this.durability = durability;
            return this;
        }

        public Builder efficiency(float efficiency) {
            this.efficiency = efficiency;
            return this;
        }

        public Builder attackDamage(float attackDamage) {
            this.attackDamage = attackDamage;
            return this;
        }

        public Builder attackSpeed(float attackSpeed) {
            this.attackSpeed = attackSpeed;
            return this;
        }

        public Builder harvestLevel(int level) {
            this.harvestLevel = level;
            return this;
        }

        public Builder enchantability(int enchantability) {
            this.enchantability = enchantability;
            return this;
        }

        public Builder repairMaterial(Supplier<Ingredient> material) {
            this.repairMaterial = material;
            return this;
        }

        public Builder craftingIngredient(Supplier<Ingredient> ingredient) {
            this.craftingIngredient = ingredient;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder aiot() {
            this.aiot = true;
            return this;
        }

        public Builder big() {
            this.big = true;
            return this;
        }

        public Builder vanilla() {
            this.vanilla = true;
            return this;
        }

        public Builder copy() {
            Builder builder = new Builder();
            builder.durability = this.durability;
            builder.efficiency = this.efficiency;
            builder.attackDamage = this.attackDamage;
            builder.attackSpeed = this.attackSpeed;
            builder.harvestLevel = this.harvestLevel;
            builder.enchantability = this.enchantability;
            builder.repairMaterial = this.repairMaterial;
            builder.craftingIngredient = this.craftingIngredient;
            builder.name = this.name;
            builder.vanilla = this.vanilla;
            builder.aiot = this.aiot;
            builder.big = this.big;
            return builder;
        }

        public ItemTier build() {
            return new ItemTier(this.durability, this.efficiency, this.attackDamage, this.attackSpeed, this.harvestLevel, this.enchantability, new LazyValue<>(this.repairMaterial), new LazyValue<>(this.craftingIngredient), this.name, this.vanilla, this.aiot, this.big);
        }
    }
}
