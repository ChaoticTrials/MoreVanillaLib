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
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.FIERY_TOOLS)).build(),
                Inverted.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))).build()
        }));
        this.add("glowstone_drops", ModContent.glowstoneDrops, new GlowstoneToolModifier(new ILootCondition[]{
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.GLOWSTONE_TOOLS)).build(),
                Inverted.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))).build(),
                BlockStateProperty.hasBlockStateProperties(Blocks.GLOWSTONE).build()
        }));
        this.add("double_drops", ModContent.doubleDrops, new DoubleDropModifier(new ILootCondition[]{
                Alternative.alternative(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.DIAMOND_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.COAL_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.EMERALD_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.LAPIS_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.QUARTZ_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.REDSTONE_TOOLS))
                ).build(),
                Inverted.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))).build()
        }));
        this.add("extra_drops", ModContent.extraDrops, new ExtraDropsModifier(new ILootCondition[]{
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.ALL_TOOLS)).build()
        }));
        this.add("head_drops", ModContent.headDrops, new HeadDropModifier(new ILootCondition[]{}));
    }
}
