package com.arsmagica2.arsmagica2return.client.renderer.entity;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.client.model.entity.NatureScytheModel;
import com.arsmagica2.arsmagica2return.common.entity.NatureScythe;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class NatureScytheRenderer extends NonLiving3DModelRenderer<NatureScythe, NatureScytheModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ArsMagicaAPI.MOD_ID, "textures/entity/nature_guardian.png");

    public NatureScytheRenderer(EntityRendererProvider.Context context) {
        super(context, new NatureScytheModel(context.bakeLayer(NatureScytheModel.LAYER_LOCATION)));
    }

    @Override
    public ResourceLocation getTextureLocation(NatureScythe pEntity) {
        return TEXTURE;
    }
}
