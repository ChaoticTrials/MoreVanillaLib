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

    WOOD(LibConfigHandler.woodHarvestlevel.get(), ItemTier.WOOD.getMaxUses(), LibConfigHandler.woodMiningSpeed.get(), 3, -2.5F, ItemTier.WOOD.getEnchantability(), () -> RepairMaterialsList.wood, "wood", ItemTags.LOGS),
    STONE(LibConfigHandler.stoneHarvestlevel.get(), ItemTier.STONE.getMaxUses(), LibConfigHandler.stoneMiningSpeed.get(), 4, -2.6F, ItemTier.STONE.getEnchantability(), () -> RepairMaterialsList.stone, "stone", Tags.Items.STONE),
    IRON(LibConfigHandler.ironHarvestlevel.get(), ItemTier.IRON.getMaxUses(), LibConfigHandler.ironMiningSpeed.get(), 5, -2.8F, ItemTier.IRON.getEnchantability(), () -> RepairMaterialsList.iron, "iron", Tags.Items.STORAGE_BLOCKS_IRON),
    GOLD(LibConfigHandler.goldHarvestlevel.get(), ItemTier.GOLD.getMaxUses(), LibConfigHandler.goldMiningSpeed.get(), 5, -2.5F, ItemTier.GOLD.getEnchantability(), () -> RepairMaterialsList.gold, "gold", Tags.Items.STORAGE_BLOCKS_GOLD),
    DIAMOND(LibConfigHandler.diamondHarvestlevel.get(), ItemTier.DIAMOND.getMaxUses(), LibConfigHandler.diamondMiningSpeed.get(), 10, -3.0F, ItemTier.DIAMOND.getEnchantability(), () -> RepairMaterialsList.diamond, "diamond", Tags.Items.STORAGE_BLOCKS_DIAMOND),
    NETHERITE(LibConfigHandler.netheriteHarvestlevel.get(), ItemTier.NETHERITE.getMaxUses(), LibConfigHandler.netheriteMiningSpeed.get(), 11, -3.5F, ItemTier.NETHERITE.getEnchantability(), () -> RepairMaterialsList.netherite, "netherite", ModTags.Items.STORAGE_BLOCKS_NETHERITE),

    BONE(ToolMaterials.BONE.getHarvestLevel(), ToolMaterials.BONE.getMaxUses(), ToolMaterials.BONE.getEfficiency(), 4, -2.0F, ToolMaterials.BONE.getEnchantability(), () -> RepairMaterialsList.bone, "bone", ModTags.Items.BONE_BLOCK),
    COAL(ToolMaterials.COAL.getHarvestLevel(), ToolMaterials.COAL.getMaxUses(), ToolMaterials.COAL.getEfficiency(), 4, -2.6F, ToolMaterials.COAL.getEnchantability(), () -> RepairMaterialsList.coal, "coal", Tags.Items.STORAGE_BLOCKS_COAL),
    EMERALD(ToolMaterials.EMERALD.getHarvestLevel(), ToolMaterials.EMERALD.getMaxUses(), ToolMaterials.EMERALD.getEfficiency(), 11, -3.0F, ToolMaterials.EMERALD.getEnchantability(), () -> RepairMaterialsList.emerald, "emerald", Tags.Items.STORAGE_BLOCKS_EMERALD),
    ENDER(ToolMaterials.ENDER.getHarvestLevel(), ToolMaterials.ENDER.getMaxUses(), ToolMaterials.ENDER.getEfficiency(), 10, -3.3F, ToolMaterials.ENDER.getEnchantability(), () -> RepairMaterialsList.ender, "ender", ModTags.Items.CLEAN_ENDSTONE),
    FIERY(ToolMaterials.FIERY.getHarvestLevel(), ToolMaterials.FIERY.getMaxUses(), ToolMaterials.FIERY.getEfficiency(), 6, -2.3F, ToolMaterials.FIERY.getEnchantability(), () -> RepairMaterialsList.fiery, "fiery", ModTags.Items.MAGMA_BLOCK),
    GLOWSTONE(ToolMaterials.GLOWSTONE.getHarvestLevel(), ToolMaterials.GLOWSTONE.getMaxUses(), ToolMaterials.GLOWSTONE.getEfficiency(), 5, -2.3F, ToolMaterials.GLOWSTONE.getEnchantability(), () -> RepairMaterialsList.glowstone, "glowstone", ModTags.Items.STORAGE_BLOCKS_GLOWSTONE),
    LAPIS(ToolMaterials.LAPIS.getHarvestLevel(), ToolMaterials.LAPIS.getMaxUses(), ToolMaterials.LAPIS.getEfficiency(), 3, -2.5F, ToolMaterials.LAPIS.getEnchantability(), () -> RepairMaterialsList.lapis, "lapis", Tags.Items.STORAGE_BLOCKS_LAPIS),
    NETHER(ToolMaterials.NETHER.getHarvestLevel(), ToolMaterials.NETHER.getMaxUses(), ToolMaterials.NETHER.getEfficiency(), 4, -2.1F, ToolMaterials.NETHER.getEnchantability(), () -> RepairMaterialsList.nether, "nether", ModTags.Items.NETHER_BRICKS),
    OBSIDIAN(ToolMaterials.OBSIDIAN.getHarvestLevel(), ToolMaterials.OBSIDIAN.getMaxUses(), ToolMaterials.OBSIDIAN.getEfficiency(), 7, -3.5F, ToolMaterials.OBSIDIAN.getEnchantability(), () -> RepairMaterialsList.obsidian, "obsidian", Tags.Items.OBSIDIAN),
    PAPER(ToolMaterials.PAPER.getHarvestLevel(), ToolMaterials.PAPER.getMaxUses(), ToolMaterials.PAPER.getEfficiency(), 0, -3.0F, ToolMaterials.PAPER.getEnchantability(), () -> RepairMaterialsList.paper, "paper", ModTags.Items.PAPER_BUNDLE),
    PRISMARINE(ToolMaterials.PRISMARINE.getHarvestLevel(), ToolMaterials.PRISMARINE.getMaxUses(), ToolMaterials.PRISMARINE.getEfficiency(), 6, -2.3F, ToolMaterials.PRISMARINE.getEnchantability(), () -> RepairMaterialsList.prismarine, "prismarine", ModTags.Items.PRISMARINE),
    QUARTZ(ToolMaterials.QUARTZ.getHarvestLevel(), ToolMaterials.QUARTZ.getMaxUses(), ToolMaterials.QUARTZ.getEfficiency(), 5, -2.0F, ToolMaterials.QUARTZ.getEnchantability(), () -> RepairMaterialsList.quartz, "quartz", Tags.Items.STORAGE_BLOCKS_QUARTZ),
    REDSTONE(ToolMaterials.REDSTONE.getHarvestLevel(), ToolMaterials.REDSTONE.getMaxUses(), ToolMaterials.REDSTONE.getEfficiency(), 3, -2.5F, ToolMaterials.REDSTONE.getEnchantability(), () -> RepairMaterialsList.redstone, "redstone", Tags.Items.STORAGE_BLOCKS_REDSTONE),
    SLIME(ToolMaterials.SLIME.getHarvestLevel(), ToolMaterials.SLIME.getMaxUses(), ToolMaterials.SLIME.getEfficiency(), 7, -3.0F, ToolMaterials.SLIME.getEnchantability(), () -> RepairMaterialsList.slime, "slime", ModTags.Items.SLIME_BLOCK);

    private final int harvestLevel;
    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final float attackSpeed;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;
    private final String prefix;
    private final ITag.INamedTag<Item> tagIngredient;

    BigBreakMaterials(int harvestLevel, int durability, double efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, String prefix, ITag.INamedTag<Item> ingredient) {
        this.harvestLevel = harvestLevel;
        this.durability = durability * 5;
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
