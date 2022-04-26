package moviebuddy.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DomainModuleConfig.class, DatasourceModuleConfig.class})
public class MovieBuddyConfiguration {

}
