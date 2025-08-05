package com.arsmagica2.arsmagica2return.common.spell.shape;

import com.arsmagica2.arsmagica2return.api.spell.ISpellPartStat;
import com.arsmagica2.arsmagica2return.api.spell.ISpellShape;

import java.util.Set;

public abstract class AbstractShape implements ISpellShape {
    private final Set<ISpellPartStat> stats;

    public AbstractShape(ISpellPartStat... stats) {
        this.stats = Set.of(stats);
    }

    @Override
    public Set<ISpellPartStat> getStatsUsed() {
        return stats;
    }
}
