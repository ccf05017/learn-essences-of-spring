package moviebuddy.infrastructure;

import moviebuddy.MovieBuddyProfile;
import moviebuddy.configuration.MovieBuddyConfiguration;
import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.util.AopTestUtils;

import java.util.List;

@SpringJUnitConfig(MovieBuddyConfiguration.class)
@ActiveProfiles(MovieBuddyProfile.XML_MODE)
@TestPropertySource(properties = {"movie.metadata=movie_metadata.xml"})
class XmlMovieReaderTest {

    @Autowired
    private MovieReader movieReader;

    @Test
    void loadMoviesTest() {
        int expectedMovieSize = 1375;

        List<Movie> movies = movieReader.loadMovies();

        Assertions.assertEquals(movies.size(), expectedMovieSize);
    }

    @DisplayName("AOP가 제대로 되는지 확인하는 테스트")
    @Test
    void aopTest() {
        Assertions.assertTrue(AopUtils.isAopProxy(movieReader));

        MovieReader targetObject = AopTestUtils.getTargetObject(movieReader);
        Assertions.assertTrue(XmlMovieReader.class.isAssignableFrom(targetObject.getClass()));
    }

}
