package movies.monolith.service;

import movies.monolith.exception.UserNotFoundException;
import movies.monolith.model.User;

/**
 * Created by tri.bui on 8/9/16.
 */
public interface UserService {
    User getUser(String userId) throws UserNotFoundException;
    User getUserByUsernameAndPassword(String username, String password) throws UserNotFoundException;
}
