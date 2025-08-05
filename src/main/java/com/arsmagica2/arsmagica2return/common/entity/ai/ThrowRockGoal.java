package com.arsmagica2.arsmagica2return.common.entity.ai;

import com.arsmagica2.arsmagica2return.common.entity.AbstractBoss;
import com.arsmagica2.arsmagica2return.common.entity.EarthGuardian;
import com.arsmagica2.arsmagica2return.common.entity.ThrownRock;
import com.arsmagica2.arsmagica2return.common.init.AMEntities;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class ThrowRockGoal extends AbstractBossGoal<EarthGuardian> {
    public ThrowRockGoal(EarthGuardian boss) {
        super(boss, AbstractBoss.Action.THROW, 15, 5);
    }

    @Override
    public boolean canUse() {
        return super.canUse() && boss.getTarget() != null && boss.distanceTo(boss.getTarget()) > 4;
    }

    @Override
    public void performTick() {
        super.performTick();
        boss.level().broadcastEntityEvent(boss, ticks > 2 && ticks < 16 ? (byte) -8 : (byte) -9);
    }

    @Override
    public void perform() {
        Level level = boss.level();
        if (!level.isClientSide()) {
            ThrownRock entity = Objects.requireNonNull(AMEntities.THROWN_ROCK.get().create(level));
            entity.moveTo(boss.getEyePosition().add(boss.getLookAngle()));
            entity.setDeltaMovement(boss.getLookAngle());
            entity.setOwner(boss);
            level.addFreshEntity(entity);
        }
    }
}
