package moviebuddy.configuration;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieReader;
import moviebuddy.infrastructure.CsvMovieReader;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@PropertySource("/application.properties")
@ComponentScan(basePackages = {"moviebuddy"})
@Import({DomainModuleConfig.class, DatasourceModuleConfig.class})
public class MovieBuddyConfiguration {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan("moviebuddy");

        return jaxb2Marshaller;
    }

    @Bean
    @Primary
    public MovieReader csvMovieReader() {
        return new CsvMovieReader(caffeineCacheManager());
    }

    @Bean
    public CacheManager caffeineCacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS));

        return caffeineCacheManager;
    }

}
