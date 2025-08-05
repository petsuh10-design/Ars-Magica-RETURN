package com.arsmagica2.arsmagica2return.client.hud;

import com.arsmagica2.arsmagica2return.Config;
import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.api.magic.IManaHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.neoforge.client.gui.overlay.ExtendedGui;

public final class ManaHUD extends AbstractHUD {
    public ManaHUD() {
        super(Config.CLIENT.MANA_ANCHOR_X, Config.CLIENT.MANA_ANCHOR_Y, Config.CLIENT.MANA_X, Config.CLIENT.MANA_Y, 80, 10);
    }

    @Override
    public void draw(ExtendedGui forgeGui, GuiGraphics graphics, float partialTick) {
        Player player = Minecraft.getInstance().player;
        var api = ArsMagicaAPI.get();
        if (player == null || !api.getMagicHelper().knowsMagic(player)) return;
        double mana = 0;
        double maxMana = 0;
        if (!player.isDeadOrDying()) {
            IManaHelper manaHelper = api.getManaHelper();
            mana = manaHelper.getMana(player);
            maxMana = manaHelper.getMaxMana(player);
        }
        if (maxMana > 0) {
            renderBar(graphics, 0, 0, getWidth(), getHeight(), mana, maxMana, 0x99FFFF);
        }
    }
}
