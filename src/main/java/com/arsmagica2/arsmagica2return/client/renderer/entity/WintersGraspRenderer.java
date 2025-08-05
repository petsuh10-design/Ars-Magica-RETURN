package com.arsmagica2.arsmagica2return.client.renderer.entity;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.client.model.entity.WintersGraspModel;
import com.arsmagica2.arsmagica2return.common.entity.WintersGrasp;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class WintersGraspRenderer extends NonLiving3DModelRenderer<WintersGrasp, WintersGraspModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ArsMagicaAPI.MOD_ID, "textures/entity/ice_guardian.png");

    public WintersGraspRenderer(EntityRendererProvider.Context context) {
        super(context, new WintersGraspModel(context.bakeLayer(WintersGraspModel.LAYER_LOCATION)));
    }

    @Override
    public ResourceLocation getTextureLocation(WintersGrasp pEntity) {
        return TEXTURE;
    }
}
