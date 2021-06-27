package de.melanx.morevanillalib.api.aiot;

import de.melanx.morevanillalib.api.BaseToolItem;
import de.melanx.morevanillalib.api.IConfigurableTier;
import de.melanx.morevanillalib.util.ComponentUtil;
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
                .addToolType(ToolType.PICKAXE, tier.getLevel())
                .addToolType(ToolType.AXE, tier.getLevel())
                .addToolType(ToolType.SHOVEL, tier.getLevel())
                .addToolType(ToolType.HOE, tier.getLevel()));
    }

    @Override
    public boolean canApplyAtEnchantingTable(@Nonnull ItemStack stack, @Nonnull Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) || enchantment.category.canEnchant(Items.DIAMOND_SWORD);
    }

    @Nonnull
    @Override
    public ActionResultType useOn(@Nonnull ItemUseContext context) {
        PlayerEntity player = context.getPlayer();

        if (player == null) return ActionResultType.PASS;

        ItemStack item = context.getItemInHand();
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
    public ActionResult<ItemStack> use(@Nonnull World level, @Nonnull PlayerEntity player, @Nonnull Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide && player.isCrouching()) {
            Style dark_blue = Style.EMPTY.applyLegacyFormat(TextFormatting.DARK_BLUE);
            Style aqua = Style.EMPTY.applyLegacyFormat(TextFormatting.AQUA);
            IFormattableTextComponent text = ComponentUtil.getTooltip("toggleMode").append(": ").withStyle(dark_blue);
            IFormattableTextComponent pathMode = ComponentUtil.getTooltip("pathMode", Blocks.GRASS_PATH.getName().getString()).withStyle(aqua);
            IFormattableTextComponent hoeMode = ComponentUtil.getTooltip("hoeMode").withStyle(aqua);

            if (isHoemode(stack)) {
                setHoemode(stack, false);
                text = text.append(pathMode);
            } else {
                setHoemode(stack, true);
                text = text.append(hoeMode);
            }

            player.displayClientMessage(text, true);

            return ActionResult.success(stack);
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
}
