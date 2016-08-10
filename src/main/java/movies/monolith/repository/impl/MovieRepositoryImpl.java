package movies.monolith.repository.impl;

import movies.monolith.model.Movie;
import movies.monolith.repository.MovieRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tri.bui on 8/10/16.
 */
@Repository
public class MovieRepositoryImpl implements MovieRepository {
    @Inject
    MongoTemplate mongoTemplate;

    @Override
    public List<Movie> findByGenre(int genreId, int limit) {
        Query query = Query.query(Criteria.where("genre_ids").in(genreId)).limit(limit);
        return mongoTemplate.find(query, Movie.class);
    }
}
