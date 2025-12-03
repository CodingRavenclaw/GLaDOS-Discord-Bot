package com.glados.bot.core;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public interface SlashCommand {
    /**
     * Returns the command data for the slash command.
     * @return The command data.
     */
    SlashCommandData getCommandData();

    /**
     * Executes the slash command.
     *
     * @param anEvent The slash command event.
     */
    void execute(SlashCommandInteractionEvent anEvent);
}
