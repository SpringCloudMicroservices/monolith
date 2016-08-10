package movies.monolith.service.impl;

import movies.monolith.model.Genre;
import movies.monolith.model.Movie;
import movies.monolith.repository.GenreRepository;
import movies.monolith.repository.MovieRepository;
import movies.monolith.service.MovieService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tri.bui on 8/9/16.
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    MovieRepository movieRepository;

    @Inject
    GenreRepository genreRepository;

    @Override
    public Genre getGenre(String name) {
        return genreRepository.findFirstByName(name);
    }

    @Override
    public List<Movie> getMovies(int genreId, int limit) {
        return movieRepository.findByGenre(genreId, limit);
    }
}
