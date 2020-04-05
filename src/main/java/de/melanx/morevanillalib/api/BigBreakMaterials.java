package de.melanx.morevanillalib.api;

import de.melanx.morevanillalib.LibConfigHandler;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.LazyValue;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum BigBreakMaterials implements IItemTier {

    WOOD(LibConfigHandler.woodHarvestlevel.get(), 59, LibConfigHandler.woodMiningSpeed.get(), 3, -2.5F, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }, "wooden", ItemTags.PLANKS, ItemTags.LOGS), // todo "wood" in 1.16
    STONE(LibConfigHandler.stoneHarvestlevel.get(), 131, LibConfigHandler.stoneMiningSpeed.get(), 4, -2.6F, 5, () -> {
        return Ingredient.fromTag(Tags.Items.COBBLESTONE);
    }, "stone", Tags.Items.COBBLESTONE, Tags.Items.STONE),
    IRON(LibConfigHandler.ironHarvestlevel.get(), 250, LibConfigHandler.ironMiningSpeed.get(), 5, -2.8F, 14, () -> {
        return Ingredient.fromTag(Tags.Items.INGOTS_IRON);
    }, "iron", Tags.Items.INGOTS_IRON, Tags.Items.STORAGE_BLOCKS_IRON),
    GOLD(LibConfigHandler.goldHarvestlevel.get(), 32, LibConfigHandler.goldMiningSpeed.get(), 5, -2.5F, 22, () -> {
        return Ingredient.fromTag(Tags.Items.INGOTS_GOLD);
    }, "golden", Tags.Items.INGOTS_GOLD, Tags.Items.STORAGE_BLOCKS_GOLD), // todo "gold" in 1.16
    DIAMOND(LibConfigHandler.diamondHarvestlevel.get(), 1561, LibConfigHandler.diamondMiningSpeed.get(), 10, -3.0F, 10, () -> {
        return Ingredient.fromTag(Tags.Items.GEMS_DIAMOND);
    }, "diamond", Tags.Items.GEMS_DIAMOND, Tags.Items.STORAGE_BLOCKS_DIAMOND),

    BONE(LibConfigHandler.boneHarvestlevel.get(), LibConfigHandler.boneDurability.get(), LibConfigHandler.boneMiningSpeed.get(), 4, -2.0F, 17, () -> {
        return Ingredient.fromTag(Tags.Items.BONES);
    }, "bone", ModTags.Items.BONE_BLOCK),
    COAL(LibConfigHandler.coalHarvestlevel.get(), LibConfigHandler.coalDurability.get(), LibConfigHandler.coalMiningSpeed.get(), 4, -2.6F, 17, () -> {
        return Ingredient.fromTag(ModTags.Items.GEMS_COAL);
    }, "coal", Tags.Items.STORAGE_BLOCKS_COAL),
    EMERALD(LibConfigHandler.emeraldHarvestlevel.get(), LibConfigHandler.emeraldDurability.get(), LibConfigHandler.emeraldMiningSpeed.get(), 11, -3.0F, 25, () -> {
        return Ingredient.fromTag(Tags.Items.GEMS_EMERALD);
    }, "emerald", Tags.Items.GEMS_EMERALD, Tags.Items.STORAGE_BLOCKS_EMERALD),
    ENDER(LibConfigHandler.enderHarvestlevel.get(), LibConfigHandler.enderDurability.get(), LibConfigHandler.enderMiningSpeed.get(), 10, -3.3F, 10, () -> {
        return Ingredient.fromTag(Tags.Items.ENDER_PEARLS);
    }, "ender", ModTags.Items.DRAGON_HEAD, Tags.Items.END_STONES),
    FIERY(LibConfigHandler.fieryHarvestlevel.get(), LibConfigHandler.fieryDurability.get(), LibConfigHandler.fieryMiningSpeed.get(), 6, -2.3F, 15, () -> {
        return Ingredient.fromTag(ModTags.Items.MAGMA_BLOCK);
    }, "fiery", ModTags.Items.MAGMA_BLOCK),
    GLOWSTONE(LibConfigHandler.glowstoneHarvestlevel.get(), LibConfigHandler.glowstoneDurability.get(), LibConfigHandler.glowstoneMiningSpeed.get(), 5, -2.3F, 35, () -> {
        return Ingredient.fromTag(ModTags.Items.STORAGE_BLOCKS_GLOWSTONE);
    }, "glowstone", ModTags.Items.STORAGE_BLOCKS_GLOWSTONE),
    LAPIS(LibConfigHandler.lapisHarvestlevel.get(), LibConfigHandler.lapisDurability.get(), LibConfigHandler.lapisMiningSpeed.get(), 3, -2.5F, 20, () -> {
        return Ingredient.fromTag(Tags.Items.GEMS_LAPIS);
    }, "lapis", Tags.Items.STORAGE_BLOCKS_LAPIS),
    NETHER(LibConfigHandler.netherHarvestlevel.get(), LibConfigHandler.netherDurability.get(), LibConfigHandler.netherMiningSpeed.get(), 4, -2.1F, 66, () -> {
        return Ingredient.fromTag(ModTags.Items.NETHER_BRICKS);
    }, "nether", ModTags.Items.NETHER_BRICKS),
    OBSIDIAN(LibConfigHandler.obsidianHarvestlevel.get(), LibConfigHandler.obsidianDurability.get(), LibConfigHandler.obsidianMiningSpeed.get(), 7, -3.5F, 15, () -> {
        return Ingredient.fromTag(Tags.Items.OBSIDIAN);
    }, "obsidian", Tags.Items.OBSIDIAN),
    PAPER(LibConfigHandler.paperHarvestlevel.get(), LibConfigHandler.paperDurability.get(), LibConfigHandler.paperMiningSpeed.get(), 0, -3.0F, 17, () -> {
        return Ingredient.fromTag(ModTags.Items.PAPER);
    }, "paper", ModTags.Items.PAPER),
    PRISMARINE(LibConfigHandler.prismarineHarvestlevel.get(), LibConfigHandler.prismarineDurability.get(), LibConfigHandler.prismarineMiningSpeed.get(), 6, -2.3F, 20, () -> {
        return Ingredient.fromTag(Tags.Items.DUSTS_PRISMARINE);
    }, "prismarine", ModTags.Items.PRISMARINE),
    QUARTZ(LibConfigHandler.quartzHarvestlevel.get(), LibConfigHandler.quartzDurability.get(), LibConfigHandler.quartzMiningSpeed.get(), 5, -2.0F, 18, () -> {
        return Ingredient.fromTag(Tags.Items.GEMS_QUARTZ);
    }, "quartz", Tags.Items.STORAGE_BLOCKS_QUARTZ),
    REDSTONE(LibConfigHandler.redstoneHarvestlevel.get(), LibConfigHandler.redstoneDurability.get(), LibConfigHandler.redstoneMiningSpeed.get(), 3, -2.5F, 20, () -> {
        return Ingredient.fromTag(Tags.Items.DUSTS_REDSTONE);
    }, "redstone", Tags.Items.STORAGE_BLOCKS_REDSTONE),
    SLIME(LibConfigHandler.slimeHarvestlevel.get(), LibConfigHandler.slimeDurability.get(), LibConfigHandler.slimeMiningSpeed.get(), 7, -3.0F, 20, () -> {
        return Ingredient.fromTag(Tags.Items.SLIMEBALLS);
    }, "slime", ModTags.Items.SLIME_BLOCK);

    private final int harvestLevel;
    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final float attackSpeed;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;
    private final String prefix;
    private final Tag<Item> tagIngredient1;
    private final Tag<Item> tagIngredient2;
    private final int durability_modifier = 5;

    BigBreakMaterials(int harvestLevel, int durability, double efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, String prefix, Tag<Item> ingredient1, Tag<Item> ingredient2) {
        this.harvestLevel = harvestLevel;
        this.durability = durability * durability_modifier;
        this.efficiency = (float) efficiency / 3.5F;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.prefix = prefix;
        this.tagIngredient1 = ingredient1;
        this.tagIngredient2 = ingredient2;
    }

    BigBreakMaterials(int harvestLevel, int durability, double efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, String prefix, Tag<Item> ingredient1) {
        this.harvestLevel = harvestLevel;
        this.durability = durability * durability_modifier;
        this.efficiency = (float) efficiency / 3.5F;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.prefix = prefix;
        this.tagIngredient1 = ingredient1;
        this.tagIngredient2 = null;
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

    public Tag<Item> getTagIngredient1() {
        return this.tagIngredient1;
    }

    public Tag<Item> getTagIngredient2() {
        return this.tagIngredient2;
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }

}
