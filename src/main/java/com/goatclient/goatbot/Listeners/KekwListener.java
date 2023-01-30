package com.goatclient.goatbot.Listeners;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
/**
 * Thus is class performs auto reaction of the kekw emoji.
 * When any user in the server mentions @Bl4ckye#0567.
 * */

public class KekwListener extends ListenerAdapter {

    private static final String MENTIONED_USER_ID = "<@803261112883216384>";


    private static final Emoji KEKW_EMOJI = Emoji.fromFormatted("<a:KEKWLaugh:1055759577964085278>");
    /**
     * This class overrides the onMessageReceived method.
     *  when the user -> MENTIONED_USER_ID get mentioned the bot automatically performs the kekw reaction.
     * */
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.contains(MENTIONED_USER_ID)) {
            event.getMessage().addReaction(KEKW_EMOJI).queue();
        }
    }

}
