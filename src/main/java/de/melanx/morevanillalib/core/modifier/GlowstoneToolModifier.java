package de.melanx.morevanillalib.core.modifier;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import de.melanx.morevanillalib.FeatureConfig;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import javax.annotation.Nonnull;

public class GlowstoneToolModifier extends LootModifier {

    public static final MapCodec<GlowstoneToolModifier> CODEC = RecordCodecBuilder.mapCodec(instance -> codecStart(instance).apply(instance, GlowstoneToolModifier::new));

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

    @Nonnull
    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
