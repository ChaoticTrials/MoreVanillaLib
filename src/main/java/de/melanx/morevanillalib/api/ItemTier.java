package de.melanx.morevanillalib.api;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class ItemTier implements IConfigurableTier {

    private ItemTier(int durability, float speed, float attackDamageBonus, float attackSpeed, int level, int enchantmentValue, LazyValue<Ingredient> repairIngredient, LazyValue<Ingredient> craftingIngredient, String name, boolean vanilla, boolean aiot, boolean big) {
        this.durability = aiot ? durability * 5 : big ? durability * 7 : durability;
        this.speed = big ? speed / 3.5F : speed;
        this.attackDamageBonus = attackDamageBonus;
        this.attackSpeed = big ? attackSpeed : attackSpeed * 1.2F;
        this.level = level;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
        this.craftingIngredient = craftingIngredient;
        this.name = name;
        this.vanilla = vanilla;
    }

    private final int durability;
    private final float speed;
    private final float attackDamageBonus;
    private final float attackSpeed;
    private final int level;
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;
    private final LazyValue<Ingredient> craftingIngredient;
    private final String name;
    private final boolean vanilla;

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public int getUses() {
        return this.durability;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamageBonus;
    }

    @Override
    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Nonnull
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Nonnull
    @Override
    public Ingredient getCraftingIngredient() {
        return this.craftingIngredient.get();
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
        private float speed;
        private float attackDamageBonus;
        private float attackSpeed;
        private int harvestLevel;
        private int enchantmentValue;
        private Supplier<Ingredient> repairIngredient = () -> Ingredient.EMPTY;
        private Supplier<Ingredient> craftingIngredient = () -> Ingredient.EMPTY;
        private String name = "";
        private boolean vanilla;
        private boolean aiot;
        private boolean big;

        public Builder durability(int durability) {
            this.durability = durability;
            return this;
        }

        public Builder speed(float speed) {
            this.speed = speed;
            return this;
        }

        public Builder attackDamageBonus(float attackDamageBonus) {
            this.attackDamageBonus = attackDamageBonus;
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

        public Builder enchantmentValue(int enchantmentValue) {
            this.enchantmentValue = enchantmentValue;
            return this;
        }

        public Builder repairIngredient(Supplier<Ingredient> ingredient) {
            this.repairIngredient = ingredient;
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
            builder.speed = this.speed;
            builder.attackDamageBonus = this.attackDamageBonus;
            builder.attackSpeed = this.attackSpeed;
            builder.harvestLevel = this.harvestLevel;
            builder.enchantmentValue = this.enchantmentValue;
            builder.repairIngredient = this.repairIngredient;
            builder.craftingIngredient = this.craftingIngredient;
            builder.name = this.name;
            builder.vanilla = this.vanilla;
            builder.aiot = this.aiot;
            builder.big = this.big;
            return builder;
        }

        public ItemTier build() {
            return new ItemTier(this.durability, this.speed, this.attackDamageBonus, this.attackSpeed, this.harvestLevel, this.enchantmentValue, new LazyValue<>(this.repairIngredient), new LazyValue<>(this.craftingIngredient), this.name, this.vanilla, this.aiot, this.big);
        }
    }
}
