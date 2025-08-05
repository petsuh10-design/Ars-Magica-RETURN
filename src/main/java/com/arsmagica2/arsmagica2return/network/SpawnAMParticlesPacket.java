package com.arsmagica2.arsmagica2return.network;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.client.SpellParticleSpawners;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.neoforge.network.handling.PlayPayloadContext;

public record SpawnAMParticlesPacket(int entity) implements CustomPacketPayload {
    public static final ResourceLocation ID = new ResourceLocation(ArsMagicaAPI.MOD_ID, "spawn_particles");

    SpawnAMParticlesPacket(FriendlyByteBuf buf) {
        this(buf.readInt());
    }

    public SpawnAMParticlesPacket(Entity entity) {
        this(entity.getId());
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        buf.writeInt(entity);
    }

    void handle(PlayPayloadContext context) {
        context.workHandler().execute(() -> SpellParticleSpawners.handleReceivedPacket(entity()));
    }
}
