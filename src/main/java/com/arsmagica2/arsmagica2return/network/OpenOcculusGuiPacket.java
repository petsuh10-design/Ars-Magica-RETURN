package com.arsmagica2.arsmagica2return.network;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.client.ClientHelper;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.neoforge.network.handling.PlayPayloadContext;

public record OpenOcculusGuiPacket() implements CustomPacketPayload {
    public static final ResourceLocation ID = new ResourceLocation(ArsMagicaAPI.MOD_ID, "open_occulus_gui");

    OpenOcculusGuiPacket(FriendlyByteBuf buf) {
        this();
    }

    @Override
    public void write(FriendlyByteBuf buf) {}

    @Override
    public ResourceLocation id() {
        return ID;
    }

    void handle(PlayPayloadContext ctx) {
        ctx.workHandler().execute(ClientHelper::openOcculusGui);
    }
}
