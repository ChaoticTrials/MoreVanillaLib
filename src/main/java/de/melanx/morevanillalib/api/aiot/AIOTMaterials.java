package de.melanx.morevanillalib.api.aiot;

import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.config.ToolValueConfig;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyValue;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public enum AIOTMaterials implements IConfigurableTier {

    WOODEN(ItemTier.WOOD, -2.5F, () -> Ingredient.of(ItemTags.PLANKS), true),
    STONE(ItemTier.STONE, -2.6F, () -> Ingredient.of(Tags.Items.COBBLESTONE), true),
    IRON(ItemTier.IRON, -2.8F, () -> Ingredient.of(Tags.Items.INGOTS_IRON), true),
    GOLDEN(ItemTier.GOLD, -2.5F, () -> Ingredient.of(Tags.Items.INGOTS_GOLD), true),
    DIAMOND(ItemTier.DIAMOND, -3.0F, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND), true),
    NETHERITE(ItemTier.NETHERITE, -3.5F, () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE), true),

    BONE(ToolValueConfig.AIOTs.bone, () -> Ingredient.of(Tags.Items.BONES)),
    COAL(ToolValueConfig.AIOTs.coal, () -> Ingredient.of(Items.COAL)),
    EMERALD(ToolValueConfig.AIOTs.emerald, () -> Ingredient.of(Tags.Items.GEMS_EMERALD)),
    ENDER(ToolValueConfig.AIOTs.ender, () -> Ingredient.of(Tags.Items.ENDER_PEARLS)),
    FIERY(ToolValueConfig.AIOTs.fiery, () -> Ingredient.of(Items.MAGMA_BLOCK)),
    GLOWSTONE(ToolValueConfig.AIOTs.glowstone, () -> Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)),
    LAPIS(ToolValueConfig.AIOTs.lapis, () -> Ingredient.of(Tags.Items.GEMS_LAPIS)),
    NETHER(ToolValueConfig.AIOTs.nether, () -> Ingredient.of(Items.NETHER_BRICKS)),
    OBSIDIAN(ToolValueConfig.AIOTs.obsidian, () -> Ingredient.of(Tags.Items.OBSIDIAN)),
    PAPER(ToolValueConfig.AIOTs.paper, () -> Ingredient.of(Items.PAPER)),
    PRISMARINE(ToolValueConfig.AIOTs.prismarine, () -> Ingredient.of(Tags.Items.DUSTS_PRISMARINE)),
    QUARTZ(ToolValueConfig.AIOTs.quartz, () -> Ingredient.of(Tags.Items.GEMS_QUARTZ)),
    REDSTONE(ToolValueConfig.AIOTs.redstone, () -> Ingredient.of(Tags.Items.DUSTS_REDSTONE)),
    SLIME(ToolValueConfig.AIOTs.slime, () -> Ingredient.of(Tags.Items.SLIMEBALLS));

    private final int harvestLevel;
    private final int durability;
    private final float speed;
    private final float attackDamageBonus;
    private final float attackSpeed;
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;
    private final boolean vanilla;
    private final boolean morevanillatools;

    AIOTMaterials(IItemTier delegate, float attackSpeed, Supplier<Ingredient> repairIngredient, boolean vanilla) {
        this.harvestLevel = delegate.getLevel();
        this.durability = delegate.getUses();
        this.speed = delegate.getSpeed();
        this.attackDamageBonus = delegate.getAttackDamageBonus();
        this.attackSpeed = attackSpeed;
        this.enchantmentValue = delegate.getEnchantmentValue();
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.vanilla = vanilla;
        this.morevanillatools = !vanilla;
    }

    AIOTMaterials(IItemTier delegate, float attackSpeed, Supplier<Ingredient> repairIngredient) {
        this.harvestLevel = delegate.getLevel();
        this.durability = delegate.getUses();
        this.speed = delegate.getSpeed();
        this.attackDamageBonus = delegate.getAttackDamageBonus();
        this.attackSpeed = attackSpeed;
        this.enchantmentValue = delegate.getEnchantmentValue();
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.vanilla = false;
        this.morevanillatools = true;
    }

    AIOTMaterials(IConfigurableTier delegate, Supplier<Ingredient> repairIngredient, boolean vanilla) {
        this.harvestLevel = delegate.getLevel();
        this.durability = delegate.getUses();
        this.speed = delegate.getSpeed();
        this.attackDamageBonus = delegate.getAttackDamageBonus();
        this.attackSpeed = delegate.getAttackSpeed();
        this.enchantmentValue = delegate.getEnchantmentValue();
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.vanilla = vanilla;
        this.morevanillatools = !vanilla;
    }

    AIOTMaterials(IConfigurableTier delegate, Supplier<Ingredient> repairIngredient) {
        this.harvestLevel = delegate.getLevel();
        this.durability = delegate.getUses();
        this.speed = delegate.getSpeed();
        this.attackDamageBonus = delegate.getAttackDamageBonus();
        this.attackSpeed = delegate.getAttackSpeed();
        this.enchantmentValue = delegate.getEnchantmentValue();
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.vanilla = false;
        this.morevanillatools = true;
    }

    @Override
    public int getUses() {
        if (this.durability < 0) return Integer.MAX_VALUE;
        return this.durability;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.attackDamageBonus;
    }

    public int getLevel() {
        return this.harvestLevel;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Nonnull
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    public boolean isVanilla() {
        return this.vanilla;
    }
}
