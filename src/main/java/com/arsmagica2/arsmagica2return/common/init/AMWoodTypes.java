package com.arsmagica2.arsmagica2return.common.init;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public interface AMWoodTypes {
    BlockSetType WITCHWOOD_BLOCK_SET_TYPE = BlockSetType.register(new BlockSetType(ArsMagicaAPI.MOD_ID + ":witchwood"));
    WoodType WITCHWOOD = WoodType.register(new WoodType(ArsMagicaAPI.MOD_ID + ":witchwood", WITCHWOOD_BLOCK_SET_TYPE));
}
