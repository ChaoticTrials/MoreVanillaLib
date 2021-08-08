package de.melanx.morevanillalib.api.ranged;

import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.config.ToolValueConfig;
import de.melanx.morevanillalib.data.ModTags;
import io.github.noeppi_noeppi.libx.util.LazyValue;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public enum RangeMaterials implements IConfigurableTier {

    WOODEN(ToolValueConfig.RangedTools.bone, () -> Ingredient.of(ItemTags.PLANKS), () -> Ingredient.of(ItemTags.LOGS), true),
    STONE(ToolValueConfig.RangedTools.stone, () -> Ingredient.of(Tags.Items.COBBLESTONE), () -> Ingredient.of(Tags.Items.STONE), true),
    IRON(ToolValueConfig.RangedTools.iron, () -> Ingredient.of(Tags.Items.INGOTS_IRON), () -> Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON), true),
    GOLDEN(ToolValueConfig.RangedTools.gold, () -> Ingredient.of(Tags.Items.INGOTS_GOLD), () -> Ingredient.of(Tags.Items.STORAGE_BLOCKS_GOLD), true),
    DIAMOND(ToolValueConfig.RangedTools.diamond, () -> Ingredient.of(Tags.Items.GEMS_DIAMOND), () -> Ingredient.of(Tags.Items.STORAGE_BLOCKS_DIAMOND), true),
    NETHERITE(ToolValueConfig.RangedTools.netherite, () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE), () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE), true),

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
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;
    private final LazyValue<Ingredient> craftingIngredient;
    private final boolean vanilla;

    RangeMaterials(int harvestLevel, int durability, float speed, float attackDamageBonus, float attackSpeed, int enchantmentValue, Supplier<Ingredient> repairIngredient, Supplier<Ingredient> craftingIngredient, boolean vanilla) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.attackSpeed = attackSpeed;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.craftingIngredient = new LazyValue<>(craftingIngredient);
        this.vanilla = vanilla;
    }

    RangeMaterials(int harvestLevel, int durability, float speed, float attackDamageBonus, float attackSpeed, int enchantmentValue, Supplier<Ingredient> repairIngredient, Supplier<Ingredient> craftingIngredient) {
        this.harvestLevel = harvestLevel;
        this.durability = durability;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.attackSpeed = attackSpeed;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.craftingIngredient = new LazyValue<>(craftingIngredient);
        this.vanilla = false;
    }

    RangeMaterials(IConfigurableTier delegate, Supplier<Ingredient> repairIngredient, Supplier<Ingredient> craftingIngredient, boolean vanilla) {
        this.harvestLevel = delegate.getLevel();
        this.durability = delegate.getUses();
        this.speed = delegate.getSpeed();
        this.attackDamageBonus = delegate.getAttackDamageBonus();
        this.attackSpeed = delegate.getAttackSpeed();
        this.enchantmentValue = delegate.getEnchantmentValue();
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.craftingIngredient = new LazyValue<>(craftingIngredient);
        this.vanilla = vanilla;
    }

    RangeMaterials(IConfigurableTier delegate, Supplier<Ingredient> repairIngredient, Supplier<Ingredient> craftingIngredient) {
        this.harvestLevel = delegate.getLevel();
        this.durability = delegate.getUses();
        this.speed = delegate.getSpeed();
        this.attackDamageBonus = delegate.getAttackDamageBonus();
        this.attackSpeed = delegate.getAttackSpeed();
        this.enchantmentValue = delegate.getEnchantmentValue();
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

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamageBonus;
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
        return this.repairIngredient.get();
    }

    @Nonnull
    @Override
    public Ingredient getCraftingIngredient() {
        return this.craftingIngredient.get();
    }

    @Override
    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    @Override
    public boolean isVanilla() {
        return this.vanilla;
    }

}
