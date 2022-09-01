package moviebuddy.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.core.io.DefaultResourceLoader;

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
    void invalidCase() throws Exception {
        AbstractMetaDataResourceMovieReader abstractMetaDataResourceMovieReader = new CsvMovieReader();

        abstractMetaDataResourceMovieReader.setMetadata("movie_metadata.csv");
        abstractMetaDataResourceMovieReader.setResourceLoader(new DefaultResourceLoader());

        abstractMetaDataResourceMovieReader.afterPropertiesSet();
    }

}
