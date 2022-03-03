package de.melanx.morevanillalib.api;

import io.github.noeppi_noeppi.libx.util.LazyValue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.TierSortingRegistry;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.function.Supplier;

public class ItemTier implements IConfigurableTier {

    private ItemTier(int durability, float efficiency, float attackDamage, float attackSpeed, int harvestLevel, int enchantmentValue, LazyValue<Ingredient> repairMaterial, LazyValue<Ingredient> craftingIngredient, String name, boolean vanilla, boolean big) {
        this.durability = big ? durability * 7 : durability;
        this.efficiency = big ? efficiency / 3.5F : efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.harvestLevel = harvestLevel;
        this.enchantmentValue = enchantmentValue;
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
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairMaterial;
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
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    @Override
    public int getLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Nonnull
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
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
        private float attackDamage;
        private float attackSpeed;
        private int harvestLevel;
        private int enchantmentValue;
        private Supplier<Ingredient> repairIngredient = () -> Ingredient.EMPTY;
        private Supplier<Ingredient> craftingIngredient = () -> Ingredient.EMPTY;
        private String name = "";
        private boolean vanilla;
        private boolean big;

        public Builder durability(int durability) {
            this.durability = durability;
            return this;
        }

        public Builder speed(float speed) {
            this.speed = speed;
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
            builder.attackDamage = this.attackDamage;
            builder.attackSpeed = this.attackSpeed;
            builder.harvestLevel = this.harvestLevel;
            builder.enchantmentValue = this.enchantmentValue;
            builder.repairIngredient = this.repairIngredient;
            builder.craftingIngredient = this.craftingIngredient;
            builder.name = this.name;
            builder.vanilla = this.vanilla;
            builder.big = this.big;
            return builder;
        }

        public ItemTier build() {
            ItemTier tier = new ItemTier(this.durability, this.speed, this.attackDamage, this.attackSpeed, this.harvestLevel, this.enchantmentValue, new LazyValue<>(this.repairIngredient), new LazyValue<>(this.craftingIngredient), this.name, this.vanilla, this.big);
            if (!this.vanilla) {
                String name = this.name + (this.big ? "big" : "");
                TierSortingRegistry.registerTier(tier, new ResourceLocation("morevanillalib", name), List.of(), List.of());
            }
            return tier;
        }
    }
}
