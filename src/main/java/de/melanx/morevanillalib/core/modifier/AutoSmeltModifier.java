package de.melanx.morevanillalib.core.modifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import de.melanx.morevanillalib.FeatureConfig;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import javax.annotation.Nonnull;

public class AutoSmeltModifier extends LootModifier {

    public static final MapCodec<AutoSmeltModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> codecStart(instance).apply(instance, AutoSmeltModifier::new));

    public AutoSmeltModifier(LootItemCondition[] conditions) {
        super(conditions);
    }

    private static ItemStack smelt(ItemStack stack, LootContext context) {
        return context.getLevel().getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(stack), context.getLevel())
                .map(recipe -> recipe.value().getResultItem(context.getLevel().registryAccess()))
                .filter(itemStack -> !itemStack.isEmpty())
                .map(itemStack -> itemStack.copyWithCount(stack.getCount() + itemStack.getCount()))
                .orElse(stack);
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (!FeatureConfig.autoSmelt) return generatedLoot;
        ObjectArrayList<ItemStack> ret = new ObjectArrayList<>();
        generatedLoot.forEach(stack -> ret.add(smelt(stack, context)));
        return ret;
    }

    @Nonnull
    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
