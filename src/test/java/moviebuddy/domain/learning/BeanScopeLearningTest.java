package moviebuddy.domain.learning;

import moviebuddy.configuration.MovieBuddyConfiguration;
import moviebuddy.domain.MovieFinder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScopeLearningTest {

    @Test
    @DisplayName("싱글톤 빈은 정말 한개만 생성될까?")
    void isReallyOnlyOneSingleton() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MovieBuddyConfiguration.class);
        MovieFinder movieFinder = applicationContext.getBean(MovieFinder.class);

        Assertions.assertEquals(movieFinder, applicationContext.getBean(MovieFinder.class));
    }

}
