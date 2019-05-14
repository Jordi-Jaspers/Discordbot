package discordbot.core;

import discordbot.handler.CommandHandler;
import discordbot.util.EmojiMessage;
import discordbot.commands.music.JoinCommand;
import discordbot.commands.music.LeaveCommand;
import discordbot.commands.music.StopCommand;

/**
 *
 * @author Jordi Jaspers
 */
public class CommandList {

    private final CommandHandler cHandler;
    private String subCommand;

    /**
     *
     * @param cHandler
     */
    public CommandList(CommandHandler cHandler) {
        this.cHandler = cHandler;
        //hier een RankSysteem maken.
    }

    /**
     *
     * @param mainCommand
     */
    public void CommandTrigger(String mainCommand) {

        if (cHandler.CheckSubCommandPresent()) {
            subCommand = cHandler.getSubCommand();
            }

        switch (mainCommand) {
            case "hello":
                String answer = "Hello, " + cHandler.getUser().getAsMention();
                cHandler.SendMessage(answer);
                break;
            case "join":
                JoinCommand join = new JoinCommand();
                answer = join.execute(mainCommand, subCommand, cHandler.getGuildID(), cHandler.getChannel(), cHandler.getUser());
                cHandler.SendMessage(answer);
                break;
            case "leave":
                LeaveCommand leave = new LeaveCommand();
                answer = leave.execute(mainCommand, subCommand, cHandler.getGuildID(), cHandler.getChannel(), cHandler.getUser());
                cHandler.SendMessage(answer);
                break;
            case "play":
                cHandler.SendMessage("Playing song: " + "getsongID");
                break;
            case "pause":
                cHandler.SendMessage("Pausing song: " + "getsongID");
                break;
            case "skip":
                cHandler.SendMessage("Skipping to the next song!");
                break;
            case "queue":
                cHandler.SendMessage("Your song is succesfully added to the queue!" + EmojiMessage.NOTEPAD);
                break;
            case "volume":
                break;
            case "ban":
                break;
            default:
                break;
        }
    }
}
