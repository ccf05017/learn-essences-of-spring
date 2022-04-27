package moviebuddy.domain;

import moviebuddy.configuration.MovieBuddyConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * @author springrunner.kr@gmail.com
 */
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {MovieBuddyConfiguration.class})

// 위의 애노테이션을 묶은 도구임. (편의성 증가)
@SpringJUnitConfig(MovieBuddyConfiguration.class)
class MovieFinderTest {

    private final MovieFinder movieFinder;

    @Autowired
    public MovieFinderTest(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    @Test
    void findMovieByDirecterTest() {
        int expectedMovieSize = 3;

        List<Movie> result = movieFinder.directedBy("Michael Bay");

        Assertions.assertEquals(result.size(), expectedMovieSize);
    }

    @Test
    void findMovieByReleasedYearTest() {
        int expectedMovieSize = 225;

        List<Movie> result = movieFinder.releasedYearBy(2015);

        Assertions.assertEquals(result.size(), expectedMovieSize);
    }

}
