package de.melanx.morevanillalib.api.aiot;

import de.melanx.morevanillalib.api.BaseToolItem;
import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.data.ModTags;
import de.melanx.morevanillalib.util.ComponentUtil;
import de.melanx.morevanillalib.util.ToolUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AIOTBase extends BaseToolItem {

    public AIOTBase(IConfigurableTier tier, Properties properties) {
        super(tier, ModTags.Blocks.MINEABLE_WITH_AIOT, properties);
    }

    @Override
    public boolean canApplyAtEnchantingTable(@Nonnull ItemStack stack, @Nonnull Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || enchantment.category.canEnchant(Items.DIAMOND_SWORD);
    }

    @Nonnull
    @Override
    public InteractionResult useOn(@Nonnull UseOnContext context) {
        Player player = context.getPlayer();

        if (player == null) return InteractionResult.PASS;

        ItemStack item = context.getItemInHand();
        boolean hoemode = isHoemode(item);

        InteractionResult axeResult = ToolUtil.toolUse(context, ToolType.AXE);
        if (axeResult == InteractionResult.PASS) {
            if (hoemode) {
                return ToolUtil.toolUse(context, ToolType.HOE);
            } else {
                return ToolUtil.toolUse(context, ToolType.SHOVEL);
            }
        }

        return axeResult;
    }

    @Nonnull
    @Override
    public InteractionResultHolder<ItemStack> use(@Nonnull Level level, @Nonnull Player player, @Nonnull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide && player.isCrouching()) {
            Style dark_blue = Style.EMPTY.withColor(ChatFormatting.DARK_BLUE);
            Style aqua = Style.EMPTY.withColor(ChatFormatting.AQUA);
            MutableComponent text = ComponentUtil.getTooltip("toggleMode").append(": ").withStyle(dark_blue);
            MutableComponent pathMode = ComponentUtil.getTooltip("pathMode", Blocks.DIRT_PATH.getName().getString()).withStyle(aqua);
            MutableComponent hoeMode = ComponentUtil.getTooltip("hoeMode").withStyle(aqua);

            if (isHoemode(stack)) {
                setHoemode(stack, false);
                text = text.append(pathMode);
            } else {
                setHoemode(stack, true);
                text = text.append(hoeMode);
            }

            player.displayClientMessage(text, true);

            return InteractionResultHolder.success(stack);
        }

        return super.use(level, player, hand);
    }

    private static void setHoemode(ItemStack stack, boolean b) {
        stack.getOrCreateTag().putBoolean("hoemode", b);
    }

    private static boolean isHoemode(ItemStack stack) {
        return stack.isEmpty() || !stack.getOrCreateTag().contains("hoemode") || stack.getOrCreateTag().getBoolean("hoemode");
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
        if (state.is(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return state.getBlock().getHarvestTool(state) == null || this.getToolTypes(stack).contains(state.getBlock().getHarvestTool(state)) ? this.speed : 1.0F;
        }
    }

    @Override
    public int getBurnTime(@Nonnull ItemStack stack, @Nullable RecipeType<?> recipeType) {
        if (this.getToolMaterial() == AIOTMaterials.WOODEN) {
            return 400;
        }

        return 0;
    }
}
