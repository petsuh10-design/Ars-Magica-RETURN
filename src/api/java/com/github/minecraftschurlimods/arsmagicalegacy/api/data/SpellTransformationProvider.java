package com.arsmagica2.arsmagica2return.api.data;

import com.arsmagica2.arsmagica2return.api.spell.SpellTransformation;
import com.github.minecraftschurlimods.easydatagenlib.api.AbstractDatapackRegistryProvider;

public abstract class SpellTransformationProvider extends AbstractDatapackRegistryProvider<SpellTransformation> {
    protected SpellTransformationProvider(String namespace) {
        super(SpellTransformation.REGISTRY_KEY, namespace);
    }
}
