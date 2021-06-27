package de.melanx.morevanillalib.api.normal;

import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.config.ToolValueConfig;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.common.Tags;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public enum ToolMaterials implements IConfigurableTier {

    BONE(ToolValueConfig.NormalTools.bone, () -> Ingredient.of(Tags.Items.BONES), () -> Ingredient.of(Tags.Items.BONES)),
    COAL(ToolValueConfig.NormalTools.coal, () -> Ingredient.of(Items.COAL), () -> Ingredient.of(Items.COAL)),
    EMERALD(ToolValueConfig.NormalTools.emerald, () -> Ingredient.of(Tags.Items.GEMS_EMERALD), () -> Ingredient.of(Tags.Items.GEMS_EMERALD)),
    ENDER(ToolValueConfig.NormalTools.ender, () -> Ingredient.of(Tags.Items.ENDER_PEARLS), () -> Ingredient.of(Tags.Items.END_STONES)),
    FIERY(ToolValueConfig.NormalTools.fiery, () -> Ingredient.of(Items.MAGMA_BLOCK), () -> Ingredient.of(Items.MAGMA_CREAM)),
    GLOWSTONE(ToolValueConfig.NormalTools.glowstone, () -> Ingredient.of(Tags.Items.DUSTS_GLOWSTONE), () -> Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)),
    LAPIS(ToolValueConfig.NormalTools.lapis, () -> Ingredient.of(Tags.Items.GEMS_LAPIS), () -> Ingredient.of(Tags.Items.GEMS_LAPIS)),
    NETHER(ToolValueConfig.NormalTools.nether, () -> Ingredient.of(Items.NETHER_BRICKS), () -> Ingredient.of(Tags.Items.NETHERRACK)),
    OBSIDIAN(ToolValueConfig.NormalTools.obsidian, () -> Ingredient.of(Tags.Items.OBSIDIAN), () -> Ingredient.of(ModTags.Items.DUSTS_OBSIDIAN)),
    PAPER(ToolValueConfig.NormalTools.paper, () -> Ingredient.of(Items.PAPER), () -> Ingredient.of(Items.PAPER)),
    PRISMARINE(ToolValueConfig.NormalTools.prismarine, () -> Ingredient.of(Tags.Items.DUSTS_PRISMARINE), () -> Ingredient.of(Tags.Items.DUSTS_PRISMARINE)),
    QUARTZ(ToolValueConfig.NormalTools.quartz, () -> Ingredient.of(Tags.Items.GEMS_QUARTZ), () -> Ingredient.of(Tags.Items.GEMS_QUARTZ)),
    REDSTONE(ToolValueConfig.NormalTools.redstone, () -> Ingredient.of(Tags.Items.DUSTS_REDSTONE), () -> Ingredient.of(Tags.Items.DUSTS_REDSTONE)),
    SLIME(ToolValueConfig.NormalTools.slime, () -> Ingredient.of(Tags.Items.SLIMEBALLS), () -> Ingredient.of(Tags.Items.SLIMEBALLS));

    private final int durability;
    private final float speed;
    private final float attackDamageBonus;
    private final int harvestLevel;
    private final int enchantmentValue;
    private final LazyValue<Ingredient> repairIngredient;
    private final LazyValue<Ingredient> craftingIngredient;

    ToolMaterials(int durability, double speed, float attackDamage, int harvestLevel, int enchantmentValue, Supplier<Ingredient> repairIngredient, Supplier<Ingredient> craftingIngredient) {
        this.durability = durability;
        this.speed = (float) speed;
        this.attackDamageBonus = attackDamage;
        this.harvestLevel = harvestLevel;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.craftingIngredient = new LazyValue<>(craftingIngredient);
    }

    ToolMaterials(IConfigurableTier delegate, Supplier<Ingredient> repairIngredient, Supplier<Ingredient> craftingIngredient) {
        this.durability = delegate.getUses();
        this.speed = delegate.getSpeed();
        this.attackDamageBonus = delegate.getAttackDamageBonus();
        this.harvestLevel = delegate.getLevel();
        this.enchantmentValue = delegate.getEnchantmentValue();
        this.repairIngredient = new LazyValue<>(repairIngredient);
        this.craftingIngredient = new LazyValue<>(craftingIngredient);
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

    public Ingredient getCraftingIngredient() {
        return this.craftingIngredient.get();
    }

}
