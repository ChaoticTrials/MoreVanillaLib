package de.melanx.morevanillalib.core.modifier;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import de.melanx.morevanillalib.FeatureConfig;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;

public class ExtraDropsModifier extends LootModifier {

    public static final Codec<ExtraDropsModifier> CODEC = RecordCodecBuilder.create(instance -> codecStart(instance).apply(instance, ExtraDropsModifier::new));

    public ExtraDropsModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
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

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
