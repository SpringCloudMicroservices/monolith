package movies.monolith.exception;

/**
 * Created by tri.bui on 8/2/16.
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User not found");
    }
}
