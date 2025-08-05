package com.arsmagica2.arsmagica2return.common.block.celestialprism;

import com.arsmagica2.arsmagica2return.Config;
import com.arsmagica2.arsmagica2return.api.etherium.EtheriumType;
import com.arsmagica2.arsmagica2return.api.etherium.IEtheriumProvider;
import com.arsmagica2.arsmagica2return.common.etherium.SimpleEtheriumProvider;
import com.arsmagica2.arsmagica2return.common.init.AMBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CelestialPrismBlockEntity extends BlockEntity {
    private final SimpleEtheriumProvider provider = new SimpleEtheriumProvider(EtheriumType.LIGHT, Config.SERVER.MAX_ETHERIUM_STORAGE.get()).setCallback(CelestialPrismBlockEntity::onConsume);
    private int time;

    public CelestialPrismBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(AMBlockEntities.CELESTIAL_PRISM.get(), pWorldPosition, pBlockState);
    }

    private static void onConsume(Level level, BlockPos consumerPos, int amount) {
        // TODO spawn particles
    }

    void tick(Level level, BlockPos pos, BlockState state) {
        int tier = state.getBlock() instanceof CelestialPrismBlock block ? block.getTier(level, pos) : 0;
        if (level.canSeeSky(pos) && (level.isDay() || tier == 5)) {
            if (time > 0) {
                time--;
            } else {
                time = 6 / (tier + 1);
                provider.add(1);
            }
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("etheriumValue", provider.getAmount());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        provider.set(tag.getInt("etheriumValue"));
    }

    public IEtheriumProvider getEtheriumCapability(Void v) {
        return provider;
    }
}
