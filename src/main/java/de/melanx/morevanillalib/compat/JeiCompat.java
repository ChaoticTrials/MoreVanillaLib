package de.melanx.morevanillalib.compat;

import de.melanx.morevanillalib.LibCommonConfig;
import de.melanx.morevanillalib.LibConfigHandler;
import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.api.BigBreakMaterials;
import de.melanx.morevanillalib.api.ToolMaterials;
import de.melanx.morevanillalib.data.ModTags;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@JeiPlugin
public class JeiCompat implements IModPlugin {
    public static final ResourceLocation PLUGIN_UID = new ResourceLocation(MoreVanillaLib.MODID, "plugin/main");

    private static void addInfoPage(IRecipeRegistration reg, Collection<Item> items, String name) {
        if (items.isEmpty()) return;
        String key = getDescKey(new ResourceLocation(MoreVanillaLib.MODID, name));
        List<ItemStack> stacks = items.stream().map(ItemStack::new).collect(Collectors.toList());
        reg.addIngredientInfo(stacks, VanillaTypes.ITEM, key);
    }

    public static void addValueInfoPage(IRecipeRegistration reg, Item item, String name, Object... values) {
        Collection<Item> items = Collections.singletonList(item);
        addValueInfoPage(reg, items, name, values);
    }

    private static void addValueInfoPage(IRecipeRegistration reg, Collection<Item> items, String name, Object... values) {
        if (items.isEmpty()) return;
        String key = getDescKey(new ResourceLocation(MoreVanillaLib.MODID, name));
        List<ItemStack> stacks = items.stream().map(ItemStack::new).collect(Collectors.toList());
        reg.addIngredientInfo(stacks, VanillaTypes.ITEM, I18n.format(key, values));
    }

    private static String getDescKey(ResourceLocation name) {
        return "jei." + name.getNamespace() + "." + name.getPath() + ".desc";
    }

    private static Item getItemFromIngredient(Ingredient ingredient) {
        return ingredient.getMatchingStacks()[0].getItem();
    }

    @Nonnull
    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_UID;
    }

    @Override
    public void registerRecipes(@Nonnull IRecipeRegistration registration) {
        addValueInfoPage(registration, ModTags.Items.WOOD_TOOLS.getAllElements(), "wood_tools",
                ItemTier.WOOD.getMaxUses(),
                BigBreakMaterials.WOOD.getMaxUses(),
                LibConfigHandler.woodHarvestlevel.get(),
                getItemFromIngredient(ItemTier.WOOD.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.STONE_TOOLS.getAllElements(), "stone_tools",
                ItemTier.STONE.getMaxUses(),
                BigBreakMaterials.STONE.getMaxUses(),
                LibConfigHandler.stoneHarvestlevel.get(),
                getItemFromIngredient(ItemTier.STONE.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.IRON_TOOLS.getAllElements(), "iron_tools",
                ItemTier.IRON.getMaxUses(),
                BigBreakMaterials.IRON.getMaxUses(),
                LibConfigHandler.ironHarvestlevel.get(),
                getItemFromIngredient(ItemTier.IRON.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.GOLD_TOOLS.getAllElements(), "gold_tools",
                ItemTier.GOLD.getMaxUses(),
                BigBreakMaterials.GOLD.getMaxUses(),
                LibConfigHandler.goldHarvestlevel.get(),
                getItemFromIngredient(ItemTier.GOLD.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.DIAMOND_TOOLS.getAllElements(), "diamond_tools",
                ItemTier.DIAMOND.getMaxUses(),
                BigBreakMaterials.DIAMOND.getMaxUses(),
                LibConfigHandler.diamondHarvestlevel.get(),
                getItemFromIngredient(ItemTier.DIAMOND.getRepairMaterial()).getName().getString());
        addValueInfoPage(registration, ModTags.Items.NETHERITE_TOOLS.getAllElements(), "netherite_tools",
                ItemTier.NETHERITE.getMaxUses(),
                BigBreakMaterials.NETHERITE.getMaxUses(),
                LibConfigHandler.netheriteHarvestlevel.get(),
                getItemFromIngredient(ItemTier.NETHERITE.getRepairMaterial()).getName().getString());
        if (!LibCommonConfig.vanilla.get()) {
            addValueInfoPage(registration, ModTags.Items.BONE_TOOLS.getAllElements(), "bone_tools",
                    ToolMaterials.BONE.getMaxUses(),
                    BigBreakMaterials.BONE.getMaxUses(),
                    LibConfigHandler.boneHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.BONE.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.COAL_TOOLS.getAllElements(), "coal_tools",
                    ToolMaterials.COAL.getMaxUses(),
                    BigBreakMaterials.COAL.getMaxUses(),
                    LibConfigHandler.coalHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.COAL.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.EMERALD_TOOLS.getAllElements(), "emerald_tools",
                    ToolMaterials.EMERALD.getMaxUses(),
                    BigBreakMaterials.EMERALD.getMaxUses(),
                    LibConfigHandler.emeraldHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.EMERALD.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.ENDER_TOOLS.getAllElements(), "ender_tools",
                    ToolMaterials.ENDER.getMaxUses(),
                    BigBreakMaterials.ENDER.getMaxUses(),
                    LibConfigHandler.enderHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.ENDER.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.FIERY_TOOLS.getAllElements(), "fiery_tools",
                    ToolMaterials.FIERY.getMaxUses(),
                    BigBreakMaterials.FIERY.getMaxUses(),
                    LibConfigHandler.fieryHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.FIERY.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.GLOWSTONE_TOOLS.getAllElements(), "glowstone_tools",
                    ToolMaterials.GLOWSTONE.getMaxUses(),
                    BigBreakMaterials.GLOWSTONE.getMaxUses(),
                    LibConfigHandler.glowstoneHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.GLOWSTONE.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.LAPIS_TOOLS.getAllElements(), "lapis_tools",
                    ToolMaterials.LAPIS.getMaxUses(),
                    BigBreakMaterials.LAPIS.getMaxUses(),
                    LibConfigHandler.lapisHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.LAPIS.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.NETHER_TOOLS.getAllElements(), "nether_tools",
                    ToolMaterials.NETHER.getMaxUses(),
                    BigBreakMaterials.NETHER.getMaxUses(),
                    LibConfigHandler.netherHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.NETHER.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.OBSIDIAN_TOOLS.getAllElements(), "obsidian_tools",
                    ToolMaterials.OBSIDIAN.getMaxUses(),
                    BigBreakMaterials.OBSIDIAN.getMaxUses(),
                    LibConfigHandler.obsidianHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.OBSIDIAN.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.PAPER_TOOLS.getAllElements(), "paper_tools",
                    ToolMaterials.PAPER.getMaxUses(),
                    BigBreakMaterials.PAPER.getMaxUses(),
                    LibConfigHandler.paperHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.PAPER.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.PRISMARINE_TOOLS.getAllElements(), "prismarine_tools",
                    ToolMaterials.PRISMARINE.getMaxUses(),
                    BigBreakMaterials.PRISMARINE.getMaxUses(),
                    LibConfigHandler.prismarineHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.PRISMARINE.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.QUARTZ_TOOLS.getAllElements(), "quartz_tools",
                    ToolMaterials.QUARTZ.getMaxUses(),
                    BigBreakMaterials.QUARTZ.getMaxUses(),
                    LibConfigHandler.quartzHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.QUARTZ.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.REDSTONE_TOOLS.getAllElements(), "redstone_tools",
                    ToolMaterials.REDSTONE.getMaxUses(),
                    BigBreakMaterials.REDSTONE.getMaxUses(),
                    LibConfigHandler.redstoneHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.REDSTONE.getRepairMaterial()).getName().getString());
            addValueInfoPage(registration, ModTags.Items.SLIME_TOOLS.getAllElements(), "slime_tools",
                    ToolMaterials.SLIME.getMaxUses(),
                    BigBreakMaterials.SLIME.getMaxUses(),
                    LibConfigHandler.slimeHarvestlevel.get(),
                    getItemFromIngredient(BigBreakMaterials.SLIME.getRepairMaterial()).getName().getString());

            if (LibConfigHandler.extraDrop.get())
                addValueInfoPage(registration, ModTags.Items.ALL_TOOLS.getAllElements(), "extra_drop", LibConfigHandler.extraDropChance.get() * 100);

            if (LibConfigHandler.extraDamage.get()) {
                double extraDamageChance = LibConfigHandler.extraDamageChance.get() * 100;
                addValueInfoPage(registration, ModTags.Items.BONE_TOOLS.getAllElements(), "bone_damage", extraDamageChance);
                addValueInfoPage(registration, ModTags.Items.ENDER_TOOLS.getAllElements(), "ender_damage", extraDamageChance);
                addValueInfoPage(registration, ModTags.Items.FIERY_TOOLS.getAllElements(), "fiery_damage", extraDamageChance);
                addValueInfoPage(registration, ModTags.Items.PRISMARINE_TOOLS.getAllElements(), "prismarine_damage", extraDamageChance);
                addValueInfoPage(registration, ModTags.Items.SLIME_TOOLS.getAllElements(), "slime_damage", extraDamageChance);
            }

            if (LibConfigHandler.headDrop.get()) {
                addValueInfoPage(registration, ModTags.Items.BONE_TOOLS.getAllElements(), "bone_heads",
                        LibConfigHandler.headDropChance.get() * 100);
            }

            if (LibConfigHandler.damageByPaperTools.get()) {
                addValueInfoPage(registration, ModTags.Items.PAPER_TOOLS.getAllElements(), "paper_damage",
                        LibConfigHandler.damageByPaperToolsChance.get() * 100,
                        (double) LibConfigHandler.minPaperDamage.get() / 2,
                        (double) LibConfigHandler.maxPaperDamage.get() / 2);
            }

            if (LibConfigHandler.autoSmelt.get()) {
                addInfoPage(registration, ModTags.Items.FIERY_TOOLS.getAllElements(), "fiery_smelt");
            }

            if (LibConfigHandler.glowstoneDrops.get()) {
                addInfoPage(registration, ModTags.Items.GLOWSTONE_TOOLS.getAllElements(), "glowstone_drops");
            }
        }
    }
}
