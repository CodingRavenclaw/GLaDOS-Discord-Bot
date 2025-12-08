package com.glados.bot;

import com.glados.bot.core.SlashCommandManager;
import com.glados.bot.listeners.ReactionRoleListener;
import com.glados.bot.listeners.SlashCommandListener;
import com.glados.bot.listeners.VoiceListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BotApplication extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(BotApplication.class);

    /**
     * The main method serves as the entry point for the application. It initializes the required
     * dependencies, sets up the bot with event listeners, configures its activity, and updates
     * the bot's slash commands on startup.
     *
     * @param args Command-line arguments passed to the program.
     * @throws Exception If there is an issue during the initialization process, including failures
     *                   in loading environment variables, building the JDA instance, or registering commands.
     */
    public static void main(String[] args) throws Exception {
        String token = System.getenv("DISCORD_TOKEN");

        SlashCommandManager commandManager = new SlashCommandManager();

        JDA jda = JDABuilder.createDefault(
                token,
                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_VOICE_STATES
                )
                .addEventListeners(new BotApplication())
                .addEventListeners(new SlashCommandListener(commandManager))
                .addEventListeners(new ReactionRoleListener())
                .addEventListeners(new VoiceListener())
                .setActivity(Activity.playing("Recklinghausen > Derbe..."))
                .build()
                .awaitReady();

        jda.updateCommands()
                .addCommands(commandManager.getAllCommandData())
                .queue();

        if (System.getenv("MODE").equals("DEV")) {
            LOGGER.info("Bot is running in development mode.");
        }
    }
}
