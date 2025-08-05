package com.arsmagica2.arsmagica2return.common.init;

import com.arsmagica2.arsmagica2return.api.ritual.RitualEffect;
import com.arsmagica2.arsmagica2return.api.ritual.RitualRequirement;
import com.arsmagica2.arsmagica2return.api.ritual.RitualTrigger;
import com.arsmagica2.arsmagica2return.common.ritual.effect.EntitySpawnRitualEffect;
import com.arsmagica2.arsmagica2return.common.ritual.effect.LearnSkillRitualEffect;
import com.arsmagica2.arsmagica2return.common.ritual.effect.PlaceBlockRitualEffect;
import com.arsmagica2.arsmagica2return.common.ritual.requirement.BiomeRequirement;
import com.arsmagica2.arsmagica2return.common.ritual.requirement.DimensionRequirement;
import com.arsmagica2.arsmagica2return.common.ritual.requirement.DimensionTypeRequirement;
import com.arsmagica2.arsmagica2return.common.ritual.requirement.HeightRequirement;
import com.arsmagica2.arsmagica2return.common.ritual.requirement.ItemRequirement;
import com.arsmagica2.arsmagica2return.common.ritual.requirement.MagicLevelRequirement;
import com.arsmagica2.arsmagica2return.common.ritual.requirement.MoonPhaseRequirement;
import com.arsmagica2.arsmagica2return.common.ritual.requirement.RitualStructureRequirement;
import com.arsmagica2.arsmagica2return.common.ritual.requirement.UltrawarmDimensionRequirement;
import com.arsmagica2.arsmagica2return.common.ritual.trigger.EntityDeathTrigger;
import com.arsmagica2.arsmagica2return.common.ritual.trigger.EntitySummonTrigger;
import com.arsmagica2.arsmagica2return.common.ritual.trigger.GameEventRitualTrigger;
import com.arsmagica2.arsmagica2return.common.ritual.trigger.ItemDropRitualTrigger;
import com.arsmagica2.arsmagica2return.common.ritual.trigger.SpellComponentCastRitualTrigger;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

import static com.arsmagica2.arsmagica2return.common.init.AMRegistries.RITUAL_EFFECT_TYPES;
import static com.arsmagica2.arsmagica2return.common.init.AMRegistries.RITUAL_REQUIREMENT_TYPES;
import static com.arsmagica2.arsmagica2return.common.init.AMRegistries.RITUAL_TRIGGER_TYPES;

@NonExtendable
public interface AMRituals {
    Holder<Codec<? extends RitualTrigger>> ENTITY_DEATH_TRIGGER = RITUAL_TRIGGER_TYPES.register("entity_death", () -> EntityDeathTrigger.CODEC);
    Holder<Codec<? extends RitualTrigger>> ENTITY_SUMMON_TRIGGER = RITUAL_TRIGGER_TYPES.register("entity_summon", () -> EntitySummonTrigger.CODEC);
    Holder<Codec<? extends RitualTrigger>> ITEM_DROP_TRIGGER = RITUAL_TRIGGER_TYPES.register("item_drop", () -> ItemDropRitualTrigger.CODEC);
    Holder<Codec<? extends RitualTrigger>> GAME_EVENT_TRIGGER = RITUAL_TRIGGER_TYPES.register("game_event", () -> GameEventRitualTrigger.CODEC);
    Holder<Codec<? extends RitualTrigger>> SPELL_COMPONENT_CAST_TRIGGER = RITUAL_TRIGGER_TYPES.register("spell_component_cast", () -> SpellComponentCastRitualTrigger.CODEC);

    Holder<Codec<? extends RitualEffect>> SPAWN_ENTITY_EFFECT = RITUAL_EFFECT_TYPES.register("spawn_entity", () -> EntitySpawnRitualEffect.CODEC);
    Holder<Codec<? extends RitualEffect>> LEARN_SKILL_EFFECT = RITUAL_EFFECT_TYPES.register("learn_skill", () -> LearnSkillRitualEffect.CODEC);
    Holder<Codec<? extends RitualEffect>> PLACE_BLOCK_EFFECT = RITUAL_EFFECT_TYPES.register("place_block", () -> PlaceBlockRitualEffect.CODEC);

    Holder<Codec<? extends RitualRequirement>> BIOME_REQUIREMENT = RITUAL_REQUIREMENT_TYPES.register("biome", () -> BiomeRequirement.CODEC);
    Holder<Codec<? extends RitualRequirement>> DIMENSION_REQUIREMENT = RITUAL_REQUIREMENT_TYPES.register("dimension", () -> DimensionRequirement.CODEC);
    Holder<Codec<? extends RitualRequirement>> DIMENSION_TYPE_REQUIREMENT = RITUAL_REQUIREMENT_TYPES.register("dimension_type", () -> DimensionTypeRequirement.CODEC);
    Holder<Codec<? extends RitualRequirement>> HEIGHT_REQUIREMENT = RITUAL_REQUIREMENT_TYPES.register("height", () -> HeightRequirement.CODEC);
    Holder<Codec<? extends RitualRequirement>> MAGIC_LEVEL_REQUIREMENT = RITUAL_REQUIREMENT_TYPES.register("magic_level", () -> MagicLevelRequirement.CODEC);
    Holder<Codec<? extends RitualRequirement>> MOON_PHASE_REQUIREMENT = RITUAL_REQUIREMENT_TYPES.register("moon_phase", () -> MoonPhaseRequirement.CODEC);
    Holder<Codec<? extends RitualRequirement>> RITUAL_STRUCTURE_REQUIREMENT = RITUAL_REQUIREMENT_TYPES.register("structure", () -> RitualStructureRequirement.CODEC);
    Holder<Codec<? extends RitualRequirement>> ULTRAWARM_DIMENSION_REQUIREMENT = RITUAL_REQUIREMENT_TYPES.register("ultrawarm_dimension", () -> UltrawarmDimensionRequirement.CODEC);
    Holder<Codec<? extends RitualRequirement>> ITEM_REQUIREMENT = RITUAL_REQUIREMENT_TYPES.register("item", () -> ItemRequirement.CODEC);

    /**
     * Empty method that is required for classloading
     */
    @ApiStatus.Internal
    static void register() {}
}
