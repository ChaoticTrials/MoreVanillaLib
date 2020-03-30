package de.melanx.morevanillalib.api;

import de.melanx.morevanillalib.LibConfigHandler;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.LazyValue;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum BigBreakMaterials implements IItemTier {

    WOOD(0, 59, 2.0F / 3.5f, 3, -2.5F, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }, ItemTags.PLANKS, ItemTags.LOGS),
    STONE(1, 131, 4.0F / 3.5f, 4, -2.6F, 5, () -> {
        return Ingredient.fromTag(Tags.Items.COBBLESTONE);
    }, Tags.Items.COBBLESTONE, Tags.Items.STONE),
    IRON(2, 250, 6.0F / 3.5f, 5, -2.8F, 14, () -> {
        return Ingredient.fromTag(Tags.Items.INGOTS_IRON);
    }, Tags.Items.INGOTS_IRON, Tags.Items.STORAGE_BLOCKS_IRON),
    GOLD(0, 32, 12.0F / 3.5f, 5, -2.5F, 22, () -> {
        return Ingredient.fromTag(Tags.Items.INGOTS_GOLD);
    }, Tags.Items.INGOTS_GOLD, Tags.Items.STORAGE_BLOCKS_GOLD),
    DIAMOND(3, 1561, 8.0F / 3.5f, 10, -3.0F, 10, () -> {
        return Ingredient.fromTag(Tags.Items.GEMS_DIAMOND);
    }, Tags.Items.GEMS_DIAMOND, Tags.Items.STORAGE_BLOCKS_DIAMOND),

    BONE(LibConfigHandler.boneHarvestlevel.get(), LibConfigHandler.boneDurability.get(), 4.9F / 3.5F, 4, -2.0F, 17, () -> {
        return Ingredient.fromTag(Tags.Items.BONES);
    }, ModTags.Items.BONE_BLOCK),
    COAL(LibConfigHandler.coalHarvestlevel.get(), LibConfigHandler.coalDurability.get(), 4.9F / 3.5F, 4, -2.6F, 17, () -> {
        return Ingredient.fromTag(ModTags.Items.GEMS_COAL);
    }, Tags.Items.STORAGE_BLOCKS_COAL),
    EMERALD(LibConfigHandler.emeraldHarvestlevel.get(), LibConfigHandler.emeraldDurability.get(), 12.0F / 3.5f, 11, -3.0F, 25, () -> {
        return Ingredient.fromTag(Tags.Items.GEMS_EMERALD);
    }, Tags.Items.GEMS_EMERALD, Tags.Items.STORAGE_BLOCKS_EMERALD),
    ENDER(LibConfigHandler.enderHarvestlevel.get(), LibConfigHandler.enderDurability.get(), 10f / 3.5f, 10, -3.3F, 10, () -> {
        return Ingredient.fromTag(Tags.Items.ENDER_PEARLS);
    }, ModTags.Items.DRAGON_HEAD, Tags.Items.END_STONES),
    FIERY(LibConfigHandler.fieryHarvestlevel.get(), LibConfigHandler.fieryDurability.get(), 7.0F / 3.5f, 6, -2.3F, 15, () -> {
        return Ingredient.fromTag(ModTags.Items.MAGMA_BLOCK);
    }, ModTags.Items.MAGMA_BLOCK),
    GLOWSTONE(LibConfigHandler.glowstoneHarvestlevel.get(), LibConfigHandler.glowstoneDurability.get(), 5.0F / 3.5f, 5, -2.3F, 35, () -> {
        return Ingredient.fromTag(ModTags.Items.STORAGE_BLOCKS_GLOWSTONE);
    }, ModTags.Items.STORAGE_BLOCKS_GLOWSTONE),
    LAPIS(LibConfigHandler.lapisHarvestlevel.get(), LibConfigHandler.lapisDurability.get(), 6.0f / 3.5f, 3, -2.5F, 20, () -> {
        return Ingredient.fromTag(Tags.Items.GEMS_LAPIS);
    }, Tags.Items.STORAGE_BLOCKS_LAPIS),
    NETHER(LibConfigHandler.netherHarvestlevel.get(), LibConfigHandler.netherDurability.get(), 5.0F / 3.5f, 4, -2.1F, 66, () -> {
        return Ingredient.fromTag(ModTags.Items.NETHER_BRICKS);
    }, ModTags.Items.NETHER_BRICKS),
    OBSIDIAN(LibConfigHandler.obsidianHarvestlevel.get(), LibConfigHandler.obsidianDurability.get(), 5.0F / 3.5f, 7, -3.5F, 15, () -> {
        return Ingredient.fromTag(Tags.Items.OBSIDIAN);
    }, Tags.Items.OBSIDIAN),
    PAPER(LibConfigHandler.paperHarvestlevel.get(), LibConfigHandler.paperDurability.get(), 1.8F / 3.5F, 0, -3.0F, 17, () -> {
        return Ingredient.fromTag(ModTags.Items.PAPER);
    }, ModTags.Items.PAPER),
    PRISMARINE(LibConfigHandler.prismarineHarvestlevel.get(), LibConfigHandler.prismarineDurability.get(), 7.0F / 3.5F, 6, -2.3F, 20, () -> {
        return Ingredient.fromTag(Tags.Items.DUSTS_PRISMARINE);
    }, ModTags.Items.PRISMARINE),
    QUARTZ(LibConfigHandler.quartzHarvestlevel.get(), LibConfigHandler.quartzDurability.get(), 8.0F / 3.5f, 5, -2.0F, 18, () -> {
        return Ingredient.fromTag(Tags.Items.GEMS_QUARTZ);
    }, Tags.Items.STORAGE_BLOCKS_QUARTZ),
    REDSTONE(LibConfigHandler.redstoneHarvestlevel.get(), LibConfigHandler.redstoneDurability.get(), 6.0F / 3.5F, 3, -2.5F, 20, () -> {
        return Ingredient.fromTag(Tags.Items.DUSTS_REDSTONE);
    }, Tags.Items.STORAGE_BLOCKS_REDSTONE),
    SLIME(LibConfigHandler.slimeHarvestlevel.get(), LibConfigHandler.slimeDurability.get(), 6f / 3.5f, 7, -3.0F, 20, () -> {
        return Ingredient.fromTag(Tags.Items.SLIMEBALLS);
    }, ModTags.Items.SLIME_BLOCK);

    private final int harvestLevel;
    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final float attackSpeed;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;
    private final Tag<Item> tagIngredient1;
    private final Tag<Item> tagIngredient2;
    private final int durability_modifier = 5;

    BigBreakMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, Tag<Item> ingredient1, Tag<Item> ingredient2) {
        this.harvestLevel = harvestLevel;
        this.durability = durability * durability_modifier;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.tagIngredient1 = ingredient1;
        this.tagIngredient2 = ingredient2;
    }

    BigBreakMaterials(int harvestLevel, int durability, float efficiency, float attackDamage, float attackSpeed, int enchantability, Supplier<Ingredient> repairMaterial, Tag<Item> ingredient1) {
        this.harvestLevel = harvestLevel;
        this.durability = durability * durability_modifier;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
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
