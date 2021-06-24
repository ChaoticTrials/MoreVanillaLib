package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.ModContent;
import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.core.modifier.*;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.conditions.*;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class LootModifierProvider extends GlobalLootModifierProvider {

    public LootModifierProvider(DataGenerator generator) {
        super(generator, MoreVanillaLib.getInstance().modid);
    }

    @Override
    protected void start() {
        this.add("auto_smelt", ModContent.autoSmelt, new AutoSmeltModifier(new ILootCondition[]{
                MatchTool.builder(ItemPredicate.Builder.create().tag(ModTags.Items.FIERY_TOOLS)).build(),
                Inverted.builder(MatchTool.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))).build()
        }));
        this.add("glowstone_drops", ModContent.glowstoneDrops, new GlowstoneToolModifier(new ILootCondition[]{
                MatchTool.builder(ItemPredicate.Builder.create().tag(ModTags.Items.GLOWSTONE_TOOLS)).build(),
                Inverted.builder(MatchTool.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))).build(),
                BlockStateProperty.builder(Blocks.GLOWSTONE).build()
        }));
        this.add("double_drops", ModContent.doubleDrops, new DoubleDropModifier(new ILootCondition[]{
                Alternative.builder(
                        MatchTool.builder(ItemPredicate.Builder.create().tag(ModTags.Items.DIAMOND_TOOLS)),
                        MatchTool.builder(ItemPredicate.Builder.create().tag(ModTags.Items.COAL_TOOLS)),
                        MatchTool.builder(ItemPredicate.Builder.create().tag(ModTags.Items.EMERALD_TOOLS)),
                        MatchTool.builder(ItemPredicate.Builder.create().tag(ModTags.Items.LAPIS_TOOLS)),
                        MatchTool.builder(ItemPredicate.Builder.create().tag(ModTags.Items.QUARTZ_TOOLS)),
                        MatchTool.builder(ItemPredicate.Builder.create().tag(ModTags.Items.REDSTONE_TOOLS))
                ).build(),
                Inverted.builder(MatchTool.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))).build()
        }));
        this.add("extra_drops", ModContent.extraDrops, new ExtraDropsModifier(new ILootCondition[]{
                MatchTool.builder(ItemPredicate.Builder.create().tag(ModTags.Items.ALL_TOOLS)).build()
        }));
        this.add("head_drops", ModContent.headDrops, new HeadDropModifier(new ILootCondition[]{}));
    }
}
