package com.arsmagica2.arsmagica2return.common.particle;

import com.arsmagica2.arsmagica2return.common.util.AMUtil;

public class MoveInDirectionController extends ParticleController {
    private final double x, y, z;

    public MoveInDirectionController(AMParticle particle, double yaw, double pitch, double speed) {
        super(particle);
        yaw = AMUtil.wrap(yaw, 180);
        pitch = AMUtil.wrap(pitch, 180);
        x = Math.cos(Math.toRadians(yaw)) * speed;
        y = -Math.sin(Math.toRadians(pitch)) * speed;
        z = Math.sin(Math.toRadians(yaw)) * speed;
    }

    @Override
    public void tick() {
        particle.setPosition(particle.getX() + x, particle.getY() + y, particle.getZ() + z);
    }
}
