package moviebuddy.configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import moviebuddy.infrastructure.cache.CachingAspect;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.concurrent.TimeUnit;

@Configuration
@PropertySource("/application.properties")
@ComponentScan(basePackages = {"moviebuddy"})
@Import({DomainModuleConfig.class, DatasourceModuleConfig.class})
@EnableAspectJAutoProxy
public class MovieBuddyConfiguration {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan("moviebuddy");

        return jaxb2Marshaller;
    }

//    @Bean
//    @Primary
//    public ProxyFactoryBean cachingMovieReaderFactory(ApplicationContext applicationContext) {
//        MovieReader target = applicationContext.getBean(MovieReader.class);
//        CacheManager cacheManager = applicationContext.getBean(CacheManager.class);
//
//        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
//        proxyFactoryBean.setTarget(target);
//        proxyFactoryBean.addAdvice(new CachingAdvice(cacheManager));
//
//        return proxyFactoryBean;
//    }

    @Bean
    public CacheManager caffeineCacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS));

        return caffeineCacheManager;
    }

//    @Bean
//    public Advisor cachingAdvisor(CacheManager cacheManager) {
//        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(null, CacheResult.class);
//        Advice cachingAdvice = new CachingAdvice(cacheManager);
//
//        // Advisor = PointCut(대상 선정 알고리즘) + Advice(부가기능)
//        return new DefaultPointcutAdvisor(pointcut, cachingAdvice);
//    }
//
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        return new DefaultAdvisorAutoProxyCreator();
//    }

    @Bean
    public CachingAspect cachingAspect(CacheManager cacheManager) {
        return new CachingAspect(cacheManager);
    }

}
