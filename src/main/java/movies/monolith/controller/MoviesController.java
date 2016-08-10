package movies.monolith.controller;

import movies.monolith.model.Genre;
import movies.monolith.model.Movie;
import movies.monolith.service.MovieService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tri.bui on 8/9/16.
 */
@RestController
@RequestMapping("/api/movies")
public class MoviesController {
    @Inject
    MovieService movieService;

    @RequestMapping("/lists/{list}")
    public
    @ResponseBody
    List<Movie> getMovies(@PathVariable(value = "list") String list,
                          @RequestParam(value = "limit", defaultValue = "10") int limit) {
        Genre genre = movieService.getGenre(list);
        return movieService.getMovies(genre.getId(), limit);
    }
}