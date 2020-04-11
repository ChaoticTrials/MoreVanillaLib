package de.melanx.morevanillalib.api;

import de.melanx.morevanillalib.LibConfigHandler;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraft.util.LazyValue;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum ToolMaterials implements IItemTier {

    BONE(LibConfigHandler.boneDurability.get(), LibConfigHandler.boneMiningSpeed.get(), 2, LibConfigHandler.boneHarvestlevel.get(), 17, () -> RepairMaterialsList.bone, Tags.Items.BONES),
    COAL(LibConfigHandler.coalDurability.get(), LibConfigHandler.coalMiningSpeed.get(), 2, LibConfigHandler.coalHarvestlevel.get(), 17, () -> RepairMaterialsList.coal, Tags.Items.STORAGE_BLOCKS_COAL),
    EMERALD(LibConfigHandler.emeraldDurability.get(), LibConfigHandler.emeraldMiningSpeed.get(), 4, LibConfigHandler.emeraldHarvestlevel.get(), 25, () -> RepairMaterialsList.emerald, Tags.Items.GEMS_EMERALD),
    ENDER(LibConfigHandler.enderDurability.get(), LibConfigHandler.enderMiningSpeed.get(), 5, LibConfigHandler.enderHarvestlevel.get(), 10, () -> RepairMaterialsList.ender, Tags.Items.END_STONES),
    FIERY(LibConfigHandler.fieryDurability.get(), LibConfigHandler.fieryMiningSpeed.get(), 2, LibConfigHandler.fieryHarvestlevel.get(), 15, () -> RepairMaterialsList.fiery, ModTags.Items.MAGMA_CREAM),
    GLOWSTONE(LibConfigHandler.glowstoneDurability.get(), LibConfigHandler.glowstoneMiningSpeed.get(), 2.5F, LibConfigHandler.glowstoneHarvestlevel.get(), 35, () -> RepairMaterialsList.glowstone, Tags.Items.DUSTS_GLOWSTONE),
    LAPIS(LibConfigHandler.lapisDurability.get(), LibConfigHandler.lapisMiningSpeed.get(), 1.5F, LibConfigHandler.lapisHarvestlevel.get(), 20, () -> RepairMaterialsList.lapis, Tags.Items.GEMS_LAPIS),
    NETHER(LibConfigHandler.netherDurability.get(), LibConfigHandler.netherMiningSpeed.get(), 2, LibConfigHandler.netherHarvestlevel.get(), 66, () -> RepairMaterialsList.nether, Tags.Items.NETHERRACK),
    OBSIDIAN(LibConfigHandler.obsidianDurability.get(), LibConfigHandler.obsidianMiningSpeed.get(), 2.5F, LibConfigHandler.obsidianHarvestlevel.get(), 15, () -> RepairMaterialsList.obsidian, Tags.Items.OBSIDIAN), // todo add obsidian shards
    PAPER(LibConfigHandler.paperDurability.get(), LibConfigHandler.paperMiningSpeed.get(), 0, LibConfigHandler.paperHarvestlevel.get(), 17, () -> RepairMaterialsList.paper, ModTags.Items.PAPER),
    PRISMARINE(LibConfigHandler.prismarineDurability.get(), LibConfigHandler.prismarineMiningSpeed.get(), 3, LibConfigHandler.prismarineHarvestlevel.get(), 20, () -> RepairMaterialsList.prismarine, Tags.Items.DUSTS_PRISMARINE),
    QUARTZ(LibConfigHandler.quartzDurability.get(), LibConfigHandler.quartzMiningSpeed.get(), 2, LibConfigHandler.quartzHarvestlevel.get(), 18, () -> RepairMaterialsList.quartz, Tags.Items.GEMS_QUARTZ),
    REDSTONE(LibConfigHandler.redstoneDurability.get(), LibConfigHandler.redstoneMiningSpeed.get(), 1.5F, LibConfigHandler.redstoneHarvestlevel.get(), 20, () -> RepairMaterialsList.redstone, Tags.Items.DUSTS_REDSTONE),
    SLIME(LibConfigHandler.slimeDurability.get(), LibConfigHandler.slimeMiningSpeed.get(), 2, LibConfigHandler.slimeHarvestlevel.get(), 20, () -> RepairMaterialsList.slime, Tags.Items.SLIMEBALLS);

    private final int durability;
    private final float efficiency;
    private final float attackDamage;
    private final int harvestLevel;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;
    private final Tag<Item> ingredient;

    ToolMaterials(int durability, double efficiency, float attackDamage, int harvestLevel, int enchantability, Supplier<Ingredient> repairMaterial, Tag<Item> ingredient) {
        this.durability = durability;
        this.efficiency = (float) efficiency;
        this.attackDamage = attackDamage;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
        this.ingredient = ingredient;
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

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    public Tag<Item> getIngredient() {
        return this.ingredient;
    }

}
