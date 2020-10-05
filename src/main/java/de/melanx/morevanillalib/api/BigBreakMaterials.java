package de.melanx.morevanillalib.api;

import de.melanx.morevanillalib.LibConfigHandler;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyValue;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum BigBreakMaterials implements IItemTier {

    WOOD(LibConfigHandler.woodHarvestlevel.get(), ItemTier.WOOD.getMaxUses(), LibConfigHandler.woodMiningSpeed.get(), 3, -2.5F, ItemTier.WOOD.getEnchantability(), () -> Ingredient.fromTag(ItemTags.PLANKS), "wood", ItemTags.LOGS),
    STONE(LibConfigHandler.stoneHarvestlevel.get(), ItemTier.STONE.getMaxUses(), LibConfigHandler.stoneMiningSpeed.get(), 4, -2.6F, ItemTier.STONE.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.COBBLESTONE), "stone", Tags.Items.STONE),
    IRON(LibConfigHandler.ironHarvestlevel.get(), ItemTier.IRON.getMaxUses(), LibConfigHandler.ironMiningSpeed.get(), 5, -2.8F, ItemTier.IRON.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.INGOTS_IRON), "iron", Tags.Items.STORAGE_BLOCKS_IRON),
    GOLD(LibConfigHandler.goldHarvestlevel.get(), ItemTier.GOLD.getMaxUses(), LibConfigHandler.goldMiningSpeed.get(), 5, -2.5F, ItemTier.GOLD.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.INGOTS_GOLD), "gold", Tags.Items.STORAGE_BLOCKS_GOLD),
    DIAMOND(LibConfigHandler.diamondHarvestlevel.get(), ItemTier.DIAMOND.getMaxUses(), LibConfigHandler.diamondMiningSpeed.get(), 10, -3.0F, ItemTier.DIAMOND.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.GEMS_DIAMOND), "diamond", Tags.Items.STORAGE_BLOCKS_DIAMOND),
    NETHERITE(LibConfigHandler.netheriteHarvestlevel.get(), ItemTier.NETHERITE.getMaxUses(), LibConfigHandler.netheriteMiningSpeed.get(), 11, -3.5F, ItemTier.NETHERITE.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.INGOTS_NETHERITE), "netherite", Tags.Items.STORAGE_BLOCKS_NETHERITE),

    BONE(ToolMaterials.BONE.getHarvestLevel(), ToolMaterials.BONE.getMaxUses(), ToolMaterials.BONE.getEfficiency(), 4, -2.0F, ToolMaterials.BONE.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.BONES), "bone", ModTags.Items.BONE_BLOCK),
    COAL(ToolMaterials.COAL.getHarvestLevel(), ToolMaterials.COAL.getMaxUses(), ToolMaterials.COAL.getEfficiency(), 4, -2.6F, ToolMaterials.COAL.getEnchantability(), () -> Ingredient.fromTag(ModTags.Items.GEMS_COAL), "coal", Tags.Items.STORAGE_BLOCKS_COAL),
    EMERALD(ToolMaterials.EMERALD.getHarvestLevel(), ToolMaterials.EMERALD.getMaxUses(), ToolMaterials.EMERALD.getEfficiency(), 11, -3.0F, ToolMaterials.EMERALD.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.GEMS_EMERALD), "emerald", Tags.Items.STORAGE_BLOCKS_EMERALD),
    ENDER(ToolMaterials.ENDER.getHarvestLevel(), ToolMaterials.ENDER.getMaxUses(), ToolMaterials.ENDER.getEfficiency(), 10, -3.3F, ToolMaterials.ENDER.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.ENDER_PEARLS), "ender", ModTags.Items.CLEAN_ENDSTONE),
    FIERY(ToolMaterials.FIERY.getHarvestLevel(), ToolMaterials.FIERY.getMaxUses(), ToolMaterials.FIERY.getEfficiency(), 6, -2.3F, ToolMaterials.FIERY.getEnchantability(), () -> Ingredient.fromTag(ModTags.Items.MAGMA_BLOCK), "fiery", ModTags.Items.MAGMA_BLOCK),
    GLOWSTONE(ToolMaterials.GLOWSTONE.getHarvestLevel(), ToolMaterials.GLOWSTONE.getMaxUses(), ToolMaterials.GLOWSTONE.getEfficiency(), 5, -2.3F, ToolMaterials.GLOWSTONE.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.DUSTS_GLOWSTONE), "glowstone", ModTags.Items.STORAGE_BLOCKS_GLOWSTONE),
    LAPIS(ToolMaterials.LAPIS.getHarvestLevel(), ToolMaterials.LAPIS.getMaxUses(), ToolMaterials.LAPIS.getEfficiency(), 3, -2.5F, ToolMaterials.LAPIS.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.GEMS_LAPIS), "lapis", Tags.Items.STORAGE_BLOCKS_LAPIS),
    NETHER(ToolMaterials.NETHER.getHarvestLevel(), ToolMaterials.NETHER.getMaxUses(), ToolMaterials.NETHER.getEfficiency(), 4, -2.1F, ToolMaterials.NETHER.getEnchantability(), () -> Ingredient.fromTag(ModTags.Items.NETHER_BRICKS), "nether", ModTags.Items.NETHER_BRICKS),
    OBSIDIAN(ToolMaterials.OBSIDIAN.getHarvestLevel(), ToolMaterials.OBSIDIAN.getMaxUses(), ToolMaterials.OBSIDIAN.getEfficiency(), 7, -3.5F, ToolMaterials.OBSIDIAN.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.OBSIDIAN), "obsidian", Tags.Items.OBSIDIAN),
    PAPER(ToolMaterials.PAPER.getHarvestLevel(), ToolMaterials.PAPER.getMaxUses(), ToolMaterials.PAPER.getEfficiency(), 0, -3.0F, ToolMaterials.PAPER.getEnchantability(), () -> Ingredient.fromTag(ModTags.Items.PAPER), "paper", ModTags.Items.PAPER_BUNDLE),
    PRISMARINE(ToolMaterials.PRISMARINE.getHarvestLevel(), ToolMaterials.PRISMARINE.getMaxUses(), ToolMaterials.PRISMARINE.getEfficiency(), 6, -2.3F, ToolMaterials.PRISMARINE.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.DUSTS_PRISMARINE), "prismarine", ModTags.Items.PRISMARINE),
    QUARTZ(ToolMaterials.QUARTZ.getHarvestLevel(), ToolMaterials.QUARTZ.getMaxUses(), ToolMaterials.QUARTZ.getEfficiency(), 5, -2.0F, ToolMaterials.QUARTZ.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.GEMS_QUARTZ), "quartz", Tags.Items.STORAGE_BLOCKS_QUARTZ),
    REDSTONE(ToolMaterials.REDSTONE.getHarvestLevel(), ToolMaterials.REDSTONE.getMaxUses(), ToolMaterials.REDSTONE.getEfficiency(), 3, -2.5F, ToolMaterials.REDSTONE.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.DUSTS_REDSTONE), "redstone", Tags.Items.STORAGE_BLOCKS_REDSTONE),
    SLIME(ToolMaterials.SLIME.getHarvestLevel(), ToolMaterials.SLIME.getMaxUses(), ToolMaterials.SLIME.getEfficiency(), 7, -3.0F, ToolMaterials.SLIME.getEnchantability(), () -> Ingredient.fromTag(Tags.Items.SLIMEBALLS), "slime", ModTags.Items.SLIME_BLOCK);

    private final int harvestLevel;
    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final float attackSpeed;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;
    private final String prefix;
    private final ITag.INamedTag<Item> tagIngredient; // todo 1.17 change to ingredient

    BigBreakMaterials(int harvestLevel, int durability, double efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, String prefix, ITag.INamedTag<Item> ingredient) {
        this.harvestLevel = harvestLevel;
        this.durability = durability * LibConfigHandler.durabilityMulitplier.get();
        this.efficiency = (float) efficiency / 3.5F;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.prefix = prefix;
        this.tagIngredient = ingredient;
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

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    public String getPrefix() {
        return this.prefix;
    }

    public ITag.INamedTag<Item> getTagIngredient() {
        return this.tagIngredient;
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }

}
