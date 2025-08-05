package com.arsmagica2.arsmagica2return.common.block.altar;

import net.minecraft.world.level.block.state.BlockState;

public interface ICapMatcher {
    /**
     * @param state The block state to test.
     * @return Whether the given block state matches this material.
     */
    boolean testCap(BlockState state);
}
