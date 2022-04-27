package moviebuddy.infrastructure;

import moviebuddy.configuration.MovieBuddyConfiguration;
import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(MovieBuddyConfiguration.class)
class JaxbMovieReaderTest {

    private final MovieReader movieReader;

    // 어떤 MovieReader를 사용할지 명시적으로 드러냈기 때문에 문제 없음
    @Autowired
    public JaxbMovieReaderTest(MovieReader jaxbMovieReader) {
        this.movieReader = jaxbMovieReader;
    }

    @Test
    void loadMoviesTest() {
        int expectedMovieSize = 1375;

        List<Movie> movies = movieReader.loadMovies();

        Assertions.assertEquals(movies.size(), expectedMovieSize);
    }

}
