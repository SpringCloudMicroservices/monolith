package movies.monolith.repository;

import movies.monolith.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by tri.bui on 8/9/16.
 */
public interface MovieRepository {
    List<Movie> findByGenre(int genreId, int limit);
}
