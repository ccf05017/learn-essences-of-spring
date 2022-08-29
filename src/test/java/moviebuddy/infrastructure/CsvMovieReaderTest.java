package moviebuddy.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.FileNotFoundException;

class CsvMovieReaderTest {

    @Test
    @DisplayName("올바른 경로의 메타 데이터로 무비리더를 기동할 경우")
    void validCase() throws Exception {
        AbstractMetaDataResourceMovieReader abstractMetaDataResourceMovieReader = new CsvMovieReader();
        abstractMetaDataResourceMovieReader.setMetadata("movie_metadata.csv");
        abstractMetaDataResourceMovieReader.setResourceLoader(new DefaultResourceLoader());

        abstractMetaDataResourceMovieReader.afterPropertiesSet();
    }

    @Test
    @DisplayName("잘못된 경로의 메타 데이터로 무비리더를 기동할 경우")
    void invalidCase() {
        AbstractMetaDataResourceMovieReader abstractMetaDataResourceMovieReader = new CsvMovieReader();
        abstractMetaDataResourceMovieReader.setResourceLoader(new DefaultResourceLoader());

        Assertions.assertThrows(FileNotFoundException.class, () -> {
           abstractMetaDataResourceMovieReader.setMetadata("invalid metadata path");
           abstractMetaDataResourceMovieReader.afterPropertiesSet();
        });
    }

}
