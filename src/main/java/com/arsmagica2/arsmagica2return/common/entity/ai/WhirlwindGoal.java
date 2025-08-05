package com.arsmagica2.arsmagica2return.common.entity.ai;

import com.arsmagica2.arsmagica2return.common.entity.AbstractBoss;
import com.arsmagica2.arsmagica2return.common.entity.AirGuardian;
import com.arsmagica2.arsmagica2return.common.entity.Whirlwind;
import com.arsmagica2.arsmagica2return.common.init.AMEntities;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class WhirlwindGoal extends AbstractBossGoal<AirGuardian> {
    public WhirlwindGoal(AirGuardian boss) {
        super(boss, AbstractBoss.Action.LONG_CAST, 40);
    }

    @Override
    public boolean canUse() {
        return super.canUse() && boss.getTarget() != null && boss.distanceTo(boss.getTarget()) > 4;
    }

    @Override
    public void perform() {
        Level level = boss.level();
        if (!level.isClientSide()) {
            Whirlwind entity = Objects.requireNonNull(AMEntities.WHIRLWIND.get().create(level));
            entity.moveTo(boss.getX(), boss.getY() + boss.getEyeHeight(), boss.getZ());
            entity.setDeltaMovement(boss.getLookAngle());
            level.addFreshEntity(entity);
        }
    }
}
