package com.goatclient.goatbot;

import com.goatclient.goatbot.Commands.CommandManager;
import com.goatclient.goatbot.Listeners.KekwListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

/**
 * JDA-5.0.0 Discord Bot for GOAT Client MineCraft Server.
 * This is the main class where we initialize our bot.
 * @author Ram Kousik
 */

public class GoatBot {

    private final ShardManager shardManager;

    private final Dotenv config;

    public GoatBot() throws LoginException {
        config = Dotenv.configure().load();
        /**
         * If you want to change the bot token kindly check .env.example
         * create a file called ".env" with your bot token
         * ".env" file is key-value type to store the bot token
         * */
        String token = config.get("TOKEN");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("GOAT client"));
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES);

        shardManager = builder.build();

        shardManager.addEventListener(new KekwListener(), new CommandManager());
    }

    public Dotenv getConfig() {
        return config;
    }

    public ShardManager getShardManager() {
        return shardManager;
    }
    /** In order to host this bot do the following:
     * Firstly download the updated JAR file of the project.
     * Check the "discloud.config" file and configure accordingly.
     *  Join discloud server and perform the following command -> .upload or .up
     */
    public static void main(String[] args) {
        try {
            GoatBot bot = new GoatBot();
        } catch (LoginException e) {
            System.out.println("ERROR: Provided Bot token is invalid");
        }
    }
}
