package com.arsmagica2.arsmagica2return.common.magic;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

/**
 * Основна система магії Ars Magica 2
 * Керує всіма аспектами магічних взаємодій
 */
public class MagicSystem {
    private static final Map<UUID, MagicData> playerMagicData = new HashMap<>();
    
    /**
     * Отримує магічні дані гравця
     */
    public static MagicData getMagicData(Player player) {
        return playerMagicData.computeIfAbsent(player.getUUID(), uuid -> new MagicData());
    }
    
    /**
     * Перевіряє, чи може гравець використовувати магію
     */
    public static boolean canUseMagic(Player player) {
        MagicData data = getMagicData(player);
        return data.getCurrentMana() > 0 && !data.isMagicBlocked();
    }
    
    /**
     * Витрачає ману у гравця
     */
    public static boolean consumeMana(Player player, float amount) {
        MagicData data = getMagicData(player);
        if (data.getCurrentMana() >= amount) {
            data.consumeMana(amount);
            return true;
        }
        return false;
    }
    
    /**
     * Додає ману гравцю
     */
    public static void addMana(Player player, float amount) {
        MagicData data = getMagicData(player);
        data.addMana(amount);
    }
    
    /**
     * Перевіряє магічну силу в певній локації
     */
    public static float getMagicPowerAt(Level level, BlockPos pos) {
        // Базова магічна сила залежить від біому та навколишніх блоків
        float basePower = 1.0f;
        
        // Додаткова сила від магічних блоків поблизу
        float additionalPower = 0.0f;
        for (BlockPos nearbyPos : BlockPos.betweenClosed(pos.offset(-5, -5, -5), pos.offset(5, 5, 5))) {
            // Тут буде логіка перевірки магічних блоків
            // additionalPower += getMagicBlockPower(level.getBlockState(nearbyPos));
        }
        
        return Math.min(basePower + additionalPower, 5.0f); // Максимум 5x
    }
    
    /**
     * Перевіряє, чи може заклинання бути кастовано в цій локації
     */
    public static boolean canCastSpellAt(Level level, BlockPos pos, SpellType spellType) {
        float magicPower = getMagicPowerAt(level, pos);
        return magicPower >= spellType.getMinimumPowerRequired();
    }
    
    /**
     * Обробляє магічні ефекти що тикають
     */
    public static void tick(Player player) {
        MagicData data = getMagicData(player);
        data.tick();
    }
    
    /**
     * Зберігає магічні дані в NBT
     */
    public static CompoundTag saveMagicData(Player player) {
        MagicData data = getMagicData(player);
        return data.serialize();
    }
    
    /**
     * Завантажує магічні дані з NBT
     */
    public static void loadMagicData(Player player, CompoundTag tag) {
        MagicData data = getMagicData(player);
        data.deserialize(tag);
    }
    
    /**
     * Очищає дані гравця (при від'єднанні)
     */
    public static void clearPlayerData(UUID playerUUID) {
        playerMagicData.remove(playerUUID);
    }
    
    /**
     * Enum для типів заклинань
     */
    public enum SpellType {
        PROJECTILE(0.5f),
        AREA_OF_EFFECT(1.0f),
        SELF_BUFF(0.3f),
        TELEPORTATION(2.0f),
        SUMMONING(3.0f);
        
        private final float minimumPowerRequired;
        
        SpellType(float minimumPowerRequired) {
            this.minimumPowerRequired = minimumPowerRequired;
        }
        
        public float getMinimumPowerRequired() {
            return minimumPowerRequired;
        }
    }
}