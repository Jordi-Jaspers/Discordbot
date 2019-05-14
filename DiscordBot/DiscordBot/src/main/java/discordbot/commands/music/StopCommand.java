/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discordbot.commands.music;

import discordbot.core.AbstractCommand;
import discordbot.handler.MusicBotHandler;
import java.util.Arrays;
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
public class StopCommand extends AbstractCommand {

    /**
     *
     */
    public StopCommand() {
        super();
    }

    @Override
    public String getDescription() {
        return "Stop playing music and leaves a voicechannel";
    }

    @Override
    public String getCommand() {
        return "stop";
    }

    @Override
    public String[] getUsage() {
        return new String[]{
            "stop          //stops playing and leaves the channel",
            "stop after    //stops playing after the current playing track finished"};
    }

    @Override
    public String execute(String mainCommand, String subCommand, String guildID, MessageChannel channel, User user) {

        TextChannel tChannel = (TextChannel) channel;
        Guild guild = tChannel.getJDA().getGuildById(guildID);
        JDA bot = channel.getJDA();
        MusicBotHandler mHandler = new MusicBotHandler(guild, bot);

        if (mHandler.musicPlaying()) {

            if (subCommand == null) {
                mHandler.stopTrack();
                return "Succesfully stopped the music from playing.";
            }

            if (subCommand.equalsIgnoreCase("after")) {
                mHandler.stopAfterTrack();
                return "The music will stop playing after this song.";
            } 
            else {
                return "There is no such subCommand! Maybe try; "+ Arrays.toString(getUsage());
            }
        } 
        else {
            return "There is no music playing at the moment.";
        }
    }
}
