package de.melanx.morevanillalib.api;

import net.minecraft.block.BlockState;

public interface IBreakValidator {

    boolean canBreak(BlockState state);
}
