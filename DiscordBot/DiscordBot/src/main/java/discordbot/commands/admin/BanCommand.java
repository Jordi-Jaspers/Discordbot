/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discordbot.commands.admin;

import discordbot.core.AbstractCommand;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

/**
 *
 * @author Jordi
 */
public class BanCommand extends AbstractCommand {

   /**
     *
     */
    public BanCommand() {
        super();
    }

    @Override
    public String getDescription() {
        return "Bans a user from the server.";
    }

    @Override
    public String getCommand() {
        return "ban";
    }

    @Override
    public String[] getUsage() {
        return new String[]{
            "Ban <User>            //attempts to ban a specific user from the server"
        };
    }

    @Override
    public String execute(String mainCommand, String subCommand, String guildID, MessageChannel channel, User user) {
        return "";
    }
    
}
