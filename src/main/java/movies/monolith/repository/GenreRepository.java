package movies.monolith.repository;

import movies.monolith.model.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by tri.bui on 8/10/16.
 */
public interface GenreRepository extends MongoRepository<Genre, Integer> {
    Genre findFirstByName(String name);
}
