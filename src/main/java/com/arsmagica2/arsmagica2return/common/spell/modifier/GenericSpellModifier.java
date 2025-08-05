package com.arsmagica2.arsmagica2return.common.spell.modifier;

import com.arsmagica2.arsmagica2return.api.spell.ISpellPartStat;
import com.arsmagica2.arsmagica2return.api.spell.ISpellPartStatModifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GenericSpellModifier extends AbstractModifier {
    protected final Map<ISpellPartStat, ISpellPartStatModifier> modifiers = new HashMap<>();

    @Override
    public ISpellPartStatModifier getStatModifier(ISpellPartStat stat) {
        return modifiers.get(stat);
    }

    @Override
    public Set<ISpellPartStat> getStatsModified() {
        return modifiers.keySet();
    }

    /**
     * Adds a stat modifier to this spell modifier.
     *
     * @param stat     The stat to add the stat modifier for.
     * @param modifier The stat modifier to add.
     * @return This modifier, for chaining.
     */
    public GenericSpellModifier addStatModifier(ISpellPartStat stat, ISpellPartStatModifier modifier) {
        modifiers.put(stat, modifier);
        return this;
    }
}
