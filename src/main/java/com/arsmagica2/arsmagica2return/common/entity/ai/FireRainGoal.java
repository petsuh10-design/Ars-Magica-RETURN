package com.arsmagica2.arsmagica2return.common.entity.ai;

import com.arsmagica2.arsmagica2return.common.entity.AbstractBoss;
import com.arsmagica2.arsmagica2return.common.entity.FireGuardian;
import com.arsmagica2.arsmagica2return.common.entity.FireRain;
import com.arsmagica2.arsmagica2return.common.init.AMEntities;

import java.util.Objects;

public class FireRainGoal extends AbstractBossGoal<FireGuardian> {
    public FireRainGoal(FireGuardian boss) {
        super(boss, AbstractBoss.Action.LONG_CAST, 20);
    }

    @Override
    public void perform() {
        if (!boss.level().isClientSide()) {
            FireRain fireRain = Objects.requireNonNull(AMEntities.FIRE_RAIN.get().create(boss.level()));
            fireRain.setPos((boss.getTarget() != null ? boss.getTarget().position() : boss.position()).add(0, 1.5, 0));
            fireRain.setDuration(200);
            fireRain.setOwner(boss);
            fireRain.setDamage(2);
            fireRain.setRadius(2);
            boss.level().addFreshEntity(fireRain);
        }
    }
}
