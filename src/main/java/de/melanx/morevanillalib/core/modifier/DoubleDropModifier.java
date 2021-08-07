package de.melanx.morevanillalib.core.modifier;

import com.google.gson.JsonObject;
import de.melanx.morevanillalib.config.FeatureConfig;
import de.melanx.morevanillalib.data.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;

import javax.annotation.Nonnull;
import java.util.List;

public class DoubleDropModifier extends LootModifier {

    public DoubleDropModifier(ILootCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        //noinspection ConstantConditions
        Item tool = context.get(LootParameters.TOOL).getItem();
        if (FeatureConfig.DoubleDrop.enabledAll) {
            BlockState state = context.get(LootParameters.BLOCK_STATE);

            if (state != null) {
                Block block = state.getBlock();
                ServerWorld world = context.getWorld();
                if (ModTags.Items.DIAMOND_TOOLS.contains(tool)) {
                    if (Tags.Blocks.ORES_DIAMOND.contains(block)) {
                        if (FeatureConfig.DoubleDrop.Diamond.enabled && world.rand.nextDouble() < FeatureConfig.DoubleDrop.Diamond.chance) {
                            ItemStack drop = new ItemStack(Items.DIAMOND);
                            generatedLoot.add(drop);
                        }
                    }
                } else if (ModTags.Items.COAL_TOOLS.contains(tool)) {
                    if (Tags.Blocks.ORES_COAL.contains(block)) {
                        if (FeatureConfig.DoubleDrop.Coal.enabled && world.rand.nextDouble() < FeatureConfig.DoubleDrop.Coal.chance) {
                            ItemStack drop = new ItemStack(Items.COAL);
                            generatedLoot.add(drop);
                        }
                    }
                } else if (ModTags.Items.EMERALD_TOOLS.contains(tool)) {
                    if (Tags.Blocks.ORES_EMERALD.contains(block)) {
                        if (FeatureConfig.DoubleDrop.Emerald.enabled && world.rand.nextDouble() < FeatureConfig.DoubleDrop.Emerald.chance) {
                            ItemStack drop = new ItemStack(Items.EMERALD);
                            generatedLoot.add(drop);
                        }
                    }
                } else if (ModTags.Items.LAPIS_TOOLS.contains(tool)) {
                    if (Tags.Blocks.ORES_LAPIS.contains(block)) {
                        if (FeatureConfig.DoubleDrop.Lapis.enabled && world.rand.nextDouble() < FeatureConfig.DoubleDrop.Lapis.chance) {
                            int i = world.rand.nextInt(3);
                            ItemStack drop = new ItemStack(Items.LAPIS_LAZULI, i);
                            generatedLoot.add(drop);
                        }
                    }
                } else if (ModTags.Items.QUARTZ_TOOLS.contains(tool)) {
                    if (Tags.Blocks.ORES_QUARTZ.contains(block)) {
                        if (FeatureConfig.DoubleDrop.Quartz.enabled && world.rand.nextDouble() < FeatureConfig.DoubleDrop.Quartz.chance) {
                            ItemStack drop = new ItemStack(Items.QUARTZ);
                            generatedLoot.add(drop);
                        }
                    }
                } else if (ModTags.Items.REDSTONE_TOOLS.contains(tool)) {
                    if (Tags.Blocks.ORES_REDSTONE.contains(block)) {
                        if (FeatureConfig.DoubleDrop.Redstone.enabled && world.rand.nextDouble() < FeatureConfig.DoubleDrop.Redstone.chance) {
                            int i = world.rand.nextInt(3);
                            ItemStack drop = new ItemStack(Items.REDSTONE, i);
                            generatedLoot.add(drop);
                        }
                    }
                }
            }
        }

        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<DoubleDropModifier> {

        @Override
        public DoubleDropModifier read(ResourceLocation name, JsonObject json, ILootCondition[] conditions) {
            return new DoubleDropModifier(conditions);
        }

        @Override
        public JsonObject write(DoubleDropModifier instance) {
            return this.makeConditions(instance.conditions);
        }
    }
}
