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

    BONE(ToolValueConfig.NormalTools.bone, () -> Ingredient.fromTag(Tags.Items.BONES), () -> Ingredient.fromTag(Tags.Items.BONES)),
    COAL(ToolValueConfig.NormalTools.coal, () -> Ingredient.fromItems(Items.COAL), () -> Ingredient.fromItems(Items.COAL)),
    EMERALD(ToolValueConfig.NormalTools.emerald, () -> Ingredient.fromTag(Tags.Items.GEMS_EMERALD), () -> Ingredient.fromTag(Tags.Items.GEMS_EMERALD)),
    ENDER(ToolValueConfig.NormalTools.ender, () -> Ingredient.fromTag(Tags.Items.ENDER_PEARLS), () -> Ingredient.fromTag(Tags.Items.END_STONES)),
    FIERY(ToolValueConfig.NormalTools.fiery, () -> Ingredient.fromItems(Items.MAGMA_BLOCK), () -> Ingredient.fromItems(Items.MAGMA_CREAM)),
    GLOWSTONE(ToolValueConfig.NormalTools.glowstone, () -> Ingredient.fromTag(Tags.Items.DUSTS_GLOWSTONE), () -> Ingredient.fromTag(Tags.Items.DUSTS_GLOWSTONE)),
    LAPIS(ToolValueConfig.NormalTools.lapis, () -> Ingredient.fromTag(Tags.Items.GEMS_LAPIS), () -> Ingredient.fromTag(Tags.Items.GEMS_LAPIS)),
    NETHER(ToolValueConfig.NormalTools.nether, () -> Ingredient.fromItems(Items.NETHER_BRICKS), () -> Ingredient.fromTag(Tags.Items.NETHERRACK)),
    OBSIDIAN(ToolValueConfig.NormalTools.obsidian, () -> Ingredient.fromTag(Tags.Items.OBSIDIAN), () -> Ingredient.fromTag(ModTags.Items.DUSTS_OBSIDIAN)),
    PAPER(ToolValueConfig.NormalTools.paper, () -> Ingredient.fromItems(Items.PAPER), () -> Ingredient.fromItems(Items.PAPER)),
    PRISMARINE(ToolValueConfig.NormalTools.prismarine, () -> Ingredient.fromTag(Tags.Items.DUSTS_PRISMARINE), () -> Ingredient.fromTag(Tags.Items.DUSTS_PRISMARINE)),
    QUARTZ(ToolValueConfig.NormalTools.quartz, () -> Ingredient.fromTag(Tags.Items.GEMS_QUARTZ), () -> Ingredient.fromTag(Tags.Items.GEMS_QUARTZ)),
    REDSTONE(ToolValueConfig.NormalTools.redstone, () -> Ingredient.fromTag(Tags.Items.DUSTS_REDSTONE), () -> Ingredient.fromTag(Tags.Items.DUSTS_REDSTONE)),
    SLIME(ToolValueConfig.NormalTools.slime, () -> Ingredient.fromTag(Tags.Items.SLIMEBALLS), () -> Ingredient.fromTag(Tags.Items.SLIMEBALLS));

    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final int harvestLevel;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;
    private final LazyValue<Ingredient> ingredient;

    ToolMaterials(int durability, double efficiency, float attackDamage, int harvestLevel, int enchantability, Supplier<Ingredient> repairMaterial, Supplier<Ingredient> ingredient) {
        this.durability = durability;
        this.efficiency = (float) efficiency;
        this.attackDamage = attackDamage;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.ingredient = new LazyValue<>(ingredient);
    }

    ToolMaterials(IConfigurableTier delegate, Supplier<Ingredient> repairMaterial, Supplier<Ingredient> ingredient) {
        this.durability = delegate.getMaxUses();
        this.efficiency = delegate.getEfficiency();
        this.attackDamage = delegate.getAttackDamage();
        this.harvestLevel = delegate.getHarvestLevel();
        this.enchantability = delegate.getEnchantability();
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.ingredient = new LazyValue<>(ingredient);
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

    public Ingredient getIngredient() {
        return this.ingredient.getValue();
    }

}
