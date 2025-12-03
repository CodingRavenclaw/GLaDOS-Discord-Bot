package com.glados.bot.config;

import io.github.cdimascio.dotenv.Dotenv;

import java.util.Map;

public final class ReactionRoleConfig {

    private static final Dotenv DOTENV = Dotenv.load();

    public static final long CHANNEL_ID =
            Long.parseLong(DOTENV.get("ROLE_REACTION_CHANNEL_ID"));

    public static final long MESSAGE_ID =
            Long.parseLong(DOTENV.get("ROLE_REACTION_MESSAGE_ID"));

    public static final Map<String, Long> EMOJI_TO_ROLE = Map.of(
            DOTENV.get("EMOJI_ID_CS2"), Long.parseLong(DOTENV.get("ROLE_ID_CS2")),
            DOTENV.get("EMOJI_ID_GARRYS_MOD"), Long.parseLong(DOTENV.get("ROLE_ID_GARRYS_MOD"))
    );

    private ReactionRoleConfig() { }
}
