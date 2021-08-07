package de.melanx.morevanillalib.api.ranged;

import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.config.ToolValueConfig;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyValue;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public enum BigBreakMaterials implements IConfigurableTier {

    WOODEN(ItemTier.WOOD.getHarvestLevel(), ItemTier.WOOD.getMaxUses() * 7, ItemTier.WOOD.getEfficiency() / 3.5F, ItemTier.WOOD.getAttackDamage() + 3, -2.5F, ItemTier.WOOD.getEnchantability(), () -> Ingredient.fromTag(ItemTags.PLANKS), () -> Ingredient.fromTag(ItemTags.LOGS), true),
    STONE(ItemTier.STONE.getHarvestLevel(), ItemTier.STONE.getMaxUses() * 7, ItemTier.STONE.getEfficiency() / 3.5F, ItemTier.STONE.getAttackDamage() + 3, -2.6F, ItemTier.STONE.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.COBBLESTONE), () -> Ingredient.fromTag(Tags.Items.STONE), true),
    IRON(ItemTier.IRON.getHarvestLevel(), ItemTier.IRON.getMaxUses() * 7, ItemTier.IRON.getEfficiency() / 3.5F, ItemTier.IRON.getAttackDamage() + 3, -2.8F, ItemTier.IRON.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.INGOTS_IRON), () -> Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_IRON), true),
    GOLDEN(ItemTier.GOLD.getHarvestLevel(), ItemTier.GOLD.getMaxUses() * 7, ItemTier.GOLD.getEfficiency() / 3.5F, ItemTier.GOLD.getAttackDamage() + 3, -2.5F, ItemTier.GOLD.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.INGOTS_GOLD), () -> Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), true),
    DIAMOND(ItemTier.DIAMOND.getHarvestLevel(), ItemTier.DIAMOND.getMaxUses() * 7, ItemTier.DIAMOND.getEfficiency() / 3.5F, ItemTier.DIAMOND.getAttackDamage() + 3, -3.0F, ItemTier.DIAMOND.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.GEMS_DIAMOND), () -> Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_DIAMOND), true),
    NETHERITE(ItemTier.NETHERITE.getHarvestLevel(), ItemTier.NETHERITE.getMaxUses() * 7, ItemTier.NETHERITE.getEfficiency() / 3.5F, ItemTier.NETHERITE.getAttackDamage() + 3, -3.5F, ItemTier.NETHERITE.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.INGOTS_NETHERITE), () -> Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_NETHERITE), true),

    BONE(ToolValueConfig.RangedTools.bone, () -> Ingredient.fromTag(Tags.Items.BONES), () -> Ingredient.fromItems(Items.BONE_BLOCK)),
    COAL(ToolValueConfig.RangedTools.coal, () -> Ingredient.fromItems(Items.COAL), () -> Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_COAL)),
    EMERALD(ToolValueConfig.RangedTools.emerald, () -> Ingredient.fromTag(Tags.Items.GEMS_EMERALD), () -> Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_EMERALD)),
    ENDER(ToolValueConfig.RangedTools.ender, () -> Ingredient.fromTag(Tags.Items.ENDER_PEARLS), () -> Ingredient.fromTag(ModTags.Items.CLEAN_ENDSTONE)),
    FIERY(ToolValueConfig.RangedTools.fiery, () -> Ingredient.fromItems(Items.MAGMA_BLOCK), () -> Ingredient.fromItems(Items.MAGMA_BLOCK)),
    GLOWSTONE(ToolValueConfig.RangedTools.glowstone, () -> Ingredient.fromTag(Tags.Items.DUSTS_GLOWSTONE), () -> Ingredient.fromItems(Items.GLOWSTONE)),
    LAPIS(ToolValueConfig.RangedTools.lapis, () -> Ingredient.fromTag(Tags.Items.GEMS_LAPIS), () -> Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_LAPIS)),
    NETHER(ToolValueConfig.RangedTools.nether, () -> Ingredient.fromItems(Items.NETHER_BRICKS), () -> Ingredient.fromItems(Items.NETHER_BRICKS)),
    OBSIDIAN(ToolValueConfig.RangedTools.obsidian, () -> Ingredient.fromTag(Tags.Items.OBSIDIAN), () -> Ingredient.fromTag(Tags.Items.OBSIDIAN)),
    PAPER(ToolValueConfig.RangedTools.paper, () -> Ingredient.fromItems(Items.PAPER), () -> Ingredient.fromTag(ModTags.Items.PAPER_BUNDLE)),
    PRISMARINE(ToolValueConfig.RangedTools.prismarine, () -> Ingredient.fromTag(Tags.Items.DUSTS_PRISMARINE), () -> Ingredient.fromItems(Items.PRISMARINE_BRICKS)),
    QUARTZ(ToolValueConfig.RangedTools.quartz, () -> Ingredient.fromTag(Tags.Items.GEMS_QUARTZ), () -> Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_QUARTZ)),
    REDSTONE(ToolValueConfig.RangedTools.redstone, () -> Ingredient.fromTag(Tags.Items.DUSTS_REDSTONE), () -> Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_REDSTONE)),
    SLIME(ToolValueConfig.RangedTools.slime, () -> Ingredient.fromTag(Tags.Items.SLIMEBALLS), () -> Ingredient.fromItems(Items.SLIME_BLOCK));

    private final int harvestLevel;
    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final float attackSpeed;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;
    private final LazyValue<Ingredient> ingredient;
    private final boolean vanilla;

    BigBreakMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, Supplier<Ingredient> ingredient, boolean vanilla) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.ingredient = new LazyValue<>(ingredient);
        this.vanilla = vanilla;
    }

    BigBreakMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, Supplier<Ingredient> ingredient) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.ingredient = new LazyValue<>(ingredient);
        this.vanilla = false;
    }

    BigBreakMaterials(IConfigurableTier delegate, Supplier<Ingredient> repairMaterial, Supplier<Ingredient> ingredient, boolean vanilla) {
        this.harvestLevel = delegate.getHarvestLevel();
        this.durability = delegate.getMaxUses();
        this.efficiency = delegate.getEfficiency();
        this.attackDamage = delegate.getAttackDamage();
        this.attackSpeed = delegate.getAttackSpeed();
        this.enchantability = delegate.getEnchantability();
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.ingredient = new LazyValue<>(ingredient);
        this.vanilla = vanilla;
    }

    BigBreakMaterials(IConfigurableTier delegate, Supplier<Ingredient> repairMaterial, Supplier<Ingredient> ingredient) {
        this.harvestLevel = delegate.getHarvestLevel();
        this.durability = delegate.getMaxUses();
        this.efficiency = delegate.getEfficiency();
        this.attackDamage = delegate.getAttackDamage();
        this.attackSpeed = delegate.getAttackSpeed();
        this.enchantability = delegate.getEnchantability();
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.ingredient = new LazyValue<>(ingredient);
        this.vanilla = false;
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

    public Ingredient getIngredient() {
        return this.ingredient.getValue();
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    public boolean isVanilla() {
        return this.vanilla;
    }

}
