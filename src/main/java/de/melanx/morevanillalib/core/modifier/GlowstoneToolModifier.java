package de.melanx.morevanillalib.core.modifier;

import com.google.gson.JsonObject;
import de.melanx.morevanillalib.LibConfigHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;

public class GlowstoneToolModifier extends LootModifier {

    protected GlowstoneToolModifier(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        if (LibConfigHandler.glowstoneDrops.get()) {
            generatedLoot.clear();
            ItemStack glowstone = new ItemStack(Items.GLOWSTONE_DUST);
            glowstone.setCount(4);
            generatedLoot.add(glowstone);
        }
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<GlowstoneToolModifier> {
        @Override
        public GlowstoneToolModifier read(ResourceLocation name, JsonObject json, ILootCondition[] conditionsIn) {
            return new GlowstoneToolModifier(conditionsIn);
        }
    }

}
