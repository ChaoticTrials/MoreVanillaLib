package de.melanx.morevanillalib.core.modifier;

import com.google.gson.JsonObject;
import de.melanx.morevanillalib.FeatureConfig;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;

public class GlowstoneToolModifier extends LootModifier {

    public GlowstoneToolModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (FeatureConfig.glowstoneDrops) {
            generatedLoot.clear();
            ItemStack glowstone = new ItemStack(Items.GLOWSTONE_DUST);
            glowstone.setCount(4);
            generatedLoot.add(glowstone);
        }

        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<GlowstoneToolModifier> {
        @Override
        public GlowstoneToolModifier read(ResourceLocation name, JsonObject json, LootItemCondition[] conditionsIn) {
            return new GlowstoneToolModifier(conditionsIn);
        }

        @Override
        public JsonObject write(GlowstoneToolModifier instance) {
            return this.makeConditions(instance.conditions);
        }
    }

}
