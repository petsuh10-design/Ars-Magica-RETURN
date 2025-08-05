package com.arsmagica2.arsmagica2return.common.spell;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.api.spell.ISpellPartStat;
import net.minecraft.resources.ResourceLocation;

public enum SpellPartStats implements ISpellPartStat {
    BOUNCE,
    COLOR,
    DAMAGE,
    DURATION,
    FORTUNE,
    GRAVITY,
    HEALING,
    HOMING,
    MINING_TIER,
    PIERCING,
    POWER,
    RANGE,
    SILK_TOUCH,
    SIZE,
    SPEED,
    TARGET_NON_SOLID;

    private final ResourceLocation id;

    SpellPartStats() {
        id = new ResourceLocation(ArsMagicaAPI.MOD_ID, name().toLowerCase());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }
}
