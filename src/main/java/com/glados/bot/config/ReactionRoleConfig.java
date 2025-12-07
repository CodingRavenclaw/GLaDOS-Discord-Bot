package com.glados.bot.config;

import java.util.Map;

public final class ReactionRoleConfig {

    public static final long CHANNEL_ID =
            Long.parseLong(System.getenv("ROLE_REACTION_CHANNEL_ID"));

    public static final long MESSAGE_ID =
            Long.parseLong(System.getenv("ROLE_REACTION_MESSAGE_ID"));

    public static final Map<String, Long> EMOJI_TO_ROLE = Map.of(
            System.getenv("EMOJI_ID_CS2"), Long.parseLong(System.getenv("ROLE_ID_CS2")),
            System.getenv("EMOJI_ID_GARRYS_MOD"), Long.parseLong(System.getenv("ROLE_ID_GARRYS_MOD"))
    );

    private ReactionRoleConfig() { }
}
