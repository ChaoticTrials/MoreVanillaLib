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

    WOODEN(ItemTier.WOOD.getLevel(), ItemTier.WOOD.getUses() * 7, ItemTier.WOOD.getSpeed() / 3.5F, ItemTier.WOOD.getAttackDamageBonus() + 3, -2.5F, ItemTier.WOOD.getEnchantmentValue(), () -> Ingredient.of(ItemTags.PLANKS), () -> Ingredient.of(ItemTags.LOGS), true),
    STONE(ItemTier.STONE.getLevel(), ItemTier.STONE.getUses() * 7, ItemTier.STONE.getSpeed() / 3.5F, ItemTier.STONE.getAttackDamageBonus() + 3, -2.6F, ItemTier.STONE.getEnchantmentValue(), () -> Ingredient.of(Tags.Items.COBBLESTONE), () -> Ingredient.of(Tags.Items.STONE), true),
    IRON(ItemTier.IRON.getLevel(), ItemTier.IRON.getUses() * 7, ItemTier.IRON.getSpeed() / 3.5F, ItemTier.IRON.getAttackDamageBonus() + 3, -2.8F, ItemTier.IRON.getEnchantmentValue(), () -> Ingredient.of(Tags.Items.INGOTS_IRON), () -> Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON), true),
    GOLDEN(ItemTier.GOLD.getLevel(), ItemTier.GOLD.getUses() * 7, ItemTier.GOLD.getSpeed() / 3.5F, ItemTier.GOLD.getAttackDamageBonus() + 3, -2.5F, ItemTier.GOLD.getEnchantmentValue(), () -> Ingredient.of(Tags.Items.INGOTS_GOLD), () -> Ingredient.of(Tags.Items.STORAGE_BLOCKS_GOLD), true),
    DIAMOND(ItemTier.DIAMOND.getLevel(), ItemTier.DIAMOND.getUses() * 7, ItemTier.DIAMOND.getSpeed() / 3.5F, ItemTier.DIAMOND.getAttackDamageBonus() + 3, -3.0F, ItemTier.DIAMOND.getEnchantmentValue(), () -> Ingredient.of(Tags.Items.GEMS_DIAMOND), () -> Ingredient.of(Tags.Items.STORAGE_BLOCKS_DIAMOND), true),
    NETHERITE(ItemTier.NETHERITE.getLevel(), ItemTier.NETHERITE.getUses() * 7, ItemTier.NETHERITE.getSpeed() / 3.5F, ItemTier.NETHERITE.getAttackDamageBonus() + 3, -3.5F, ItemTier.NETHERITE.getEnchantmentValue(), () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE), () -> Ingredient.of(Tags.Items.STORAGE_BLOCKS_NETHERITE), true),

    BONE(ToolValueConfig.RangedTools.bone, () -> Ingredient.of(Tags.Items.BONES), () -> Ingredient.of(Items.BONE_BLOCK)),
    COAL(ToolValueConfig.RangedTools.coal, () -> Ingredient.of(Items.COAL), () -> Ingredient.of(Tags.Items.STORAGE_BLOCKS_COAL)),
    EMERALD(ToolValueConfig.RangedTools.emerald, () -> Ingredient.of(Tags.Items.GEMS_EMERALD), () -> Ingredient.of(Tags.Items.STORAGE_BLOCKS_EMERALD)),
    ENDER(ToolValueConfig.RangedTools.ender, () -> Ingredient.of(Tags.Items.ENDER_PEARLS), () -> Ingredient.of(ModTags.Items.CLEAN_ENDSTONE)),
    FIERY(ToolValueConfig.RangedTools.fiery, () -> Ingredient.of(Items.MAGMA_BLOCK), () -> Ingredient.of(Items.MAGMA_BLOCK)),
    GLOWSTONE(ToolValueConfig.RangedTools.glowstone, () -> Ingredient.of(Tags.Items.DUSTS_GLOWSTONE), () -> Ingredient.of(Items.GLOWSTONE)),
    LAPIS(ToolValueConfig.RangedTools.lapis, () -> Ingredient.of(Tags.Items.GEMS_LAPIS), () -> Ingredient.of(Tags.Items.STORAGE_BLOCKS_LAPIS)),
    NETHER(ToolValueConfig.RangedTools.nether, () -> Ingredient.of(Items.NETHER_BRICKS), () -> Ingredient.of(Items.NETHER_BRICKS)),
    OBSIDIAN(ToolValueConfig.RangedTools.obsidian, () -> Ingredient.of(Tags.Items.OBSIDIAN), () -> Ingredient.of(Tags.Items.OBSIDIAN)),
    PAPER(ToolValueConfig.RangedTools.paper, () -> Ingredient.of(Items.PAPER), () -> Ingredient.of(ModTags.Items.PAPER_BUNDLE)),
    PRISMARINE(ToolValueConfig.RangedTools.prismarine, () -> Ingredient.of(Tags.Items.DUSTS_PRISMARINE), () -> Ingredient.of(Items.PRISMARINE_BRICKS)),
    QUARTZ(ToolValueConfig.RangedTools.quartz, () -> Ingredient.of(Tags.Items.GEMS_QUARTZ), () -> Ingredient.of(Tags.Items.STORAGE_BLOCKS_QUARTZ)),
    REDSTONE(ToolValueConfig.RangedTools.redstone, () -> Ingredient.of(Tags.Items.DUSTS_REDSTONE), () -> Ingredient.of(Tags.Items.STORAGE_BLOCKS_REDSTONE)),
    SLIME(ToolValueConfig.RangedTools.slime, () -> Ingredient.of(Tags.Items.SLIMEBALLS), () -> Ingredient.of(Items.SLIME_BLOCK));

    private final int harvestLevel;
    private final int durability;
    private final float speed;
    private final float attackDamageBonus;
    private final float attackSpeed;
    private final int enchantability;
    private final LazyValue<Ingredient> repairIngredient;
    private final LazyValue<Ingredient> craftingIngredient;
    private final boolean vanilla;

    BigBreakMaterials(int harvestLevel, int durability, float speed, float attackDamageBonus, float attackSpeed, int enchantability, Supplier<Ingredient> repairIngredient, Supplier<Ingredient> craftingIngredient, boolean vanilla) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.craftingIngredient = new LazyValue<>(craftingIngredient);
        this.vanilla = vanilla;
    }

    BigBreakMaterials(int harvestLevel, int durability, float speed, float attackDamageBonus, float attackSpeed, int enchantability, Supplier<Ingredient> repairIngredient, Supplier<Ingredient> craftingIngredient) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.craftingIngredient = new LazyValue<>(craftingIngredient);
        this.vanilla = false;
    }

    BigBreakMaterials(IConfigurableTier delegate, Supplier<Ingredient> repairIngredient, Supplier<Ingredient> craftingIngredient, boolean vanilla) {
        this.harvestLevel = delegate.getLevel();
        this.durability = delegate.getUses();
        this.speed = delegate.getSpeed();
        this.attackDamageBonus = delegate.getAttackDamageBonus();
        this.attackSpeed = delegate.getAttackSpeed();
        this.enchantability = delegate.getEnchantmentValue();
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.craftingIngredient = new LazyValue<>(craftingIngredient);
        this.vanilla = vanilla;
    }

    BigBreakMaterials(IConfigurableTier delegate, Supplier<Ingredient> repairIngredient, Supplier<Ingredient> craftingIngredient) {
        this.harvestLevel = delegate.getLevel();
        this.durability = delegate.getUses();
        this.speed = delegate.getSpeed();
        this.attackDamageBonus = delegate.getAttackDamageBonus();
        this.attackSpeed = delegate.getAttackSpeed();
        this.enchantability = delegate.getEnchantmentValue();
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.craftingIngredient = new LazyValue<>(craftingIngredient);
        this.vanilla = false;
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
        return this.enchantability;
    }

    @Nonnull
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public Ingredient getCraftingIngredient() {
        return this.craftingIngredient.get();
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    public boolean isVanilla() {
        return this.vanilla;
    }

}
