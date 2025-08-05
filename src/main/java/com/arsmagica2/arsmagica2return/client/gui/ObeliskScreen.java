package com.arsmagica2.arsmagica2return.client.gui;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.common.block.obelisk.ObeliskMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ObeliskScreen extends AbstractContainerScreen<ObeliskMenu> {
    private static final ResourceLocation LOCATION = new ResourceLocation(ArsMagicaAPI.MOD_ID, "textures/gui/obelisk.png");

    public ObeliskScreen(ObeliskMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShaderTexture(0, LOCATION);
        pGuiGraphics.blit(LOCATION, leftPos, topPos, 0, 0, imageWidth, imageHeight);
        if (menu.isLit()) {
            int k = menu.getLitProgress();
            pGuiGraphics.blit(LOCATION, leftPos + 80, topPos + 31 + 12 - k, 176, 12 - k, 14, k + 1);
        }
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        renderTransparentBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTicks);
        renderTooltip(graphics, mouseX, mouseY);
    }
}
