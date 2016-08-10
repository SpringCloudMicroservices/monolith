package movies.monolith.controller;

import movies.monolith.RequestUtils;
import movies.monolith.exception.UserNotFoundException;
import movies.monolith.model.Movie;
import movies.monolith.service.RecommendationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by tri.bui on 8/9/16.
 */
@RestController
@RequestMapping("/api/recommendations")
public class RecommendationsController {
    @Inject
    RecommendationService recommendationService;

    @RequestMapping("/me")
    public @ResponseBody List<Movie> getRecommendedMoviesOfUser(
            @RequestParam(value = "limit", defaultValue = "6") int limit,
            final HttpServletRequest request)
            throws UserNotFoundException {
        String userId = RequestUtils.getUserId(request);
        return recommendationService.getRecommendationsForUser(userId, limit);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> handleUserNotFoundException(HttpServletRequest req, Exception e) {
        return new ResponseEntity<>(new Error(1000, "User not found."), HttpStatus.NOT_FOUND);
    }
}
