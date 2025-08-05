package com.arsmagica2.arsmagica2return.common.init;

import com.arsmagica2.arsmagica2return.common.entity.AirGuardian;
import com.arsmagica2.arsmagica2return.common.entity.ArcaneGuardian;
import com.arsmagica2.arsmagica2return.common.entity.Blizzard;
import com.arsmagica2.arsmagica2return.common.entity.Dryad;
import com.arsmagica2.arsmagica2return.common.entity.EarthGuardian;
import com.arsmagica2.arsmagica2return.common.entity.EnderGuardian;
import com.arsmagica2.arsmagica2return.common.entity.FallingStar;
import com.arsmagica2.arsmagica2return.common.entity.FireGuardian;
import com.arsmagica2.arsmagica2return.common.entity.FireRain;
import com.arsmagica2.arsmagica2return.common.entity.IceGuardian;
import com.arsmagica2.arsmagica2return.common.entity.LifeGuardian;
import com.arsmagica2.arsmagica2return.common.entity.LightningGuardian;
import com.arsmagica2.arsmagica2return.common.entity.Mage;
import com.arsmagica2.arsmagica2return.common.entity.ManaCreeper;
import com.arsmagica2.arsmagica2return.common.entity.ManaVortex;
import com.arsmagica2.arsmagica2return.common.entity.NatureGuardian;
import com.arsmagica2.arsmagica2return.common.entity.NatureScythe;
import com.arsmagica2.arsmagica2return.common.entity.Projectile;
import com.arsmagica2.arsmagica2return.common.entity.Shockwave;
import com.arsmagica2.arsmagica2return.common.entity.ThrownRock;
import com.arsmagica2.arsmagica2return.common.entity.Wall;
import com.arsmagica2.arsmagica2return.common.entity.WaterGuardian;
import com.arsmagica2.arsmagica2return.common.entity.Wave;
import com.arsmagica2.arsmagica2return.common.entity.Whirlwind;
import com.arsmagica2.arsmagica2return.common.entity.WintersGrasp;
import com.arsmagica2.arsmagica2return.common.entity.Zone;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

import static com.arsmagica2.arsmagica2return.common.init.AMRegistries.ENTITY_TYPES;

@NonExtendable
public interface AMEntities {
    DeferredHolder<EntityType<?>, EntityType<Projectile>>        PROJECTILE         = ENTITY_TYPES.register("projectile",         () -> EntityType.Builder.of(Projectile::new,        MobCategory.MISC)   .clientTrackingRange(8).sized(0.25F, 0.25F).build("projectile"));
    DeferredHolder<EntityType<?>, EntityType<Wall>>              WALL               = ENTITY_TYPES.register("wall",               () -> EntityType.Builder.of(Wall::new,              MobCategory.MISC)   .clientTrackingRange(8).sized(0.25F, 0.25F).build("wall"));
    DeferredHolder<EntityType<?>, EntityType<Wave>>              WAVE               = ENTITY_TYPES.register("wave",               () -> EntityType.Builder.of(Wave::new,              MobCategory.MISC)   .clientTrackingRange(8).sized(0.25F, 0.25F).build("wave"));
    DeferredHolder<EntityType<?>, EntityType<Zone>>              ZONE               = ENTITY_TYPES.register("zone",               () -> EntityType.Builder.of(Zone::new,              MobCategory.MISC)   .clientTrackingRange(8).sized(0.25F, 0.25F).build("zone"));
    DeferredHolder<EntityType<?>, EntityType<Blizzard>>          BLIZZARD           = ENTITY_TYPES.register("blizzard",           () -> EntityType.Builder.of(Blizzard::new,          MobCategory.MISC)   .clientTrackingRange(8).sized(0.25F, 0.25F).build("blizzard"));
    DeferredHolder<EntityType<?>, EntityType<FireRain>>          FIRE_RAIN          = ENTITY_TYPES.register("fire_rain",          () -> EntityType.Builder.of(FireRain::new,          MobCategory.MISC)   .clientTrackingRange(8).sized(0.25F, 0.25F).build("fire_rain"));
    DeferredHolder<EntityType<?>, EntityType<FallingStar>>       FALLING_STAR       = ENTITY_TYPES.register("falling_star",       () -> EntityType.Builder.of(FallingStar::new,       MobCategory.MISC)   .clientTrackingRange(8).sized(0.25F, 0.25F).build("falling_star"));
    DeferredHolder<EntityType<?>, EntityType<WaterGuardian>>     WATER_GUARDIAN     = ENTITY_TYPES.register("water_guardian",     () -> EntityType.Builder.of(WaterGuardian::new,     MobCategory.MONSTER).clientTrackingRange(8).sized(    1,  1.5F).build("water_guardian"));
    DeferredHolder<EntityType<?>, EntityType<FireGuardian>>      FIRE_GUARDIAN      = ENTITY_TYPES.register("fire_guardian",      () -> EntityType.Builder.of(FireGuardian::new,      MobCategory.MONSTER).clientTrackingRange(8).sized(    1,     3).build("fire_guardian"));
    DeferredHolder<EntityType<?>, EntityType<EarthGuardian>>     EARTH_GUARDIAN     = ENTITY_TYPES.register("earth_guardian",     () -> EntityType.Builder.of(EarthGuardian::new,     MobCategory.MONSTER).clientTrackingRange(8).sized( 1.5F,  2.5F).build("earth_guardian"));
    DeferredHolder<EntityType<?>, EntityType<AirGuardian>>       AIR_GUARDIAN       = ENTITY_TYPES.register("air_guardian",       () -> EntityType.Builder.of(AirGuardian::new,       MobCategory.MONSTER).clientTrackingRange(8).sized( 0.6F, 1.75F).build("air_guardian"));
    DeferredHolder<EntityType<?>, EntityType<IceGuardian>>       ICE_GUARDIAN       = ENTITY_TYPES.register("ice_guardian",       () -> EntityType.Builder.of(IceGuardian::new,       MobCategory.MONSTER).clientTrackingRange(8).sized( 1.5F,     3).build("ice_guardian"));
    DeferredHolder<EntityType<?>, EntityType<LightningGuardian>> LIGHTNING_GUARDIAN = ENTITY_TYPES.register("lightning_guardian", () -> EntityType.Builder.of(LightningGuardian::new, MobCategory.MONSTER).clientTrackingRange(8).sized( 0.5F, 1.25F).build("lightning_guardian"));
    DeferredHolder<EntityType<?>, EntityType<NatureGuardian>>    NATURE_GUARDIAN    = ENTITY_TYPES.register("nature_guardian",    () -> EntityType.Builder.of(NatureGuardian::new,    MobCategory.MONSTER).clientTrackingRange(8).sized(1.25F, 4.25F).build("nature_guardian"));
    DeferredHolder<EntityType<?>, EntityType<LifeGuardian>>      LIFE_GUARDIAN      = ENTITY_TYPES.register("life_guardian",      () -> EntityType.Builder.of(LifeGuardian::new,      MobCategory.MONSTER).clientTrackingRange(8).sized(    1, 1.25F).build("life_guardian"));
    DeferredHolder<EntityType<?>, EntityType<ArcaneGuardian>>    ARCANE_GUARDIAN    = ENTITY_TYPES.register("arcane_guardian",    () -> EntityType.Builder.of(ArcaneGuardian::new,    MobCategory.MONSTER).clientTrackingRange(8).sized( 0.9F, 2.25F).build("arcane_guardian"));
    DeferredHolder<EntityType<?>, EntityType<EnderGuardian>>     ENDER_GUARDIAN     = ENTITY_TYPES.register("ender_guardian",     () -> EntityType.Builder.of(EnderGuardian::new,     MobCategory.MONSTER).clientTrackingRange(8).sized(    1, 2.25F).build("ender_guardian"));
    DeferredHolder<EntityType<?>, EntityType<WintersGrasp>>      WINTERS_GRASP      = ENTITY_TYPES.register("winters_grasp",      () -> EntityType.Builder.of(WintersGrasp::new,      MobCategory.MISC)   .clientTrackingRange(8).sized(0.25F, 0.25F).build("winters_grasp"));
    DeferredHolder<EntityType<?>, EntityType<NatureScythe>>      NATURE_SCYTHE      = ENTITY_TYPES.register("nature_scythe",      () -> EntityType.Builder.of(NatureScythe::new,      MobCategory.MISC)   .clientTrackingRange(8).sized(0.25F, 0.25F).build("nature_scythe"));
    DeferredHolder<EntityType<?>, EntityType<ThrownRock>>        THROWN_ROCK        = ENTITY_TYPES.register("thrown_rock",        () -> EntityType.Builder.of(ThrownRock::new,        MobCategory.MISC)   .clientTrackingRange(8).sized( 0.5F,  0.5F).build("thrown_rock"));
    DeferredHolder<EntityType<?>, EntityType<Shockwave>>         SHOCKWAVE          = ENTITY_TYPES.register("shockwave",          () -> EntityType.Builder.of(Shockwave::new,         MobCategory.MISC)   .clientTrackingRange(8).sized(0.25F, 0.25F).build("shockwave"));
    DeferredHolder<EntityType<?>, EntityType<Whirlwind>>         WHIRLWIND          = ENTITY_TYPES.register("whirlwind",          () -> EntityType.Builder.of(Whirlwind::new,         MobCategory.MISC)   .clientTrackingRange(8).sized(0.25F, 0.25F).build("whirlwind"));
    DeferredHolder<EntityType<?>, EntityType<Dryad>>             DRYAD              = ENTITY_TYPES.register("dryad",              () -> EntityType.Builder.of(Dryad::new,             MobCategory.AMBIENT).clientTrackingRange(8).sized( 0.6F,  1.8F).build("dryad"));
    DeferredHolder<EntityType<?>, EntityType<Mage>>              MAGE               = ENTITY_TYPES.register("mage",               () -> EntityType.Builder.of(Mage::new,              MobCategory.MONSTER).clientTrackingRange(8).sized( 0.6F,  1.8F).build("mage"));
    DeferredHolder<EntityType<?>, EntityType<ManaCreeper>>       MANA_CREEPER       = ENTITY_TYPES.register("mana_creeper",       () -> EntityType.Builder.of(ManaCreeper::new,       MobCategory.MONSTER).clientTrackingRange(8).sized( 0.6F,  1.7F).build("mana_creeper"));
    DeferredHolder<EntityType<?>, EntityType<ManaVortex>>        MANA_VORTEX        = ENTITY_TYPES.register("mana_vortex",        () -> EntityType.Builder.of(ManaVortex::new,        MobCategory.MISC)   .clientTrackingRange(8).sized(0.25F, 0.25F).build("mana_vortex"));

    /**
     * Empty method that is required for classloading
     */
    @Internal
    static void register() {}
}
