package com.arsmagica2.arsmagica2return.common.init;

import com.arsmagica2.arsmagica2return.api.spell.ISpell;
import com.github.minecraftschurlimods.codeclib.CodecEntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraftforge.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

import static com.arsmagica2.arsmagica2return.common.init.AMRegistries.ENTITY_DATA_SERIALIZERS;

@NonExtendable
public interface AMDataSerializers {
    DeferredHolder<EntityDataSerializer<?>, CodecEntityDataSerializer<ISpell>> SPELL = ENTITY_DATA_SERIALIZERS.register("spell", () -> new CodecEntityDataSerializer<>(ISpell.CODEC));

    /**
     * Empty method that is required for classloading
     */
    @Internal
    static void register() {}
}
