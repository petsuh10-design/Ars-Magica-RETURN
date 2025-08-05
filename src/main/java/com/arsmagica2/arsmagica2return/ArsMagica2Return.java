package com.arsmagica2.arsmagica2return;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ArsMagica2Return.MOD_ID)
public class ArsMagica2Return {
    public static final String MOD_ID = "arsmagica2return";
    private static final Logger LOGGER = LogManager.getLogger();

    public ArsMagica2Return() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Реєстрація на подальше розширення
        MinecraftForge.EVENT_BUS.register(this);
        
        LOGGER.info("Ars Magica 2 Return успішно завантажено!");
    }
}