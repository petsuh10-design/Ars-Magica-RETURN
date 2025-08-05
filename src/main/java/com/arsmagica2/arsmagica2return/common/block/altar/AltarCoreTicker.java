package com.arsmagica2.arsmagica2return.common.block.altar;

import com.arsmagica2.arsmagica2return.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

class AltarCoreTicker implements BlockEntityTicker<AltarCoreBlockEntity> {
    @Override
    public void tick(Level pLevel, BlockPos pPos, BlockState pState, AltarCoreBlockEntity pBlockEntity) {
        pBlockEntity.checkCounter--;
        if (pBlockEntity.checkCounter <= 0) {
            pBlockEntity.checkMultiblock();
            pBlockEntity.checkCounter = Config.SERVER.CRAFTING_ALTAR_CHECK_TIME.get();
        }
        if (pBlockEntity.isMultiblockFormed()) {
            pBlockEntity.consumeTick();
        }
    }
}
