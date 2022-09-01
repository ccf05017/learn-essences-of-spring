package moviebuddy.infrastructure;

import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

import java.util.List;

class CachingMovieReaderTest {

    @DisplayName("캐시가 제대로 적용되는지 확인하는테스트")
    @Test
    void cachingTest() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        MovieReader target = new DummyMovieReader();

        CachingMovieReader cachingMovieReader = new CachingMovieReader(cacheManager, target);

        Assertions.assertNull(cachingMovieReader.getCachedData());

        List<Movie> movies = cachingMovieReader.loadMovies();
        Assertions.assertNotNull(cachingMovieReader.getCachedData());
        Assertions.assertSame(cachingMovieReader.loadMovies(), movies);
    }

    class DummyMovieReader implements MovieReader {
        @Override
        public List<Movie> loadMovies() {
            return List.of();
        }
    }
}