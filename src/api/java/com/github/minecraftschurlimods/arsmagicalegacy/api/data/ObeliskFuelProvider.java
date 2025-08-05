package com.arsmagica2.arsmagica2return.api.data;

import com.arsmagica2.arsmagica2return.api.etherium.ObeliskFuel;
import com.github.minecraftschurlimods.easydatagenlib.api.AbstractDatapackRegistryProvider;

public abstract class ObeliskFuelProvider extends AbstractDatapackRegistryProvider<ObeliskFuel> {
    protected ObeliskFuelProvider(String namespace) {
        super(ObeliskFuel.REGISTRY_KEY, namespace);
    }
}
