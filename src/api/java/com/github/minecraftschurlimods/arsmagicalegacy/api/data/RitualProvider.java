package com.arsmagica2.arsmagica2return.api.data;

import com.arsmagica2.arsmagica2return.api.ritual.Ritual;
import com.arsmagica2.arsmagica2return.api.ritual.RitualEffect;
import com.arsmagica2.arsmagica2return.api.ritual.RitualRequirement;
import com.arsmagica2.arsmagica2return.api.ritual.RitualTrigger;
import com.github.minecraftschurlimods.easydatagenlib.api.AbstractDatapackRegistryProvider;
import net.minecraft.core.BlockPos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class RitualProvider extends AbstractDatapackRegistryProvider<Ritual> {
    protected RitualProvider(String namespace) {
        super(Ritual.REGISTRY_KEY, namespace);
    }

    /**
     * @param effect  The effect of the ritual.
     * @param trigger The trigger of the trigger.
     */
    public Builder builder(RitualEffect effect, RitualTrigger trigger) {
        return new Builder(effect, trigger);
    }

    public static class Builder {
        private final List<RitualRequirement> requirements = new ArrayList<>();
        private final RitualEffect effect;
        private final RitualTrigger trigger;
        private BlockPos offset = BlockPos.ZERO;

        private Builder(RitualEffect effect, RitualTrigger trigger) {
            this.effect = effect;
            this.trigger = trigger;
        }

        public Builder with(RitualRequirement requirement) {
            this.requirements.add(requirement);
            return this;
        }

        public Builder with(RitualRequirement... requirements) {
            return with(Arrays.asList(requirements));
        }

        public Builder with(List<RitualRequirement> requirements) {
            this.requirements.addAll(requirements);
            return this;
        }

        public Builder with(BlockPos offset) {
            this.offset = offset;
            return this;
        }

        public Ritual build() {
            return new Ritual(trigger, requirements, effect, offset);
        }
    }
}
