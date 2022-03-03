package de.melanx.morevanillalib.compat;

import com.google.common.collect.Sets;
import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.data.ModTags;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@JeiPlugin
public class JeiCompat implements IModPlugin {
    public static final ResourceLocation PLUGIN_UID = new ResourceLocation(MoreVanillaLib.getInstance().modid, "plugin/main");

    private static void addInfoPage(IRecipeRegistration reg, Collection<Item> items, String name) {
        if (items.isEmpty()) return;
        Component component = getDescKey(new ResourceLocation(MoreVanillaLib.getInstance().modid, name));
        List<ItemStack> stacks = items.stream().map(ItemStack::new).collect(Collectors.toList());
        reg.addIngredientInfo(stacks, VanillaTypes.ITEM, component);
    }

    public static void addValueInfoPage(IRecipeRegistration reg, Item item, String name, Object... values) {
        Collection<Item> items = Collections.singletonList(item);
        addValueInfoPage(reg, items, name, values);
    }

    private static void addValueInfoPage(IRecipeRegistration reg, Collection<Item> items, String name, Object... values) {
        if (items.isEmpty()) return;
        Component component = getDescKey(new ResourceLocation(MoreVanillaLib.getInstance().modid, name), values);
        List<ItemStack> stacks = items.stream().map(ItemStack::new).collect(Collectors.toList());
        reg.addIngredientInfo(stacks, VanillaTypes.ITEM, component);
    }

    private static TranslatableComponent getDescKey(ResourceLocation name) {
        return new TranslatableComponent("jei." + name.getNamespace() + "." + name.getPath() + ".desc");
    }

    private static TranslatableComponent getDescKey(ResourceLocation name, Object... values) {
        return new TranslatableComponent("jei." + name.getNamespace() + "." + name.getPath() + ".desc", values);
    }

    private static Item getItemFromIngredient(Ingredient ingredient) {
        return ingredient.getItems()[0].getItem();
    }

    @Nonnull
    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_UID;
    }

    @Override
    public void registerRecipes(@Nonnull IRecipeRegistration registration) {
        if (!FeatureConfig.vanillaOnly) {
            if (FeatureConfig.ExtraDrop.enabled) {
                addValueInfoPage(registration, this.getValues(ModTags.Items.ALL_TOOLS), "extra_drop", FeatureConfig.ExtraDrop.chance * 100);
            }

            if (FeatureConfig.ExtraDamage.enabled) {
                double extraDamageChance = FeatureConfig.ExtraDamage.chance * 100;
                addValueInfoPage(registration, this.getValues(ModTags.Items.BONE_TOOLS), "bone_damage", extraDamageChance, FeatureConfig.ExtraDamage.maxMultiplier * 100);
                addValueInfoPage(registration, this.getValues(ModTags.Items.ENDER_TOOLS), "ender_damage", extraDamageChance, FeatureConfig.ExtraDamage.maxMultiplier * 100);
                addValueInfoPage(registration, this.getValues(ModTags.Items.FIERY_TOOLS), "fiery_damage", extraDamageChance, FeatureConfig.ExtraDamage.maxMultiplier * 100);
                addValueInfoPage(registration, this.getValues(ModTags.Items.PRISMARINE_TOOLS), "prismarine_damage", extraDamageChance, FeatureConfig.ExtraDamage.maxMultiplier * 100);
                addValueInfoPage(registration, this.getValues(ModTags.Items.SLIME_TOOLS), "slime_damage", extraDamageChance, FeatureConfig.ExtraDamage.maxMultiplier * 100);
            }

            if (FeatureConfig.HeadDrop.enabled) {
                addValueInfoPage(registration, this.getValues(ModTags.Items.BONE_TOOLS), "bone_heads",
                        FeatureConfig.HeadDrop.chance * 100);
            }

            if (FeatureConfig.PaperDamage.enabled) {
                addValueInfoPage(registration, this.getValues(ModTags.Items.PAPER_TOOLS), "paper_damage",
                        FeatureConfig.PaperDamage.chance * 100,
                        FeatureConfig.PaperDamage.minDamage,
                        FeatureConfig.PaperDamage.maxDamage);
            }

            if (FeatureConfig.autoSmelt) {
                addInfoPage(registration, this.getValues(ModTags.Items.FIERY_TOOLS), "fiery_smelt");
            }

            if (FeatureConfig.glowstoneDrops) {
                addInfoPage(registration, this.getValues(ModTags.Items.GLOWSTONE_TOOLS), "glowstone_drops");
            }
        }
    }

    private Collection<Item> getValues(TagKey<Item> key) {
        Set<Item> items = Sets.newHashSet();
        //noinspection deprecation
        for (Holder<Item> itemHolder : Registry.ITEM.getTagOrEmpty(key)) {
            items.add(itemHolder.value());
        }

        return items;
    }
}
