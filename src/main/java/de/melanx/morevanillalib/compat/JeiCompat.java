package de.melanx.morevanillalib.compat;

import de.melanx.morevanillalib.LibConfigHandler;
import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.api.BigBreakMaterials;
import de.melanx.morevanillalib.data.ModTags;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@JeiPlugin
public class JeiCompat implements IModPlugin {
    private static final ResourceLocation PLUGIN_UID = new ResourceLocation(MoreVanillaLib.MODID, "plugin/main");

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_UID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        addDefaultInfoPage(registration, ModTags.Items.BONE_TOOLS.getAllElements(), "bone_tools", LibConfigHandler.boneDurability.get(), LibConfigHandler.boneDurability.get() * 5, LibConfigHandler.boneHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.BONE.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.COAL_TOOLS.getAllElements(), "coal_tools", LibConfigHandler.coalDurability.get(), LibConfigHandler.coalDurability.get() * 5, LibConfigHandler.coalHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.COAL.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.EMERALD_TOOLS.getAllElements(), "emerald_tools", LibConfigHandler.emeraldDurability.get(), LibConfigHandler.emeraldDurability.get() * 5, LibConfigHandler.emeraldHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.EMERALD.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.ENDER_TOOLS.getAllElements(), "ender_tools", LibConfigHandler.enderDurability.get(), LibConfigHandler.enderDurability.get() * 5, LibConfigHandler.enderHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.ENDER.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.FIERY_TOOLS.getAllElements(), "fiery_tools", LibConfigHandler.fieryDurability.get(), LibConfigHandler.fieryDurability.get() * 5, LibConfigHandler.fieryHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.FIERY.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.GLOWSTONE_TOOLS.getAllElements(), "glowstone_tools", LibConfigHandler.glowstoneDurability.get(), LibConfigHandler.glowstoneDurability.get() * 5, LibConfigHandler.glowstoneHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.GLOWSTONE.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.LAPIS_TOOLS.getAllElements(), "lapis_tools", LibConfigHandler.lapisDurability.get(), LibConfigHandler.lapisDurability.get() * 5, LibConfigHandler.lapisHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.LAPIS.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.NETHER_TOOLS.getAllElements(), "nether_tools", LibConfigHandler.netherDurability.get(), LibConfigHandler.netherDurability.get() * 5, LibConfigHandler.netherHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.NETHER.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.OBSIDIAN_TOOLS.getAllElements(), "obsidian_tools", LibConfigHandler.obsidianDurability.get(), LibConfigHandler.obsidianDurability.get() * 5, LibConfigHandler.obsidianHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.OBSIDIAN.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.PAPER_TOOLS.getAllElements(), "paper_tools", LibConfigHandler.paperDurability.get(), LibConfigHandler.paperDurability.get() * 5, LibConfigHandler.paperHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.PAPER.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.PRISMARINE_TOOLS.getAllElements(), "prismarine_tools", LibConfigHandler.prismarineDurability.get(), LibConfigHandler.prismarineDurability.get() * 5, LibConfigHandler.prismarineHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.PRISMARINE.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.QUARTZ_TOOLS.getAllElements(), "quartz_tools", LibConfigHandler.quartzDurability.get(), LibConfigHandler.quartzDurability.get() * 5, LibConfigHandler.quartzHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.QUARTZ.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.REDSTONE_TOOLS.getAllElements(), "redstone_tools", LibConfigHandler.redstoneDurability.get(), LibConfigHandler.redstoneDurability.get() * 5, LibConfigHandler.redstoneHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.REDSTONE.getRepairMaterial()));
        addDefaultInfoPage(registration, ModTags.Items.SLIME_TOOLS.getAllElements(), "slime_tools", LibConfigHandler.slimeDurability.get(), LibConfigHandler.slimeDurability.get() * 5, LibConfigHandler.slimeHarvestlevel.get(), getItemFromIngredient(BigBreakMaterials.SLIME.getRepairMaterial()));

        if (LibConfigHandler.extraDrop.get()) {
            float chance = (float) LibConfigHandler.extraDropChance.get() / 10;
            if (LibConfigHandler.coalDoubleDrop.get())
                addValueInfoPage(registration, ModTags.Items.COAL_TOOLS.getAllElements(), "coal_drop", chance);
            if (LibConfigHandler.emeraldDoubleDrop.get())
                addValueInfoPage(registration, ModTags.Items.EMERALD_TOOLS.getAllElements(), "emerald_drop", chance);
            if (LibConfigHandler.lapisDoubleDrop.get())
                addValueInfoPage(registration, ModTags.Items.LAPIS_TOOLS.getAllElements(), "lapis_drop", chance);
            if (LibConfigHandler.quartzDoubleDrop.get())
                addValueInfoPage(registration, ModTags.Items.QUARTZ_TOOLS.getAllElements(), "quartz_drop", chance);
            if (LibConfigHandler.redstoneDoubleDrop.get())
                addValueInfoPage(registration, ModTags.Items.REDSTONE_TOOLS.getAllElements(), "redstone_drop", chance);
        }

        if (LibConfigHandler.extraDamage.get()) {
            float extraDamageChance = (float) LibConfigHandler.extraDamageChance.get() / 10;
            addValueInfoPage(registration, ModTags.Items.BONE_TOOLS.getAllElements(), "bone_damage", extraDamageChance);
            addValueInfoPage(registration, ModTags.Items.ENDER_TOOLS.getAllElements(), "ender_damage", extraDamageChance);
            addValueInfoPage(registration, ModTags.Items.FIERY_TOOLS.getAllElements(), "fiery_damage", extraDamageChance);
            addValueInfoPage(registration, ModTags.Items.PRISMARINE_TOOLS.getAllElements(), "prismarine_damage", extraDamageChance);
            addValueInfoPage(registration, ModTags.Items.SLIME_TOOLS.getAllElements(), "slime_damage", extraDamageChance);
        }

        if (LibConfigHandler.headDrop.get()) {
            addValueInfoPage(registration, ModTags.Items.BONE_TOOLS.getAllElements(), "bone_heads", (float) LibConfigHandler.headDropChance.get() / 10);
        }

        if (LibConfigHandler.damageByPaperTools.get()) {
            add3ValueInfoPage(registration, ModTags.Items.PAPER_TOOLS.getAllElements(), "paper_damage", (float) LibConfigHandler.damageByPaperToolsChance.get() / 10, (float) LibConfigHandler.minPaperDamage.get() / 2, (float) LibConfigHandler.maxPaperDamage.get() / 2);
        }

        if (LibConfigHandler.autoSmelt.get()) {
            addInfoPage(registration, ModTags.Items.FIERY_TOOLS.getAllElements(), "fiery_smelt");
        }
    }

    private static void addInfoPage(IRecipeRegistration reg, Collection<Item> items, String name) {
        String key = getDescKey(new ResourceLocation(MoreVanillaLib.MODID, name));
        List<ItemStack> stacks = items.stream().map(ItemStack::new).collect(Collectors.toList());
        reg.addIngredientInfo(stacks, VanillaTypes.ITEM, key);
    }

    private static void addValueInfoPage(IRecipeRegistration reg, Collection<Item> items, String name, float value) {
        String key = getDescKey(new ResourceLocation(MoreVanillaLib.MODID, name));
        List<ItemStack> stacks = items.stream().map(ItemStack::new).collect(Collectors.toList());
        reg.addIngredientInfo(stacks, VanillaTypes.ITEM, I18n.format(key, value));
    }

    private static void add3ValueInfoPage(IRecipeRegistration reg, Collection<Item> items, String name, float value, float value2, float value3) {
        String key = getDescKey(new ResourceLocation(MoreVanillaLib.MODID, name));
        List<ItemStack> stacks = items.stream().map(ItemStack::new).collect(Collectors.toList());
        reg.addIngredientInfo(stacks, VanillaTypes.ITEM, I18n.format(key, value, value2, value3));
    }

    private static void addDefaultInfoPage(IRecipeRegistration reg, Collection<Item> items, String name, int durability, int durabilityBigItems, int harvestLevel, Item repairMaterial) {
        String key = getDescKey(new ResourceLocation(MoreVanillaLib.MODID, name));
        List<ItemStack> stacks = items.stream().map(ItemStack::new).collect(Collectors.toList());
        reg.addIngredientInfo(stacks, VanillaTypes.ITEM, I18n.format(key, durability, durabilityBigItems, harvestLevel, repairMaterial));
    }

    private static String getDescKey(ResourceLocation name) {
        return "jei." + name.getNamespace() + "." + name.getPath() + ".desc";
    }

    private static Item getItemFromIngredient(Ingredient ingredient) {
        return ingredient.getMatchingStacks()[0].getItem();
    }
}
