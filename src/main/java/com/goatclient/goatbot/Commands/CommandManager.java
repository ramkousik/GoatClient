package com.goatclient.goatbot.Commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class CommandManager extends ListenerAdapter {

    public static String getTitle() {
        return title;
    }

    public static StringBuilder getDevString() {
        return devString;
    }

    public static String getDescription() {
        return description;
    }

    private static String title;

    private static StringBuilder devString;

    private static String description;
    private String WEBSITE_LATEST = "https://workupload.com/file/2hrA2XWH4AP";

    private String WEBSITE_1_0_0 = "https://workupload.com/file/2hrA2XWH4AP";
    private String LABEL = "DOWNLOAD HERE";
    private Long channelId = 1063793935635456101L;
    private static final String v1 = "1.0.0";

    public static String getCheckMark() {
        return checkMark;
    }

    private static String checkMark = ":white_check_mark:";

    private Emoji whiteCheckMark = Emoji.fromUnicode("✅");
    /**
     * This class handles four of the slash commands.
     * It overrides onSlashCommandInteraction method to handle four commands.
      */

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();


        /**
         * When /credits command is performed the following data is displayed.
         * */
        if(command.equals("credits")) {
            String userTag = event.getUser().getAsTag();

            /** You can change the display format from here */

            event.reply("Hey!, **" + userTag + "**" + "```\n" + "Bl4ckye - Owner\n" +
                    "SoosTv - Admin\n" +
                    "Odin - Lead-Developer \n" +
                    "Frisby - Developer \n" +
                    "xAcee - Moderator\n" +
                    "\n" +
                    "CLIENT CREDITS\n" +
                    "\n" +
                    "Adiversment Soundtrack:\n" +
                    "   Headphones - Ooyy\n" +
                    "\n" +
                    "Client Developer:\n" +
                    "   Bl4ckye\n" +
                    "   Frisby\n" +
                    "   SoosTv\n" +
                    "\n" +
                    "Client coded with:\n" +
                    "    IntelliJ IDEA\n" +
                    "\n" +
                    "Discord Bot coded by:\n" +
                    "    Bl4ckye\n" +
                    "\n" +
                    "Discord bot hosted on:\n" +
                    "    Discloud\n" +
                    "\n" +
                    "Website coded by:\n" +
                    "   Bl4ckye    \n" +
                    "\n" +
                    "Website Hosted at:\n" +
                    "   netlify.com    \n" +
                    "\n" +
                    "Website Coded with:\n" +
                    "   VScode    \n" +
                    "\n" +
                    "```" ).queue();

        } else if (command.equals("download")) {

            OptionMapping option = event.getOption("version");
            if(option != null) {
                String versionNumber = option.getAsString();
                switch (versionNumber) {
                    case "1.0.0" -> {
                        event.reply("Click the button to Download GOAT client version 1.0.0")
                                .addActionRow(Button.link(WEBSITE_1_0_0, LABEL))
                                .queue();
                    }
                    default -> {
                        event.reply("Invalid version number provided. Please provide a valid version number or Download the latest version")
                                .addActionRow(Button.link(WEBSITE_LATEST, "Download Latest version"))
                                .queue();
                    }
                }
            } else {
                event.reply("Click the button to Download the latest version of GOAT client")
                        .addActionRow(Button.link(WEBSITE_LATEST, LABEL))
                        .queue();


            }

        } else if(command.equals(("request"))) {
//            OptionMapping titleOption = event.getOption("title");
//            OptionMapping userOption = event.getOption("user");
//            OptionMapping descriptionOption = event.getOption("description");
//
//            String title = titleOption.getAsString();
//            String user = userOption.getAsUser().getAsMention();
//            String description = descriptionOption.getAsString();
//
//            event.reply("> **" + title + "**" +"\n"+
//                    "\n" +
//                    "Devs to work on: " + user + "\n" +
//                    "\n" +
//                    "The features:" + "\n"+
//                    "\n"+
//                    description + "\n" +
//                    "\n" +
//                    "**—————————————————**\n" +
//                    "\n" +
//                    "**React to **" + checkMark + " **to claim **").queue();

            MessageChannel messageChannel = event.getMessageChannel();

            if (messageChannel.getIdLong() == channelId) {
                if (event.getMember().getRoles().stream().anyMatch(role -> role.getId().equals("1056231583125876806")) || event.getMember().getRoles().stream().anyMatch(role -> role.getId().equals("1046533127436238868"))) {

                    OptionMapping titleOption = event.getOption("title");
                    OptionMapping userOption = event.getOption("user");
                    OptionMapping descriptionOption = event.getOption("description");

                    title = titleOption.getAsString();
                    String userString = userOption.getAsString();
                    description = descriptionOption.getAsString();

                    devString = new StringBuilder("Devs to work on: ");
                    if (!userString.equals("none")) {
                        String[] userMentions = userString.split(" ");
                        for (String userMention : userMentions) {
                            devString.append(userMention).append(" ");
                        }
                    } else {
                        devString.append("Not specified");
                    }

                    event.reply("> **" + title + "**" + "\n" +
                            "\n" +
                            devString + "\n" +
                            "\n" +
                            "The features:" + "\n" +
                            "\n" +
                            description + "\n" +
                            "\n" +
                            "**—————————————————**\n" +
                            "\n" +
                            "**React to **" + checkMark + " **to claim **").queue();


                    //event.reply("** The Request **");
                    //            event.getJDA().addEventListener(new ListenerAdapter() {
                    //                @Override
                    //                public void onMessageReactionAdd(MessageReactionAddEvent event) {
                    //                    if(!event.getUser().isBot() && event.getMessageId().equals(sentMessage.getId())) {
                    //                        if(event.getReaction().equals("✅")) {
                    //                            sentMessage.editMessage("> " + title + "" + "\n" +
                    //                                    "\n" +
                    //                                    devString + "\n" +
                    //                                    "\n" +
                    //                                    "The features:" + "\n" +
                    //                                    "\n" +
                    //                                    description + "\n" +
                    //                                    "\n" +
                    //                                    "—————————————————\n" +
                    //                                    "\n" +
                    //                                    "Claimed by " + event.getUser().getAsMention()).queue();
                    //                        }
                    //                    }
                    //                }
                    //            });

                } else {
                    event.reply("Sorry you must be Lead-Dev-Goat or Admin-Goat to perform this action").queue();
                }
            }

        }
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("credits", "Server Credits"));

        OptionData version = new OptionData(OptionType.STRING, "version","Please mention the version of GOAT client to download",false);
                //.addChoice("verision 1.0.0", "1.0.0");
        commandData.add(Commands.slash("download", "GOAT download link").addOptions(version));

        OptionData title = new OptionData(OptionType.STRING, "title", "Give a title for the request", true);
        OptionData user = new OptionData(OptionType.STRING, "user","Mention the user", true);
        OptionData description = new OptionData(OptionType.STRING, "description", "Give a description for the request", true);
        commandData.add(Commands.slash("request", "add request requirement").addOptions(title, user, description));


        commandData.add(Commands.slash("donate", "Coming soon"));

        event.getJDA().updateCommands().addCommands(commandData).queue();

    }


}