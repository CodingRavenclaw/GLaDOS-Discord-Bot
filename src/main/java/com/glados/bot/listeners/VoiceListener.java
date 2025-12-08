package com.glados.bot.listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.concrete.Category;
import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.unions.AudioChannelUnion;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class VoiceListener extends ListenerAdapter {

    /**
     * Handles updates to voice state in a guild, such as a member joining or leaving a voice/stage channel.
     * Updates the name of the parent category of the affected voice or stage channel
     * to reflect the total number of users present in all voice/stage channels within the category.
     *
     * @param event the GuildVoiceUpdateEvent containing details about the voice state change,
     *              including the member and channels involved in the update.
     */
    @Override
    public void onGuildVoiceUpdate(@NotNull GuildVoiceUpdateEvent event) {
        Member member = event.getMember();
        AudioChannelUnion channelJoined = event.getChannelJoined();
        AudioChannelUnion channelLeft = event.getChannelLeft();

        AudioChannelUnion channel = channelJoined != null ? channelJoined : channelLeft;
        if (channel == null) {
            return;
        }

        Category category = channel.getParentCategory();
        if (category == null) {
            return;
        }

        category.getManager()
                .setName(getString(category))
                .queue();
    }

    /**
     * Constructs a string that displays the total number of users across all voice and stage channels
     * within a given category. The string includes a label and the user count.
     *
     * @param category the category containing the channels to calculate the user count from
     * @return a formatted string indicating the total number of users in the voice and stage channels
     *         within the specified category
     */
    @NotNull
    private static String getString(Category category) {
        int totalUsersInCategoryVoiceChannels = 0;

        for (GuildChannel guildChannel : category.getChannels()) {
            switch (guildChannel.getType()) {
                case VOICE:
                case STAGE:
                    AudioChannel audioChannel = (AudioChannel) guildChannel;
                    totalUsersInCategoryVoiceChannels += audioChannel.getMembers().size();
                    break;
                default:
                    break;
            }
        }

        String baseName = "📞 VOICE | ";
        return baseName + totalUsersInCategoryVoiceChannels + " USER(s) 📞";
    }

}
