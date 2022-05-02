package moviebuddy.infrastructure;

import moviebuddy.MovieBuddyProfile;
import moviebuddy.configuration.MovieBuddyConfiguration;
import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(MovieBuddyConfiguration.class)
@ActiveProfiles(MovieBuddyProfile.XML_MODE)
@TestPropertySource(properties = {"movie.metadata=movie_metadata.xml"})
class XmlMovieReaderTest {

    private final MovieReader movieReader;

    @Autowired
    public XmlMovieReaderTest(MovieReader movieReader) {
        this.movieReader = movieReader;
    }

    @Test
    void loadMoviesTest() {
        int expectedMovieSize = 1375;

        List<Movie> movies = movieReader.loadMovies();

        Assertions.assertEquals(movies.size(), expectedMovieSize);
    }

}
