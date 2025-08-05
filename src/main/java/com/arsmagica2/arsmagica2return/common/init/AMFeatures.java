package com.arsmagica2.arsmagica2return.common.init;

import com.arsmagica2.arsmagica2return.common.level.SunstoneOreFeature;
import com.arsmagica2.arsmagica2return.common.level.meteorite.MeteoriteFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

import static com.arsmagica2.arsmagica2return.common.init.AMRegistries.FEATURES;

@NonExtendable
public interface AMFeatures {
    DeferredHolder<Feature<?>, MeteoriteFeature>   METEORITE            = FEATURES.register("meteorite", MeteoriteFeature::new);
    DeferredHolder<Feature<?>, SunstoneOreFeature> SUNSTONE_ORE_FEATURE = FEATURES.register("sunstone_ore", SunstoneOreFeature::new);

    /**
     * Empty method that is required for classloading
     */
    @Internal
    static void register() {}
}
