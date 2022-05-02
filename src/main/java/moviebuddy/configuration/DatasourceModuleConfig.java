package moviebuddy.configuration;

import moviebuddy.MovieBuddyProfile;
import moviebuddy.infrastructure.CsvMovieReader;
import moviebuddy.infrastructure.XmlMovieReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.oxm.Unmarshaller;

@Configuration
public class DatasourceModuleConfig {

//    private final Environment environment;
//
//    public DatasourceModuleConfig(Environment environment) {
//        this.environment = environment;
//    }
//
//    @Profile(MovieBuddyProfile.CSV_MODE)
//    @Bean
//    public CsvMovieReader csvMovieReader() {
//        CsvMovieReader csvMovieReader = new CsvMovieReader();
//        csvMovieReader.setMetadata(environment.getProperty("movie.metadata"));
//
//        return csvMovieReader;
//    }
//
//    @Profile(MovieBuddyProfile.XML_MODE)
//    @Bean
//    public XmlMovieReader xmlMovieReader(Unmarshaller unmarshaller) {
//        XmlMovieReader xmlMovieReader = new XmlMovieReader(unmarshaller);
//        xmlMovieReader.setMetadata(environment.getProperty("movie.metadata"));
//
//        return xmlMovieReader;
//    }

}
