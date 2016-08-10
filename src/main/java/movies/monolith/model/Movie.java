package movies.monolith.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Created by tri.bui on 8/2/16.
 */
@Data
@NoArgsConstructor
public class Movie {
    @Id
    Long id;
    String title;
    String description;
    String tagline;
    String imageUrl;
    String poster_path;
    String genre;
    int[] genre_ids;
    String trailer;
    String homepage;
}
