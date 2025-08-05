package com.arsmagica2.arsmagica2return.common.block.sign;

import com.arsmagica2.arsmagica2return.common.init.AMBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CustomHangingSignBlockEntity extends HangingSignBlockEntity {
    public CustomHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return AMBlockEntities.WITCHWOOD_HANGING_SIGN.get();
    }
}
