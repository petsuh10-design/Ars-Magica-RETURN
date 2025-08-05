package com.arsmagica2.arsmagica2return.common.entity.ai;

import com.arsmagica2.arsmagica2return.api.spell.ISpell;
import com.arsmagica2.arsmagica2return.common.entity.AbstractBoss;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ExecuteRandomSpellGoal<T extends AbstractBoss> extends ExecuteBossSpellGoal<T> {
    private final List<ISpell> spells;

    public ExecuteRandomSpellGoal(T caster, List<ISpell> spells, int duration) {
        super(caster, null, duration);
        this.spells = spells;
    }

    @Override
    @Nullable
    protected ISpell getSpell(T caster) {
        return spells.get(caster.level().getRandom().nextInt(spells.size()));
    }
}
