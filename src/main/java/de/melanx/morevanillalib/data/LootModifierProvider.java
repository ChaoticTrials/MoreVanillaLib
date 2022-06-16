package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.ModContent;
import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.core.modifier.*;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import org.moddingx.libx.annotation.data.Datagen;

@Datagen
public class LootModifierProvider extends GlobalLootModifierProvider {

    public LootModifierProvider(DataGenerator generator) {
        super(generator, MoreVanillaLib.getInstance().modid);
    }

    @Override
    protected void start() {
        this.add("auto_smelt", ModContent.autoSmelt, new AutoSmeltModifier(new LootItemCondition[]{
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.FIERY_TOOLS)).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }));
        this.add("glowstone_drops", ModContent.glowstoneDrops, new GlowstoneToolModifier(new LootItemCondition[]{
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.GLOWSTONE_TOOLS)).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GLOWSTONE).build()
        }));
        this.add("double_drops", ModContent.doubleDrops, new DoubleDropModifier(new LootItemCondition[]{
                AlternativeLootItemCondition.alternative(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.DIAMOND_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.COAL_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.EMERALD_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.LAPIS_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.QUARTZ_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.REDSTONE_TOOLS))
                ).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))).build()
        }));
        this.add("extra_drops", ModContent.extraDrops, new ExtraDropsModifier(new LootItemCondition[]{
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.ALL_TOOLS)).build()
        }));
        this.add("head_drops", ModContent.headDrops, new HeadDropModifier(new LootItemCondition[]{}));
    }
}
