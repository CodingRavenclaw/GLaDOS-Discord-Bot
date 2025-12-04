package com.glados.bot.listeners;

import com.glados.bot.core.SlashCommandManager;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class SlashCommandListener extends ListenerAdapter {

    private final SlashCommandManager commandManager;

    /**
     * Constructor with dependency injection.
     *
     * @param commandManager The slash command manager.
     */
    public SlashCommandListener(SlashCommandManager commandManager) {
        this.commandManager = commandManager;
    }

    /**
     * Handles an interaction event triggered by a slash command. Delegates
     * the event to the registered command manager for further processing and execution.
     *
     * @param event The SlashCommandInteractionEvent representing a triggered slash command,
     *              including the command's name, user context, and any provided arguments.
     */
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        commandManager.handle(event);
    }
}
