package com.glados.bot.commands;

import com.glados.bot.core.SlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public class PingSlashCommand implements SlashCommand {

    @Override
    public SlashCommandData getCommandData() {
        return Commands.slash("ping", "Answers with pong!");
    }

    /**
     * Executes the "ping" slash command, replying with "Pong! 🏓".
     *
     * @param event The event that triggered the slash command interaction.
     */
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.reply("Pong! 🏓").setEphemeral(true).queue();
    }
}
