package moviebuddy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@ComponentScan(basePackages = { "moviebuddy" })
@Import({DomainModuleConfig.class, DatasourceModuleConfig.class})
public class MovieBuddyConfiguration {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan("moviebuddy");

        return jaxb2Marshaller;
    }

}
