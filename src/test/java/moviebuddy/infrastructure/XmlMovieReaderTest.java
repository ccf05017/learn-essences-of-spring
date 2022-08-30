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

    @Autowired
    private XmlMovieReader xmlMovieReader;

    @Test
    void loadMoviesTest() {
        int expectedMovieSize = 1375;

        List<Movie> movies = xmlMovieReader.loadMovies();

        Assertions.assertEquals(movies.size(), expectedMovieSize);
    }

}
