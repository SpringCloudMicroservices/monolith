package movies.monolith.controller;

import movies.monolith.model.Genre;
import movies.monolith.model.Movie;
import movies.monolith.repository.GenreRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tri.bui on 8/10/16.
 */
@RestController
@RequestMapping("/crawl")
public class CrawlController {
    private static String API_KEY = "646c2edf89793cf96a5b2a21faa7be6b";

    @Inject
    MongoMovieRepository movieRepository;

    @Inject
    GenreRepository genreRepository;

    @RequestMapping("/movies")
    public void crawlMovies() {
        RestTemplate restTemplate = new RestTemplate();
        for (int page = 1; page < 10; page++) {
            DiscoverResult result = restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY + "&page=" + page,
                    DiscoverResult.class);
            for (Movie movie : result.results) {
                movie.setImageUrl("https://image.tmdb.org/t/p/w600_and_h900_bestv2/" + movie.getPoster_path());
            }
            movieRepository.save(result.results);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/genres")
    public void crawlGenres() {
        RestTemplate restTemplate = new RestTemplate();
        GenresResult result = restTemplate.getForObject("https://api.themoviedb.org/3/genre/movie/list?api_key=" + API_KEY,
                    GenresResult.class);
        genreRepository.save(result.genres);
    }
}

interface MongoMovieRepository extends MongoRepository<Movie, Long> {
}

class GenresResult {
    public List<Genre> genres;
}

class DiscoverResult {
    public int page;
    public List<Movie> results;
}

