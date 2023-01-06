package com.goatclient.goatbot.Listeners;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class KekwListener extends ListenerAdapter {

    public static final String MENTIONED_USER_ID = "<@803261112883216384>";


    public static final Emoji KEKW_EMOJI = Emoji.fromFormatted("<:KEKW:1055759631760232519>");

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.contains(MENTIONED_USER_ID)) {
            event.getMessage().addReaction(KEKW_EMOJI).queue();
        }
    }

}
