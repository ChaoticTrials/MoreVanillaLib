package de.melanx.morevanillalib.api.aiot;

import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.config.ToolValueConfig;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import javax.annotation.Nonnull;

public enum AIOTMaterials implements IConfigurableTier {

    WOODEN(ItemTier.WOOD, -2.5F, true),
    STONE(ItemTier.STONE, -2.6F, true),
    IRON(ItemTier.IRON, -2.8F, true),
    GOLDEN(ItemTier.GOLD, -2.5F, true),
    DIAMOND(ItemTier.DIAMOND, -3.0F, true),
    NETHERITE(ItemTier.NETHERITE, -3.5F, true),

    BONE(ToolValueConfig.AIOTs.bone),
    COAL(ToolValueConfig.AIOTs.coal),
    EMERALD(ToolValueConfig.AIOTs.emerald),
    ENDER(ToolValueConfig.AIOTs.ender),
    FIERY(ToolValueConfig.AIOTs.fiery),
    GLOWSTONE(ToolValueConfig.AIOTs.glowstone),
    LAPIS(ToolValueConfig.AIOTs.lapis),
    NETHER(ToolValueConfig.AIOTs.nether),
    OBSIDIAN(ToolValueConfig.AIOTs.obsidian),
    PAPER(ToolValueConfig.AIOTs.paper),
    PRISMARINE(ToolValueConfig.AIOTs.prismarine),
    QUARTZ(ToolValueConfig.AIOTs.quartz),
    REDSTONE(ToolValueConfig.AIOTs.redstone),
    SLIME(ToolValueConfig.AIOTs.slime);

    private final int harvestLevel;
    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final float attackSpeed;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;
    private final String prefix;
    private final boolean vanilla;
    private final boolean morevanillatools;

    AIOTMaterials(IItemTier delegate, float attackSpeed, boolean vanilla) {
        this.harvestLevel = delegate.getHarvestLevel();
        this.durability = delegate.getMaxUses();
        this.efficiency = delegate.getEfficiency();
        this.attackDamage = delegate.getAttackDamage();
        this.attackSpeed = attackSpeed;
        this.enchantability = delegate.getEnchantability();
        this.repairMaterial = new LazyValue<>(delegate::getRepairMaterial);
        this.prefix = this.name();
        this.vanilla = vanilla;
        this.morevanillatools = !vanilla;
    }

    AIOTMaterials(IItemTier delegate, float attackSpeed) {
        this.harvestLevel = delegate.getHarvestLevel();
        this.durability = delegate.getMaxUses();
        this.efficiency = delegate.getEfficiency();
        this.attackDamage = delegate.getAttackDamage();
        this.attackSpeed = attackSpeed;
        this.enchantability = delegate.getEnchantability();
        this.repairMaterial = new LazyValue<>(delegate::getRepairMaterial);
        this.prefix = this.name();
        this.vanilla = false;
        this.morevanillatools = true;
    }

    AIOTMaterials(IConfigurableTier delegate, boolean vanilla) {
        this.harvestLevel = delegate.getHarvestLevel();
        this.durability = delegate.getMaxUses();
        this.efficiency = delegate.getEfficiency();
        this.attackDamage = delegate.getAttackDamage();
        this.attackSpeed = delegate.getAttackSpeed();
        this.enchantability = delegate.getEnchantability();
        this.repairMaterial = new LazyValue<>(delegate::getRepairMaterial);
        this.prefix = this.name();
        this.vanilla = vanilla;
        this.morevanillatools = !vanilla;
    }

    AIOTMaterials(IConfigurableTier delegate) {
        this.harvestLevel = delegate.getHarvestLevel();
        this.durability = delegate.getMaxUses();
        this.efficiency = delegate.getEfficiency();
        this.attackDamage = delegate.getAttackDamage();
        this.attackSpeed = delegate.getAttackSpeed();
        this.enchantability = delegate.getEnchantability();
        this.repairMaterial = new LazyValue<>(delegate::getRepairMaterial);
        this.prefix = this.name();
        this.vanilla = false;
        this.morevanillatools = true;
    }

    @Override
    public int getMaxUses() {
        if (this.durability < 0) return Integer.MAX_VALUE;
        return this.durability;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    @Nonnull
    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    public boolean isVanilla() {
        return this.vanilla;
    }
}
