package com.glados.bot.core;

import com.glados.bot.commands.PingSlashCommand;
import com.glados.bot.commands.QuakieSlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SlashCommandManager {

    private final Map<String, SlashCommand> commands = new HashMap<>();

    /**
     * Default constructor registering all default commands.
     */
    public SlashCommandManager() {
        registerDefaults();
    }

    /**
     * Registers all default commands.
     */
    private void registerDefaults() {
        register(new PingSlashCommand());
        register(new QuakieSlashCommand());
    }

    /**
     * Registers a slash command.
     *
     * @param aCommand The slash command to register.
     */
    public void register(SlashCommand aCommand) {
        String commandName = aCommand.getCommandData().getName().toLowerCase();
        commands.put(commandName, aCommand);
    }

    /**
     * Returns all registered slash command data.
     *
     * @return All registered slash command data.
     */
    public List<SlashCommandData> getAllCommandData() {
        return commands.values().stream()
                .map(SlashCommand::getCommandData)
                .collect(Collectors.toList());
    }

    /**
     * Handles a slash command event.
     *
     * @param anEvent The slash command event.
     */
    public void handle(SlashCommandInteractionEvent anEvent) {
        String eventName = anEvent.getName().toLowerCase();
        SlashCommand slashCommand = commands.get(eventName);

        if (slashCommand != null) {
            slashCommand.execute(anEvent);
        } else {
            anEvent.reply("Unknown command!").setEphemeral(true).queue();
        }
    }

}
