package com.arsmagica2.arsmagica2return.common.entity.ai;

import com.arsmagica2.arsmagica2return.common.entity.AbstractBoss;
import com.arsmagica2.arsmagica2return.common.entity.WaterGuardian;
import com.arsmagica2.arsmagica2return.common.init.AMEntities;

public class CloneGoal extends AbstractBossGoal<WaterGuardian> {
    public CloneGoal(WaterGuardian boss) {
        super(boss, AbstractBoss.Action.LONG_CAST, 40);
    }

    @Override
    public boolean canUse() {
        return super.canUse() && boss.getTarget() != null && boss.distanceTo(boss.getTarget()) > 2 && !boss.isClone() && !boss.hasClones();
    }

    @Override
    public void perform() {
        boss.setClones(spawnClone(), spawnClone());
    }

    private WaterGuardian spawnClone() {
        WaterGuardian clone = new WaterGuardian(AMEntities.WATER_GUARDIAN.get(), boss.level());
        clone.setMaster(boss);
        clone.setPos(boss.getX(), boss.getY(), boss.getZ());
        boss.level().addFreshEntity(clone);
        return clone;
    }
}
