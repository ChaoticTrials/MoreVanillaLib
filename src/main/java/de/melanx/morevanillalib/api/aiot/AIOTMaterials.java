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

    WOODEN(ItemTier.WOOD, -2.5F, () -> Ingredient.fromTag(ItemTags.PLANKS), true),
    STONE(ItemTier.STONE, -2.6F, () -> Ingredient.fromTag(Tags.Items.COBBLESTONE), true),
    IRON(ItemTier.IRON, -2.8F, () -> Ingredient.fromTag(Tags.Items.INGOTS_IRON), true),
    GOLDEN(ItemTier.GOLD, -2.5F, () -> Ingredient.fromTag(Tags.Items.INGOTS_GOLD), true),
    DIAMOND(ItemTier.DIAMOND, -3.0F, () -> Ingredient.fromTag(Tags.Items.GEMS_DIAMOND), true),
    NETHERITE(ItemTier.NETHERITE, -3.5F, () -> Ingredient.fromTag(Tags.Items.INGOTS_NETHERITE), true),

    BONE(ToolValueConfig.AIOTs.bone, () -> Ingredient.fromTag(Tags.Items.BONES)),
    COAL(ToolValueConfig.AIOTs.coal, () -> Ingredient.fromItems(Items.COAL)),
    EMERALD(ToolValueConfig.AIOTs.emerald, () -> Ingredient.fromTag(Tags.Items.GEMS_EMERALD)),
    ENDER(ToolValueConfig.AIOTs.ender, () -> Ingredient.fromTag(Tags.Items.ENDER_PEARLS)),
    FIERY(ToolValueConfig.AIOTs.fiery, () -> Ingredient.fromItems(Items.MAGMA_BLOCK)),
    GLOWSTONE(ToolValueConfig.AIOTs.glowstone, () -> Ingredient.fromTag(Tags.Items.DUSTS_GLOWSTONE)),
    LAPIS(ToolValueConfig.AIOTs.lapis, () -> Ingredient.fromTag(Tags.Items.GEMS_LAPIS)),
    NETHER(ToolValueConfig.AIOTs.nether, () -> Ingredient.fromItems(Items.NETHER_BRICKS)),
    OBSIDIAN(ToolValueConfig.AIOTs.obsidian, () -> Ingredient.fromTag(Tags.Items.OBSIDIAN)),
    PAPER(ToolValueConfig.AIOTs.paper, () -> Ingredient.fromItems(Items.PAPER)),
    PRISMARINE(ToolValueConfig.AIOTs.prismarine, () -> Ingredient.fromTag(Tags.Items.DUSTS_PRISMARINE)),
    QUARTZ(ToolValueConfig.AIOTs.quartz, () -> Ingredient.fromTag(Tags.Items.GEMS_QUARTZ)),
    REDSTONE(ToolValueConfig.AIOTs.redstone, () -> Ingredient.fromTag(Tags.Items.DUSTS_REDSTONE)),
    SLIME(ToolValueConfig.AIOTs.slime, () -> Ingredient.fromTag(Tags.Items.SLIMEBALLS));

    private final int harvestLevel;
    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final float attackSpeed;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;
    private final boolean vanilla;
    private final boolean morevanillatools;

    AIOTMaterials(IItemTier delegate, float attackSpeed, Supplier<Ingredient> repairMaterial, boolean vanilla) {
        this.harvestLevel = delegate.getHarvestLevel();
        this.durability = delegate.getMaxUses();
        this.efficiency = delegate.getEfficiency();
        this.attackDamage = delegate.getAttackDamage();
        this.attackSpeed = attackSpeed;
        this.enchantability = delegate.getEnchantability();
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.vanilla = vanilla;
        this.morevanillatools = !vanilla;
    }

    AIOTMaterials(IItemTier delegate, float attackSpeed, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = delegate.getHarvestLevel();
        this.durability = delegate.getMaxUses();
        this.efficiency = delegate.getEfficiency();
        this.attackDamage = delegate.getAttackDamage();
        this.attackSpeed = attackSpeed;
        this.enchantability = delegate.getEnchantability();
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.vanilla = false;
        this.morevanillatools = true;
    }

    AIOTMaterials(IConfigurableTier delegate, Supplier<Ingredient> repairMaterial, boolean vanilla) {
        this.harvestLevel = delegate.getHarvestLevel();
        this.durability = delegate.getMaxUses();
        this.efficiency = delegate.getEfficiency();
        this.attackDamage = delegate.getAttackDamage();
        this.attackSpeed = delegate.getAttackSpeed();
        this.enchantability = delegate.getEnchantability();
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.vanilla = vanilla;
        this.morevanillatools = !vanilla;
    }

    AIOTMaterials(IConfigurableTier delegate, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = delegate.getHarvestLevel();
        this.durability = delegate.getMaxUses();
        this.efficiency = delegate.getEfficiency();
        this.attackDamage = delegate.getAttackDamage();
        this.attackSpeed = delegate.getAttackSpeed();
        this.enchantability = delegate.getEnchantability();
        this.repairMaterial = new LazyValue<>(repairMaterial);
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
