package com.arsmagica2.arsmagica2return.common.spell.component;

import com.arsmagica2.arsmagica2return.api.spell.ISpellComponent;
import com.arsmagica2.arsmagica2return.api.spell.ISpellPartStat;

import java.util.Set;

public abstract class AbstractComponent implements ISpellComponent {
    private final Set<ISpellPartStat> stats;

    protected AbstractComponent(ISpellPartStat... stats) {
        this.stats = Set.of(stats);
    }

    @Override
    public Set<ISpellPartStat> getStatsUsed() {
        return stats;
    }
}
