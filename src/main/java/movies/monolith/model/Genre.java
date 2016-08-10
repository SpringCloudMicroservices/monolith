package movies.monolith.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by tri.bui on 8/10/16.
 */
@Data
public class Genre {
    @Id
    int id;
    String name;
}
