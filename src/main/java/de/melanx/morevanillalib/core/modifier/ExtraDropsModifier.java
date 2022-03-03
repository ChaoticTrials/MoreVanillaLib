package de.melanx.morevanillalib.core.modifier;

import com.google.gson.JsonObject;
import de.melanx.morevanillalib.config.FeatureConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;

public class ExtraDropsModifier extends LootModifier {

    public ExtraDropsModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        ItemStack tool = context.getParamOrNull(LootContextParams.TOOL);
        if (tool == null) {
            Entity killer = context.getParamOrNull(LootContextParams.KILLER_ENTITY);
            if (killer instanceof LivingEntity) {
                tool = ((LivingEntity) killer).getMainHandItem();
            }
        }

        if (tool != null && tool.getItem() instanceof DiggerItem && FeatureConfig.ExtraDrop.enabled && context.getRandom().nextDouble() < FeatureConfig.ExtraDrop.chance) {
            Ingredient repairMaterial = ((DiggerItem) tool.getItem()).getTier().getRepairIngredient();
            generatedLoot.add(repairMaterial.getItems()[0].copy());
        }

        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<ExtraDropsModifier> {

        @Override
        public ExtraDropsModifier read(ResourceLocation name, JsonObject json, LootItemCondition[] conditions) {
            return new ExtraDropsModifier(conditions);
        }

        @Override
        public JsonObject write(ExtraDropsModifier instance) {
            return this.makeConditions(instance.conditions);
        }
    }
}
