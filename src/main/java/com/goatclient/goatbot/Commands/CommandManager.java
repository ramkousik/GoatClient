package com.goatclient.goatbot.Commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class CommandManager extends ListenerAdapter {

    private String WEBSITE = "https://workupload.com/file/2hrA2XWH4AP";
    private String LABEL = "DOWNLOAD HERE";
//    private Long channelId = 1056438063477305415L;

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        Button downloadButton = Button.link(WEBSITE, LABEL);

        if(command.equals("credits")) {
            String userTag = event.getUser().getAsTag();
            event.reply("Hey!, **" + userTag + "**" + "```\n" +
                    "\n" +
                    "Client Shader & Zoom by:\n" +
                    "   Optifine    \n" +
                    "\n" +
                    "DC Bot by:\n" +
                    "   Bl4ckye    \n" +
                    "\n" +
                    "Goat Client by:\n" +
                    "   Bl4ckye    \n" +
                    "\n" +
                    "Ideas by:\n" +
                    "   xAce    \n" +
                    "\n" +
                    "Coded with:\n" +
                    "   IntelliJ    \n" +
                    "\n" +
                    "Website by:\n" +
                    "   Bl4ckye    \n" +
                    "\n" +
                    "Hosted at:\n" +
                    "   netlify.com    \n" +
                    "\n" +
                    "Coded by:\n" +
                    "   Bl4ckye    \n" +
                    "\n" +
                    "Coded with:\n" +
                    "   VScode    \n" + "```").queue();

        } else if (command.equals("download")) {
            //MessageChannel checkChannel = event.getChannel();

            //if(checkChannel.getIdLong() == channelId) {
            event.reply("Click the button to Download GOAT client")
                    .addActionRow(
                            Button.link(WEBSITE, LABEL))
                    .queue();
            //}
        }

    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("credits", "Server Credits"));
        commandData.add(Commands.slash("download", "GOAT download link"));
        commandData.add(Commands.slash("donate", "Coming soon"));
        event.getJDA().updateCommands().addCommands(commandData).queue();
    }


}