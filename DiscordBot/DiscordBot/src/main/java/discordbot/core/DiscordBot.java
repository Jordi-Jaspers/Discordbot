package discordbot.core;

import discordbot.handler.CommandHandler;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * 
 * In deze klasse wordt via de token(=Unieke Code) een bot geinitialiseerd. die
 * reageert op verschillende commando's.
 * 
 * @author Jordi Jaspers
 */
public class DiscordBot extends ListenerAdapter {
    
    private static final String BOTID = "MzkwNjU1MTY4NTMxOTIyOTQ0.DRNRfg.CdzgmR82S9X8mVGfR-5aI7JrVm0";
    
    private final String botPrefix;
    private final CommandHandler processCommand;
    
    /**
     * De constructor voor de MainBot klasse.
     * Prefix voor de commando's worden ingesteld
     * een klasse voor de berichten te verwerken opgeroepen.
     */
    public DiscordBot() {
        botPrefix = "!";
        processCommand = new CommandHandler();
    }
    
    /**
     * De DiscordBot wordt geinitialiseerd en eigenschappen gegeven, nadat er 
     * gecontrolleerd is op exceptions.
     * 
     * @param args
     * @throws LoginException
     * @throws IllegalArgumentException
     * @throws InterruptedException
     * @throws RateLimitedException 
     */
    public static void main(String[] args) throws LoginException, IllegalArgumentException, InterruptedException, RateLimitedException {
        new JDABuilder(AccountType.BOT)
                .setToken(BOTID)
                .addEventListener(new DiscordBot())
                .setStatus(OnlineStatus.ONLINE)
                .buildBlocking();
    }

    /**
     *
     * @param event
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getMessage().getContent().isEmpty()) {
            if (event.getMessage().getContent().startsWith(botPrefix)) {
                processCommand.ProcesMessage(event);
            }
        }
    }
}