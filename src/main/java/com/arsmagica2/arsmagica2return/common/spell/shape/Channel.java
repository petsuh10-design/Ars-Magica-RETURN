package com.arsmagica2.arsmagica2return.common.spell.shape;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.api.spell.ISpell;
import com.arsmagica2.arsmagica2return.api.spell.ISpellModifier;
import com.arsmagica2.arsmagica2return.api.spell.SpellCastResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Channel extends AbstractShape {
    @Override
    public SpellCastResult invoke(ISpell spell, LivingEntity caster, Level level, List<ISpellModifier> modifiers, @Nullable HitResult hit, int ticksUsed, int index, boolean awardXp) {
        return ArsMagicaAPI.get().getSpellHelper().invoke(spell, caster, null, level, new EntityHitResult(caster), ticksUsed, index, awardXp);
    }

    @Override
    public boolean isContinuous() {
        return true;
    }
}
