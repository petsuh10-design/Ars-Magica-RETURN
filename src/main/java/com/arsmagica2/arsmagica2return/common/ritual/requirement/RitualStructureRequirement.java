package com.arsmagica2.arsmagica2return.common.ritual.requirement;

import com.arsmagica2.arsmagica2return.api.ritual.RitualRequirement;
import com.arsmagica2.arsmagica2return.compat.patchouli.PatchouliCompat;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;

public record RitualStructureRequirement(ResourceLocation structure) implements RitualRequirement {
    public static final Codec<RitualStructureRequirement> CODEC = RecordCodecBuilder.create(inst -> inst.group(
            ResourceLocation.CODEC.fieldOf("structure").forGetter(RitualStructureRequirement::structure)
    ).apply(inst, RitualStructureRequirement::new));

    @Override
    public boolean test(Player player, ServerLevel level, BlockPos pos) {
        return PatchouliCompat.getMultiblockMatcher(structure).test(level, pos);
    }

    @Override
    public Codec<? extends RitualRequirement> codec() {
        return CODEC;
    }
}
