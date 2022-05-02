package moviebuddy.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class CsvMovieReaderTest {

    @Test
    @DisplayName("올바른 경로의 메타 데이터로 무비리더를 기동할 경우")
    void validCase() throws Exception {
        AbstractFileSystemMovieReader abstractFileSystemMovieReader = new CsvMovieReader();
        abstractFileSystemMovieReader.setMetadata("movie_metadata.csv");

        abstractFileSystemMovieReader.afterPropertiesSet();
    }

    @Test
    @DisplayName("잘못된 경로의 메타 데이터로 무비리더를 기동할 경우")
    void invalidCase() {
        AbstractFileSystemMovieReader abstractFileSystemMovieReader = new CsvMovieReader();

        Assertions.assertThrows(FileNotFoundException.class, () -> {
           abstractFileSystemMovieReader.setMetadata("invalid metadata path");
           abstractFileSystemMovieReader.afterPropertiesSet();
        });
    }

}
