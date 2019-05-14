package discordbot.commands.music;

import discordbot.core.AbstractCommand;
import discordbot.util.EmojiMessage;
import discordbot.handler.MusicBotHandler;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.entities.VoiceChannel;

/**
 *
 * @author jordi
 */
public class JoinCommand extends AbstractCommand {

    /**
     *
     */
    public JoinCommand() {
        super();
    }

    @Override
    public String getDescription() {
        return "joins a voicechannel";
    }

    @Override
    public String getCommand() {
        return "join";
    }

    @Override
    public String[] getUsage() {
        return new String[]{
            "join                          //attempts to join you",
            "join <channelname>            //attempts to join channelname"
        };
    }

    /**
     * de discordBot heeft 3 keuzes als die joined: 
     * - join my channel. 
     * - join een gegeven channel. 
     * - can't find channel to join.
     *
     * @param mainCommand eerste commando die gegeven wordt zonder prefix
     * @param subCommand tweede commando als die gegeven is.
     * @param channel channel waar het commando is uitgevoerd.
     * @param user die het commando heeft opgeroepen.
     * @return antwoord op een van de drie situaties.
     */
    @Override
    public String execute(String mainCommand, String subCommand, String guildID, MessageChannel channel, User user) {
        VoiceChannel targetChannel = null;
        
        TextChannel tChannel = (TextChannel) channel;
        Guild guild = tChannel.getJDA().getGuildById(guildID);
        JDA bot = channel.getJDA();
        MusicBotHandler mHandler = new MusicBotHandler(guild, bot);
        
        if (subCommand == null) {
            //dan probeert de discordbot de voicechannel van de user te joinen.
            targetChannel = guild.getMember(user).getVoiceState().getChannel();
        }
      
        else {
            // Channel zoeken die overeenkomt met het subcommand.
            for (VoiceChannel voiceChannel : guild.getVoiceChannels()) {
                if (voiceChannel.getName().equalsIgnoreCase(subCommand)) {
                    targetChannel = voiceChannel;
                    break;
                }
            }
        }
        
        if (targetChannel != null) {
            //checken als de Discordbot niet al gejoined is in die channel.
            if (mHandler.sameChannel(targetChannel)) {
                return "Sorry, " + user.getAsMention() + ". I am already connected to that channel.";
            } 
            
            else {
                //Join de opgegeven channel.
                mHandler.connect(targetChannel);
                return "I succesfully joined the channel! Thank you for having me!" + user.getAsMention();
            }
        } 
        
        else {
            //Geen channel gevonden voor te joinen.
            return "Error 404: Channel not found " + EmojiMessage.ERROR;
        }
    }
}
