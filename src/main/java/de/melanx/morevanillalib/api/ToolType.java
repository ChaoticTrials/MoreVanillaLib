package de.melanx.morevanillalib.api;

import de.melanx.morevanillalib.data.ModTags;
import de.melanx.morevanillalib.util.ToolUtil;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import java.util.Set;

public enum ToolType {
    AIOT(ModTags.Blocks.MINEABLE_WITH_AIOT, ToolUtil.DEFAULT_AIOT_ACTIONS),
    AXE(BlockTags.MINEABLE_WITH_AXE, ToolActions.DEFAULT_AXE_ACTIONS),
    HOE(BlockTags.MINEABLE_WITH_HOE, ToolActions.DEFAULT_HOE_ACTIONS),
    PICKAXE(BlockTags.MINEABLE_WITH_PICKAXE, ToolActions.DEFAULT_PICKAXE_ACTIONS),
    SHOVEL(BlockTags.MINEABLE_WITH_SHOVEL, ToolActions.DEFAULT_SHOVEL_ACTIONS);

    private final Tag<Block> blocks;
    private final Set<ToolAction> toolActions;

    ToolType(Tag<Block> blocks, Set<ToolAction> toolActions) {
        this.blocks = blocks;
        this.toolActions = toolActions;
    }

    public Tag<Block> getBlocks() {
        return this.blocks;
    }

    public Set<ToolAction> getToolActions() {
        return this.toolActions;
    }
}
