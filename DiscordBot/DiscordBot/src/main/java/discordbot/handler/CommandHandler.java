package discordbot.handler;

import discordbot.core.CommandList;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author Jordi
 */
public class CommandHandler {

    private MessageChannel channel;
    private User user;
    
    private String mainCommand;
    private String subCommand;
    
    private final String guildID = "390654413569523713";

    /**
     *
     * @param event
     */
    public void ProcesMessage(MessageReceivedEvent event) {
        
        channel = event.getChannel();
        user = event.getAuthor();

        CommandList commandList = new CommandList(this);

        String[] splitCommand = event.getMessage().getContent().substring(1).split(" ");
        mainCommand = splitCommand[0];
       
        if (splitCommand.length > 1) {
            subCommand = splitCommand[1];
        }

        commandList.CommandTrigger(mainCommand);
    }

    /**
     * 
     * @param message 
     */
    public void SendMessage(String message) {
        channel.sendMessage(message).queue();
    }

    /**
     * 
     * @return 
     */
    public MessageChannel getChannel() {
        return channel;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @return
     */
    public String getMainCommand() {
        return mainCommand;
    }

    /**
     *
     * @return
     */
    public String getGuildID() {
        return guildID;
    }

    /**
     *
     * @return
     */
    public String getSubCommand() {
        return subCommand;
    }

    /**
     * return true (= Als value een waarde heeft) return false (= Als value null
     * is)
     *
     * @return value
     */
    public boolean CheckSubCommandPresent() {
        return subCommand != null;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public boolean isInteger(String s) {
        boolean integer = false;
        try {
            //ingegeven string is een integer.
            Integer.parseInt(s);
            integer = true;
        } catch (NumberFormatException exception) {
            // ingegeven string is geen integer.
        }
        return integer;
    }
}
