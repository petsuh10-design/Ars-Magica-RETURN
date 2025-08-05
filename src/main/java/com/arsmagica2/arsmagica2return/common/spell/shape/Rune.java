package com.arsmagica2.arsmagica2return.common.spell.shape;

import com.arsmagica2.arsmagica2return.api.spell.ISpell;
import com.arsmagica2.arsmagica2return.api.spell.ISpellModifier;
import com.arsmagica2.arsmagica2return.api.spell.SpellCastResult;
import com.arsmagica2.arsmagica2return.common.block.spellrune.SpellRuneBlock;
import com.arsmagica2.arsmagica2return.common.block.spellrune.SpellRuneBlockEntity;
import com.arsmagica2.arsmagica2return.common.init.AMBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Rune extends AbstractShape {
    @Override
    public SpellCastResult invoke(ISpell spell, LivingEntity caster, Level level, List<ISpellModifier> modifiers, @Nullable HitResult hit, int ticksUsed, int index, boolean awardXp) {
        if (!(hit instanceof BlockHitResult bHit)) return SpellCastResult.EFFECT_FAILED;
        Direction direction = bHit.getDirection();
        BlockPos pos = bHit.getBlockPos().relative(direction);
        BlockState blockState = level.getBlockState(pos);
        if (!blockState.isAir()) return SpellCastResult.EFFECT_FAILED;
        level.setBlock(pos, AMBlocks.SPELL_RUNE.get().defaultBlockState().setValue(SpellRuneBlock.FACE, direction.getOpposite()), Block.UPDATE_ALL);
        ((SpellRuneBlockEntity) level.getBlockEntity(pos)).setSpell(spell, caster, index, awardXp);
        return SpellCastResult.SUCCESS;
    }

    @Override
    public boolean needsPrecedingShape() {
        return true;
    }

    @Override
    public boolean isEndShape() {
        return true;
    }
}
