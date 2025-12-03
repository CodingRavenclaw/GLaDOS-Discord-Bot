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

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        commandManager.handle(event);
    }
}
