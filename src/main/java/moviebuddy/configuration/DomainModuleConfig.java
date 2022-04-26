package moviebuddy.configuration;

import moviebuddy.domain.MovieFinder;
import moviebuddy.domain.MovieReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainModuleConfig {

    // 메서드 DI
//    @Bean
//    public MovieFinder movieFinder() {
//        return new MovieFinder(movieReader());
//    }

    // 생성자 DI
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) <- 프로토타입 스코프로 변경하고 싶을 때의 설정
//    public MovieFinder movieFinder(MovieReader movieReader) {
//        return new MovieFinder(movieReader);
//    }

}
