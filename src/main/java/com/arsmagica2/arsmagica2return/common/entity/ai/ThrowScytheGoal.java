package com.arsmagica2.arsmagica2return.common.entity.ai;

import com.arsmagica2.arsmagica2return.common.entity.AbstractBoss;
import com.arsmagica2.arsmagica2return.common.entity.NatureGuardian;
import com.arsmagica2.arsmagica2return.common.entity.NatureScythe;
import com.arsmagica2.arsmagica2return.common.init.AMEntities;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class ThrowScytheGoal extends AbstractBossGoal<NatureGuardian> {
    public ThrowScytheGoal(NatureGuardian boss) {
        super(boss, AbstractBoss.Action.THROW, 10, 10);
    }

    @Override
    public boolean canUse() {
        return super.canUse() && boss.getTarget() != null && boss.distanceTo(boss.getTarget()) > 4 && boss.hasScythe();
    }

    @Override
    public void perform() {
        Level level = boss.level();
        if (!level.isClientSide()) {
            NatureScythe entity = Objects.requireNonNull(AMEntities.NATURE_SCYTHE.get().create(level));
            entity.moveTo(boss.position().add(0, 3, 0).add(boss.getLookAngle()));
            entity.setDeltaMovement(boss.getLookAngle());
            entity.setXRot(boss.getXRot());
            entity.setYRot(boss.getYRot());
            entity.setOwner(boss);
            level.addFreshEntity(entity);
            boss.setHasScythe(false);
        }
    }
}
