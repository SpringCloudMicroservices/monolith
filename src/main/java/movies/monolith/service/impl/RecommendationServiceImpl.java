package movies.monolith.service.impl;

import movies.monolith.exception.UserNotFoundException;
import movies.monolith.model.Movie;
import movies.monolith.model.User;
import movies.monolith.repository.MovieRepository;
import movies.monolith.service.RecommendationService;
import movies.monolith.service.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tri.bui on 8/9/16.
 */
@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Inject
    UserService userService;

    @Inject
    MovieRepository movieRepository;

    int adultAge = 17; // NOTE

    public List<Movie> getRecommendationsForUser(String userId, int limit)
            throws UserNotFoundException {
        User user = userService.getUser(userId); // NOTE: Should we use UserRepository directly?
        return user.getAge() < adultAge ? movieRepository.findByGenre(16, limit) : movieRepository.findByGenre(28, limit);
    }
}
