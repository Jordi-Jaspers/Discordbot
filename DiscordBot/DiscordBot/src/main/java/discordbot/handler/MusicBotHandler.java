package discordbot.handler;

import java.util.ArrayList;
import com.sedmelluq.discord.lavaplayer.player.AudioConfiguration;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import java.util.Random;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.managers.AudioManager;

/**
 *
 * @author jordi
 */
public class MusicBotHandler {
    
    private static DefaultAudioPlayerManager playerManager;

    /**
     *
     */
    public final AudioPlayer musicPlayer;

    private final JDA bot;
    private final Guild guild;

    private ArrayList<String> playlist;
    private boolean repeatMode;
    private boolean musicPlaying;
    private boolean connected;

    private int volume;
    private Random random;
    private String currentPlayingSong;

    /**
     *
     * @param guild
     * @param bot
     */
    public MusicBotHandler(Guild guild, JDA bot) {
        this.bot = bot;
        this.guild = guild;
        
        playerManager = new DefaultAudioPlayerManager();
        musicPlayer = playerManager.createPlayer();
        
        AudioManager guildManager = guild.getAudioManager();

        playlist = new ArrayList<>();

        musicPlaying = false;
    }

    /**
     *
     */
    public static void init() {
        AudioSourceManagers.registerLocalSource(playerManager);
        playerManager.getConfiguration().setResamplingQuality(AudioConfiguration.ResamplingQuality.HIGH);
    }

    /**
     *
     * @param url
     */
    public void addSongToPlaylist(String url) {
        playlist.add(url);
    }

    /**
     *
     */
    public void clearPlaylist() {
        playlist.clear();
    }

    /**
     *
     * @param targetChannel
     */
    public void connect(VoiceChannel targetChannel) {
        guild.getAudioManager().openAudioConnection(targetChannel);
        setConnected(true);
    }

    /**
     *
     */
    public void disconnect() {
        guild.getAudioManager().closeAudioConnection();
        setConnected(false);
    }

    /**
     *
     */
    public void skipTrack() {
        
    }

    /**
     *
     */
    public void startPlaying() {

    }

    /**
     *
     */
    public void pauseTrack() {

    }

    /**
     *
     */
    public void stopTrack() {
        musicPlayer.destroy();
    }

    /**
     *
     */
    public void stopAfterTrack() {
        
    }

    /**
     *
     */
    public void nextTrack() {

    }

    /**
     * 
     */
    public void trackEnded(){
        
    }

    /**
     * 
     * @param connected 
     */
    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    
    /**
     * 
     * @param volume 
     */
    public void setVolume(int volume){
        musicPlayer.setVolume(volume);
    }
    
    /**
     *
     * @param musicPlaying
     */
    public void setMusicPlaying(boolean musicPlaying) {
        this.musicPlaying = musicPlaying;
    }

    /**
     *
     * @param musicPaused
     */
    public void setMusicPaused(boolean musicPaused) {
        musicPlayer.setPaused(musicPaused);
    }

    /**
     *
     * @param repeatMode
     */
    public void setRepeatMode(boolean repeatMode) {
        this.repeatMode = repeatMode;
    }
    
    /**
     * 
     * @return 
     */
    public VoiceChannel getConnectedChannel(){
        return guild.getAudioManager().getConnectedChannel();
    }
    
    /**
     *
     * @return
     */
    public int getVolume() {
        return musicPlayer.getVolume();
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getPlaylist() {
        return playlist;
    }

    /**
     *
     * @return 
     */
    public String getCurrentPlayingSong() {
        return currentPlayingSong;

    }

    
    
    /**
     *
     * @return
     */
    public synchronized boolean InRepeatMode() {
        return repeatMode;
    }

    /**
     *
     * @return
     */
    public boolean musicPlaying() {
        return musicPlaying;
    }

    /**
     *
     * @return
     */
    public boolean musicPaused() {
        return musicPlayer.isPaused();
    }

    /**
     *
     * @param targetChannel
     * @return 
     */
    public boolean sameChannel(VoiceChannel targetChannel) {
        if(getConnectedChannel() != null){
            return getConnectedChannel().equals(targetChannel);
        }
        return false;
    }

    /**
     * 
     * @return 
     */
    public boolean isConnected() {
        return connected;
    }

    
}
