package com.arsmagica2.arsmagica2return.common.spell.component;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.api.spell.ISpell;
import com.arsmagica2.arsmagica2return.api.spell.ISpellModifier;
import com.arsmagica2.arsmagica2return.api.spell.SpellCastResult;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class Drought extends AbstractComponent {
    @Override
    public SpellCastResult invoke(ISpell spell, LivingEntity caster, @Nullable Entity directEntity, Level level, List<ISpellModifier> modifiers, EntityHitResult target, int index, int ticksUsed) {
        return SpellCastResult.EFFECT_FAILED;
    }

    @Override
    public SpellCastResult invoke(ISpell spell, LivingEntity caster, @Nullable Entity directEntity, Level level, List<ISpellModifier> modifiers, BlockHitResult target, int index, int ticksUsed) {
        BlockPos pos = target.getBlockPos();
        BlockState state = level.getBlockState(pos);
        if (level.getBlockState(pos.offset(target.getDirection().getNormal())).getBlock() == Blocks.WATER) {
            level.setBlock(pos.offset(target.getDirection().getNormal()), Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
            return SpellCastResult.SUCCESS;
        } else {
            Optional<BlockState> optional = ArsMagicaAPI.get().getSpellTransformationFor(state, level, getId());
            if (optional.isPresent()) {
                level.setBlock(pos, optional.get(), Block.UPDATE_ALL);
                return SpellCastResult.SUCCESS;
            }
        }
        return SpellCastResult.EFFECT_FAILED;
    }
}
