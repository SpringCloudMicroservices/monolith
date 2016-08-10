package movies.monolith;

import movies.monolith.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.inject.Inject;

/**
 * Created by tri.bui on 8/3/16.
 */
@SpringBootApplication
public class Application {
    @Value("${jwt.secret.key}")
    String jwtSecretKey;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter(jwtSecretKey));
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }
}
