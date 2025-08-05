package com.arsmagica2.arsmagica2return.common.entity.ai;

import com.arsmagica2.arsmagica2return.common.entity.AbstractBoss;
import com.arsmagica2.arsmagica2return.common.entity.IceGuardian;
import com.arsmagica2.arsmagica2return.common.entity.WintersGrasp;
import com.arsmagica2.arsmagica2return.common.init.AMEntities;
import com.arsmagica2.arsmagica2return.common.init.AMSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class ThrowArmGoal extends AbstractBossGoal<IceGuardian> {
    public ThrowArmGoal(IceGuardian boss) {
        super(boss, AbstractBoss.Action.THROW, 10, 10);
    }

    @Override
    public boolean canUse() {
        return super.canUse() && boss.getTarget() != null && boss.distanceTo(boss.getTarget()) > 4 && boss.canLaunchArm();
    }

    @Override
    protected SoundEvent getAttackSound() {
        return AMSounds.ICE_GUARDIAN_LAUNCH_ARM.value();
    }

    @Override
    public void perform() {
        Level level = boss.level();
        if (!level.isClientSide()) {
            WintersGrasp entity = Objects.requireNonNull(AMEntities.WINTERS_GRASP.get().create(level));
            entity.moveTo(boss.position().add(0, 1, 0).add(boss.getLookAngle()));
            entity.setDeltaMovement(boss.getLookAngle());
            entity.setXRot(boss.getXRot());
            entity.setYRot(boss.getYRot());
            entity.setOwner(boss);
            level.addFreshEntity(entity);
            boss.launchArm();
        }
    }
}
