package de.melanx.morevanillalib.core.modifier;

import com.google.gson.JsonObject;
import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;

public class HeadDropModifier extends LootModifier {

    public HeadDropModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        Entity target = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        Entity killer = context.getParamOrNull(LootContextParams.KILLER_ENTITY);
        if (target instanceof AbstractSkeleton && killer instanceof LivingEntity) {
            ItemStack weapon = ((LivingEntity) killer).getMainHandItem();
            int looting = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MOB_LOOTING, weapon);

            if (ModTags.Items.BONE_TOOLS.contains(weapon.getItem()) && FeatureConfig.HeadDrop.enabled && context.getRandom().nextDouble() < FeatureConfig.HeadDrop.chance + (looting / 100F)) {
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

    public static class Serializer extends GlobalLootModifierSerializer<HeadDropModifier> {

        @Override
        public HeadDropModifier read(ResourceLocation name, JsonObject json, LootItemCondition[] conditions) {
            return new HeadDropModifier(conditions);
        }

        @Override
        public JsonObject write(HeadDropModifier instance) {
            return this.makeConditions(instance.conditions);
        }
    }
}
