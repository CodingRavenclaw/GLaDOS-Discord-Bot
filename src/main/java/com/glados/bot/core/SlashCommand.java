package com.glados.bot.core;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public interface SlashCommand {

    /**
     * Retrieves the slash command data associated with this command.
     *
     * @return The SlashCommandData representing this command, including its name and description.
     */
    SlashCommandData getCommandData();

    /**
     * Executes the specific logic associated with the triggered slash command.
     *
     * @param anEvent The slash command interaction event containing the context
     *                of the command, including the user interaction and any
     *                provided arguments.
     */
    void execute(SlashCommandInteractionEvent anEvent);
}
