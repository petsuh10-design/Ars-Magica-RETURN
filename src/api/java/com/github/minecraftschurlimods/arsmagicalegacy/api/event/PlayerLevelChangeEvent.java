package com.arsmagica2.arsmagica2return.api.event;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.neoforge.event.entity.player.PlayerEvent;

/**
 * Event that fires when the player's magic level changes.
 */
public final class PlayerLevelChangeEvent extends PlayerEvent {
    private final int level;
    private final int oldLevel;

    public PlayerLevelChangeEvent(Player player, int level, int oldLevel) {
        super(player);
        this.level = level;
        this.oldLevel = oldLevel;
    }

    /**
     * @return The new level of the player.
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return The old level of the player.
     */
    public int getOldLevel() {
        return oldLevel;
    }
}
