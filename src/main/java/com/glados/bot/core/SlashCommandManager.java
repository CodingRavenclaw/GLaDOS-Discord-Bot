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
     * Constructs a new instance of the SlashCommandManager class and initializes
     * it by automatically registering all default slash commands.
     */
    public SlashCommandManager() {
        registerDefaults();
    }


    /**
     * Registers the default set of slash commands to the command manager.
     */
    private void registerDefaults() {
        register(new PingSlashCommand());
        register(new QuakieSlashCommand());
    }

    /**
     * Registers a provided slash command with the command manager, allowing it
     * to be recognized and executed based on its name.
     *
     * @param aCommand The slash command to be registered. It must implement
     *                 the SlashCommand interface and provide the relevant
     *                 SlashCommandData, including the command name and description.
     */
    public void register(SlashCommand aCommand) {
        String commandName = aCommand.getCommandData().getName().toLowerCase();
        commands.put(commandName, aCommand);
    }

    /**
     * Retrieves a list of all registered slash command data from the command manager.
     * Each slash command's data includes relevant metadata such as its name and description.
     *
     * @return A list of {@code SlashCommandData} representing all registered slash commands.
     */
    public List<SlashCommandData> getAllCommandData() {
        return commands.values().stream()
                .map(SlashCommand::getCommandData)
                .collect(Collectors.toList());
    }


    /**
     * Handles an incoming slash command interaction event by routing it to the appropriate
     * command implementation registered in the SlashCommandManager. If the command is not
     * recognized, a default reply is sent back indicating an unknown command.
     *
     * @param anEvent The slash command interaction event containing the context of the
     *                triggered command, including its name, user information, and any
     *                provided arguments.
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
