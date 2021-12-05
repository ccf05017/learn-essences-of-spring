package moviebuddy.domain;

import moviebuddy.ApplicationException;

import java.util.List;

public class JaxbMovieReaderTest {
    public static void main(String[] args) {
        MovieReader movieReader = new JaxbMovieReader();

        List<Movie> movies = movieReader.loadMovies();

        if (movies.size() != 1375) {
            throw new ApplicationException("JAXB에서 로딩된 영화 수량이 기대값과 다릅니다.");
        }
    }
}
