package com.arsmagica2.arsmagica2return.common.entity.ai;

import com.arsmagica2.arsmagica2return.common.entity.AbstractBoss;
import com.arsmagica2.arsmagica2return.common.entity.FireGuardian;
import com.arsmagica2.arsmagica2return.common.init.AMSounds;
import net.minecraft.sounds.SoundEvent;

public class FlamethrowerGoal extends AbstractBossGoal<FireGuardian> {
    public FlamethrowerGoal(FireGuardian boss) {
        super(boss, AbstractBoss.Action.LONG_CAST, 20);
    }

    @Override
    protected SoundEvent getAttackSound() {
        return AMSounds.FIRE_GUARDIAN_FLAMETHROWER.value();
    }

    @Override
    public void perform() {
        boss.flamethrower();
    }
}
