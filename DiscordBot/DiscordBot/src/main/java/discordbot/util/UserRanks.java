
package discordbot.util;

/**
 *
 * @author Jordi Jaspers
 */
public enum UserRanks {

    /**
     *
     */
    BANNED_USER("Will be ignored"),

    /**
     *
     */
    USER("Regular user"),

    /**
     *
     */
    BOT("Will be ignored"),

    /**
     *
     */
    SYSTEM_ADMIN("Admin");

    private final String description;

    UserRanks(String description) {
        this.description = description;
    }

    /**
     * find a rank by name
     *
     * @param search the role to search for
     * @return rank || null
     */
    public static UserRanks findRank(String search) {
        for (UserRanks userRanks : values()) {
            if (userRanks.name().equalsIgnoreCase(search)) {
                return userRanks;
            }
        }
        return null;
    }

    /**
     *
     * @param rank
     * @return
     */
    public boolean isAtLeast(UserRanks rank) {
        return this.ordinal() >= rank.ordinal();
    }

    /**
     *
     * @param rank
     * @return
     */
    public boolean isHigherThan(UserRanks rank) {
        return this.ordinal() > rank.ordinal();
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }
}
