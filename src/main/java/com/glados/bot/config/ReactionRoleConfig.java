package com.glados.bot.config;

import java.util.Map;

public final class ReactionRoleConfig {

    private static final long ADD_GAMES_CHANNEL_ID =
            Long.parseLong(System.getenv("ROLE_REACTION_ADD_GAMES_CHANNEL_ID"));

    private static final long ADD_GAMES_MESSAGE_ID =
            Long.parseLong(System.getenv("ROLE_REACTION_ADD_GAMES_MESSAGE_ID"));

    private static final long ACCEPT_RULES_CHANNEL_ID =
            Long.parseLong(System.getenv("ROLE_REACTION_ACCEPT_RULES_CHANNEL_ID"));

    private static final long ACCEPT_RULES_MESSAGE_ID =
            Long.parseLong(System.getenv("ROLE_REACTION_ACCEPT_RULES_MESSAGE_ID"));

    private static final String EMOJI_ACCEPT = "✅";

    private static final String EMOJI_ID_CS2 = System.getenv("EMOJI_ID_CS2");

    private static final String EMOJI_ID_GARRYS_MOD = System.getenv("EMOJI_ID_GARRYS_MOD");

    private static final String EMOJI_ID_ETS2 = System.getenv("EMOJI_ID_ETS2");

    private static final long ROLE_ID_VISITOR = Long.parseLong(System.getenv("ROLE_ID_VISITOR"));

    private static final long ROLE_ID_ETS2 = Long.parseLong(System.getenv("ROLE_ID_ETS2"));

    private static final long ROLE_ID_CS2 = Long.parseLong(System.getenv("ROLE_ID_CS2"));

    private static final long ROLE_ID_GARRYS_MOD = Long.parseLong(System.getenv("ROLE_ID_GARRYS_MOD"));

    public static final Map<Long, Long> CHANNEL_TO_MESSAGE = Map.of(
            ADD_GAMES_CHANNEL_ID, ADD_GAMES_MESSAGE_ID,
            ACCEPT_RULES_CHANNEL_ID, ACCEPT_RULES_MESSAGE_ID
    );

    public static final Map<String, Long> EMOJI_TO_ROLE = Map.of(
            EMOJI_ID_CS2, ROLE_ID_CS2,
            EMOJI_ID_GARRYS_MOD, ROLE_ID_GARRYS_MOD,
            EMOJI_ID_ETS2, ROLE_ID_ETS2,
            EMOJI_ACCEPT, ROLE_ID_VISITOR
    );

    private ReactionRoleConfig() { }
}
