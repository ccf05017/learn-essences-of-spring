package moviebuddy.domain;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface MovieReader {
    List<Movie> loadMovies();
}
