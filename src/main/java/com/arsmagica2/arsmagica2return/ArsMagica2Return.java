package com.arsmagica2.arsmagica2return;

import com.arsmagica2.arsmagica2return.common.blocks.AMBlocks;
import com.arsmagica2.arsmagica2return.common.items.AMItems;
import com.arsmagica2.arsmagica2return.common.magic.AMSpells;
import com.arsmagica2.arsmagica2return.common.network.AMNetworking;
import com.arsmagica2.arsmagica2return.common.registries.AMRegistries;
import com.arsmagica2.arsmagica2return.common.capabilities.AMCapabilities;
import com.arsmagica2.arsmagica2return.common.config.AMConfig;
import com.arsmagica2.arsmagica2return.common.worldgen.AMWorldGen;
import com.arsmagica2.arsmagica2return.client.ClientSetup;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ArsMagica2Return.MOD_ID)
public class ArsMagica2Return {
    public static final String MOD_ID = "arsmagica2return";
    public static final String MOD_NAME = "Ars Magica 2 Return";
    
    private static final Logger LOGGER = LogManager.getLogger();
    
    public ArsMagica2Return() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Реєстрація основних компонентів
        AMRegistries.init(modEventBus);
        AMBlocks.BLOCKS.register(modEventBus);
        AMItems.ITEMS.register(modEventBus);
        AMSpells.init(modEventBus);
        AMCapabilities.register(modEventBus);
        
        // Конфігурація
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AMConfig.COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, AMConfig.CLIENT_SPEC);
        
        // Події
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);
        
        // Клієнтська частина
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            modEventBus.addListener(ClientSetup::init);
        });
        
        MinecraftForge.EVENT_BUS.register(this);
        
        LOGGER.info("Ars Magica 2 Return завантажується...");
    }
    
    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Ініціалізація Ars Magica 2 Return...");
        
        event.enqueueWork(() -> {
            // Мережа
            AMNetworking.register();
            
            // Генерація світу
            AMWorldGen.register();
            
            // Можливості
            AMCapabilities.setup();
        });
        
        LOGGER.info("Ars Magica 2 Return успішно ініціалізовано!");
    }
    
    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Клієнтська ініціалізація Ars Magica 2 Return...");
    }
    
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Ars Magica 2 Return запускається на сервері...");
    }
    
    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
    
    public static Logger getLogger() {
        return LOGGER;
    }
}