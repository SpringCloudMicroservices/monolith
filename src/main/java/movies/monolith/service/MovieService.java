package movies.monolith.service;

import movies.monolith.model.Genre;
import movies.monolith.model.Movie;

import java.util.List;

/**
 * Created by tri.bui on 8/5/16.
 */
public interface MovieService {
    Genre getGenre(String name);
    List<Movie> getMovies(int genreId, int limit);
}
