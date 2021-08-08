// TODO re-add
//package de.melanx.morevanillalib.compat;
//
//import de.melanx.morevanillalib.MoreVanillaLib;
//import de.melanx.morevanillalib.config.FeatureConfig;
//import de.melanx.morevanillalib.data.ModTags;
//import mezz.jei.api.IModPlugin;
//import mezz.jei.api.JeiPlugin;
//import mezz.jei.api.constants.VanillaTypes;
//import mezz.jei.api.registration.IRecipeRegistration;
//import net.minecraft.client.resources.language.I18n;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.resources.ResourceLocation;
//
//import javax.annotation.Nonnull;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@JeiPlugin
//public class JeiCompat implements IModPlugin {
//    public static final ResourceLocation PLUGIN_UID = new ResourceLocation(MoreVanillaLib.getInstance().modid, "plugin/main");
//
//    private static void addInfoPage(IRecipeRegistration reg, Collection<Item> items, String name) {
//        if (items.isEmpty()) return;
//        String key = getDescKey(new ResourceLocation(MoreVanillaLib.getInstance().modid, name));
//        List<ItemStack> stacks = items.stream().map(ItemStack::new).collect(Collectors.toList());
//        reg.addIngredientInfo(stacks, VanillaTypes.ITEM, key);
//    }
//
//    public static void addValueInfoPage(IRecipeRegistration reg, Item item, String name, Object... values) {
//        Collection<Item> items = Collections.singletonList(item);
//        addValueInfoPage(reg, items, name, values);
//    }
//
//    private static void addValueInfoPage(IRecipeRegistration reg, Collection<Item> items, String name, Object... values) {
//        if (items.isEmpty()) return;
//        String key = getDescKey(new ResourceLocation(MoreVanillaLib.getInstance().modid, name));
//        List<ItemStack> stacks = items.stream().map(ItemStack::new).collect(Collectors.toList());
//        reg.addIngredientInfo(stacks, VanillaTypes.ITEM, I18n.get(key, values));
//    }
//
//    private static String getDescKey(ResourceLocation name) {
//        return "jei." + name.getNamespace() + "." + name.getPath() + ".desc";
//    }
//
//    private static Item getItemFromIngredient(Ingredient ingredient) {
//        return ingredient.getItems()[0].getItem();
//    }
//
//    @Nonnull
//    @Override
//    public ResourceLocation getPluginUid() {
//        return PLUGIN_UID;
//    }
//
//    @Override
//    public void registerRecipes(@Nonnull IRecipeRegistration registration) {
//        if (!FeatureConfig.vanillaOnly) {
//            if (FeatureConfig.ExtraDrop.enabled) {
//                addValueInfoPage(registration, ModTags.Items.ALL_TOOLS.getValues(), "extra_drop", FeatureConfig.ExtraDrop.chance * 100);
//            }
//
//            if (FeatureConfig.ExtraDamage.enabled) {
//                double extraDamageChance = FeatureConfig.ExtraDamage.chance * 100;
//                addValueInfoPage(registration, ModTags.Items.BONE_TOOLS.getValues(), "bone_damage", extraDamageChance, FeatureConfig.ExtraDamage.maxMultiplier * 100);
//                addValueInfoPage(registration, ModTags.Items.ENDER_TOOLS.getValues(), "ender_damage", extraDamageChance, FeatureConfig.ExtraDamage.maxMultiplier * 100);
//                addValueInfoPage(registration, ModTags.Items.FIERY_TOOLS.getValues(), "fiery_damage", extraDamageChance, FeatureConfig.ExtraDamage.maxMultiplier * 100);
//                addValueInfoPage(registration, ModTags.Items.PRISMARINE_TOOLS.getValues(), "prismarine_damage", extraDamageChance, FeatureConfig.ExtraDamage.maxMultiplier * 100);
//                addValueInfoPage(registration, ModTags.Items.SLIME_TOOLS.getValues(), "slime_damage", extraDamageChance, FeatureConfig.ExtraDamage.maxMultiplier * 100);
//            }
//
//            if (FeatureConfig.HeadDrop.enabled) {
//                addValueInfoPage(registration, ModTags.Items.BONE_TOOLS.getValues(), "bone_heads",
//                        FeatureConfig.HeadDrop.chance * 100);
//            }
//
//            if (FeatureConfig.PaperDamage.enabled) {
//                addValueInfoPage(registration, ModTags.Items.PAPER_TOOLS.getValues(), "paper_damage",
//                        FeatureConfig.PaperDamage.chance * 100,
//                        FeatureConfig.PaperDamage.minDamage,
//                        FeatureConfig.PaperDamage.maxDamage);
//            }
//
//            if (FeatureConfig.autoSmelt) {
//                addInfoPage(registration, ModTags.Items.FIERY_TOOLS.getValues(), "fiery_smelt");
//            }
//
//            if (FeatureConfig.glowstoneDrops) {
//                addInfoPage(registration, ModTags.Items.GLOWSTONE_TOOLS.getValues(), "glowstone_drops");
//            }
//        }
//    }
//}
