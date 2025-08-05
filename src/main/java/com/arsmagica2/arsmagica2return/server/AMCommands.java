package com.arsmagica2.arsmagica2return.server;

import com.arsmagica2.arsmagica2return.api.ArsMagicaAPI;
import com.arsmagica2.arsmagica2return.server.commands.AffinityCommand;
import com.arsmagica2.arsmagica2return.server.commands.MagicXpCommand;
import com.arsmagica2.arsmagica2return.server.commands.SkillCommand;
import com.arsmagica2.arsmagica2return.server.commands.SkillPointCommand;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public final class AMCommands {
    static void registerCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
        LiteralArgumentBuilder<CommandSourceStack> builder = Commands.literal(ArsMagicaAPI.MOD_ID).requires(p -> p.hasPermission(2));
        AffinityCommand.register(builder);
        MagicXpCommand.register(builder);
        SkillCommand.register(builder);
        SkillPointCommand.register(builder);
        dispatcher.register(builder);
    }
}
