package moviebuddy.configuration;

import moviebuddy.MovieBuddyProfile;
import moviebuddy.infrastructure.CsvMovieReader;
import moviebuddy.infrastructure.XmlMovieReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.oxm.Unmarshaller;

@Configuration
public class DatasourceModuleConfig {

    @Profile(MovieBuddyProfile.CSV_MODE)
    @Bean
    public CsvMovieReader csvMovieReader() {
        CsvMovieReader csvMovieReader = new CsvMovieReader();
        csvMovieReader.setMetadata("movie_metadata.csv");

        return csvMovieReader;
    }

    @Profile(MovieBuddyProfile.XML_MODE)
    @Bean
    public XmlMovieReader xmlMovieReader(Unmarshaller unmarshaller) {
        XmlMovieReader xmlMovieReader = new XmlMovieReader(unmarshaller);
        xmlMovieReader.setMetadata("movie_metadata.xml");

        return xmlMovieReader;
    }

}
