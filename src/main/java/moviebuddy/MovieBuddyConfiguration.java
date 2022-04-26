package moviebuddy;

import moviebuddy.domain.MovieFinder;
import moviebuddy.infrastructure.CsvMovieReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieBuddyConfiguration {

    @Bean
    public MovieFinder movieFinder() {
        return new MovieFinder(new CsvMovieReader());
    }

}
