package movies.monolith.service;

import movies.monolith.exception.UserNotFoundException;
import movies.monolith.model.Movie;

import java.util.List;
import java.util.Set;

/**
 * Created by tri.bui on 7/20/16.
 */
public interface RecommendationService {
    List<Movie> getRecommendationsForUser(String userId, int limit) throws UserNotFoundException;
}

