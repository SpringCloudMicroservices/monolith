package movies.monolith.service.impl;

import movies.monolith.exception.UserNotFoundException;
import movies.monolith.model.User;
import movies.monolith.repository.UserRepository;
import movies.monolith.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by tri.bui on 8/3/16.
 */
@Service
public class UserServiceImpl implements UserService {
    @Inject
    UserRepository userRepository;

    @Override
    public User getUserByUsernameAndPassword(String username, String password) throws UserNotFoundException {
        User user = userRepository.findFirstByUsernameAndPassword(username, password);
        if (user  == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    public User getUser(String userId) throws UserNotFoundException {
        User user = userRepository.findOne(userId);
        if (user  == null) {
            throw new UserNotFoundException();
        }
        return user;
    }
}
