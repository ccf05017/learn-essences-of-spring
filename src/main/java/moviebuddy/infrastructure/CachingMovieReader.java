package moviebuddy.infrastructure;

import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieReader;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.List;
import java.util.Objects;

public class CachingMovieReader implements MovieReader {
    private static final String CACHE_NAME = CachingMovieReader.class.getName();
    private static final String CACHE_KEY = "moveis";

    private final CacheManager cacheManager;
    private final MovieReader target;

    public CachingMovieReader(CacheManager cacheManager, MovieReader target) {
        this.cacheManager = cacheManager;
        this.target = target;
    }

    @Override
    public List<Movie> loadMovies() {
        Cache cache = cacheManager.getCache(CACHE_NAME);
        List<Movie> movies = cache.get(CACHE_KEY, List.class);
        if (Objects.nonNull(movies)) {
            return movies;
        }

        List<Movie> newMovies = target.loadMovies();
        cache.put(CACHE_KEY, newMovies);

        return newMovies;
    }

    public List<Movie> getCachedData() {
        Cache cache = cacheManager.getCache(CACHE_NAME);
        return cache.get(CACHE_KEY, List.class);
    }
}
