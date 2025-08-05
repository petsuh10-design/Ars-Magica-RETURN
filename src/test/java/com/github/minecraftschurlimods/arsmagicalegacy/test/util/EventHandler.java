package com.arsmagica2.arsmagica2return.test.util;

import com.arsmagica2.arsmagica2return.ArsMagicaLegacy;
import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.bus.api.EventPriority;
import net.minecraftforge.bus.api.SubscribeEvent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.neoforge.common.NeoForge;
import net.minecraftforge.neoforge.event.RegisterCommandsEvent;
import net.minecraftforge.testframework.conf.ClientConfiguration;
import net.minecraftforge.testframework.conf.Feature;
import net.minecraftforge.testframework.conf.FrameworkConfiguration;
import net.minecraftforge.testframework.impl.MutableTestFramework;
import net.minecraftforge.testframework.summary.GitHubActionsStepSummaryDumper;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = ArsMagicaAPI.MOD_ID)
public class EventHandler {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    static void initTestframework(FMLConstructModEvent evt) {
        ModContainer container = ArsMagicaLegacy.getModContainer();
        FrameworkConfiguration configuration = FrameworkConfiguration
                .builder(new ResourceLocation(container.getModId(), "tests"))
                .clientConfiguration(() -> ClientConfiguration.builder().toggleOverlayKey(GLFW.GLFW_KEY_J).openManagerKey(GLFW.GLFW_KEY_N).build())
                .enable(Feature.CLIENT_SYNC, Feature.CLIENT_MODIFICATIONS, Feature.TEST_STORE)
                .dumpers(new GitHubActionsStepSummaryDumper(ArsMagicaLegacy.getModName() + " Gametest Summary"))
                .build();

        final MutableTestFramework framework = configuration.create();
        framework.init(container.getEventBus(), container);

        NeoForge.EVENT_BUS.addListener((final RegisterCommandsEvent event) -> {
            final LiteralArgumentBuilder<CommandSourceStack> node = Commands.literal("tests");
            framework.registerCommands(node);
            event.getDispatcher().register(node);
        });
    }
}
