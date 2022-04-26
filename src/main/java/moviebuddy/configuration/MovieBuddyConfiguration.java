package moviebuddy.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "moviebuddy" })
@Import({DomainModuleConfig.class, DatasourceModuleConfig.class})
public class MovieBuddyConfiguration {

}
