package com.arsmagica2.arsmagica2return.api.data;

import com.arsmagica2.arsmagica2return.api.affinity.Ability;
import com.github.minecraftschurlimods.easydatagenlib.api.AbstractDatapackRegistryProvider;

public abstract class AbilityProvider extends AbstractDatapackRegistryProvider<Ability> {
    protected AbilityProvider(String namespace) {
        super(Ability.REGISTRY_KEY, namespace);
    }
}
