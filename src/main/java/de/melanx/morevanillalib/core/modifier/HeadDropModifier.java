package de.melanx.morevanillalib.core.modifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.data.ModTags;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import javax.annotation.Nonnull;

public class HeadDropModifier extends LootModifier {

    public static final MapCodec<HeadDropModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> codecStart(instance).apply(instance, HeadDropModifier::new));

    public HeadDropModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        Entity target = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        Entity killer = context.getParamOrNull(LootContextParams.ATTACKING_ENTITY);
        if (target instanceof AbstractSkeleton && killer instanceof LivingEntity) {
            ItemStack weapon = ((LivingEntity) killer).getMainHandItem();
            int looting = weapon.getEnchantmentLevel(context.getLevel().registryAccess().holderOrThrow(Enchantments.LOOTING));

            if (weapon.is(ModTags.Items.BONE_TOOLS) && FeatureConfig.headDrop.test(context.getRandom(), looting / 100F)) {
                Item skull = null;
                if (target instanceof WitherSkeleton) {
                    skull = Items.WITHER_SKELETON_SKULL;
                } else if (target instanceof Skeleton) {
                    skull = Items.SKELETON_SKULL;
                }

                if (skull != null) {
                    generatedLoot.add(new ItemStack(skull));
                }
            }
        }

        return generatedLoot;
    }

    @Nonnull
    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
