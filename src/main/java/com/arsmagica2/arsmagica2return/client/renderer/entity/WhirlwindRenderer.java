package com.arsmagica2.arsmagica2return.client.renderer.entity;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.common.entity.Whirlwind;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class WhirlwindRenderer extends FlatTextureRenderer<Whirlwind> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ArsMagicaAPI.MOD_ID, "textures/entity/whirlwind.png");

    public WhirlwindRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Whirlwind pEntity) {
        return TEXTURE;
    }

    @Override
    protected int getTextureHeight() {
        return 10;
    }
}
