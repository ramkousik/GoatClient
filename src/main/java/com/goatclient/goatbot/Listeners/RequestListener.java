package com.goatclient.goatbot.Listeners;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveAllEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import com.goatclient.goatbot.Commands.CommandManager;

import java.util.List;
import java.util.stream.Collectors;

public class RequestListener extends ListenerAdapter {

    private String messageId;

    private Message message;

    public static String getSentMessage() {
        return sentMessage;
    }

    public static void setSentMessage(String sentMessage) {
        RequestListener.sentMessage = sentMessage;
    }

    private static String sentMessage;

    public static String getSentMessageStringId() {
        return sentMessageStringId;
    }

    private static String sentMessageStringId;



    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
         sentMessage = event.getMessage().getContentRaw();
         sentMessageStringId = event.getMessage().getId();
         message = event.getMessage();


        if (sentMessage.contains("> **" +  CommandManager.getTitle() + "**" + "\n" +
                "\n" +
                CommandManager.getDevString()+ "\n" +
                "\n" +
                "The features:" + "\n" +
                "\n" +
                CommandManager.getDescription() + "\n" +
                "\n" +
                "**—————————————————**\n" +
                "\n" +
                "**React to **" + CommandManager.getCheckMark() + " **to claim **") ) {

            messageId = event.getMessageId();
            event.getMessage().addReaction(Emoji.fromUnicode("✅")).queue();

        }

    }



    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
//        Message message = event.getChannel().retrieveMessageById(event.getMessageId()).complete();
//        if(!event.getUser().isBot() && event.getMessageId().equals(sentMessageStringId)) {
//                        if(event.getReaction().equals("✅")) {
//                            message.editMessage("> " + CommandManager.getTitle() + "" + "\n" +
//                                    "\n" +
//                                    CommandManager.getDevString() + "\n" +
//                                    "\n" +
//                                    "The features:" + "\n" +
//                                    "\n" +
//                                    CommandManager.getDescription() + "\n" +
//                                    "\n" +
//                                    "—————————————————\n" +
//                                    "\n" +
//                                    "Claimed by " + event.getUser().getAsMention()).queue();
//                        }
//                    }
//        if (event.getReaction().getEmoji().equals("✅")) {
//            Member member = event.getMember();
//            Message message = event.getChannel().retrieveMessageById(event.getMessageId()).complete();
//            message.editMessage("> " + CommandManager.getTitle() + "" + "\n" +
//                    "\n" +
//                    CommandManager.getDevString() + "\n" +
//                    "\n" +
//                    "The features:" + "\n" +
//                    "\n" +
//                    CommandManager.getDescription() + "\n" +
//                    "\n" +
//                    "—————————————————\n" +
//                    "\n" +
//                    "Claimed by " + event.getUser().getAsMention()).queue();
//        }
            if(event.getReaction().getEmoji().equals(Emoji.fromUnicode("✅")) && !event.getUser().isBot()) {
                if (event.getMessageId().equals(messageId)) {
                    message.editMessage("> " + "**" + CommandManager.getTitle() + "**" + "\n" +
                            "\n" +
                            CommandManager.getDevString() + "\n" +
                            "\n" +
                            "The features:" + "\n" +
                            "\n" +
                            CommandManager.getDescription() + "\n" +
                            "\n" +
                            "—————————————————\n" +
                            "\n" +
                            "Claimed by " + event.getUser().getAsMention()).queue();
                }
//                List<User> users = event.getReaction().getJDA().getUsers().stream()
//                        .filter(user -> !user.isBot())
//                        .toList();
//                if (users.size() == 1) {
//                    User user = users.get(0);
//                    message.editMessage("> " + CommandManager.getTitle() + "" + "\n" +
//                            "\n" +
//                            CommandManager.getDevString() + "\n" +
//                            "\n" +
//                            "The features:" + "\n" +
//                            "\n" +
//                            CommandManager.getDescription() + "\n" +
//                            "\n" +
//                            "—————————————————\n" +
//                            "\n" +
//                            "Claimed by " + event.getUser().getAsMention()).queue();
//                }

            }
    }


    @Override
    public void onMessageReactionRemove(@NotNull MessageReactionRemoveEvent event) {
        if (event.getReaction().getEmoji().equals(Emoji.fromUnicode("✅")) && !event.getUser().isBot()) {
            if (event.getMessageId().equals(messageId)) {
                message.editMessage("> **" + CommandManager.getTitle() + "**" + "\n" +
                        "\n" +
                        CommandManager.getDevString() + "\n" +
                        "\n" +
                        "The features:" + "\n" +
                        "\n" +
                        CommandManager.getDescription() + "\n" +
                        "\n" +
                        "**—————————————————**\n" +
                        "\n" +
                        "**React to **" + CommandManager.getCheckMark() + " **to claim **").queue();
            }
        }
    }
}
