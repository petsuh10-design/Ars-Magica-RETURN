package com.arsmagica2.arsmagica2return.api.spell;

import java.util.Set;

/**
 * Base interface for a spell modifier.
 */
public interface ISpellModifier extends ISpellPart {
    /**
     * @param stat The stat to modify.
     * @return A modifier for the given stat.
     */
    ISpellPartStatModifier getStatModifier(ISpellPartStat stat);

    /**
     * @return A set containing all stats this modifier modifies.
     */
    Set<ISpellPartStat> getStatsModified();

    @Override
    default SpellPartType getType() {
        return SpellPartType.MODIFIER;
    }
}
