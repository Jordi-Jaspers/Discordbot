package discordbot.commands.music;

import discordbot.core.AbstractCommand;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import discordbot.handler.MusicBotHandler;

/**
 *
 * @author jordi
 */
public class LeaveCommand extends AbstractCommand {

    /**
     *
     */
    public LeaveCommand() {
        super();
    }

    @Override
    public String getDescription() {
        return "Leaves a voicechannel";
    }

    @Override
    public String getCommand() {
        return "leave";
    }

    @Override
    public String[] getUsage() {
        return new String[]{
            "leave                         //attempts to leave the voiceChannel",
        };
    }

    /**
     * Leaving a voiceChannel
     * 
     * @param mainCommand eerste commando die gegeven wordt zonder prefix
     * @param subCommand tweede commando als die gegeven is.
     * @param channel channel waar het commando is uitgevoerd.
     * @param user die het commando heeft opgeroepen.
     * @return antwoord op een van de drie situaties.
     */
    @Override
    public String execute(String mainCommand, String subCommand, String guildID, MessageChannel channel, User user) { 
        TextChannel tChannel = (TextChannel) channel;
        Guild guild = tChannel.getJDA().getGuildById(guildID);
        JDA bot = channel.getJDA();
        MusicBotHandler mHandler = new MusicBotHandler(guild, bot);
        
        if(mHandler.isConnected()){
            mHandler.disconnect();
            return "Succesfully disconnected from the voiceChannel";
        }
        else{
            return "I am currently not in Voicechannel";
        }
        
    }
}
