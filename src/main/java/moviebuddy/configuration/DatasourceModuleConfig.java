package moviebuddy.configuration;

import moviebuddy.domain.MovieReader;
import moviebuddy.infrastructure.CsvMovieReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceModuleConfig {

    @Bean
    public MovieReader movieReader() {
        return new CsvMovieReader();
    }

}
