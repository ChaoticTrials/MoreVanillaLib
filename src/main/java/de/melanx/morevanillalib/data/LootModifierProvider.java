package de.melanx.morevanillalib.data;

import de.melanx.morevanillalib.MoreVanillaLib;
import de.melanx.morevanillalib.core.modifier.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import org.moddingx.libx.datagen.DatagenContext;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class LootModifierProvider extends GlobalLootModifierProvider {

    public LootModifierProvider(DatagenContext context) {
        super(context.output(), CompletableFuture.completedFuture(context.registries().registryAccess()), MoreVanillaLib.getInstance().modid);
    }

    @Override
    protected void start() {
        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistry = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        this.add("auto_smelt", new AutoSmeltModifier(new LootItemCondition[]{
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.FIERY_TOOLS)).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().withSubPredicate(
                        ItemSubPredicates.ENCHANTMENTS,
                        ItemEnchantmentsPredicate.enchantments(
                                List.of(new EnchantmentPredicate(enchantmentRegistry.getOrThrow(Enchantments.SILK_TOUCH), MinMaxBounds.Ints.atLeast(1)))
                        )
                ))).build()
        }));
        this.add("glowstone_drops", new GlowstoneToolModifier(new LootItemCondition[]{
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.GLOWSTONE_TOOLS)).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().withSubPredicate(
                        ItemSubPredicates.ENCHANTMENTS,
                        ItemEnchantmentsPredicate.enchantments(
                                List.of(new EnchantmentPredicate(enchantmentRegistry.getOrThrow(Enchantments.SILK_TOUCH), MinMaxBounds.Ints.atLeast(1)))
                        )
                ))).build(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GLOWSTONE).build()
        }));
        this.add("double_drops", new DoubleDropModifier(new LootItemCondition[]{
                AnyOfCondition.anyOf(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.DIAMOND_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.COAL_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.EMERALD_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.LAPIS_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.QUARTZ_TOOLS)),
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.REDSTONE_TOOLS))
                ).build(),
                InvertedLootItemCondition.invert(MatchTool.toolMatches(ItemPredicate.Builder.item().withSubPredicate(
                        ItemSubPredicates.ENCHANTMENTS,
                        ItemEnchantmentsPredicate.enchantments(
                                List.of(new EnchantmentPredicate(enchantmentRegistry.getOrThrow(Enchantments.SILK_TOUCH), MinMaxBounds.Ints.atLeast(1)))
                        )
                ))).build()
        }));
        this.add("extra_drops", new ExtraDropsModifier(new LootItemCondition[]{
                MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.ALL_TOOLS)).build()
        }));
        this.add("head_drops", new HeadDropModifier(new LootItemCondition[]{}));
    }
}
