package de.melanx.morevanillalib.core.modifier;

import com.google.gson.JsonObject;
import de.melanx.morevanillalib.FeatureConfig;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nonnull;

public class AutoSmeltModifier extends LootModifier {

    public AutoSmeltModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    private static ItemStack smelt(ItemStack stack, LootContext context) {
        return context.getLevel().getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(stack), context.getLevel())
                .map(SmeltingRecipe::getResultItem)
                .filter(itemStack -> !itemStack.isEmpty())
                .map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount()))
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

    public static class Serializer extends GlobalLootModifierSerializer<AutoSmeltModifier> {
        @Override
        public AutoSmeltModifier read(ResourceLocation name, JsonObject json, LootItemCondition[] conditionsIn) {
            return new AutoSmeltModifier(conditionsIn);
        }

        @Override
        public JsonObject write(AutoSmeltModifier instance) {
            return this.makeConditions(instance.conditions);
        }
    }
}
