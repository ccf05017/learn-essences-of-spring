package moviebuddy.domain;

import moviebuddy.infrastructure.JaxbMovieReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JaxbMovieReaderTest {
    @Test
    void loadMoviesTest() {
        int expectedMovieSize = 1375;
        MovieReader movieReader = new JaxbMovieReader();

        List<Movie> movies = movieReader.loadMovies();

        Assertions.assertEquals(movies.size(), expectedMovieSize);
    }
}
