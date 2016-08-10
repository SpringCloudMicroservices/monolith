package movies.monolith.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Created by tri.bui on 8/2/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    String id;
    String username;
    String password;
    String name;
    int age;
}

