package com.glados.bot.listeners;

import com.glados.bot.config.ReactionRoleConfig;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ReactionRoleListener extends ListenerAdapter {

    /**
     * Handles the addition of a reaction to a message. Evaluates if the reaction is relevant,
     * resolves the corresponding role, and assigns it to the reacting member if applicable.
     *
     * @param event The MessageReactionAddEvent containing details of the reaction event,
     *              including the reacting member, the reaction itself, and the affected message.
     */
    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        if (!isRelevantReaction(event)) {
            return;
        }

        Member member = event.getMember();
        if (member == null)  {
            return;
        }

        Role role = resolveRole(event);
        if (role == null)  {
            return;
        }

        addRole(member, role, event);
    }

    /**
     * Determines whether the provided MessageReactionAddEvent is relevant based on predefined criteria.
     * This includes checking if the event originates from a guild, ensuring the user is not a bot,
     * and matching the reaction's channel ID and message ID to configured values.
     *
     * @param event The MessageReactionAddEvent to evaluate.
     * @return true if the reaction is relevant, false otherwise.
     */
    private boolean isRelevantReaction(MessageReactionAddEvent event) {
        if (!event.isFromGuild()) {
            return false;
        }

        var user = event.getUser();
        if (user == null || user.isBot()) {
            return false;
        }

        if (event.getChannel().getIdLong() != ReactionRoleConfig.CHANNEL_ID) {
            return false;
        }

        return event.getMessageIdLong() == ReactionRoleConfig.MESSAGE_ID;
    }

    /**
     * Resolves a role based on the reaction added to a message.
     * Maps the emoji reaction to a predefined role ID and retrieves the corresponding role from the guild.
     *
     * @param event The MessageReactionAddEvent containing the reaction details.
     * @return The Role corresponding to the reaction, or null if no matching role is found.
     */
    private Role resolveRole(MessageReactionAddEvent event) {
        String key = event.getReaction().getEmoji().getAsReactionCode();
        Long roleId = ReactionRoleConfig.EMOJI_TO_ROLE.get(key);
        if (roleId == null) {
            return null;
        }
        return event.getGuild().getRoleById(roleId);
    }

    /**
     * Adds a specified role to a specified member in response to a message reaction event.
     * Logs the outcome of the role assignment operation, indicating success or failure.
     *
     * @param member The guild member to whom the role is to be added.
     * @param role The role to be assigned to the member.
     * @param event The MessageReactionAddEvent triggering the addition of the role.
     */
    private void addRole(Member member, Role role, MessageReactionAddEvent event) {
        event.getGuild()
                .addRoleToMember(member, role)
                .queue(
                        success -> System.out.println(
                                "Added role " + role.getName()
                                        + " to " + member.getEffectiveName()
                        ),
                        error -> System.err.println(
                                "Failed to add role: " + error.getMessage()
                        )
                );
    }
}
