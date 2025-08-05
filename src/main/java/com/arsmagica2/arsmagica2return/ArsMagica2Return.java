package com.arsmagica2.arsmagica2return;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.client.ClientInit;
import com.arsmagica2.arsmagica2return.common.affinity.AffinityHelper;
import com.arsmagica2.arsmagica2return.common.etherium.EtheriumHelper;
import com.arsmagica2.arsmagica2return.common.handler.EventHandler;
import com.arsmagica2.arsmagica2return.common.init.AMRegistries;
import com.arsmagica2.arsmagica2return.common.magic.BurnoutHelper;
import com.arsmagica2.arsmagica2return.common.magic.ContingencyHelper;
import com.arsmagica2.arsmagica2return.common.magic.MagicHelper;
import com.arsmagica2.arsmagica2return.common.magic.ManaHelper;
import com.arsmagica2.arsmagica2return.common.magic.RiftHelper;
import com.arsmagica2.arsmagica2return.common.skill.SkillHelper;
import com.arsmagica2.arsmagica2return.common.spell.SpellDataManager;
import com.arsmagica2.arsmagica2return.compat.CompatManager;
import com.arsmagica2.arsmagica2return.network.NetworkInit;
import com.arsmagica2.arsmagica2return.server.ServerInit;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

@Mod(ArsMagicaAPI.MOD_ID)
public final class ArsMagica2Return {
    public static final Logger LOGGER = LoggerFactory.getLogger(ArsMagicaAPI.MOD_ID);
    private static ArsMagica2Return INSTANCE;

    private final ModContainer modContainer;

    public ArsMagica2Return(ModContainer container, IEventBus bus) {
        if (INSTANCE != null) {
            IllegalStateException exception = new IllegalStateException("Tried to create mod " + ArsMagicaAPI.MOD_ID + " more than once!");
            LOGGER.error(exception.getMessage(), exception);
            throw exception;
        }
        if (!(ArsMagicaAPI.get() instanceof ArsMagicaAPIImpl)) {
            IllegalStateException exception = new IllegalStateException("API was not initialized!");
            LOGGER.error(exception.getMessage(), exception);
            throw exception;
        }
        INSTANCE = this;
        modContainer = container;
        GeckoLib.initialize(bus);
        AMRegistries.init(bus);
        EventHandler.register(bus);
        CompatManager.register(bus);
        NetworkInit.init(bus);
        
        ServerInit.init(bus);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            ClientInit.init(bus);
        }
        
        // Ініціалізація магічних систем
        ManaHelper.init();
        BurnoutHelper.init();
        AffinityHelper.init();
        SkillHelper.init();
        ContingencyHelper.init();
        RiftHelper.init();
        MagicHelper.init();
        EtheriumHelper.init();
        SpellDataManager.init();

        LOGGER.info("Ars Magica 2 Return successfully loaded!");
    }

    public static ArsMagica2Return getInstance() {
        return INSTANCE;
    }

    public ModContainer getModContainer() {
        return modContainer;
    }
}