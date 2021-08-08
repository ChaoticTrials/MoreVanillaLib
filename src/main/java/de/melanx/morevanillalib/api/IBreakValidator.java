package de.melanx.morevanillalib.api;

import net.minecraft.world.level.block.state.BlockState;

public interface IBreakValidator {

    boolean canBreak(BlockState state);
}
