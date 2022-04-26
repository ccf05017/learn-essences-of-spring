package moviebuddy.domain;

import moviebuddy.infrastructure.CsvMovieReader;
import moviebuddy.MovieBuddyConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author springrunner.kr@gmail.com
 */
public class MovieFinderTest {
    private final MovieReader csvMovieReader = new CsvMovieReader();

    @Test
    void findMovieByDirecterTest() {
        int expectedMovieSize = 3;
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MovieBuddyConfiguration.class);
        MovieFinder movieFinder = applicationContext.getBean(MovieFinder.class);

        List<Movie> result = movieFinder.directedBy("Michael Bay");

        Assertions.assertEquals(result.size(), expectedMovieSize);
    }

    @Test
    void findMovieByReleasedYearTest() {
        int expectedMovieSize = 225;
        MovieFinder movieFinder = new MovieFinder(csvMovieReader);

        List<Movie> result = movieFinder.releasedYearBy(2015);

        Assertions.assertEquals(result.size(), expectedMovieSize);
    }
}
