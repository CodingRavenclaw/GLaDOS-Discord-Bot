package com.glados.bot.commands;

import com.glados.bot.core.SlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public class QuakieSlashCommand implements SlashCommand {

    @Override
    public SlashCommandData getCommandData() {
        return Commands.slash("quakie", "Returns a quote from the famous quakie!");
    }

    /**
     * Executes the "quakie" slash command, replying with a random quote attributed to "Lukas".
     *
     * @param event The event that triggered the slash command interaction.
     */
    @Override
    public void execute(SlashCommandInteractionEvent event) {
        String[] lukasQuotes = {
                "Lukas sagt: Hauptsache weg vom Weiß!",
                "Lukas sagt: CS2 kann mich sowas von mal...",
                "Lukas schreit: ER PREFIRED MICH!!!",
                "Lukas sagt: Maxim hat eine Pistole in der Hand! Traitor...",
                "Lukas sagt: ICH BINS NICHT!",
                "Lukas sagt: Ich mach den Capocall!",
                "Lukas sagt: Jungs, ich bereite mich gerade mental auf den Capocall vor...",
                "Lukas sagt: Es ist unfassbar!",
                "Lukas sagt: Digga der Bot!",
                "Lukas sagt: Ich bin ein Bot!",
                "Lukas sagt: Also Jungs... also... meine Rechte... eigentlich könnte ich doch Mod werden, oder?",
                "Lukas sagt: Ich bin gebrochen... alles vergambelt...",
                "Lukas sagt: Ich bin kein Schwabe!",
                "Lukas sagt: Moment mal! Moment mal!",
        };

        int randomIndex = (int) (Math.random() * lukasQuotes.length);
        String randomQuote = lukasQuotes[randomIndex];

        event.reply(randomQuote).queue();
    }
}