package de.melanx.morevanillalib.core.modifier;

import com.google.gson.JsonObject;
import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;

public class HeadDropModifier extends LootModifier {

    public HeadDropModifier(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        Entity target = context.getParamOrNull(LootParameters.THIS_ENTITY);
        Entity killer = context.getParamOrNull(LootParameters.KILLER_ENTITY);
        if (target instanceof AbstractSkeletonEntity && killer instanceof LivingEntity) {
            ItemStack weapon = ((LivingEntity) killer).getMainHandItem();
            int looting = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MOB_LOOTING, weapon);

            if (ModTags.Items.BONE_TOOLS.contains(weapon.getItem()) && FeatureConfig.HeadDrop.enabled && context.getRandom().nextDouble() < FeatureConfig.HeadDrop.chance + (looting / 100F)) {
                Item skull = null;
                if (target instanceof WitherSkeletonEntity) {
                    skull = Items.WITHER_SKELETON_SKULL;
                } else if (target instanceof SkeletonEntity) {
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
        public HeadDropModifier read(ResourceLocation name, JsonObject json, ILootCondition[] conditions) {
            return new HeadDropModifier(conditions);
        }

        @Override
        public JsonObject write(HeadDropModifier instance) {
            return this.makeConditions(instance.conditions);
        }
    }
}
