package com.arsmagica2.arsmagica2return.common.ritual.requirement;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.api.ritual.RitualRequirement;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;

public record MagicLevelRequirement(MinMaxBounds.Ints bounds) implements RitualRequirement {
    public static final Codec<MagicLevelRequirement> CODEC = RecordCodecBuilder.create(inst -> inst.group(MinMaxBounds.Ints.CODEC.fieldOf("level").forGetter(MagicLevelRequirement::bounds)).apply(inst, MagicLevelRequirement::new));

    @Override
    public Codec<? extends RitualRequirement> codec() {
        return CODEC;
    }

    @Override
    public boolean test(final Player player, final ServerLevel serverLevel, final BlockPos pos) {
        return bounds().matches(ArsMagicaAPI.get().getMagicHelper().getLevel(player));
    }
}
