package com.arsmagica2.arsmagica2return.api.data;

import com.arsmagica2.arsmagica2return.api.altar.AltarCapMaterial;
import com.github.minecraftschurlimods.easydatagenlib.api.AbstractDatapackRegistryProvider;

public abstract class AltarCapMaterialProvider extends AbstractDatapackRegistryProvider<AltarCapMaterial> {
    protected AltarCapMaterialProvider(String namespace) {
        super(AltarCapMaterial.REGISTRY_KEY, namespace);
    }
}
