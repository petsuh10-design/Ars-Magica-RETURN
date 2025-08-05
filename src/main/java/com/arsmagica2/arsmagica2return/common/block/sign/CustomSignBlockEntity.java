package com.arsmagica2.arsmagica2return.common.block.sign;

import com.arsmagica2.arsmagica2return.common.init.AMBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CustomSignBlockEntity extends SignBlockEntity {
    public CustomSignBlockEntity(BlockPos pPos, BlockState pState) {
        super(pPos, pState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return AMBlockEntities.WITCHWOOD_SIGN.get();
    }
}
