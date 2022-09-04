package moviebuddy.learningtest;

import moviebuddy.domain.Movie;
import moviebuddy.domain.MovieReader;
import moviebuddy.infrastructure.CsvMovieReader;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class DynamicProxyLearningTest {

    @Test
    void dynamicProxyTest() throws Exception {
        CsvMovieReader csvMovieReader = new CsvMovieReader();
        csvMovieReader.setResourceLoader(new DefaultResourceLoader());
        csvMovieReader.setMetadata("movie_metadata.csv");
        csvMovieReader.afterPropertiesSet();

        ClassLoader classLoader = DynamicProxyLearningTest.class.getClassLoader();
        Class<?>[] interfaces = new Class[]{MovieReader.class};
        InvocationHandler handler = new PerformanceInvocationHandler(csvMovieReader);
        MovieReader proxy = (MovieReader) Proxy.newProxyInstance(classLoader, interfaces, handler);

        proxy.loadMovies();
        proxy.loadMovies();
    }

    static class PerformanceInvocationHandler implements InvocationHandler {

        Logger logger = LoggerFactory.getLogger(getClass());
        final Object target;

        public PerformanceInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long start = System.currentTimeMillis();
            Object result = method.invoke(target, args);
            long elapsed = System.currentTimeMillis() - start;

            logger.info("Excution {} method finished in {} ms", method.getName(), elapsed);

            return result;
        }
    }

}
