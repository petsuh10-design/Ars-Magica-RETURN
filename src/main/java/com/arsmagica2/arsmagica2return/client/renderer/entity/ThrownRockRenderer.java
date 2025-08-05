package com.arsmagica2.arsmagica2return.client.renderer.entity;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.client.model.entity.ThrownRockModel;
import com.arsmagica2.arsmagica2return.common.entity.ThrownRock;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ThrownRockRenderer extends NonLiving3DModelRenderer<ThrownRock, ThrownRockModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ArsMagicaAPI.MOD_ID, "textures/entity/earth_guardian.png");

    public ThrownRockRenderer(EntityRendererProvider.Context context) {
        super(context, new ThrownRockModel(context.bakeLayer(ThrownRockModel.LAYER_LOCATION)));
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownRock pEntity) {
        return TEXTURE;
    }
}
