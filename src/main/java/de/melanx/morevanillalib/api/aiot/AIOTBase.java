package de.melanx.morevanillalib.api.aiot;

import de.melanx.morevanillalib.api.BaseToolItem;
import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.util.ToolUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;

public class AIOTBase extends BaseToolItem {

    public AIOTBase(IConfigurableTier tier, Properties properties) {
        super(tier, properties
                .addToolType(ToolType.PICKAXE, tier.getHarvestLevel())
                .addToolType(ToolType.AXE, tier.getHarvestLevel())
                .addToolType(ToolType.SHOVEL, tier.getHarvestLevel())
                .addToolType(ToolType.HOE, tier.getHarvestLevel()));
    }

    @Override
    public boolean canApplyAtEnchantingTable(@Nonnull ItemStack stack, @Nonnull Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || enchantment.type.canEnchantItem(Items.DIAMOND_SWORD);
    }

    @Nonnull
    @Override
    public ActionResultType onItemUse(@Nonnull ItemUseContext context) {
        PlayerEntity player = context.getPlayer();

        if (player == null) return ActionResultType.PASS;

        ItemStack item = context.getItem();
        boolean hoemode = isHoemode(item);

        ActionResultType axeResult = ToolUtil.toolUse(context, ToolType.AXE);
        if (axeResult == ActionResultType.PASS) {
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
    public ActionResult<ItemStack> onItemRightClick(@Nonnull World world, @Nonnull PlayerEntity player, @Nonnull Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (!world.isRemote && player.isCrouching()) {
            Style dark_blue = Style.EMPTY.setFormatting(TextFormatting.DARK_BLUE).setItalic(true);
            Style aqua = Style.EMPTY.setFormatting(TextFormatting.AQUA).setItalic(true);
            IFormattableTextComponent text = ToolUtil.getTooltip("toggleMode").appendString(": ").mergeStyle(dark_blue);
            IFormattableTextComponent pathMode = ToolUtil.getTooltip("pathMode", Blocks.GRASS_PATH.getTranslatedName().getString()).mergeStyle(aqua);
            IFormattableTextComponent hoeMode = ToolUtil.getTooltip("hoeMode").mergeStyle(aqua);

            if (isHoemode(stack)) {
                setHoemode(stack, false);
                text = text.appendSibling(pathMode);
            } else {
                setHoemode(stack, true);
                text = text.appendSibling(hoeMode);
            }

            player.sendStatusMessage(text, true);

            return ActionResult.resultSuccess(stack);
        }

        return super.onItemRightClick(world, player, hand);
    }

    private static void setHoemode(ItemStack stack, boolean b) {
        stack.getOrCreateTag().putBoolean("hoemode", b);
    }

    private static boolean isHoemode(ItemStack stack) {
        return stack.isEmpty() || !stack.getOrCreateTag().contains("hoemode") || stack.getOrCreateTag().getBoolean("hoemode");
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
        if (state.matchesBlock(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return state.getBlock().getHarvestTool(state) == null || this.getToolTypes(stack).contains(state.getBlock().getHarvestTool(state)) ? this.efficiency : 1.0F;
        }
    }
}
