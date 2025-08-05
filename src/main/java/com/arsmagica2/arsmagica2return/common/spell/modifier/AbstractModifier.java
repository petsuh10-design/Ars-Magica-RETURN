package com.arsmagica2.arsmagica2return.common.spell.modifier;

import com.arsmagica2.arsmagica2return.api.spell.ISpellModifier;

import java.util.Objects;

public abstract class AbstractModifier implements ISpellModifier {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ISpellModifier mod && Objects.equals(getId(), mod.getId());
    }
}
