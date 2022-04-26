package moviebuddy.infrastructure.factory;

import moviebuddy.domain.MovieFinder;
import moviebuddy.infrastructure.CsvMovieReader;

public class MovieBuddyFactory {

    public MovieFinder movieFinder() {
        return new MovieFinder(new CsvMovieReader());
    }

}
