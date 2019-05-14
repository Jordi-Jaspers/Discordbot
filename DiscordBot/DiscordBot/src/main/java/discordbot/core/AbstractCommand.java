package discordbot.core;

import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

/**
 *
 * @author jordi
 */
public abstract class AbstractCommand {

    /**
     *
     */
    public AbstractCommand() {

    }

    /**
     * Beschrijving van het commando.
     *
     * @return description
     */
    public abstract String getDescription();

    /**
     * Hoe ziet het commando er uit zonder prefix.
     *
     * @return command
     */
    public abstract String getCommand();

    /**
     * How to use the command?
     *
     * @return command usage
     */
    public abstract String[] getUsage();

    /**
     * @param mainCommand eerste commando die gegeven wordt zonder prefix
     * @param subCommand tweede commando als die gegeven is.
     * @param guildID ID van de server.
     * @param channel channel waar het commando is uitgevoerd.
     * @param user die het commando heeft opgeroepen.
     * @return the message to output or an empty string for nothing.
     */
    public abstract String execute(String mainCommand, String subCommand, String guildID, MessageChannel channel, User user);

}
