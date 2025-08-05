package com.arsmagica2.arsmagica2return.api.client;

import com.arsmagica2.arsmagica2return.api.spell.ISpellIngredient;
import com.arsmagica2.arsmagica2return.api.spell.SpellIngredientType;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;

/**
 * Renderer for spell ingredients.
 */
public interface ISpellIngredientRenderer<T extends ISpellIngredient> {
    /**
     * Renders the passed ingredient instance in world.
     *
     * @param ingredient The ingredient to render.
     */
    void renderInWorld(T ingredient, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay);

    /**
     * Renders the passed ingredient in a gui.
     *
     * @param ingredient The ingredient to render.
     */
    void renderInGui(T ingredient, GuiGraphics graphics, int x, int y, int mouseX, int mouseY);

    @SuppressWarnings("unchecked")
    static ISpellIngredientRenderer<ISpellIngredient> getFor(SpellIngredientType<? extends ISpellIngredient> type) {
        return (ISpellIngredientRenderer<ISpellIngredient>) type.renderFactory().get();
    }
}
